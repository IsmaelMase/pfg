package com.ismaelmasegosa.salerev.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
	public boolean addRecurso(Recurso r) {
		try {
			Recurso rSave = recursoRepository.save(r);

			if (rSave == null) {
				return false;
			}

			return true;
		} catch (Exception e) {

			return false;

		}

	}

	@Override
	public boolean removeRecurso(String id) {
		try {

			recursoRepository.deleteById(id);

			return true;

		} catch (Exception e) {

			return false;

		}
	}
}
