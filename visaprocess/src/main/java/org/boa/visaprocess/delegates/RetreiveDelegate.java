package org.boa.visaprocess.delegates;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.boa.visaprocess.models.Flight;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("retreiveDelegate")
public class RetreiveDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		String fromCity = execution.getVariable("fromCity").toString();
		String toCity = execution.getVariable("toCity").toString();
		Date date = (Date)execution.getVariable("travelDate");
		LocalDate travelDate = Instant.ofEpochMilli(date.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
		List<Flight> filteredFlights = getAvailableFlights().stream().filter(r ->  {
			//r.getTravelDate().plusMonths(1);
			return (r.getFromCity().equals(fromCity) && r.getToCity().equals(toCity));
		}).collect(Collectors.toList());
		execution.setVariable("availableFlights", filteredFlights);
		execution.setVariable("availableFlightCount", filteredFlights.size());
	}
	
	private List<Flight> getAvailableFlights() {
		List<Flight> flightList = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			flightList.add(new Flight("From"+i,
									  "To"+i,
									  LocalDate.of(2020, 1+i, 1+i)));
		}
		
		return flightList;
	}

}
