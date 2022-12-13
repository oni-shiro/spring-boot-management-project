package com.sinchan.hibernateproject.workflow.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sinchan.hibernateproject.exceptions.ResourceNotFoundException;
import com.sinchan.hibernateproject.requestDto.ProcessEventDto;
import com.sinchan.hibernateproject.requestDto.WorkflowStartDto;
import com.sinchan.hibernateproject.responseDto.WorkflowResponseDto;
import com.sinchan.hibernateproject.services.WorkflowService;
import com.sinchan.hibernateproject.workflow.service.BookWflService;
@RestController
public class WorkflowController {
    private static Logger LOGGER = LoggerFactory.getLogger(WorkflowController.class);
    @Autowired
    WorkflowService wfService;

    /***
     * 
     * @param dto
     * @return responseEntity
     */
    @RequestMapping(value = "/startWorkFlow", method = RequestMethod.POST)
    public ResponseEntity<WorkflowResponseDto> startWorkflow(@RequestBody WorkflowStartDto dto)
            throws Exception {
        final WorkflowResponseDto response = wfService.startWorkflow(dto);
        LOGGER.error(response.toString());
        
        return ResponseEntity.ok(response);

    }

    /**
     * 
     * @param dto
     * @return String
     */

    @RequestMapping(value = "/processEvent", method = RequestMethod.POST)
    public ResponseEntity<String> processEvent(@RequestBody ProcessEventDto dto) throws Exception {
        final String response = wfService.processEvent(dto);
        LOGGER.error(response.toString());
        return ResponseEntity.ok(response);

    }
}
