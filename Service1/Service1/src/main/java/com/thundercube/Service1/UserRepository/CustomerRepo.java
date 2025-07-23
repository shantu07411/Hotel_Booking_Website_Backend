package com.thundercube.Service1.UserRepository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thundercube.Service1.pojos.Customer;

import jakarta.transaction.Transactional;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer>{
	
	public List<Customer>findAll();
	public Customer findBycustomerid(int customerid);
	@Modifying
	@Transactional
	@Query("UPDATE Customer c SET c.bal = ?1 WHERE c.customerid = ?2")
	void updateBal(double bal,  int customerid);
	
	@Query("SELECT c FROM Customer c ORDER BY c.customerid DESC")
    List<Customer> findTopByOrderByCustomeridDesc();
	
	
	
	



	

}
