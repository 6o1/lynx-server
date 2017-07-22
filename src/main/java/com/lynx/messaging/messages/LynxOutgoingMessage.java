package com.lynx.messaging.messages;

import java.io.Serializable;

import com.lynx.messaging.enums.MessageType;

public interface LynxOutgoingMessage extends Serializable {

	MessageType getType();

	String getRecipient();

}
