package com.lynx.domain;

import java.util.Date;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.lynx.domain.enums.TaskResultCode;

import lombok.Builder;
import lombok.Getter;

@Document(collection = "task")
@Getter
public class Task extends LynxBaseCollection {

	@Id
	private String id;

	@NotNull
	private Plugin plugin;

	@NotNull
	private String label;

	@Indexed
	private String code;

	private String cronExpression;

	private Date activationDate;

	private Date expirationDate;

	private Long timeToLive;

	@NotNull
	private TaskResultCode status;

	private Map<String, Object> parameters;

	private Boolean cancelled;

	@Builder
	public Task(String id, Plugin plugin, String label, String code, String cronExpression, Date activationDate,
			Date expirationDate, Long timeToLive, TaskResultCode status, Map<String, Object> parameters,
			Boolean cancelled, Date dateCreated, String createdBy, Date dateUpdated, String updatedBy) {
		super(dateCreated, createdBy, dateUpdated, updatedBy);
		this.id = id;
		this.plugin = plugin;
		this.label = label;
		this.code = code;
		this.cronExpression = cronExpression;
		this.activationDate = activationDate;
		this.expirationDate = expirationDate;
		this.timeToLive = timeToLive;
		this.status = status;
		this.parameters = parameters;
		this.cancelled = cancelled;
	}

}
