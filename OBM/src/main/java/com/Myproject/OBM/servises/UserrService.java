package com.Myproject.OBM.servises;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Myproject.OBM.exception.DuplicateEntryException;
import com.Myproject.OBM.exception.ResourceNotFoundException;
import com.Myproject.OBM.model.Cart;
import com.Myproject.OBM.model.OrderList;
import com.Myproject.OBM.model.Userr;
import com.Myproject.OBM.repository.CartRepo;
import com.Myproject.OBM.repository.OderRepo;
import com.Myproject.OBM.repository.UserrRepo;

@Service
public class UserrService {
	
	@Autowired
	private UserrRepo userrepo;
	
	@Autowired
	private CartRepo cartRepo;
	
	
		

	

	// save the user details form the form if not duplicated
	public Userr SaveUserDetails(Userr user) throws DuplicateEntryException
	{
		System.out.println(user.getEmailId());
		String tempEmailId = user.getEmailId();
		if(tempEmailId != null && !"".equals(tempEmailId)){
			Userr userobj = userrepo.findByEmailId(tempEmailId);		
		
			if(userobj != null) {
				throw new DuplicateEntryException("User","EmailId", userobj);
				}		
		}
		
		Userr userObj = null;
		userObj = userrepo.save(user);
		return userObj;
	}
	
	
	//get the user detail from the database for authentication
	public Userr fetchUserByemailIdAndPassword(Userr user) throws ResourceNotFoundException {
	
		String tempEmailId = user.getEmailId();
		String temppass = user.getPassword();
		Userr userObj = null;
			if((tempEmailId) != null && temppass != null){	
				
					userObj = userrepo.findByEmailIdAndPassword(tempEmailId, temppass);	
					
				}
			
			if(userObj == null) {
				throw new  ResourceNotFoundException("User", "email", userObj);	
		
		}

		return userObj;
	}
	
	
	//show user by id
	public Userr fetchById(int id) throws ResourceNotFoundException  {
		Userr user = userrepo.findById(id).get();
		if (user == null)
		{
			throw new  ResourceNotFoundException("User", "Id", user);	
		}
		else
			return user;
		
	}
	
//get all user details
	
	public List<Userr> fetchAllUser()
	{
		return userrepo.findAll();
	}


	public Cart addOrder(Cart cart) {
		
		return cartRepo.save(cart);
	}


	
	
	

}
