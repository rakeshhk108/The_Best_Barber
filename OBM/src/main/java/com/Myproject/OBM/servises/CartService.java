package com.Myproject.OBM.servises;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Myproject.OBM.exception.ResourceNotFoundException;
import com.Myproject.OBM.model.BarberServiceList;

import com.Myproject.OBM.model.Cart;
import com.Myproject.OBM.model.Userr;
import com.Myproject.OBM.repository.BarberServicesRepo;

import com.Myproject.OBM.repository.CartRepo;
import com.Myproject.OBM.repository.UserrRepo;

@Service
public class CartService {
	
	@Autowired
	private CartRepo cartRepo;	
	
	@Autowired
	private BarberServicesRepo serviceRepo;
	
	@Autowired
	private UserrRepo userRepo;
	
	//add service to cart
	
	public Cart addServiceToCart (Cart cart) {		
		
		return cartRepo.saveAndFlush(cart);	
		
	}


	//get details of card with card id
	public Cart fetchByCartId(Integer cartId) {
		
		return cartRepo.findById(cartId) .orElseThrow(() -> new ResourceNotFoundException("Admin", "Name", null));
		
	}
	
}	   
