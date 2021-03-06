package com.ismaelmasegosa.salerev.auth;

import lombok.experimental.UtilityClass;

@UtilityClass
public class SecurityConstants {
	public static final String SECRET = "SecretKeyToGenJWTs";
	public static final long EXPIRATION_TIME = 864_000_000; // 10 days
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String SIGN_UP_URL = "/api/usuario/saveUsuario";
	public static final String LOG_IN_URL = "/api/login";
	public static final String SAVE_IMAGE = "/api/upload/saveFile";
	public static final String GET_FILE = "/api/upload/files/{filename:.+}";
	public static final String FORGET_PASS = "/api/mail/sendMail";

}
