package com.lynx.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class LynxUtils {

	private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

	public static String encode(String plaintext) {
		return encoder.encode(plaintext);
	}

}
