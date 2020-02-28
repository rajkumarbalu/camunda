package org.boa.visaprocess;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngines;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.history.DurationReportResult;
import org.camunda.bpm.engine.query.PeriodUnit;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.ProcessApplicationStartedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableProcessApplication("visaprocess")
public class CamundaApplication {

	@Autowired
	private RuntimeService runTimeService;

	@Autowired
	private HistoryService historyService;

	private static final String PROCESS_DEFENITION_KEY = "generateRandom";

	public static void main(String... args) {
		SpringApplication.run(CamundaApplication.class, args);
	}

	@EventListener
	public void onStart(final ProcessApplicationStartedEvent event) {

		/*
		 * ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
		 * 
		 * Map<String, Object> variables = new HashMap<>(); variables.put("email",
		 * "rajkumar.ab@bofa.com"); ProcessInstance instance =
		 * runTimeService.startProcessInstanceByKey(PROCESS_DEFENITION_KEY, "123456",
		 * variables); historyService = processEngine.getHistoryService(); Calendar
		 * calendar = Calendar.getInstance(); List<DurationReportResult> duration =
		 * historyService.createHistoricProcessInstanceReport()
		 * .startedBefore(calendar.getTime()).duration(PeriodUnit.MONTH);
		 * 
		 * duration.forEach(e -> { System.out.println(e.getAverage());
		 * System.out.println(e.getMinimum()); System.out.println(e.getMaximum()); });
		 * 
		 * System.out.println(historyService.createHistoricJobLogQuery().count());
		 */
		
	}
}
