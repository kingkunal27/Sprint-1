package com.example.cricketseatbooking.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricketseatbooking.entities.Booking;
import com.example.cricketseatbooking.entities.MatchEvent;
import com.example.cricketseatbooking.entities.Seat;
import com.example.cricketseatbooking.entities.User;
import com.example.cricketseatbooking.repository.BookingRepository;
import com.example.cricketseatbooking.repository.MatchEventRepository;
import com.example.cricketseatbooking.repository.SeatRepository;
import com.example.cricketseatbooking.repository.UserRepository;

@Service
public class BookingService {

	@Autowired
	BookingRepository bookingRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	SeatRepository seatRepository;
	
	@Autowired
	MatchEventRepository matchEventRepository;
	
	public String addBooking(Booking booking) {
		
		Long user_id = booking.getUser().getUser_id();
		Long eventId = booking.getEvent().getEventId();
		List<Long> seatId = booking.getBookedSeats().stream().map(Seat::getSeatId).collect((Collectors.toList()));
		
		User user = userRepository.findById(user_id).orElse(null);
	    
		   MatchEvent event =  matchEventRepository.findById(eventId).orElse(null);
		   
		   ArrayList<Seat> seats =  (ArrayList<Seat>) seatRepository.findAllById(seatId);
		   
		   if(user != null && event != null && !seats.isEmpty()) {
			   
			   booking.setUser(user);
			   booking.setEvent(event);
			   booking.setBookedSeats(seats);
			   
			   bookingRepository.save(booking);
			   
			   user.getBookingHistory().add(booking);
			   userRepository.save(user);
			   
			   return "Booking "+ booking.getBooking_id() +" created successfully";
		   } else {
			   return "User, MatchEvent, or Seat not found";
		   }
		
		
		/*User user = userRepository.findById(user_id).get();
	    
	   MatchEvent event =  matchEventRepository.findById(eventId).get();
	   
	   ArrayList<Seat> seats =  (ArrayList<Seat>) seatRepository.findAllById(seatId);
	    
	    if(user != null && event != null && !seats.isEmpty()) {
	    //Booking book = new Booking();
		booking.setUser(user);
		booking.setEvent(event);
		booking.setBookedSeats(seats);
	  
		bookingRepository.save(booking);
		
		return "Booking " +booking.getBooking_id()+"created successfully";
	    } else {
	    	return "User, MatchEvent, or Seat not found";
	    }*/
		/*if(b1 != null) {
			return "Booking " + b1.getBooking_id() + " created successfully";
		} else {
		return null;
	}*/
  }
	public Booking getBooking(Long booking_id) {
		
		Booking b2 = bookingRepository.findById(booking_id).get();
		
		return b2;
	}
	
	public Booking updateBooking(Long booking_id, Booking newBooking) {
		
	Booking b3 = bookingRepository.findById(booking_id).get();
	
	if(b3 != null) {
		
		b3.setBookedSeats(newBooking.getBookedSeats());
		b3.setEvent(newBooking.getEvent());
		b3.setUser(newBooking.getUser());
		
		return bookingRepository.save(b3);
	} else {
		
		return null;
	}
		
	}
	
	public String deleteBooking(Long booking_id) {
		
		bookingRepository.findById(booking_id);
		
		if(booking_id == null) {
			return "Booking with id " + booking_id + " not found";
		} else {
			return "Booking with id " + booking_id +" deleted successfully";
		}
	}
}
