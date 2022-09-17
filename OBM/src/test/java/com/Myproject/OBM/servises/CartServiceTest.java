package com.Myproject.OBM.servises;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.Myproject.OBM.exception.ResourceNotFoundException;
import com.Myproject.OBM.model.Cart;
import com.Myproject.OBM.repository.BarberServicesRepo;
import com.Myproject.OBM.repository.CartRepo;
import com.Myproject.OBM.repository.UserrRepo;

import java.util.ArrayList;
import java.util.Optional;

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
     * Method under test: {@link CartService#addServiceToCart(Cart)}
     */
    @Test
    void testAddServiceToCart() {
        Cart cart = new Cart();
        cart.setCartId(123);
        cart.setOrderList(new ArrayList<>());
        when(cartRepo.saveAndFlush((Cart) any())).thenReturn(cart);

        Cart cart1 = new Cart();
        cart1.setCartId(123);
        cart1.setOrderList(new ArrayList<>());
        assertSame(cart, cartService.addServiceToCart(cart1));
        verify(cartRepo).saveAndFlush((Cart) any());
    }

    /**
     * Method under test: {@link CartService#addServiceToCart(Cart)}
     */
    @Test
    void testAddServiceToCart2() {
        when(cartRepo.saveAndFlush((Cart) any()))
                .thenThrow(new ResourceNotFoundException("Resource Name", "Field Name", "Field Value"));

        Cart cart = new Cart();
        cart.setCartId(123);
        cart.setOrderList(new ArrayList<>());
        assertThrows(ResourceNotFoundException.class, () -> cartService.addServiceToCart(cart));
        verify(cartRepo).saveAndFlush((Cart) any());
    }

    /**
     * Method under test: {@link CartService#fetchByCartId(Integer)}
     */
    @Test
    void testFetchByCartId() {
        Cart cart = new Cart();
        cart.setCartId(123);
        cart.setOrderList(new ArrayList<>());
        Optional<Cart> ofResult = Optional.of(cart);
        when(cartRepo.findById((Integer) any())).thenReturn(ofResult);
        assertSame(cart, cartService.fetchByCartId(123));
        verify(cartRepo).findById((Integer) any());
    }

    /**
     * Method under test: {@link CartService#fetchByCartId(Integer)}
     */
    @Test
    void testFetchByCartId2() {
        when(cartRepo.findById((Integer) any())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> cartService.fetchByCartId(123));
        verify(cartRepo).findById((Integer) any());
    }

    /**
     * Method under test: {@link CartService#fetchByCartId(Integer)}
     */
    @Test
    void testFetchByCartId3() {
        when(cartRepo.findById((Integer) any()))
                .thenThrow(new ResourceNotFoundException("Admin", "Admin", "Field Value"));
        assertThrows(ResourceNotFoundException.class, () -> cartService.fetchByCartId(123));
        verify(cartRepo).findById((Integer) any());
    }
}

