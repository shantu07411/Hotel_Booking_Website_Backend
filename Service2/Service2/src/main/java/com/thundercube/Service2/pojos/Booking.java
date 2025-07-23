package com.thundercube.Service2.pojos;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
	@Id
	private String bookingId;

	private int noofbooking;
	private double cost;

	private String StartDate;
	private String EndDate;

	public LocalDate currdate;

	Booking() {
		this.currdate = java.time.LocalDate.now();

	}

	@ManyToOne
	private Hotel hotel;

	@ManyToOne
	private Customer c;

	public Customer getC() {
		return c;
	}

	public void setC(Customer c) {
		this.c = c;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public int getNoofbooking() {
		return noofbooking;
	}

	public void setNoofbooking(int noofbooking) {
		this.noofbooking = noofbooking;
	}

}
