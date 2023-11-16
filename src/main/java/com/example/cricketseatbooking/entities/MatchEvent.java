package com.example.cricketseatbooking.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MatchEvent {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eventId;
	private String title;
	private String venue;
	private String teamsPlaying;
	private int ticketAvailability;
	
	public MatchEvent() {}
	
	public MatchEvent(Long eventId, String title, String venue, String teamsPlaying, int ticketAvailability) {
		super();
		this.eventId = eventId;
		this.title = title;
		this.venue = venue;
		this.teamsPlaying = teamsPlaying;
		this.ticketAvailability = ticketAvailability;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public String getTeamsPlaying() {
		return teamsPlaying;
	}

	public void setTeamsPlaying(String teamsPlaying) {
		this.teamsPlaying = teamsPlaying;
	}

	public int getTicketAvailability() {
		return ticketAvailability;
	}

	public void setTicketAvailability(int ticketAvailability) {
		this.ticketAvailability = ticketAvailability;
	}

	@Override
	public String toString() {
		return "MatchEvent [eventId=" + eventId + ", title=" + title + ", venue=" + venue + ", teamsPlaying="
				+ teamsPlaying + ", ticketAvailability=" + ticketAvailability + "]";
	}
	
	
}
