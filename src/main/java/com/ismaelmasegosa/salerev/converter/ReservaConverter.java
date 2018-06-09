package com.ismaelmasegosa.salerev.converter;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.ismaelmasegosa.salerev.entities.Reserva;
import com.ismaelmasegosa.salerev.models.ReservaModel;

/**
 * 
 * @author Ismael Masegosa
 *
 */
@Component("reservaConverter")
public class ReservaConverter {

	/**
	 * Convertir de entidad a modelo
	 * 
	 * @param r
	 *            Reserva
	 * @return ReservaModel reserva
	 */
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

	/**
	 * Convertir de modelo a entidad
	 * 
	 * @param rm
	 *            RecursoModel recurso
	 * @param fecha
	 *            String fecha de la reserva
	 * @param intervalo
	 *            String intervalo de la reserva
	 * @return Reserva reserva
	 */
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
