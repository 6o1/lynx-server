package com.lynx.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.lynx.config.SecurityConfig;

public class LynxUtils {

	public static void main(String[] args) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(SecurityConfig.ENCODER_STRENGTH);
		System.out.println("PWD: " + encoder.encode("lynx"));
	}

}
