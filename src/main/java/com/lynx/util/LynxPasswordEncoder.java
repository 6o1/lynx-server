package com.lynx.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class LynxPasswordEncoder {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println("Encoded: " + encoder.encode(""));
	}

}
