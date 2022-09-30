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
	@Column(name = "User_Id")
	private int userid;
	@Column(name = "Bsl_Id")
	private  int bslid;


	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getBslid() {
		return bslid;
	}

	public void setBslid(int bslid) {
		this.bslid = bslid;
	}

	public Cart(int cartId, int userid, int bslid) {
		this.cartId = cartId;
		this.userid = userid;
		this.bslid = bslid;
	}

	public Cart() {
		super();
	}
}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
