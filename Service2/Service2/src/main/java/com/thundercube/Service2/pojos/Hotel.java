package com.thundercube.Service2.pojos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Hotel {
	@Id
	private int hotelId;

	private String hotelname;

	private String location;
	private String City;
	private int totalrooms;
	private double cost;

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getHotelname() {
		return hotelname;
	}

	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	public int getTotalrooms() {
		return totalrooms;
	}

	public void setTotalrooms(int totalrooms) {
		this.totalrooms = totalrooms;
	}

	public String toString() {
		return "Hostel [hotelname=" + hotelname + ", hotelId=" + hotelId + ", location=" + location + ", City=" + City
				+ ", totalrooms=" + totalrooms + "]";
	}

}
