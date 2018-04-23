package com.ismaelmasegosa.salerev.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ismaelmasegosa.salerev.entities.Recurso;
import com.ismaelmasegosa.salerev.repository.RecursoRepository;
import com.ismaelmasegosa.salerev.service.RecursoService;

@Service("recursoService")
public class RecursoServiceImpl implements RecursoService {

	@Autowired
	@Qualifier("recursoRepository")
	private RecursoRepository recursoRepository;

	@Override
	public ResponseEntity<?> addRecurso(Recurso r) {
		try {
			Recurso rSave = recursoRepository.save(r);

			if (rSave == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

	}

	@Override
	public ResponseEntity<?> removeRecurso(String id) {
		try {

			recursoRepository.deleteById(id);

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<Recurso> findAllRecursos() {

		return recursoRepository.findByTipo("r");
		
	}

	@Override
	public List<Recurso> findAllAulas() {
		
		return recursoRepository.findByTipo("a");

	}

	@Override
	public List<Recurso> findAll() {
		
		return recursoRepository.findAll();

	}

}
