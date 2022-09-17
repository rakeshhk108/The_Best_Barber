package com.Myproject.OBM.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Myproject.OBM.model.BarberServiceList;
import com.Myproject.OBM.model.Cart;
import com.Myproject.OBM.model.Userr;

@Repository
public interface CartRepo extends JpaRepository <Cart, Integer>{
	
//	public List<Cart>findByUserr(Userr userr);
//
//	public Cart findByUserrAndBarberServiceList(Userr user, BarberServiceList service);
//	
//	

}
