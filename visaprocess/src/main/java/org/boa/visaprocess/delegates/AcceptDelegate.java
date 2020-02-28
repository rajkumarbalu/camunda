package org.boa.visaprocess.delegates;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("acceptedDelegate")
public class AcceptDelegate implements JavaDelegate {
	
	@Autowired
	private RuntimeService runtimeService;
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println("Visa Accepted -> " + execution.getVariable("status"));
		
		
		/*
		 * runtimeService.createSignalEvent("Signal_1pcdpsb").send();
		 * execution.setVariable("token", 24);
		 */
		  
		 
		System.out.println("Subprocess Triggered");
		
	}

}
