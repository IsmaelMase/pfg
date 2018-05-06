package com.ismaelmasegosa.salerev.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ismaelmasegosa.salerev.converter.RecursoConverter;
import com.ismaelmasegosa.salerev.converter.ReservaConverter;
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

	@Override
	public ResponseEntity<String> addReserva(ReservaModel r) {
		try {
			for (String fecha : r.getFechas_reservas()) {
				for (String intervalo : r.getIntervalos_reservas()) {
					Reserva rSave = reservaRepository
							.save(reservaConverter.converterModelToEntity(r, fecha, intervalo));
				}
			}

			return new ResponseEntity<>(HttpStatus.CREATED);

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
		List<String> fechas_disponibles = new ArrayList<String>();
		for (String hora : horas) {
			for (Reserva reserva : reservaRepository.findByIntervaloAndRecurso(hora,
					recursoRespository.findById(idRecurso))) {
				if (!fechas_disponibles.contains(reserva.fecha)) {
					fechas_disponibles.add(reserva.fecha);
				}

			}
		}
		return fechas_disponibles;
	}

	// @Override
	// public List<ReservaModel> findAll() {
	// ArrayList<ReservaModel> reservasModel = new ArrayList<>();
	//
	// for (Reserva r : reservaRepository.findAll()) {
	// reservasModel.add(reservaConverter.converterEntityToModel(r));
	// }
	//
	// return reservasModel;
	// }
	//
	// @Override
	// public List<ReservaModel> findByUsuario(String id) {
	// ArrayList<ReservaModel> reservasModel = new ArrayList<>();
	//
	// for (Reserva r :
	// reservaRepository.findByUsuario(usuarioRespository.findById(id))) {
	// reservasModel.add(reservaConverter.converterEntityToModel(r));
	// }
	//
	// return reservasModel;
	//
	// }
	//
	// @Override
	// public List<ReservaModel> findByRecurso(String id) {
	//
	// ArrayList<ReservaModel> reservasModel = new ArrayList<>();
	//
	// for (Reserva r :
	// reservaRepository.findByRecurso(recursoRespository.findById(id))) {
	// reservasModel.add(reservaConverter.converterEntityToModel(r));
	// }
	//
	// return reservasModel;
	//
	// }

	// @Override
	// public List<String> getHorasDisponibles(LocalDateTime fecha) {
	// ArrayList<String> reservasModel = new ArrayList<>();
	//
	// return null;
	// }

}
