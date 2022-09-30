package com.Myproject.OBM.servises;

import com.Myproject.OBM.model.Cart;
import com.Myproject.OBM.model.Userr;

import java.util.List;

public interface UserrServiceIf {
    public Userr SaveUserDetails(Userr user);
    public Userr fetchUserByemailIdAndPassword(Userr user);
    public Userr fetchById(int id);
    public List<Userr> fetchAllUser();
    public Cart addOrder(int ServiceId , String  useremail);

}
