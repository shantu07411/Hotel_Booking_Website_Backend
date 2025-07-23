package com.thundercube.Service1.pojos;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Customer {
	
	@Id
	private int customerid;
	private String customername;
	private String custpass;
	private double bal;
	
	
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customername=" + customername + ", custpass=" + custpass
				+ ", bal=" + bal + "]";
	}

	public Customer(){
		this.bal=0;
		
	}
	
	public double getBal() {
		return bal;
	}
	public void setBal(double bal) {
		this.bal = bal;
	}
	public String getCustpass() {
		return custpass;
	}
	public void setCustpass(String custpass) {
		this.custpass = custpass;
	}
	
	
	
	

	
	
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	
	

}
