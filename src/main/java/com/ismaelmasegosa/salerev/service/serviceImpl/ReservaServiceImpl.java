package com.ismaelmasegosa.salerev.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ismaelmasegosa.salerev.entities.Reserva;
import com.ismaelmasegosa.salerev.repository.CursoRepository;
import com.ismaelmasegosa.salerev.repository.ReservaRepository;
import com.ismaelmasegosa.salerev.repository.UsuarioRepository;
import com.ismaelmasegosa.salerev.service.ReservaService;

@Service("reservaService")
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	@Qualifier("reservaRepository")
	private ReservaRepository reservaRepository;

	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRespository;

	@Autowired
	@Qualifier("cursoRepository")
	private CursoRepository cursoRespository;

	@Override
	public ResponseEntity<?> addReserva(Reserva r) {
		try {
			Reserva rSave = reservaRepository.save(r);

			if (rSave == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

	}

	@Override
	public ResponseEntity<?> removeReserva(String id) {
		try {

			reservaRepository.deleteById(id);

			return new ResponseEntity<>(HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}
	}

	@Override
	public List<Reserva> findAll() {

		return reservaRepository.findAll();
	}

	@Override
	public List<Reserva> findByUsuario(String id) {

		return reservaRepository.findByUsuario(usuarioRespository.findById(null));
	}

	@Override
	public List<Reserva> findByCurso(String id) {

		return reservaRepository.findByCurso(cursoRespository.findById(id));

	}

}
