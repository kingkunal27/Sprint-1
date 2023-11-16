package com.example.cricketseatbooking.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.cricketseatbooking.entities.Seat;

public interface SeatRepository extends CrudRepository<Seat, Long>{

}
