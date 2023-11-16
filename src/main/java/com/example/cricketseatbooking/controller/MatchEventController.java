package com.example.cricketseatbooking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.cricketseatbooking.entities.MatchEvent;
import com.example.cricketseatbooking.service.MatchEventService;

@RestController
public class MatchEventController {

	@Autowired
	MatchEventService matchEventService;
	
	@PostMapping("/addEvent")
	public String addEvent(@RequestBody MatchEvent matchEvent) {
		
		return matchEventService.addEvent(matchEvent);
	}
	
	@GetMapping("/getEvent/{eventId}")
	public MatchEvent getEvent(@PathVariable Long eventId) {
		
		return matchEventService.getEvent(eventId);
	}
	
	@PutMapping("/updateEvent/{eventId}")
	public MatchEvent updateEvent(@PathVariable Long eventId, @RequestBody MatchEvent newMatchEvent) {
		
		return matchEventService.updateEvent(eventId, newMatchEvent);
	}
	
	@DeleteMapping("/deleteEvent/{eventId}")
	public String deleteEvent(@PathVariable Long eventId) {
		
		return null;
	}
}
