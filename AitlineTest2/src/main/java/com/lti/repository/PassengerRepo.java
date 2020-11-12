package com.lti.repository;
import java.time.LocalDate;
import java.util.List;

import com.lti.entity.Passenger;

public interface PassengerRepo {

	public int addApassenger(Passenger passenger );
	public Passenger findPassengerById(int passengerId);
	public List<Passenger> viewPassenger(int userId,int flightId,LocalDate dateOfTravel);
	public int findFlightInPassenger(int flightId);
	public List<Passenger> viewPassengerById(int userId);
	public int noOfSeatsBooked(int flightId,LocalDate dateOfTravel);

	

}
