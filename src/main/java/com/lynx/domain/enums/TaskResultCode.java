package com.lynx.domain.enums;

public enum TaskResultCode {

	TASK_RECEIVED(1), TASK_PROCESSING(2), TASK_PROCESSED(3), TASK_WARNING(4), 
	TASK_ERROR(5), TASK_TIMEOUT(6), TASK_CANCELLED(7);

	private int id;

	private TaskResultCode(int id) {
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
	 * @return related TaskResultCode enum
	 * @see http://blog.chris-ritchie.com/2013/09/mapping-enums-with-fixed-id-in
	 *      -jpa.html
	 * 
	 */
	public static TaskResultCode getType(Integer id) {
		if (id == null) {
			return null;
		}
		for (TaskResultCode type : TaskResultCode.values()) {
			if (id.equals(type.getId())) {
				return type;
			}
		}
		throw new IllegalArgumentException("No matching type for id: " + id);
	}

}
