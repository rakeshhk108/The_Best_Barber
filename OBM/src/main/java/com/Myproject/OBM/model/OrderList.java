package com.Myproject.OBM.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Order_list")
public class OrderList {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		@Column(name = "Order_Id")
		private int orderId;
		@Column(name = "Service_Name")
		private String serviceName;	
		@Column(name = "Service_Price")	
		private int servicePrice;
		
		
		public int getOrderId() {
			return orderId;
		}
		public void setOrderId(int orderId) {
			this.orderId = orderId;
		}
		public String getServiceName() {
			return serviceName;
		}
		public void setServiceName(String serviceName) {
			this.serviceName = serviceName;
		}
		public int getServicePrice() {
			return servicePrice;
		}
		public void setServicePrice(int servicePrice) {
			this.servicePrice = servicePrice;
		}
		public OrderList() {
			super();
			// TODO Auto-generated constructor stub
		}
		public OrderList(int orderId, String serviceName, int servicePrice) {
			super();
			this.orderId = orderId;
			this.serviceName = serviceName;
			this.servicePrice = servicePrice;
		}
		
		

}
