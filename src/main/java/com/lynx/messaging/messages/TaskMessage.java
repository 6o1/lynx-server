package com.lynx.messaging.messages;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lynx.messaging.enums.MessageType;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskMessage implements LynxOutgoingMessage {

	private static final long serialVersionUID = 126644449176283614L;

	private MessageType type = MessageType.TASK;

	private String recipient;

	private String task;

}
