package com.lynx.messaging.messages;

import java.io.Serializable;

import com.lynx.messaging.enums.MessageType;

public interface LynxIncomingMessage extends Serializable {

	MessageType getType();

	String getFrom();

}
