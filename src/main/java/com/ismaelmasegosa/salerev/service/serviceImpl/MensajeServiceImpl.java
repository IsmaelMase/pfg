package com.ismaelmasegosa.salerev.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ismaelmasegosa.salerev.entities.Mensaje;
import com.ismaelmasegosa.salerev.repository.MensajeRepository;
import com.ismaelmasegosa.salerev.service.MensajeService;

@Service("mensajeService")
public class MensajeServiceImpl implements MensajeService {

	@Autowired
	@Qualifier("mensajeRepository")
	private MensajeRepository mensajeRepository;

	@Override
	public List<Mensaje> findAll() {
		return mensajeRepository.findAll();
	}

	@Override
	public List<Mensaje> findByTipo(String tipo) {
		return mensajeRepository.findByTipo(tipo);
	}

	@Override
	public ResponseEntity<?> sendMensaje(Mensaje m) {
		try {
			Mensaje mSave = mensajeRepository.save(m);

			if (mSave == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public ResponseEntity<?> removeMensaje(String id) {
		try {

			mensajeRepository.deleteById(id);

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

}
