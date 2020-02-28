package org.boa.camundaclient;

import java.util.Map;
import java.util.Objects;
import java.util.logging.Logger;

import org.camunda.bpm.client.ExternalTaskClient;

public class PeakRateWorker {
	static Logger log = Logger.getLogger(PeakRateWorker.class.getName());
	
	public static void main(String[] args) {
		
		ExternalTaskClient client = ExternalTaskClient.create()
									.baseUrl("http://localhost:8080/engine-rest")
									.asyncResponseTimeout(10000)
									.build();
		
		client.subscribe("PeakRate").lockDuration(1000) // the default lock duration is 20 seconds, but you can override
			.handler((externalTask, externalTaskService) -> {
				Map<String, Object> variables = externalTask.getAllVariables();
				long value = 0;
				try {
					if (Objects.nonNull(variables.get("goldRate"))) {
						value = (long) variables.get("goldRate");
					}
				} catch (Exception e) {
					log.info("Variables is null in PeakRate");
				}
				// Put your business logic here
				log.info("VALUE IN PeakRateWorker -> " + value);
				// Complete the task
				externalTaskService.complete(externalTask);
		}).open();
		
	}
}
