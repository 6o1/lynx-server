package com.lynx.domain;

import java.util.Date;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.lynx.domain.enums.ContentType;
import com.lynx.domain.enums.TaskResultCode;

import lombok.Builder;
import lombok.Getter;

@Document(collection = "taskresult")
@Getter
@Builder
public class TaskResult extends LynxBaseCollection {

	@Id
	private String id;

	@NotNull
	private Agent agent;

	@NotNull
	private Task task;

	@NotNull
	private TaskResultCode status;

	private Map<String, Object> data;

	private ContentType contentType;

	@Builder
	public TaskResult(String id, Agent agent, Task task, TaskResultCode status, Map<String, Object> data,
			ContentType contentType, Date dateCreated, String createdBy, Date dateUpdated, String updatedBy) {
		super(dateCreated, createdBy, dateUpdated, updatedBy);
		this.id = id;
		this.agent = agent;
		this.task = task;
		this.status = status;
		this.data = data;
		this.contentType = contentType;
	}

}
