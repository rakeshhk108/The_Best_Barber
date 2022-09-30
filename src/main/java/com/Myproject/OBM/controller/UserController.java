package com.Myproject.OBM.controller;


import com.Myproject.OBM.model.Cart;
import com.Myproject.OBM.servises.UserrServiceIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Myproject.OBM.model.Userr;


@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserrServiceIf userService;


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
	@CrossOrigin
	@PostMapping(value ="/order/{serviceId}/{userId}")
	public Cart Order(@PathVariable("serviceId") Integer serviceId, @PathVariable("userId") String useremail) {

		return userService.addOrder(serviceId,useremail);

	}


	
	
	
	
	
}

