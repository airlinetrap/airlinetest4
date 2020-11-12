package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.entity.BoardingPass;
import com.lti.exception.BoardingPassServiceException;
import com.lti.exception.FlightServiceException;
import com.lti.repository.BoardingPassRepo;

@Service
public class BoardingPassServiceImp implements BoardingPassService {
@Autowired
BoardingPassRepo boardingPassRepo;
@Autowired
EmailService emailService;
	@Override
	public void generateBoardingPass(BoardingPass boardingPass) {
		// TODO Auto-generated method stub
		try {
			String email=boardingPass.getPassenger().getUser().getUserEmail();
			String message="Passenger Name: "+boardingPass.getPassenger().getPassengerName()+"\n Flight No: "+boardingPass.getPassenger().getFlight().getFlightNo()+"\n Date Of Travel:"+
			boardingPass.getPassenger().getDateOfTravel();
			int ticketId=boardingPassRepo.generateBoardingPass(boardingPass);
			emailService.sendEmailForNewRegistration(email, message, "Your Ticket Is Confirmed");

			System.out.println("Boarding Pass Added Succesfully");

		}
		catch(EmptyResultDataAccessException e)
		{
			throw new BoardingPassServiceException("Boarding pass could not be generated");
		}
		


	}

	@Override
	public List<BoardingPass> viewAllBoardingPass() {
		// TODO Auto-generated method stub
		return boardingPassRepo.viewAllBoardingPass();
	}

}
