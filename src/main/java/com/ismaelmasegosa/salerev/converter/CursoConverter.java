package com.ismaelmasegosa.salerev.converter;

import org.springframework.stereotype.Component;

import com.ismaelmasegosa.salerev.entities.Curso;
import com.ismaelmasegosa.salerev.models.CursoModel;

/**
 * 
 * @author Ismael Masegosa
 *
 */
@Component("cursoConverter")
public class CursoConverter {

	/**
	 * Convertir de entidad a modelo.
	 *
	 * @param c
	 *            Curso curso
	 * @return CursoModel curso
	 */
	public CursoModel converterEntityToModel(Curso c) {
		CursoModel cm = new CursoModel();
		if (!c.id.isEmpty()) {
			cm.setId(c.getId());
		}
		cm.setNombre(c.getNombre());

		return cm;
	}

	/**
	 * Convertir de modelo a entidad.
	 *
	 * @param cm
	 *            CursoModel curso
	 * @return Curso curso
	 */
	public Curso converterModelToEntity(CursoModel cm) {
		Curso c = new Curso();
		if (!cm.id.isEmpty()) {
			c.setId(cm.getId());
		}
		c.setNombre(cm.getNombre());

		return c;
	}

}
