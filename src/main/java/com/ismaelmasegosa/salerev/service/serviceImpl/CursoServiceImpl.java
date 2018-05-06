package com.ismaelmasegosa.salerev.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ismaelmasegosa.salerev.converter.CursoConverter;
import com.ismaelmasegosa.salerev.entities.Curso;
import com.ismaelmasegosa.salerev.models.CursoModel;
import com.ismaelmasegosa.salerev.models.UsuarioModel;
import com.ismaelmasegosa.salerev.repository.CursoRepository;
import com.ismaelmasegosa.salerev.service.CursoService;

@Service("cursoService")
public class CursoServiceImpl implements CursoService {

	@Autowired
	@Qualifier("cursoRepository")
	private CursoRepository cursoRepository;
	
	@Autowired
	@Qualifier("cursoConverter")
	public CursoConverter cursoConverter;

	@Override
	public List<CursoModel> findAll() {
		ArrayList<CursoModel> cursosModel= new ArrayList<>();
		for(Curso c: cursoRepository.findAll()) {
			cursosModel.add(cursoConverter.converterEntityToModel(c));
		}
		
		return cursosModel;
	}

	@Override
	public ResponseEntity<CursoModel> addCurso(CursoModel c) {
		try {
			Curso cSave = cursoRepository.save(cursoConverter.converterModelToEntity(c));
			

			return new ResponseEntity<CursoModel>(cursoConverter.converterEntityToModel(cSave), HttpStatus.CREATED);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

	}

	@Override
	public ResponseEntity<String> removeCurso(String id) {
		try {

			cursoRepository.deleteById(id);

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}	
	}

}
