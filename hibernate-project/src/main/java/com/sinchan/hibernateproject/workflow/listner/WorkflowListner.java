package com.sinchan.hibernateproject.workflow.listner;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.springframework.stereotype.Component;

@Component
public class WorkflowListner {
	public void logInfo(final DelegateExecution execution) throws Exception {
		System.out.println("Log the info of user id");
		System.out.println(execution.getProcessInstance().toString());
		try {
			System.out.println(execution.getVariable("age").toString());
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		
		
		
	}
}
