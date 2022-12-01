package com.sinchan.hibernateproject.requestDto;

public class ProcessEventDto {
	private String processId;
	private String eventName;
	public ProcessEventDto(String processId, String eventName) {
		super();
		this.processId = processId;
		this.eventName = eventName;
	}
	public ProcessEventDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProcessId() {
		return processId;
	}
	public void setProcessId(String processId) {
		this.processId = processId;
	}
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	
}
