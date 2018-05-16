package com.ismaelmasegosa.salerev.service.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ismaelmasegosa.salerev.converter.MensajeConverter;
import com.ismaelmasegosa.salerev.entities.Mensaje;
import com.ismaelmasegosa.salerev.models.MensajeModel;
import com.ismaelmasegosa.salerev.repository.MensajeRepository;
import com.ismaelmasegosa.salerev.repository.UsuarioRepository;
import com.ismaelmasegosa.salerev.service.MensajeService;

@Service("mensajeService")
public class MensajeServiceImpl implements MensajeService {

	@Autowired
	@Qualifier("mensajeRepository")
	private MensajeRepository mensajeRepository;

	@Autowired
	@Qualifier("mensajeConverter")
	private MensajeConverter mensajeConverter;

	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRepository;

	@Override
	public List<MensajeModel> findAll() {
		ArrayList<MensajeModel> mensajesModel = new ArrayList<>();
		for (Mensaje r : mensajeRepository.findAll()) {
			mensajesModel.add(mensajeConverter.converterEntityToModel(r));
		}

		return mensajesModel;
	}

	@Override
	public List<MensajeModel> findByLeido(boolean leido) {
		ArrayList<MensajeModel> mensajesModel = new ArrayList<>();
		for (Mensaje r : mensajeRepository.findByLeido(leido)) {
			mensajesModel.add(mensajeConverter.converterEntityToModel(r));
		}

		return mensajesModel;
	}

	@Override
	public List<MensajeModel> findByReceptor(String id) {
		ArrayList<MensajeModel> mensajesModel = new ArrayList<>();
		for (Mensaje r : mensajeRepository.findByReceptor(usuarioRepository.findById(id))) {
			mensajesModel.add(mensajeConverter.converterEntityToModel(r));
		}

		return mensajesModel;
	}

	@Override
	public ResponseEntity<MensajeModel> sendMensaje(Mensaje m) {
		try {
			Mensaje mSave = mensajeRepository.save(m);

			return new ResponseEntity<MensajeModel>(mensajeConverter.converterEntityToModel(mSave), HttpStatus.CREATED);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public ResponseEntity<String> removeMensaje(String id) {
		try {

			mensajeRepository.deleteById(id);

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

}
