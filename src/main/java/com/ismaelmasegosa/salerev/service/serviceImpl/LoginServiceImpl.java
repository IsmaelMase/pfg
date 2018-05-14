package com.ismaelmasegosa.salerev.service.serviceImpl;

import static com.ismaelmasegosa.salerev.auth.SecurityConstants.EXPIRATION_TIME;
import static com.ismaelmasegosa.salerev.auth.SecurityConstants.SECRET;
import static com.ismaelmasegosa.salerev.auth.SecurityConstants.TOKEN_PREFIX;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.ismaelmasegosa.salerev.converter.UsuarioConverter;
import com.ismaelmasegosa.salerev.models.LoginResponse;
import com.ismaelmasegosa.salerev.models.UsuarioModel;
import com.ismaelmasegosa.salerev.repository.UsuarioRepository;
import com.ismaelmasegosa.salerev.service.LoginService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	@Qualifier("usuarioRepository")
	private UsuarioRepository usuarioRepository;

	@Autowired
	@Qualifier("usuarioConverter")
	private UsuarioConverter usuarioConverter;

	@Override
	public ResponseEntity<LoginResponse> login(UsuarioModel request, HttpServletResponse res) {
		Authentication auth = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

		String token = Jwts.builder().setSubject(((User) auth.getPrincipal()).toString())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).compact();
		LoginResponse response = new LoginResponse(
				usuarioConverter.converterEntityToModel(usuarioRepository.findByEmail(request.getEmail())),
				TOKEN_PREFIX + token);
		return new ResponseEntity<LoginResponse>(response, HttpStatus.OK);
	}
}