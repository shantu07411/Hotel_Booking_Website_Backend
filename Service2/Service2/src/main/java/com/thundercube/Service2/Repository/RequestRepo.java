package com.thundercube.Service2.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.thundercube.Service2.pojos.Request;

public interface RequestRepo extends CrudRepository<Request, Integer>{
	public List<Request>findAll();
	public Request findByrequestid(int requestid);

}
