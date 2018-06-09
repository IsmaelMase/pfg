package com.ismaelmasegosa.salerev.converter;

import org.springframework.stereotype.Component;

import com.ismaelmasegosa.salerev.entities.Recurso;
import com.ismaelmasegosa.salerev.models.RecursoModel;

/**
 * 
 * @author Ismael Masegosa
 *
 */
@Component("recursoConverter")
public class RecursoConverter {

	/**
	 * Convertir de entidad a modelo
	 * 
	 * @param r
	 *            Recurso
	 * @return RecursoModel recurso
	 */
	public RecursoModel converterEntityToModel(Recurso r) {
		RecursoModel rm = new RecursoModel();
		if (!r.getId().isEmpty()) {
			rm.setId(r.getId());
		}
		rm.setNombre(r.getNombre());
		rm.setTipo(r.getTipo());
		rm.setDatos(r.getDatos());
		if (r.getCapacidad() != 0) {
			rm.setCapacidad(r.getCapacidad());
		}
		rm.setIncidencia(r.getIncidencia());
		rm.setIntervalo(r.getIntervalo());
		rm.setImagen(r.getImagen());

		return rm;
	}

	/**
	 * Convertir de model a entidad
	 * 
	 * @param rm
	 *            RecursoModel
	 * @return RecursoModel recurso
	 */
	public Recurso converterModelToEntity(RecursoModel rm) {
		Recurso r = new Recurso();
		if (!rm.getId().isEmpty()) {
			r.setId(rm.getId());
		}
		r.setNombre(rm.getNombre());
		r.setTipo(rm.getTipo());
		r.setDatos(rm.getDatos());
		if (rm.getCapacidad() != 0) {
			r.setCapacidad(rm.getCapacidad());
		}
		r.setIncidencia(rm.getIncidencia());
		r.setIntervalo(rm.getIntervalo());
		r.setImagen(rm.getImagen());

		return r;
	}

}
