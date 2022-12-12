package com.sinchan.hibernateproject.requestDto;

import com.sinchan.hibernateproject.workflow.dto.NewBookReq;

/**
 * @author sinch
 *
 */
public class ProcessEventDto {
	private String processId;
	private String eventName;
	private NewBookReq bookReq;

	public ProcessEventDto(String processId, String eventName) {
		super();
		this.processId = processId;
		this.eventName = eventName;
	}
	
	

	public ProcessEventDto(String processId, String eventName, NewBookReq bookReq) {
        super();
        this.processId = processId;
        this.eventName = eventName;
        this.bookReq = bookReq;
    }



    public ProcessEventDto() {
		super();
	}

    
	public NewBookReq getBookReq() {
        return bookReq;
    }



    public void setBookReq(NewBookReq bookReq) {
        this.bookReq = bookReq;
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
