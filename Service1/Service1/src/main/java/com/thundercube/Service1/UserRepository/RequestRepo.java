package com.thundercube.Service1.UserRepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.thundercube.Service1.pojos.*;

public interface RequestRepo extends CrudRepository<Request, String>{
	public List<Request>findAll();

}
