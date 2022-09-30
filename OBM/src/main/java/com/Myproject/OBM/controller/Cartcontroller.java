package com.Myproject.OBM.controller;

import java.util.List;

import com.Myproject.OBM.servises.CartServicesIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.Myproject.OBM.exception.ResourceNotFoundException;
import com.Myproject.OBM.model.BarberServiceList;
import com.Myproject.OBM.model.Cart;
import com.Myproject.OBM.model.Userr;
import com.Myproject.OBM.repository.BarberServicesRepo;
import com.Myproject.OBM.repository.CartRepo;
import com.Myproject.OBM.servises.CartService;
import com.Myproject.OBM.servises.UserrService;

@RestController
@RequestMapping("/cart")
public class Cartcontroller {
	
	
	@Autowired
	CartServicesIf cs;


	@CrossOrigin
	@GetMapping("/showcart/{useremail}")
	//get details of card with card id
	public List<BarberServiceList> getcart(@PathVariable("useremail")String useremail ) {

		return cs.fetchCartDetails(useremail);
	}

	@CrossOrigin
	@DeleteMapping("/delete/{serviceId}/{useremail}")
	public String removeFromCart( @PathVariable("useremail")String useremail, @PathVariable("serviceId") Integer serviceId)
	{

		cs.deleteItemFromCart(serviceId , useremail);
		return "Deleted";
	}
	
	
}
