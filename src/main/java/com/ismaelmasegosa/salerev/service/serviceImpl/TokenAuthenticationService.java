package com.ismaelmasegosa.salerev.service.serviceImpl;

import static com.ismaelmasegosa.salerev.auth.SecurityConstants.EXPIRATION_TIME;
import static com.ismaelmasegosa.salerev.auth.SecurityConstants.HEADER_STRING;
import static com.ismaelmasegosa.salerev.auth.SecurityConstants.SECRET;
import static com.ismaelmasegosa.salerev.auth.SecurityConstants.TOKEN_PREFIX;
import static java.util.Collections.emptyList;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class TokenAuthenticationService {

	/**
	 * Añade al response el token generado
	 * 
	 * @param res
	 *            HttpServletResponse response
	 * @param username
	 *            String emailUsuario
	 */
	public static void addAuthentication(HttpServletResponse res, String username) {
		String JWT = Jwts.builder().setSubject(username)
				.setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
		res.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);

	}

	/**
	 * Comprueba la autenticacion del token
	 * 
	 * @param request
	 *            HttpServletRequest request
	 * @return Authentication autenticacion
	 */
	public static Authentication getAuthentication(HttpServletRequest request) {
		String token = request.getHeader(HEADER_STRING);
		if (token != null) {
			// parse the token.
			String user = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token.replace(TOKEN_PREFIX, "")).getBody()
					.getSubject();

			return user != null ? new UsernamePasswordAuthenticationToken(user, null, emptyList()) : null;
		}
		return null;
	}
}
