package com.Myproject.OBM.controller;

import java.util.List;


import com.Myproject.OBM.servises.AdminServiceIf;
import com.Myproject.OBM.servises.UserrServiceIf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Myproject.OBM.model.Admin;
import com.Myproject.OBM.model.BarberServiceList;
import com.Myproject.OBM.model.Userr;
import com.Myproject.OBM.servises.AdminService;
import com.Myproject.OBM.servises.UserrService;




@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminController {
	
	@Autowired
	private AdminServiceIf adminServiceIf;
	
	@Autowired
	private UserrServiceIf userrServiceIf;
	
	
	

	//get admin details by name while login
	@PostMapping("/login")	
	public Admin loginUser(@RequestBody Admin admin) {		
		return adminServiceIf.fetchUserByemailIdAndPassword(admin);
	}
	

	
	
	// add barbers services and price
	@PostMapping("/addservice")
	public  BarberServiceList addService(@RequestBody BarberServiceList barberServiceList) {
		
		return adminServiceIf.addBarberService(barberServiceList);
	}
	
    // update barber exesting serveses and prices
	
		@PutMapping("/update/{id}")
		public BarberServiceList updateServices(@PathVariable("id") Integer serviceId,@RequestBody BarberServiceList service) {
		BarberServiceList updatedBsl = adminServiceIf.updateService(serviceId,service);
		return  updatedBsl;
	}
	
		
		@DeleteMapping("/delete/{id}")
	// remove services
	public  String deleteService(@PathVariable("id") Integer serviceId) {
		adminServiceIf.deleteService(serviceId);
		return "Deleted";		
	}
	
		
		@GetMapping("/alluser")
	// see all barbers services
	public List<Userr> allServices(){
		return userrServiceIf.fetchAllUser();
		}
		
}
		
	

		
		
	
	
	
	
	
	

	


	

