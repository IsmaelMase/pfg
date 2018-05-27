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

	public ResponseEntity<String> sendMail(ChangePass change) {

		try {
			UsuarioModel usuario = usuarioConverter
					.converterEntityToModel(usuarioRepository.findByEmail(change.getEmail()));
			if (usuario == null) {
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
			String asunto = "TAS. Aviso cambio de contraseña";
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

}
