package com.example.cricketseatbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricketseatbooking.entities.Seat;
import com.example.cricketseatbooking.repository.SeatRepository;

@Service
public class SeatService {

	@Autowired
	SeatRepository seatRepository;
	
	public String addSeat(Seat seat) {
		
	Seat s1 = seatRepository.save(seat);
	
	if(s1 != null)
		
		return "Seat " + s1.getSeatId() +" successfully reserved";
	else
	
		return null;
	}
	
	public Seat updateSeat(Long seatId,Seat newSeat) {
		
		Seat se1 = seatRepository.findById(seatId).get();
		
		if(se1 != null) {
			
			se1.setSeatNumber(newSeat.getSeatNumber());
			se1.setSeatCategory(newSeat.getSeatCategory());
			se1.setPrice(newSeat.getPrice());
			
			return seatRepository.save(se1);
		}
		else {
		return null;
	}
}
	
	public String deleteSeat(Long seatId) {
		
		seatRepository.findById(seatId);
		
		if(seatId == null) {
			
			return "Seat with Id " + seatId + " not found";
		} else {
			
			return "Seat with Id " + seatId + " deleted successfully";
		}
		
		
	}
}