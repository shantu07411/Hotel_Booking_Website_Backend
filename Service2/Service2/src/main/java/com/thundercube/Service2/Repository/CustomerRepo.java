package com.thundercube.Service2.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thundercube.Service2.pojos.Customer;

@Repository
public interface CustomerRepo extends CrudRepository<Customer, Integer>{
	
	public List<Customer>findAll();
	public Customer findBycustomerid(int customerid);
	

}
