package com.example.cricketseatbooking.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long booking_id;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToMany
	private List <Seat> bookedSeats = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="event_id")
	private MatchEvent event;
	
	public Booking() {}

	public Booking(Long booking_id, User user, ArrayList<Seat> bookedSeats, MatchEvent event) {
		super();
		this.booking_id = booking_id;
		this.user = user;
		this.bookedSeats = bookedSeats;
		this.event = event;
	}

	public Long getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(Long booking_id) {
		this.booking_id = booking_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ArrayList<Seat> getBookedSeats() {
		return (ArrayList<Seat>) bookedSeats;
	}

	public void setBookedSeats(ArrayList<Seat> bookedSeats) {
		this.bookedSeats = bookedSeats;
	}

	public MatchEvent getEvent() {
		return event;
	}

	public void setEvent(MatchEvent event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return "Booking [booking_id=" + booking_id + ", user=" + user + ", bookedSeats=" + bookedSeats + ", event="
				+ event + "]";
	}
	
	
}
