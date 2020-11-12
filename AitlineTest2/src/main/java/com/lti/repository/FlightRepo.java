package com.lti.repository;

import java.util.List;

import com.lti.dto.SelectFlightDto;
import com.lti.entity.Flight;
import com.lti.entity.User;


public interface FlightRepo {
	public int addAFlight(Flight flight);

	public List<Flight> viewAllFlight();

	public List<Flight> findFlightByFromTo(String from, String to);
	public Flight findFlightById(int flightNo);
	public List<String> viewAllFlightFrom();	
	public List<String> viewAllFlightTo();
	public void deleteAFlight(Flight flight);


}