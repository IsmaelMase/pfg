package com.ismaelmasegosa.salerev.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ismaelmasegosa.salerev.converter.RecursoConverter;
import com.ismaelmasegosa.salerev.converter.ReservaConverter;
import com.ismaelmasegosa.salerev.entities.Recurso;
import com.ismaelmasegosa.salerev.entities.Reserva;
import com.ismaelmasegosa.salerev.models.ReservaModel;
import com.ismaelmasegosa.salerev.repository.RecursoRepository;
import com.ismaelmasegosa.salerev.repository.ReservaRepository;
import com.ismaelmasegosa.salerev.repository.UsuarioRepository;
import com.ismaelmasegosa.salerev.service.ReservaService;

@Service("reservaService")
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	@Qualifier("reservaRepository")
	private ReservaRepository reservaRepository;

	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRespository;

	@Autowired
	@Qualifier("recursoRepository")
	private RecursoRepository recursoRespository;

	@Autowired
	@Qualifier("reservaConverter")
	private ReservaConverter reservaConverter;

	@Autowired
	@Qualifier("recursoConverter")
	private RecursoConverter recursoConverter;

	@Autowired
	MongoTemplate mongoTemplate;

	@Override
	public ResponseEntity<List<ReservaModel>> addReserva(ReservaModel r) {
		List<ReservaModel> reservas = new ArrayList<>();
		try {
			r.getFechas_reservas().stream().forEach((f) -> {
				r.getIntervalos_reservas().stream().forEach((i) -> {
					Reserva reserva = reservaRepository.save(reservaConverter.converterModelToEntity(r, f, i));
					reservas.add(reservaConverter.converterEntityToModel(reserva));
				});
			});

			return new ResponseEntity<List<ReservaModel>>(reservas, HttpStatus.CREATED);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

	}

	@Override
	public ResponseEntity<String> removeReserva(String id) {
		try {

			reservaRepository.deleteById(id);

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<String> getFechasNoDisponibles(List<String> horas, String idRecurso) {
		List<String> fechas_NoDisponibles = new ArrayList<String>();
		for (String hora : horas) {
			for (Reserva reserva : reservaRepository.findByIntervaloAndRecurso(hora,
					recursoRespository.findById(idRecurso))) {
				if (!fechas_NoDisponibles.contains(reserva.fecha)) {
					fechas_NoDisponibles.add(reserva.fecha);
				}

			}
		}
		return fechas_NoDisponibles;
	}

	@Override
	public List<ReservaModel> findByUsuarioAndFecha(String id, String fecha) {
		ArrayList<ReservaModel> reservasModel = new ArrayList<>();
		fecha = fecha.replace("\"", "");
		for (Reserva r : reservaRepository.findByUsuarioAndFechaContains(usuarioRespository.findById(id),
				"/" + fecha)) {
			reservasModel.add(reservaConverter.converterEntityToModel(r));
		}

		return reservasModel;

	}

	@Override
	public TreeMap<Integer, List<String>> findByRecursoAndFechasContains(String id, List<String> fechas) {
		TreeMap<Integer, List<String>> tablaReservas = new TreeMap<>();
		ArrayList<String> reservasTabla = new ArrayList<>();
		int cont = 0;
		Recurso re = recursoRespository.findById(id).get();
		for (String hora : re.getIntervalo().getIntervalos()) {
			cont++;
			reservasTabla = new ArrayList<>();
			reservasTabla.add(hora);
			for (String fecha : fechas) {
				List<Reserva> reservas = reservaRepository.findByRecursoAndFechaAndIntervalo(re, fecha, hora);
				if (reservas.size() > 0) {
					for (Reserva r : reservas) {
						if (r != null) {
							reservasTabla.add(r.getUsuario().getNombre() + " " + r.getCurso().getNombre());
						}
					}
				} else {
					reservasTabla.add("");

				}
			}
			tablaReservas.put(cont, reservasTabla);
		}
		fechas.add(0, "Horas");
		tablaReservas.put(0, fechas);
		return tablaReservas;
	}

	@Override
	public List<String> getHorasNoDisponibles(String fecha, String idRecurso) {
		Optional<Recurso> re = recursoRespository.findById(idRecurso);
		List<String> intervalos = re.get().getIntervalo().getIntervalos();
		fecha = fecha.replace("\"", "");
		List<Reserva> reservas = reservaRepository.findByRecursoAndFechaContains(re, fecha);
		if (reservas.size() > 0) {
			for (Reserva reserva : reservas) {
				intervalos.remove(reserva.getIntervalo());
			}
		}

		return intervalos;
	}

	@Override
	public List<ReservaModel> findByRecursoAndfilterByFecha(String id, String fecha) {
		ArrayList<ReservaModel> reservasModel = new ArrayList<>();
		Optional<Recurso> re = recursoRespository.findById(id);
		fecha = fecha.replace("\"", "");
		for (Reserva r : reservaRepository.findByRecursoAndFechaContains(re, fecha)) {
			reservasModel.add(reservaConverter.converterEntityToModel(r));
		}

		return reservasModel;
	}

	@Override
	public List<ReservaModel> findByUsuario(String id, int skip, int top) {

		ArrayList<ReservaModel> reservasModel = new ArrayList<>();
		Query query = new Query();
		query.addCriteria(Criteria.where("usuario.id").is(id));
		query.skip(skip);
		query.limit(top);
		for (Reserva r : mongoTemplate.find(query, Reserva.class)) {
			reservasModel.add(reservaConverter.converterEntityToModel(r));
		}
		return reservasModel;
	}

}
