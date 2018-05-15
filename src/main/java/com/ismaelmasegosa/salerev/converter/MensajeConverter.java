package com.ismaelmasegosa.salerev.converter;

import org.springframework.stereotype.Component;

import com.ismaelmasegosa.salerev.entities.Mensaje;
import com.ismaelmasegosa.salerev.models.MensajeModel;

@Component("mensajeConverter")
public class MensajeConverter {

	public MensajeModel converterEntityToModel(Mensaje m) {
		MensajeModel mm = new MensajeModel();
		if (!m.getId().isEmpty()) {
			mm.setId(m.getId());
		}
		mm.setCuerpo(m.getCuerpo());
		mm.setEmisor(m.getEmisor());
		mm.setReceptor(m.getReceptor());
		mm.setLeido(m.isLeido());
		return mm;
	}

	public Mensaje converteModelToEntity(MensajeModel mm) {
		Mensaje m = new Mensaje();
		if (!mm.getId().isEmpty()) {
			m.setId(mm.getId());
		}
		m.setCuerpo(mm.getCuerpo());
		m.setEmisor(mm.getEmisor());
		m.setReceptor(mm.getReceptor());
		m.setLeido(mm.isLeido());

		return m;
	}
}
