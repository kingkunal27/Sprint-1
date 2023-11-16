package com.example.cricketseatbooking.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.cricketseatbooking.entities.Booking;

public interface BookingRepository extends CrudRepository<Booking, Long>{

}
