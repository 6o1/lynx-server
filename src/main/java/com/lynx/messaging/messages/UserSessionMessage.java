package com.lynx.messaging.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lynx.domain.enums.SessionEvent;
import com.lynx.messaging.enums.MessageType;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSessionMessage implements LynxIncomingMessage {

	private static final long serialVersionUID = -787578099460211673L;

	private MessageType type = MessageType.USER_SESSION;

	private String from;

	private String username;

	private SessionEvent event;

}
