package com.Myproject.OBM.controller;


import java.awt.PageAttributes.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Myproject.OBM.exception.DuplicateEntryException;
import com.Myproject.OBM.exception.ResourceNotFoundException;
import com.Myproject.OBM.model.Cart;
import com.Myproject.OBM.model.OrderList;
import com.Myproject.OBM.model.Userr;
import com.Myproject.OBM.servises.UserrService;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserrService userService;


	//save new user data 
	@CrossOrigin
	@PostMapping("/regester")
	public Userr registerUser(@RequestBody Userr user)  {
		
	 return userService.SaveUserDetails(user);
	}
	
	//fetch user for login authentication
	@CrossOrigin
	@PostMapping(value ="/login")	
	public Userr loginUser(@RequestBody Userr user) {
		return userService.fetchUserByemailIdAndPassword(user);
	}

   //see user user by id
	@CrossOrigin
	@GetMapping("/{id}")
	public Userr userbyid(@PathVariable("id") Integer userid)
	{
		return userService.fetchById(userid);
	}
	
	
	//place a order
	
	@PostMapping(value ="/order")	
	public Cart Order(@RequestBody Cart cart) {
		
		return userService.addOrder(cart);
				
	}


	
	
	
	
	
}

