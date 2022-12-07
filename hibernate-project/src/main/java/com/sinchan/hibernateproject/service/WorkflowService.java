package com.sinchan.hibernateproject.service;

import java.util.List;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinchan.hibernateproject.requestDto.ProcessEventDto;
import com.sinchan.hibernateproject.requestDto.WorkflowStartDto;
import com.sinchan.hibernateproject.responseDto.WorkflowResponseDto;

@Service
public class WorkflowService {
	// @Autowired
	// SpringProcessEngineConfiguration processEngineConfig;
	@Autowired
	RuntimeService runtimeService;
	@Autowired
	TaskService taskService;

	public WorkflowResponseDto startWorkflow(WorkflowStartDto dto) {
		WorkflowResponseDto response = new WorkflowResponseDto();
		String processId = "";
		System.out.println(dto.toString());
		try {
			final ProcessInstance processInstance = runtimeService
					.startProcessInstanceByKey(dto.getJourneyName(), dto.getVariableMap());

			runtimeService.setVariables(processInstance.getId(), dto.getVariableMap());
			;
			processId = processInstance.getId();

			response.setProcessId(processId);
			response.setProcessName(dto.getJourneyName());
			System.out.println(response.toString());
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return response;
	}

	public String processEvent(ProcessEventDto dto) {
		String taskId = "";
		runtimeService.setVariable(dto.getProcessId(), "eventName", dto.getEventName());
		TaskQuery taskQuery = taskService.createTaskQuery().active();
		List<Task> taskList = taskQuery.list();
		for (Task task : taskList) {
			taskId = task.getId();
		}

		taskService.complete(taskId);

		return "Completed";
	}

}
