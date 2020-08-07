package com.example.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepo extends JpaRepository<User,Long>  {

	User findByName(String uname);
	//User getUserById(Long userId);

}
