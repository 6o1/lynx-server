package com.lynx.messaging.enums;

public enum RegistrationResultCode {
	REGISTRATION_SUCCESS(1), REGISTRATION_FAILURE(2);

	private int id;

	private RegistrationResultCode(int id) {
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
	 * @return related RegistrationResultCode enum
	 * @see http://blog.chris-ritchie.com/2013/09/mapping-enums-with-fixed-id-in
	 *      -jpa.html
	 * 
	 */
	public static RegistrationResultCode getType(Integer id) {
		if (id == null) {
			return null;
		}
		for (RegistrationResultCode type : RegistrationResultCode.values()) {
			if (id.equals(type.getId())) {
				return type;
			}
		}
		throw new IllegalArgumentException("No matching type for id: " + id);
	}

}
