package com.ismaelmasegosa.salerev.converter;

import org.springframework.stereotype.Component;

import com.ismaelmasegosa.salerev.entities.Horario;
import com.ismaelmasegosa.salerev.models.HorarioModel;

/**
 * 
 * @author Ismael Masegosa
 *
 */
@Component("intervaloConverter")
public class HorarioConverter {
	/**
	 * Convertir de entidad a modelo
	 * 
	 * @param i
	 *            Horario
	 * @return HorarioModel horario
	 */
	public HorarioModel converterEntityToModel(Horario i) {
		HorarioModel im = new HorarioModel();
		if (!i.id.isEmpty()) {
			im.setId(i.getId());
		}
		im.setNombre(i.getNombre());
		im.setIntervalos(i.getIntervalos());
		im.setFecha_max(i.getFecha_max());
		return im;
	}

	/**
	 * Convertir de model a entidad
	 * 
	 * @param im
	 *            HorarioModel
	 * @return Horario horario
	 */
	public Horario converterModelToEntity(HorarioModel im) {
		Horario i = new Horario();
		if (!im.id.isEmpty()) {
			i.setId(im.getId());
		}
		i.setNombre(im.getNombre());
		i.setIntervalos(im.getIntervalos());
		i.setFecha_max(im.getFecha_max());

		return i;
	}
}
