package com.lynx.messaging.messages;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lynx.domain.enums.ContentType;
import com.lynx.domain.enums.TaskResultCode;
import com.lynx.messaging.enums.MessageType;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskResultMessage implements LynxIncomingMessage {

	private static final long serialVersionUID = 8204329414272089579L;

	private MessageType type = MessageType.USER_SESSION;

	private String from;

	private TaskResultCode code;

	private Map<String, Object> data;

	private ContentType contentType;

}
