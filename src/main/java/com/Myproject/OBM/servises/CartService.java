package com.Myproject.OBM.servises;


import java.util.List;
import java.util.stream.Collectors;


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
public class CartService implements CartServicesIf {

	@Autowired
	private CartRepo cartRepo;

	@Autowired
	private BarberServicesRepo serviceRepo;

	@Autowired
	private UserrRepo userRepo;


	//get details of card with card id
	public List<BarberServiceList> fetchCartDetails(String email) {
		Userr user = userRepo.findByEmailId(email);

		List<Cart> cartList = cartRepo.findByUserid(user.getUserrId());

		List<Integer> ls = cartList.stream().map(Cart::getBslid).collect(Collectors.toList());

		return serviceRepo.findAllById(ls);
	}

	@Override
	public String deleteItemFromCart(int serviceId , String useremail) {

		Userr user = userRepo.findByEmailId(useremail);

		int temp = user.getUserrId();
       Cart cart = cartRepo.findByBslidAndUserid(serviceId, temp);

	   cartRepo.deleteById(cart.getCartId());

		return "deleted";
	}

}

