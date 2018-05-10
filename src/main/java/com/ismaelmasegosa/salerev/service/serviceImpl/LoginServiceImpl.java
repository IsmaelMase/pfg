package com.ismaelmasegosa.salerev.service.serviceImpl;

import static com.ismaelmasegosa.salerev.auth.SecurityConstants.EXPIRATION_TIME;
import static com.ismaelmasegosa.salerev.auth.SecurityConstants.HEADER_STRING;
import static com.ismaelmasegosa.salerev.auth.SecurityConstants.SECRET;
import static com.ismaelmasegosa.salerev.auth.SecurityConstants.TOKEN_PREFIX;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import com.ismaelmasegosa.salerev.models.UsuarioModel;
import com.ismaelmasegosa.salerev.service.LoginService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public void login(UsuarioModel request, HttpServletResponse res) {
		Authentication auth = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

		String token = Jwts.builder().setSubject(((User) auth.getPrincipal()).toString())
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SECRET.getBytes()).compact();
		res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
	}
}