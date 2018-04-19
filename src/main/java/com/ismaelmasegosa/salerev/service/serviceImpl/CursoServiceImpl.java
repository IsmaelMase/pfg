package com.ismaelmasegosa.salerev.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	public boolean addCurso(Curso c) {
		try {
			Curso cSave = cursoRepository.save(c);

			if (cSave == null) {
				return false;
			}

			return true;
		} catch (Exception e) {

			return false;

		}

	}

	@Override
	public boolean removeCurso(String id) {
		try {

			cursoRepository.deleteById(id);

			return true;

		} catch (Exception e) {

			return false;

		}
	}

}
