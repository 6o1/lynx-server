package com.lynx.messaging.messages;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lynx.messaging.enums.MessageType;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegistrationMessage implements LynxIncomingMessage {

	private static final long serialVersionUID = 6453831643640843007L;

	private MessageType type = MessageType.REGISTRATION;

	private String from;

	private String hostname;

	private String[] ipAddresses;

	private String[] macAddresses;

	private Map<String, Object> properties;

}
