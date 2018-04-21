package com.ismaelmasegosa.salerev.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ismaelmasegosa.salerev.entities.Reserva;
import com.ismaelmasegosa.salerev.repository.ReservaRepository;
import com.ismaelmasegosa.salerev.service.ReservaService;

@Service("reservaService")
public class ReservaServiceImpl implements ReservaService{

	@Autowired
	@Qualifier("reservaRepository")
	private ReservaRepository reservaRepository;

	@Override
	public boolean addReserva(Reserva r) {
		try {
			Reserva rSave = reservaRepository.save(r);

			if (rSave == null) {
				return false;
			}

			return true;
		} catch (Exception e) {

			return false;

		}

	}

	@Override
	public boolean removeReserva(String id) {
		try {

			reservaRepository.deleteById(id);

			return true;

		} catch (Exception e) {

			return false;

		}
	}

}
