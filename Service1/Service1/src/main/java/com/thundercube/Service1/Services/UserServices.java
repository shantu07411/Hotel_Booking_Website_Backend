package com.thundercube.Service1.Services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thundercube.Service1.UserRepository.BookingRepo;
import com.thundercube.Service1.UserRepository.CustomerRepo;
import com.thundercube.Service1.UserRepository.HotelRepo;
import com.thundercube.Service1.UserRepository.RequestRepo;
import com.thundercube.Service1.pojos.Booking;
import com.thundercube.Service1.pojos.Customer;
import com.thundercube.Service1.pojos.Hotel;
import com.thundercube.Service1.pojos.Request;

import jakarta.transaction.Transactional;


@Service
public class UserServices {
	
	@Autowired
	private CustomerRepo customerepo;
	
	@Autowired
	private BookingRepo br;
	
	@Autowired
	private HotelRepo hr;
	
	
	
	
	
	
	@Autowired
	private RequestRepo reqrepo;
	
	

	public String addcustomer(Customer c) {
		customerepo.save(c);
		return "Success";
		
	}
	
	
	public List<Hotel>seeallhotel(){
		return hr.findAll();
	}
	
	public List<Hotel> seedetails(String hotelname) {
		if(hr.findByhotelname(hotelname)==null) {
			return null;
		}
		return hr.findByhotelname(hotelname);
		
	}
	
	public String Cancellation(Request r) {
		
		Customer cc=r.getC();
		Customer check=customerepo.findBycustomerid(cc.getCustomerid());
		
		if(check==null) {
			return "Customer Not Found";
		}
		
		
		Hotel hh=r.getH();
		Hotel check1=hr.findByhotelId(hh.getHotelId());
		List<Hotel> check3=hr.findByhotelname(hh.getHotelname());
		
		if(check1==null) {
			return "Hotel Not Found";
		}
		
	
		
	
		
		reqrepo.save(r);
		return "Success";
		
	}
   
	
	public String AddBooking(Booking b) {
    	
    	try {
    		

    		
    		Customer cs = b.getC();
    		System.out.println(cs);
    		Hotel hh = b.getHotel();
    		Customer r1=customerepo.findById(cs.getCustomerid()).get();
			Hotel h1=hr.findByhotelId(hh.getHotelId());
			System.out.println("Customer Bal"+cs.getBal());
			System.out.println("Hotal Rent"+h1.getCost());
			
			

    		// Calculate total cost for the booking
    		double totalCost = h1.getCost() * b.getNoofbooking();
    	

    		// Check if the customer has sufficient balance
    		if (cs.getBal() >= totalCost) {
    			
    			
    		    // Update customer balance and hotel rooms if balance is sufficient
    			
    			h1.setTotalrooms(h1.getTotalrooms()-b.getNoofbooking());
    			hr.save(h1);
//    		    customerepo.updateBal(r1.getBal() - totalCost, cs.getCustomerid());
//    		    hr.updateHotelRooms(h1.getTotalrooms() - b.getNoofbooking(), hh.getHotelId());
    		    
    		    // Save the booking
    		    br.save(b);
    		    r1.setBal(r1.getBal()-totalCost);
    			customerepo.save(r1);
    		    return "Success";
    		} else {
    		    // Return a message or throw an exception indicating insufficient balance
    		    return "Insufficient balance";
    		}

			
		} catch (Exception e) {
		e.printStackTrace();
		return "Either Customer Is Not Present Or Hotel";
		}
    	
    	
    	

    	
	}
    
    public List<Booking> Allbookingofcust(int customerId){
    	try {
    		List<Booking>b=br.findAll();
    		
    		List<Booking>mylist = new ArrayList<>();
    		for(Booking bb:b) {
    			Customer c=bb.getC();
    			if(c.getCustomerid()==customerId) {
    				mylist.add(bb);
    			}
    		}
    		return mylist;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
    	
    	
    	
    }
   
    public List<Booking>seetodaydetails(LocalDate currdate){
    	try {
    		
			return br.findBycurrdate(currdate);
			
		} catch (Exception e) {
			return null;
		}
    }
	
    
    public Customer Recharge(int customerid,double bal) {
		  try {
			  Customer customer=customerepo.findBycustomerid(customerid);
			  customer.setBal(customer.getBal()+bal);
			  customerepo.save(customer);
			  return customer;
			
		} catch (Exception e) {
			return null;
		}
	  }
    
    public Customer authentication(Customer c) {
    	Customer cc=customerepo.findBycustomerid(c.getCustomerid());
    	if(cc!=null) {
    	return cc;
    	}
    	return null;
    	
    }
    
    public Integer getLastCustomerId() {
        List<Customer> customers = customerepo.findTopByOrderByCustomeridDesc();
        return customers.isEmpty() ? 0 : customers.get(0).getCustomerid();
    }
    
    public double mybalance(int customerid) {
    	Customer a=customerepo.findBycustomerid(customerid);
    	if(a==null) {
    		return -1;
    	}
    	return a.getBal();
    }
    public Customer Signup(Customer c) {
    	customerepo.save(c);
    	return c;
         
    	
    }
  
	

}
