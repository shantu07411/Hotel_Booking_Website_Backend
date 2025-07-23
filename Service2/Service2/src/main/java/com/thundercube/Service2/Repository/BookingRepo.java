package com.thundercube.Service2.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thundercube.Service2.pojos.Booking;

@Repository
public interface BookingRepo extends CrudRepository<Booking, String>{
	
	public List<Booking>findAll();
	public List<Booking>findBycurrdate(LocalDate currdate);
	

}
