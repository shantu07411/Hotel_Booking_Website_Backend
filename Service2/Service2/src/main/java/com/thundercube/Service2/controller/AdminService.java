package com.thundercube.Service2.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thundercube.Service2.Services.AdminService1;
import com.thundercube.Service2.pojos.Admin;
import com.thundercube.Service2.pojos.Booking;
import com.thundercube.Service2.pojos.Customer;
import com.thundercube.Service2.pojos.Hotel;
import com.thundercube.Service2.pojos.Request;

@RestController
public class AdminService {

	@Autowired
	private AdminService1 as1;

	@GetMapping(path = "/first")
	public String hello() {
		return "hello";

	}

	@GetMapping(path = "/all")
	public List<Admin> getall1() {
		return as1.getall();
	}

	@PostMapping(path = "/addcustomer")
	public String gethome(@RequestBody Customer c) {
		as1.addcustomer(c);
		return "Success";
	}

	@PostMapping(path = "/addhotel")
	public String addhotel(@RequestBody Hotel h) {
		return as1.addhotel(h);
	}

	@PostMapping(path = "/addadmin")
	public String addadmin(@RequestBody Admin a) {
		return as1.addadmin(a);

	}

	@PostMapping("/addbooking")
	public String books(@RequestBody Booking bb) {
		return as1.Addbooking(bb);

	}

	@GetMapping("/findhotel")
	public List<Hotel> findallhotel() {
		try {
			return as1.findthhotel();

		} catch (Exception e) {
			return null;
		}

	}

	@GetMapping("/findallreq")
	public List<Request> reqall() {
		try {
			return as1.reqcanall();

		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}

	@PostMapping("/maderequest")
	public String reqadd(@RequestBody Request r) {
		return as1.canreq(r);

	}

	@GetMapping("/getrequest")
	public List<Request> madeRequest() {
		return as1.findallrequest();
	}

	@PutMapping(path = "/updatingrooms/{hotelId}")
	public void updateHotelRooms(@PathVariable("hotelId") int hotelId, @RequestBody Hotel updatedHotel) {
		as1.Updatingrooms(hotelId, updatedHotel.getTotalrooms());
	}

	@PutMapping(path = "/updatingroom1/{hotelId}")
	public Hotel updateHotelRoom1(@PathVariable("hotelId") int hotelId, @RequestBody Hotel updatedHotel) {
		return as1.Updatingroom1(hotelId, updatedHotel);
	}

	@GetMapping(path = "/Booking/{currdate}")
	@ResponseBody
	public List<Booking> todaydetails(@PathVariable("currdate") LocalDate currdate) {
		try {
			return as1.seetodaydetails(currdate);
		} catch (Exception e) {
			return null;
		}

	}

	@GetMapping(path = "/pastbooking/{customerid}")
	@ResponseBody
	public List<Booking> getpassbooks(@PathVariable("customerid") int customerid) {
		return as1.Allbookingofcust(customerid);
	}

	@PostMapping(path = "/authetication")
	public Admin adminauth(@RequestBody Admin a) {
		return as1.auth(a);
	}

	@GetMapping("/lasthotelid")
	public Integer getLastHotelId() {
		return as1.getLastHotelId();
	}

	@GetMapping(path = "/{hotelId}")
	@ResponseBody
	public Hotel gethotel(@PathVariable("hotelId") int hotelId) {
		return as1.getfindhotel(hotelId);

	}

	@PutMapping(path = "/cancelledrequest/{requestid}")
	@ResponseBody
	public String reqcancelling(@PathVariable("requestid") int requestid) {
		return as1.cancelledreq(requestid);
	}

}
