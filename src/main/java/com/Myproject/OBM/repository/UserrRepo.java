package com.Myproject.OBM.repository;

import java.util.Optional;

import javax.swing.text.html.Option;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Myproject.OBM.model.Userr;


public interface UserrRepo extends JpaRepository<Userr, Integer>{

	//spring boots created an querry to fetch user by email id
	public Userr findByEmailId(String email);
	public Userr findByEmailIdAndPassword(String email, String password);
	
}
