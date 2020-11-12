package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.dto.SelectFlightDto;
import com.lti.entity.Flight;
import com.lti.exception.FlightServiceException;
import com.lti.exception.UserServiceException;
import com.lti.repository.FlightRepo;
import com.lti.repository.PassengerRepo;

@Service
public class FlightServiceImp implements FlightService {
	@Autowired
	FlightRepo flightRepo;
	@Autowired
	PassengerRepo passengerRepo;

	@Override
	public void addFlight(Flight flight) {
		// TODO Auto-generated method stub
		try {
			int flightNo = flightRepo.addAFlight(flight);
			System.out.println("Flight Added Succesfully");

		} catch (EmptyResultDataAccessException e) {
			throw new FlightServiceException("Flight could not be added");
		}

	}

	@Override
	public List<Flight> search(String from, String to) {
		// TODO Auto-generated method stub
		List<Flight> f = flightRepo.findFlightByFromTo(from, to);
		if (f.size() > 0)
			return f;
		else
			throw new FlightServiceException("No Flights available");

	}

	@Override
	public List<Flight> viewAllFlight() {
		// TODO Auto-generated method stub
		return flightRepo.viewAllFlight();

	}

	@Override
	public List<String> viewFlightFrom() {
		// TODO Auto-generated method stub
		return flightRepo.viewAllFlightFrom();
	}

	@Override
	public List<String> viewFlightTo() {
		// TODO Auto-generated method stub
		return flightRepo.viewAllFlightTo();
	}

	@Override
	public Flight get(int flightNo) {
		// TODO Auto-generated method stub
		return flightRepo.findFlightById(flightNo);
	}

	@Override
	public void deleteAFlight(int flightId) {
		// TODO Auto-generated method stub
		int k = passengerRepo.findFlightInPassenger(flightId);
		if (k == 0) {
			Flight flight=flightRepo.findFlightById(flightId);
			flightRepo.deleteAFlight(flight);
		} else {
			throw new FlightServiceException("cannot delete flight");

		}

	}

}
