package com.thundercube.Service2.Services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thundercube.Service2.Repository.AdminRepo;
import com.thundercube.Service2.Repository.BookingRepo;
import com.thundercube.Service2.Repository.CustomerRepo;
import com.thundercube.Service2.Repository.HotelRepo;
import com.thundercube.Service2.Repository.RequestRepo;
import com.thundercube.Service2.pojos.Admin;
import com.thundercube.Service2.pojos.Booking;
import com.thundercube.Service2.pojos.Customer;
import com.thundercube.Service2.pojos.Hotel;
import com.thundercube.Service2.pojos.Request;

@Service
public class AdminService1 {
	
	@Autowired
	private CustomerRepo customerepo;
	
	@Autowired
	private BookingRepo br;
	
	@Autowired
	private HotelRepo hr;
	
	@Autowired
	private AdminRepo ar;
	
	@Autowired
	private RequestRepo reqrepo;
	
	
	public String addhotel(Hotel h) {
		try {
			hr.save(h);
			return "success";
			
		} catch (Exception e) {
			return "Failed";
		}
		
		
	}
	
	
	
	
	public String addcustomer(Customer c) {
		customerepo.save(c);
		return "Success";
		
	}
	
	public String addadmin(Admin a) {
		ar.save(a);
		return "Success";
		
	}
	
	
	
	public String Addbooking(Booking b) {
		customerepo.save(b.getC());
		hr.save(b.getHotel());
		br.save(b);
		return "Success";
	}
	
	public List<Hotel>findthhotel(){
		try {
			return hr.findAll();
			
		} catch (Exception e) {
			return null;
		}
		
		
	}
	
	
	
	public String canreq(Request r) {
		Hotel tt=r.getH();
		if(r.getNoofrooms()>tt.getTotalrooms()) {
			return "Failed Not Possible";
		}
		Customer t=customerepo.findBycustomerid(r.getC().getCustomerid());
		if(t==null) {
			return "Customer Not Found";
		}
		customerepo.save(r.getC());
		hr.save(r.getH());
		reqrepo.save(r);
		return "Successfully Added";
		
	}
	
	public List<Request>reqcanall(){
		return reqrepo.findAll();
	}
	
	
	 public String Updatingrooms(int hotelid,int totalrooms) {
		 try {
			hr.updateHotelRooms(totalrooms, hotelid);
			return "Success";
			
			
		} catch (Exception e) {
			return "Failed";
			// TODO: handle exception
		}
		 
	    	
	 }
	  public List<Booking>seetodaydetails(LocalDate currdate){
	    	try {
	    		
				return br.findBycurrdate(currdate);
				
			} catch (Exception e) {
				return null;
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
	  
	  public List<Request>displayAllrequest(){
		  return reqrepo.findAll();
	  }
	  public String cancelledreq(int requestid) {
		  Request request=reqrepo.findByrequestid(requestid);
		  if(request==null) {
			  return "Not Such request exist with Id"+" "+requestid;
		  }
		  Hotel h=request.getH();
		  Hotel a=hr.findByhotelId(h.getHotelId());
		  if(a==null) {
			  return "No Such Hotel Found";
		  }
		  int t=request.getNoofrooms();
		  Customer cc=request.getC();
		  cc.setBal(h.getCost()*t+cc.getBal());
		  reqrepo.delete(request);
		  customerepo.save(cc);
		  h.setTotalrooms(t+h.getTotalrooms());
		  hr.save(h);
		
		  return "Success";
		  
		  
	  }
	
	public List<Admin> getall(){
		return ar.findAll()
;	}
	
	public Admin auth(Admin a) {
		Admin aa=ar.findByadminId(a.getAdminId());
		
		if(a!=null) {
			return aa;
		}
		
		return a;
	  
	}
	
	 public Integer getLastHotelId() {
	        List<Hotel> H = hr.findTopByOrderByhotelIdDesc();
	        return H.isEmpty() ? 0 : H.get(0).getHotelId();
	    }
	 
	 public Hotel getfindhotel(int hotelid) {
		
		return  hr.findByhotelId(hotelid);
		 
	 }

	 public Hotel Updatingroom1(int hotelId,Hotel h) {
		Hotel a= hr.findByhotelId(hotelId);
		a=h;
		hr.save(a);
		return a;
	 }
	 
	 public List<Request>findallrequest(){
		 return reqrepo.findAll();
	 }
	
	

}
