package com.lynx.domain;

import java.util.Date;

import lombok.Data;

@Data
public class LynxBaseCollection {

	private Date dateCreated;

	private String createdBy;

	private Date dateUpdated;

	private String updatedBy;

}
