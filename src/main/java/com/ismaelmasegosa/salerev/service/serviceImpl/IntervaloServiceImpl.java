package com.ismaelmasegosa.salerev.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ismaelmasegosa.salerev.entities.Intervalo;
import com.ismaelmasegosa.salerev.entities.Recurso;
import com.ismaelmasegosa.salerev.models.RecursoModel;
import com.ismaelmasegosa.salerev.repository.IntervaloRepository;
import com.ismaelmasegosa.salerev.service.IntervaloService;

@Service("intervaloService")
public class IntervaloServiceImpl implements IntervaloService {
	
	@Autowired
	@Qualifier("intervaloRepository")
	private IntervaloRepository intervaloRepository;

	@Override
	public List<String> findAll() {
		return intervaloRepository.findAll().get(0).getIntervalos();
	}

	@Override
	public ResponseEntity<String> addIntervalo(Intervalo in) {
		try {
			Intervalo iSave = intervaloRepository.save(in);

			return new ResponseEntity<>(HttpStatus.CREATED);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

	

}
