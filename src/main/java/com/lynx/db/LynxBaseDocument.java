package com.lynx.db;

import java.util.Date;

import lombok.Data;

@Data
public class LynxBaseDocument {

	private Date createdOn;

	private String createdBy;

	private Date updatedOn;

	private String updatedBy;

}
