package com.ismaelmasegosa.salerev.converter;

import org.springframework.stereotype.Component;

import com.ismaelmasegosa.salerev.entities.Reserva;
import com.ismaelmasegosa.salerev.models.ReservaModel;

@Component("reservaConverter")
public class ReservaConverter {

	// public ReservaModel converterEntityToModel(Reserva r) {
	//
	// ReservaModel rm = new ReservaModel();
	//
	// if (!r.getId().isEmpty()) {
	// rm.setId(r.getId());
	// }
	// rm.setFecha_inicio(r.getFecha_inicio());
	// rm.setFecha_fin(r.getFecha_fin());
	// rm.setRecurso(r.getRecurso());
	// rm.setUsuario(r.getUsuario());
	// rm.setAnotacion(r.getAnotacion());
	//
	// return rm;
	//
	// }

	public Reserva converterModelToEntity(ReservaModel rm, String fecha, String intervalo) {

		Reserva r = new Reserva();

		if (!rm.getId().isEmpty()) {
			r.setId(rm.getId());
		}
		r.setFecha(fecha);
		r.setIntervalo(intervalo);
		r.setRecurso(rm.getRecurso());
		r.setUsuario(rm.getUsuario());
		r.setAnotacion(rm.getAnotacion());

		return r;

	}
}
