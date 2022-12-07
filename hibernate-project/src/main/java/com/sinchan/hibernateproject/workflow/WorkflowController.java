package com.sinchan.hibernateproject.workflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sinchan.hibernateproject.requestDto.ProcessEventDto;
import com.sinchan.hibernateproject.requestDto.WorkflowStartDto;
import com.sinchan.hibernateproject.responseDto.WorkflowResponseDto;
import com.sinchan.hibernateproject.service.WorkflowService;

public class WorkflowController {
    @Autowired
	WorkflowService wfService;  
    /***
	 * 
	 * @param dto
	 * @return responseEntity
	 */
	@RequestMapping(value = "/startWorkFlow", method = RequestMethod.POST)
	public ResponseEntity<WorkflowResponseDto> startWorkflow(@RequestBody WorkflowStartDto dto) {
		final WorkflowResponseDto response = wfService.startWorkflow(dto);
		return ResponseEntity.ok(response);

	}

	/**
	 * 
	 * @param dto
	 * @return String
	 */

	@RequestMapping(value = "/processEvent", method = RequestMethod.POST)
	public ResponseEntity<String> processEvent(@RequestBody ProcessEventDto dto) {
		final String response = wfService.processEvent(dto);
		return ResponseEntity.ok(response);

	}
}
