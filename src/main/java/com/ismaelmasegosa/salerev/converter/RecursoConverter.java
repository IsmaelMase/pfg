package com.ismaelmasegosa.salerev.converter;

import org.springframework.stereotype.Component;

import com.ismaelmasegosa.salerev.entities.Recurso;
import com.ismaelmasegosa.salerev.models.RecursoModel;

@Component("recursoConverter")
public class RecursoConverter {

	public RecursoModel converterEntityToModel(Recurso r) {
		RecursoModel rm = new RecursoModel();
		if (!r.id.isEmpty()) {
			rm.setId(r.getId());
		}
		rm.setNombre(r.getNombre());
		rm.setTipo(r.getTipo());
		rm.setDatos(r.getDatos());
		if (r.getCapacidad() != 0) {
			rm.setCapacidad(r.getCapacidad());
		}
		rm.setIncidencia(r.getIncidencia());
		return rm;
	}

	public Recurso converterModelToEntity(RecursoModel rm) {
		Recurso r = new Recurso();
		if (!rm.id.isEmpty()) {
			r.setId(rm.getId());
		}
		r.setNombre(rm.getNombre());
		r.setTipo(rm.getTipo());
		r.setDatos(rm.getDatos());
		if (rm.getCapacidad() != 0) {
			r.setCapacidad(rm.getCapacidad());
		}
		r.setIncidencia(rm.getIncidencia());

		return r;
	}

}
