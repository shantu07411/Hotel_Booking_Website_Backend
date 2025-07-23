package com.thundercube.Service1.controller;

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

import com.thundercube.Service1.Services.UserServices;
import com.thundercube.Service1.pojos.Booking;
import com.thundercube.Service1.pojos.Customer;
import com.thundercube.Service1.pojos.Hotel;
import com.thundercube.Service1.pojos.Request;

@RestController
public class UserController {
	
	@Autowired
	private UserServices us1;
	

	@GetMapping("/")
	public String get() {
		return "Hello Guys";
	}
	

	@PostMapping(path="/addcustomer")
	public String gethome(@RequestBody Customer c) {
		us1.addcustomer(c);
		return "Success";
	}
	
	@GetMapping(path="/allhotel")
	public List<Hotel>getallhotel(){
		try {
			return us1.seeallhotel();
			
			
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@GetMapping(path="/hoteldetails/{hotelname}")
	@ResponseBody
	public List<Hotel>getdetails(@PathVariable ("hotelname") String hotelname){
		try {
			return us1.seedetails(hotelname);
		} catch (Exception e) {
			return null;
		}
		
		
	}
	
	
	@PostMapping("/addingbooking")
	public String adddedbooks(@RequestBody Booking b ) {
		return us1.AddBooking(b);
	}
	
	@GetMapping(path="/pastbooking/{customerid}")
	@ResponseBody
	public List<Booking> getpassbooks(@PathVariable ("customerid")  int customerid){
		return us1.Allbookingofcust(customerid);
	}
	
	@GetMapping(path="/Booking/{currdate}")
	@ResponseBody
	public List<Booking>todaydetails(@PathVariable ("currdate") LocalDate currdate){
		try {
			return us1.seetodaydetails(currdate);
		} catch (Exception e) {
			return null;
		}
		
		
	}
	
	@PutMapping(path="/recharge/{customerid}/{bal}")
	public Customer recharging(@PathVariable int customerid,@PathVariable double bal) {
		return us1.Recharge(customerid, bal);
	}
	
	@PostMapping(path="/sendingreq")
	public String requestCancelled(@RequestBody Request r) {
		return us1.Cancellation(r);
		
	}
	
	@PostMapping(path="/authentication")
	public String auth(@RequestBody Customer customer) {
		if(us1.authentication(customer)!=null) {
			return "Success";
		}
		return "Failed";
	}
	
	@GetMapping(path="/getbalance/{customerid}")
	public double mybal(@PathVariable int customerid) {
		return us1.mybalance(customerid);
	}
	
	@GetMapping("/lastid")
    public Integer getLastCustomerId() {
        return us1.getLastCustomerId();
    }
	
	
	@PostMapping("/singup")
	public Customer signupp(@RequestBody Customer c) {
		return us1.Signup(c);
	}

	

}

