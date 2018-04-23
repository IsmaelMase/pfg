package com.ismaelmasegosa.salerev.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ismaelmasegosa.salerev.entities.Curso;
import com.ismaelmasegosa.salerev.repository.CursoRepository;
import com.ismaelmasegosa.salerev.service.CursoService;

@Service("cursoService")
public class CursoServiceImpl implements CursoService {

	@Autowired
	@Qualifier("cursoRepository")
	private CursoRepository cursoRepository;

	@Override
	public List<Curso> findAll() {
		return cursoRepository.findAll();
	}

	@Override
	public ResponseEntity<?> addCurso(Curso c) {
		try {
			Curso cSave = cursoRepository.save(c);

			if (cSave == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

	}

	@Override
	public ResponseEntity<?> removeCurso(String id) {
		try {

			cursoRepository.deleteById(id);

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

}
