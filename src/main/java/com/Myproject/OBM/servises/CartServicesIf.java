package com.Myproject.OBM.servises;

import com.Myproject.OBM.model.BarberServiceList;
import com.Myproject.OBM.model.Cart;

import java.util.List;

public interface CartServicesIf{


    public List<BarberServiceList> fetchCartDetails(String email);

    public String deleteItemFromCart(int cartId , String useremail);
}
