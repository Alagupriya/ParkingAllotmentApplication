package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Register;

public interface UserserviceInter {
	List<Register> getAllRegister();
	// void saveEmployee(Register Reg);
	 Register getUserById(long id);
	 void deleteUserById(long id);
}
