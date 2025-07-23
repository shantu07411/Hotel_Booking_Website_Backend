package com.thundercube.Service1.UserRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thundercube.Service1.pojos.Hotel;

import jakarta.transaction.Transactional;

@Repository
public interface HotelRepo extends CrudRepository<Hotel, Integer> {
	public List<Hotel> findAll();
	public List<Hotel> findByhotelname(String hotelname);
	public Hotel findByhotelId(int hotelId);
	@Modifying
	@Transactional
	@Query("UPDATE Hotel h SET h.totalrooms = ?1 WHERE h.hotelId = ?2")
	void updateHotelRooms( int totalrooms, int hotelid);
	
	


}
