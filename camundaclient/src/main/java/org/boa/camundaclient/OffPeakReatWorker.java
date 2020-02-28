package org.boa.camundaclient;

import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

import org.camunda.bpm.client.ExternalTaskClient;

public class OffPeakReatWorker {
	
	static Logger log = Logger.getLogger(OffPeakReatWorker.class.getName());
	
	public static void main(String[] args) {
		
		ExternalTaskClient client = ExternalTaskClient.create()
									.baseUrl("http://localhost:8080/engine-rest")
									.asyncResponseTimeout(10000)
									.build();
		
		client.subscribe("NotPeakRate").lockDuration(1000) // the default lock duration is 20 seconds, but you can override
			.handler((externalTask, externalTaskService) -> {
				Map<String, Object> variables = externalTask.getAllVariables();
				System.out.println(variables.size());
				
				variables.keySet().forEach(k -> System.out.println(k));
				// Put your business logic here
				log.info("VALUE IN OffPeakReatWorker -> " + variables.get("goldRate"));
				// Complete the task
				externalTaskService.complete(externalTask);
		}).open();
		
	}

}
