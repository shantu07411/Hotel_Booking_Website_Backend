package com.thundercube.Service2.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.thundercube.Service2.pojos.Admin;

@Repository
public interface AdminRepo extends CrudRepository<Admin, Integer>{
	public Admin findByadminId(int adminId);
	public Admin findBypass(String pass);
	public Admin findByAdminIdAndPass(int adminId, String pass);
	public List<Admin> findAll();
	
	

}
