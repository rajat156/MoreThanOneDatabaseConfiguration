package com.example.demo.Entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.db1.dao.UserRepo;
import com.example.demodb2.dao.UserRepo2;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private UserRepo2 userRepo2;
	
	public List<User> getAll(){
		return this.userRepo.findAll();
	}
	
	public List<User> getAllLocal(){
		return this.userRepo2.findAll();
	}
}
