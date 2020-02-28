package org.boa.visaprocess;

import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("logger")
public class VisaDelegate implements JavaDelegate{
	
	
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		System.out.println("Visa process - Call activity step called successfully");
		
	}

}
