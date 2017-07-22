package com.lynx.domain.enums;

public enum ContentType {
	
	APPLICATION_JSON(1), APPLICATION_PDF(2), APPLICATION_VND_MS_EXCEL(3), APPLICATION_MS_WORD(4), 
	TEXT_PLAIN(5), TEXT_HTML(6), IMAGE_PNG(7), IMAGE_JPEG(8);

	private int id;

	private ContentType(int id) {
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
	 * @return related ContentType enum
	 * @see http://blog.chris-ritchie.com/2013/09/mapping-enums-with-fixed-id-in
	 *      -jpa.html
	 * 
	 */
	public static ContentType getType(Integer id) {
		if (id == null) {
			return null;
		}
		for (ContentType position : ContentType.values()) {
			if (id.equals(position.getId())) {
				return position;
			}
		}
		throw new IllegalArgumentException("No matching type for id: " + id);
	}

}
