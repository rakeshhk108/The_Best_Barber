package com.Myproject.OBM.model;



import java.util.Date;
import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Cart_Id")
	private  int cartId;

	
	
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idCart", referencedColumnName = "Cart_Id")
	private List<OrderList> orderList;



	public int getCartId() {
		return cartId;
	}



	public void setCartId(int cartId) {
		this.cartId = cartId;
	}



	public List<OrderList> getOrderList() {
		return orderList;
	}



	public void setOrderList(List<OrderList> orderList) {
		this.orderList = orderList;
	}



	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Cart(int cartId, List<OrderList> orderList) {
		super();
		this.cartId = cartId;
		this.orderList = orderList;
	}
	
	








		
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
