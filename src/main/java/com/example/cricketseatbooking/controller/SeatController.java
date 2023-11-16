package com.example.cricketseatbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricketseatbooking.entities.Seat;
import com.example.cricketseatbooking.service.SeatService;

@RestController
public class SeatController {

	@Autowired 
	SeatService seatService;
	
	@PostMapping("/addSeat")
	public String addSeat(@RequestBody Seat seat) {
		
		return seatService.addSeat(seat);
	}
	
	@PutMapping("/updateSeat/{seatId}")
	public Seat updateSeat(@PathVariable Long seatId, @RequestBody Seat newSeat) {
		
		return seatService.updateSeat(seatId, newSeat);
	}
	
	@DeleteMapping("/deleteSeat/{seatId}")
	public String deleteSeat(@PathVariable Long seatId) {
		
		String delmsg = seatService.deleteSeat(seatId);
		
		return delmsg;
	}
}
