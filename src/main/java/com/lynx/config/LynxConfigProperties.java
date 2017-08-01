package com.lynx.config;

import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * Helper class which can be used to access Lynx-related configuration
 * properties easily.
 * 
 * @author <a href="mailto:emre.akkaya@agem.com.tr">Emre Akkaya</a>
 *
 */
@Data
@Component
@ConfigurationProperties(prefix = "lynx")
public class LynxConfigProperties {

	@Length(min = 2, max = 5, message = "Locale value must conform to the IETF BCP 47 standard.")
	private String locale;
	private String dateFormat;
	private String sendInstallationInfo;
	private FileServer fileServer;
	private Mail mail;

	@Data
	public static class FileServer {
		private String protocol;
		private String host;
		@Max(65536)
		private Integer port;
		private String username;
		private String password;
		private String filePath;
	}

	@Data
	public static class Mail {

		@Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$", message = "Invalid email pattern.")
		private String address;
		private String password;
		private String host;
		@Max(65536)
		private Integer smtpPort;
		private Boolean smtpAuth;
		private Boolean smtpStarttlsEnable;
		private Boolean smtpSslEnable;
		private Integer smtpConnectionTimeout;
		private Integer smtpTimeout;
		private Integer smtpWriteTimeout;
		private Boolean collectInfo;
		private List<String> defaultRecipients;
	}

}
