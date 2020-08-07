package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Register;
import com.example.demo.model.RegRepo;
import java.util.List;
import java.util.Optional;

//import com.example.demo.service.UserserviceInter;


@Service
public class Userservice implements UserserviceInter {
	@Autowired
	private RegRepo regRepo;
	
	@Override
	public List<Register> getAllRegister() {
		return regRepo.findAll();
	}
	
	

    @Override
    public Register getUserById(long id) {
        Optional <Register > optional = regRepo.findById(id);
        Register r = null;
        if (optional.isPresent()) {
            r = optional.get();
        } else {
            throw new RuntimeException(" User not found for id :: " + id);
        }
        return r;
    }
	
	
	 @Override
	 public void deleteUserById(long id) {
	  this.regRepo.deleteById(id);
	 }

}
