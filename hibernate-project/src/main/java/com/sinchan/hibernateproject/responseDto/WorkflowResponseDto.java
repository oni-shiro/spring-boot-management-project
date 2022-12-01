package com.sinchan.hibernateproject.responseDto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class WorkflowResponseDto {
	private String processId;
	private String processName;

	public WorkflowResponseDto() {
		super();
	}

	public WorkflowResponseDto(String processId, String processName) {
		super();
		
		this.processId = processId;
		this.processName = processName;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	public String getProcessName() {
		return processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	@Override
	public String toString() {
		return "WorkflowResponseDto [processId=" + processId + ", processName=" + processName + "]";
	}

}
