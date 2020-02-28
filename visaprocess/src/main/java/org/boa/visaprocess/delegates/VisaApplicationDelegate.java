package org.boa.visaprocess.delegates;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("readApplicationNo")
public class VisaApplicationDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		System.out.println(" Visa application number in the service task $$$$$$$$$$" + execution.getVariable("applicationNo"));
	}

}
