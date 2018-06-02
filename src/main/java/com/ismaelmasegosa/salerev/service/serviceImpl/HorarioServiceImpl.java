package com.ismaelmasegosa.salerev.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ismaelmasegosa.salerev.converter.HorarioConverter;
import com.ismaelmasegosa.salerev.entities.Horario;
import com.ismaelmasegosa.salerev.entities.Recurso;
import com.ismaelmasegosa.salerev.models.HorarioModel;
import com.ismaelmasegosa.salerev.repository.HorarioRepository;
import com.ismaelmasegosa.salerev.repository.RecursoRepository;
import com.ismaelmasegosa.salerev.service.HorarioService;

@Service("intervaloService")
public class HorarioServiceImpl implements HorarioService {

	@Autowired
	@Qualifier("intervaloRepository")
	private HorarioRepository intervaloRepository;

	@Autowired
	@Qualifier("recursoRepository")
	private RecursoRepository recursoRepository;

	@Autowired
	@Qualifier("intervaloConverter")
	private HorarioConverter intervaloConverter;

	@Override
	public List<HorarioModel> findAll() {
		ArrayList<HorarioModel> intervalosModel = new ArrayList<>();
		for (Horario i : intervaloRepository.findAll()) {
			intervalosModel.add(intervaloConverter.converterEntityToModel(i));
		}

		return intervalosModel;
	}

	@Override
	public ResponseEntity<HorarioModel> addIntervalo(HorarioModel in) {
		try {
			Horario iSave = intervaloRepository.save(intervaloConverter.converterModelToEntity(in));

			return new ResponseEntity<>(intervaloConverter.converterEntityToModel(iSave), HttpStatus.CREATED);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public ResponseEntity<String> removeIntervalo(String id) {
		try {
			List<Recurso> recursos = recursoRepository.findFirstByIntervalo(intervaloRepository.findById(id).get());
			if (!recursos.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			intervaloRepository.deleteById(id);

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

}
