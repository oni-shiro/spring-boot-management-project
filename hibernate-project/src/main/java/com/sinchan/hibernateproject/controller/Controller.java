package com.sinchan.hibernateproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sinchan.hibernateproject.constants.StringConstants;
import com.sinchan.hibernateproject.entity.CourseEntity;
import com.sinchan.hibernateproject.requestDto.CourseIdReqDto;
import com.sinchan.hibernateproject.requestDto.Demo;
import com.sinchan.hibernateproject.requestDto.ProcessEventDto;
import com.sinchan.hibernateproject.requestDto.WorkflowStartDto;
import com.sinchan.hibernateproject.responseDto.WorkflowResponseDto;
import com.sinchan.hibernateproject.service.CourseService;
import com.sinchan.hibernateproject.service.WorkflowService;

/***
 * @author sinchan
 */
@RestController
public class Controller {

	@Autowired
	CourseService courseService;
	@Autowired
	WorkflowService wfService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return StringConstants.running;
	}

	@RequestMapping(value = "/getCourseById", method = RequestMethod.POST)
	public CourseEntity getCourseById(@RequestBody CourseIdReqDto reqDto) {
		System.err.println(reqDto.toString());
		CourseEntity courseObj = courseService.getCourseById(reqDto.getId());
		// System.err.println(courseObj.toString());
		return courseObj;

	}

	@RequestMapping(value = "/demo", method = RequestMethod.POST)
	public String demo(@RequestBody Demo demo) {
		System.err.println(demo.toString());
		return demo.toString();

	}

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
