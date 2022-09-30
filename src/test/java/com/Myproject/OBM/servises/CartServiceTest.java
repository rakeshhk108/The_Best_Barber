package com.Myproject.OBM.servises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.Myproject.OBM.model.BarberServiceList;
import com.Myproject.OBM.model.Cart;
import com.Myproject.OBM.model.Userr;
import com.Myproject.OBM.repository.BarberServicesRepo;
import com.Myproject.OBM.repository.CartRepo;
import com.Myproject.OBM.repository.UserrRepo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {CartService.class})
@ExtendWith(SpringExtension.class)
class CartServiceTest {
    @MockBean
    private BarberServicesRepo barberServicesRepo;

    @MockBean
    private CartRepo cartRepo;

    @Autowired
    private CartService cartService;

    @MockBean
    private UserrRepo userrRepo;

    /**
     * Method under test: {@link CartService#fetchCartDetails(String)}
     */
    @Test
    void testFetchCartDetails() {
        when(cartRepo.findByUserid(anyInt())).thenReturn(new ArrayList<>());
        ArrayList<BarberServiceList> barberServiceListList = new ArrayList<>();
        when(barberServicesRepo.findAllById((Iterable<Integer>) any())).thenReturn(barberServiceListList);

        Userr userr = new Userr();
        userr.setEmailId("42");
        userr.setName("Name");
        userr.setPassword("iloveyou");
        userr.setUserrId(123);
        when(userrRepo.findByEmailId((String) any())).thenReturn(userr);
        List<BarberServiceList> actualFetchCartDetailsResult = cartService.fetchCartDetails("jane.doe@example.org");
        assertSame(barberServiceListList, actualFetchCartDetailsResult);
        assertTrue(actualFetchCartDetailsResult.isEmpty());
        verify(cartRepo).findByUserid(anyInt());
        verify(barberServicesRepo).findAllById((Iterable<Integer>) any());
        verify(userrRepo).findByEmailId((String) any());
    }

    /**
     * Method under test: {@link CartService#deleteItemFromCart(int, String)}
     */
    @Test
    void testDeleteItemFromCart() {
        Cart cart = new Cart();
        cart.setBslid(1);
        cart.setCartId(123);
        cart.setUserid(1);
        doNothing().when(cartRepo).deleteById((Integer) any());
        when(cartRepo.findByBslidAndUserid(anyInt(), anyInt())).thenReturn(cart);

        Userr userr = new Userr();
        userr.setEmailId("42");
        userr.setName("Name");
        userr.setPassword("iloveyou");
        userr.setUserrId(123);
        when(userrRepo.findByEmailId((String) any())).thenReturn(userr);
        assertEquals("deleted", cartService.deleteItemFromCart(123, "jane.doe@example.org"));
        verify(cartRepo).findByBslidAndUserid(anyInt(), anyInt());
        verify(cartRepo).deleteById((Integer) any());
        verify(userrRepo).findByEmailId((String) any());
    }
}

