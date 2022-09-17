package com.Myproject.OBM.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	@Entity
	@Table(name = "Admin_Details")
	public class Admin {
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "Admin_Id")
		private int adminId;
		@Column(name = "Admin_Name")
		private String adminName;
		
		@Column(name = "Admin_email")
		private String adminEmail;
		
		@Column(name = "Admin_Password")
		private String adminPassword;


		public Admin() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Admin(int adminId, String adminName, String adminPassword, String adminEmail) {
			super();
			this.adminId = adminId;
			this.adminName = adminName;
			this.adminPassword = adminPassword;
			this.adminEmail = adminEmail;
			
		}

		public int getAdminId() {
			return adminId;
		}

		public void setAdminId(int adminId) {
			this.adminId = adminId;
		}

		public String getAdminName() {
			return adminName;
		}

		public void setAdminName(String adminName) {
			this.adminName = adminName;
		}

		public String getAdminPassword() {
			return adminPassword;
		}

		public void setAdminPassword(String adminPassword) {
			this.adminPassword = adminPassword;
		}	



		public String getAdminEmail() {
			return adminEmail;
		}

		public void setAdminEmail(String adminEmail) {
			this.adminEmail = adminEmail;
		}

		@Override
		public String toString() {
			return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword + "]";
		}
		
		
	}

