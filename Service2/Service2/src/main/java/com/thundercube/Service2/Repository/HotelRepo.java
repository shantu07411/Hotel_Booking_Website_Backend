package com.thundercube.Service2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thundercube.Service2.pojos.Hotel;

import jakarta.transaction.Transactional;

@Repository
public interface HotelRepo extends CrudRepository<Hotel, Integer> {
	public List<Hotel> findAll();
	public Hotel findByhotelId(int hotelId);
	
	public List<Hotel> findByhotelname(String hotelname);
	
	@Modifying
	@Query("UPDATE Hotel h SET h.totalrooms = ?1 WHERE h.hotelId = ?2")
	@Transactional
	void updateHotelRooms( int totalrooms, int hotelid);
	
	@Query("SELECT c FROM Hotel c ORDER BY c.hotelId DESC")
    List<Hotel> findTopByOrderByhotelIdDesc();
	
	
	

}
