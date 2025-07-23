package com.thundercube.Service1.UserRepository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thundercube.Service1.pojos.Booking;

@Repository
public interface BookingRepo extends CrudRepository<Booking, Integer>{
	
	public List<Booking>findAll();
	public List<Booking>findBycurrdate(LocalDate currdate);
	

}
