package com.lynx.messaging.enums;

public enum MessageType {

	/**
	 * From server to agents
	 */
	TASK(1), REGISTRATION_RESULT(2), INSTALLATION_RESULT(3),
	/**
	 * From agents to server
	 */
	TASK_RESULT(4), REGISTRATION(5), INSTALLATION(6), USER_SESSION(7);

	private int id;

	private MessageType(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	/**
	 * Provide mapping enums with a fixed ID in JPA (a more robust alternative
	 * to EnumType.String and EnumType.Ordinal)
	 * 
	 * @param id
	 * @return related MessageType enum
	 * @see http://blog.chris-ritchie.com/2013/09/mapping-enums-with-fixed-id-in
	 *      -jpa.html
	 * 
	 */
	public static MessageType getType(Integer id) {
		if (id == null) {
			return null;
		}
		for (MessageType type : MessageType.values()) {
			if (id.equals(type.getId())) {
				return type;
			}
		}
		throw new IllegalArgumentException("No matching type for id: " + id);
	}
}
