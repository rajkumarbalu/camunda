package org.boa.visaprocess.models;

import java.io.Serializable;
import java.time.LocalDate;


public class Flight implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fromCity;
	private String toCity;
	private LocalDate travelDate;
	
	
	
	public Flight(String fromCity, String toCity, LocalDate travelDate) {
		super();
		this.fromCity = fromCity;
		this.toCity = toCity;
		this.travelDate = travelDate;
	}
	public String getFromCity() {
		return fromCity;
	}
	public void setFromCity(String fromCity) {
		this.fromCity = fromCity;
	}
	public String getToCity() {
		return toCity;
	}
	public void setToCity(String toCity) {
		this.toCity = toCity;
	}
	public LocalDate getTravelDate() {
		return travelDate;
	}
	public void setTravelDate(LocalDate travelDate) {
		this.travelDate = travelDate;
	}
	
	
	
}
