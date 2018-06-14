package com.ismaelmasegosa.salerev.service.serviceImpl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.ismaelmasegosa.salerev.converter.UsuarioConverter;
import com.ismaelmasegosa.salerev.entities.Usuario;
import com.ismaelmasegosa.salerev.models.ChangePass;
import com.ismaelmasegosa.salerev.models.UsuarioModel;
import com.ismaelmasegosa.salerev.repository.UsuarioRepository;

@Service("mailService")
public class MailService {

	@Autowired
	private JavaMailSender mail;

	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRepository;

	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;

	@Autowired
	@Qualifier("usuarioService")
	private UsuarioServiceImpl usarioService;

	/**
	 * Notificar via email el cambio de contraseña
	 * 
	 * @param change
	 *            ChangePass datos para el cambio de contraseña
	 * @return ResponseEntity<String> response
	 */
	public ResponseEntity<String> sendMail(ChangePass change) {

		try {
			UsuarioModel usuario;
			try {
				usuario = usuarioConverter.converterEntityToModel(usuarioRepository.findByEmail(change.getEmail()));
			} catch (Exception e) {
				return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
			}
			try {
				usuario.setPassword(change.getPassEncr());
				usarioService.addUsuario(usuario);
			} catch (Exception e) {
				return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}

			String mensaje = "Le comunicamos que la contraseña de acceso ha sido cambiada por petición del usuario.\n"
					+ "Su nueva contraseña es: " + change.getPass();
			String asunto = "SalesRev. Aviso cambio de contraseña";
			MimeMessage message = mail.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			helper.setTo(change.getEmail());
			helper.setText(mensaje);
			helper.setSubject(asunto);
			mail.send(message);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * Notificar via email a los administradores la notificacion de una incidencia
	 * 
	 * @param nombreRecurso
	 *            String nombre del recurso o aula
	 * @param incidencia
	 *            String incidencia
	 * @return ResponseEntity<String> response
	 */
	public ResponseEntity<String> sendMailIncidencia(String nombreRecurso, String incidencia) {

		try {
			UsuarioModel usuario;

			for (Usuario u : usuarioRepository.findByRolAndEstado("ROL_ADMIN", true)) {
				String mensaje = "Se ha notificado una incidencia en el aula/recurso " + nombreRecurso + ".\n"
						+ "Incidencia:\n" + incidencia;
				String asunto = "SalesRev. Aviso de incidencia";
				MimeMessage message = mail.createMimeMessage();
				MimeMessageHelper helper = new MimeMessageHelper(message);
				helper.setTo(u.getEmail());
				helper.setText(mensaje);
				helper.setSubject(asunto);
				mail.send(message);
			}
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}

	}

}
