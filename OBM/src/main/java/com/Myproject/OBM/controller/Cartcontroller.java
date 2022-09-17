package com.Myproject.OBM.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	CartService cs;

	
	@PostMapping("/additems")
	//add service to cart
	public Cart additemsToCart (Cart cart) {
		return cs.addServiceToCart(cart);
	}

	@GetMapping("/showcart/{id}")
		//get details of card with card id
		public Cart fetchByCartId(@PathVariable("id")Integer cartId) {
			
			return cs.fetchByCartId(cartId); 
		}
	
	
}
