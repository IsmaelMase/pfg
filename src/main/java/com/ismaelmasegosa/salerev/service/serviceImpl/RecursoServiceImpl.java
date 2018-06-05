package com.ismaelmasegosa.salerev.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ismaelmasegosa.salerev.converter.RecursoConverter;
import com.ismaelmasegosa.salerev.entities.Recurso;
import com.ismaelmasegosa.salerev.entities.Reserva;
import com.ismaelmasegosa.salerev.models.RecursoModel;
import com.ismaelmasegosa.salerev.repository.RecursoRepository;
import com.ismaelmasegosa.salerev.repository.ReservaRepository;
import com.ismaelmasegosa.salerev.service.RecursoService;

@Service("recursoService")
public class RecursoServiceImpl implements RecursoService {

	@Autowired
	@Qualifier("recursoRepository")
	private RecursoRepository recursoRepository;

	@Autowired
	@Qualifier("reservaRepository")
	private ReservaRepository reservaRepository;

	@Autowired
	@Qualifier("mailService")
	private MailService mailService;

	@Autowired
	@Qualifier("recursoConverter")
	private RecursoConverter recursoConverter;

	@Override
	public ResponseEntity<RecursoModel> addRecurso(RecursoModel r) {
		try {
			RecursoModel recursoOriginal = null;
			if (!r.getId().equals("")) {
				recursoOriginal = recursoConverter.converterEntityToModel(recursoRepository.findById(r.getId()).get());
			}
			Recurso rSave = recursoRepository.save(recursoConverter.converterModelToEntity(r));

			if (recursoOriginal != null) {
				if (!recursoOriginal.getIncidencia().equalsIgnoreCase(rSave.getIncidencia())) {
					if (rSave.getIncidencia().equals("")) {
						mailService.sendMailIncidencia(rSave.getNombre(), "No tiene incidencias");
					} else {
						mailService.sendMailIncidencia(rSave.getNombre(), rSave.getIncidencia());
					}
				}
			}

			return new ResponseEntity<RecursoModel>(recursoConverter.converterEntityToModel(rSave), HttpStatus.CREATED);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

	}

	@Override
	public ResponseEntity<String> removeRecurso(String id) {
		try {
			List<Reserva> reserva = reservaRepository.findFirstByRecurso(recursoRepository.findById(id).get());
			if (!reserva.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}

			recursoRepository.deleteById(id);

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<RecursoModel> findAllRecursos() {

		ArrayList<RecursoModel> recursosModel = new ArrayList<>();
		for (Recurso r : recursoRepository.findByTipo("r")) {
			recursosModel.add(recursoConverter.converterEntityToModel(r));
		}

		return recursosModel;

	}

	@Override
	public List<RecursoModel> findAllAulas() {

		ArrayList<RecursoModel> recursosModel = new ArrayList<>();
		for (Recurso r : recursoRepository.findByTipo("a")) {
			recursosModel.add(recursoConverter.converterEntityToModel(r));
		}

		return recursosModel;
	}

	@Override
	public List<RecursoModel> findAll() {

		ArrayList<RecursoModel> recursosModel = new ArrayList<>();
		for (Recurso r : recursoRepository.findAll()) {
			recursosModel.add(recursoConverter.converterEntityToModel(r));
		}

		return recursosModel;
	}

}
