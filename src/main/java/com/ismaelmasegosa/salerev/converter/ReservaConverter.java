package com.ismaelmasegosa.salerev.converter;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.ismaelmasegosa.salerev.entities.Reserva;
import com.ismaelmasegosa.salerev.models.ReservaModel;

@Component("reservaConverter")
public class ReservaConverter {

	public ReservaModel converterEntityToModel(Reserva r) {
		ReservaModel rm = new ReservaModel();
		if (!r.getId().isEmpty()) {
			rm.setId(r.getId());
		}
		rm.fechas_reservas = new ArrayList<String>();
		rm.intervalos_reservas = new ArrayList<String>();
		rm.getIntervalos_reservas().add(r.getIntervalo());
		rm.getFechas_reservas().add(r.getFecha());
		rm.setRecurso(r.getRecurso());
		rm.setUsuario(r.getUsuario());
		rm.setAnotacion(r.getAnotacion());
		rm.setCurso(r.getCurso());
		return rm;

	}

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
		r.setCurso(rm.getCurso());
		return r;

	}
}
