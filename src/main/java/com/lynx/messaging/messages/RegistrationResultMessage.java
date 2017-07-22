package com.lynx.messaging.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lynx.messaging.enums.MessageType;
import com.lynx.messaging.enums.RegistrationResultCode;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrationResultMessage implements LynxOutgoingMessage {

	private static final long serialVersionUID = -7621316011243943127L;

	private MessageType type = MessageType.TASK;

	private String recipient;

	private String uid;

	private RegistrationResultCode code;

}
