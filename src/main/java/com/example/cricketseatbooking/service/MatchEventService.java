package com.example.cricketseatbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cricketseatbooking.entities.MatchEvent;
import com.example.cricketseatbooking.repository.MatchEventRepository;

@Service
public class MatchEventService {

	@Autowired
	MatchEventRepository matchEventRepository;
	
	public String addEvent(MatchEvent matchEvent) {
		
	MatchEvent me1 = matchEventRepository.save(matchEvent);
		
	if(me1 != null) {
		return "MatchEvent " + me1.getEventId() +" created successfully";
	} else {
		return null;
	}
	
      }
	
	public MatchEvent getEvent(Long eventId) {
		
	MatchEvent me2 = matchEventRepository.findById(eventId).get();
	
	    return me2;
	}
	
	public MatchEvent updateEvent(Long eventId, MatchEvent newMatchEvent) {
		
		MatchEvent me3 = matchEventRepository.findById(eventId).get();
		
		if(me3 != null) {
			
			me3.setTitle(newMatchEvent.getTitle());
			me3.setVenue(newMatchEvent.getVenue());
			me3.setTeamsPlaying(newMatchEvent.getTeamsPlaying());
			me3.setTicketAvailability(newMatchEvent.getTicketAvailability());
			
			return matchEventRepository.save(me3);
		} else {
			
			return null;
		}
	}
	
	public String deleteEvent(Long eventId) {
		
		matchEventRepository.findById(eventId);
		
		if(eventId == null) {
			
			return "Match with id " + eventId + " not found";
		} else {
			
			return "Match with id " + eventId + " deleted successfully"; 
		}
		
	}

}