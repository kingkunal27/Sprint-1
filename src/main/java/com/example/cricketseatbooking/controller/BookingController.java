package com.example.cricketseatbooking.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricketseatbooking.entities.Booking;
import com.example.cricketseatbooking.service.BookingService;

@RestController
public class BookingController {

	
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/addBooking")
	//public String addBooking(@RequestBody Booking booking, @RequestParam Long user_id, @RequestParam Long eventId, @RequestParam ArrayList<Long> seatId) {
	public String addBooking(@RequestBody Booking booking) {
		
	
		return bookingService.addBooking(booking) ;
	}
	
	@GetMapping("/getBooking/{booking_id}")
	public Booking getBooking(@PathVariable Long booking_id) {
		
		return bookingService.getBooking(booking_id);
	}
	
	@PutMapping("/updateBooking/{booking_id}")
	public Booking updateBooking(@PathVariable Long booking_id, @RequestBody Booking newBooking) {
		
		return bookingService.updateBooking(booking_id, newBooking);
	}
	
	@DeleteMapping("/deleteBooking/{booking_id}")
	public String deleteBooking(Long booking_id) {
	
		String delmsg = bookingService.deleteBooking(booking_id);
		
		return delmsg;
    }
}