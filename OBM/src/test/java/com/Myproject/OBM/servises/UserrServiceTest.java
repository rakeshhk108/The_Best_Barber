package com.Myproject.OBM.servises;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.Myproject.OBM.exception.DuplicateEntryException;
import com.Myproject.OBM.exception.ResourceNotFoundException;
import com.Myproject.OBM.model.Cart;
import com.Myproject.OBM.model.Userr;
import com.Myproject.OBM.repository.BarberServicesRepo;
import com.Myproject.OBM.repository.CartRepo;
import com.Myproject.OBM.repository.UserrRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserrService.class})
@ExtendWith(SpringExtension.class)
class UserrServiceTest {
    @MockBean
    private BarberServicesRepo barberServicesRepo;

    @MockBean
    private CartRepo cartRepo;

    @MockBean
    private UserrRepo userrRepo;

    @Autowired
    private UserrService userrService;


    @Test
    void testSaveUserDetails() throws DuplicateEntryException {
        Userr userr = new Userr();
        userr.setEmailId("42");
        userr.setName("Name");
        userr.setPassword("iloveyou");
        userr.setUserrId(123);

        Userr userr1 = new Userr();
        userr1.setEmailId("42");
        userr1.setName("Name");
        userr1.setPassword("iloveyou");
        userr1.setUserrId(123);
        when(userrRepo.findByEmailId((String) any())).thenReturn(userr);
        when(userrRepo.save((Userr) any())).thenReturn(userr1);

        Userr userr2 = new Userr();
        userr2.setEmailId("42");
        userr2.setName("Name");
        userr2.setPassword("iloveyou");
        userr2.setUserrId(123);
        assertThrows(DuplicateEntryException.class, () -> userrService.SaveUserDetails(userr2));
        verify(userrRepo).findByEmailId((String) any());
    }


    @Test
    void testSaveUserDetails2() throws DuplicateEntryException {
        Userr userr = new Userr();
        userr.setEmailId("42");
        userr.setName("Name");
        userr.setPassword("iloveyou");
        userr.setUserrId(123);

        Userr userr1 = new Userr();
        userr1.setEmailId("42");
        userr1.setName("Name");
        userr1.setPassword("iloveyou");
        userr1.setUserrId(123);
        when(userrRepo.findByEmailId((String) any())).thenReturn(userr);
        when(userrRepo.save((Userr) any())).thenReturn(userr1);
        Userr userr2 = mock(Userr.class);
        when(userr2.getEmailId()).thenReturn("");
        doNothing().when(userr2).setEmailId((String) any());
        doNothing().when(userr2).setName((String) any());
        doNothing().when(userr2).setPassword((String) any());
        doNothing().when(userr2).setUserrId(anyInt());
        userr2.setEmailId("42");
        userr2.setName("Name");
        userr2.setPassword("iloveyou");
        userr2.setUserrId(123);
        assertSame(userr1, userrService.SaveUserDetails(userr2));
        verify(userrRepo).save((Userr) any());
        verify(userr2, atLeast(1)).getEmailId();
        verify(userr2).setEmailId((String) any());
        verify(userr2).setName((String) any());
        verify(userr2).setPassword((String) any());
        verify(userr2).setUserrId(anyInt());
    }

    /**
     * Method under test: {@link UserrService#fetchUserByemailIdAndPassword(Userr)}
     */
    @Test
    void testFetchUserByemailIdAndPassword() throws ResourceNotFoundException {
        Userr userr = new Userr();
        userr.setEmailId("42");
        userr.setName("Name");
        userr.setPassword("iloveyou");
        userr.setUserrId(123);
        when(userrRepo.findByEmailIdAndPassword((String) any(), (String) any())).thenReturn(userr);

        Userr userr1 = new Userr();
        userr1.setEmailId("42");
        userr1.setName("Name");
        userr1.setPassword("iloveyou");
        userr1.setUserrId(123);
        assertSame(userr, userrService.fetchUserByemailIdAndPassword(userr1));
        verify(userrRepo).findByEmailIdAndPassword((String) any(), (String) any());
    }

    /**
     * Method under test: {@link UserrService#fetchById(int)}
     */
    @Test
    void testFetchById() throws ResourceNotFoundException {
        Userr userr = new Userr();
        userr.setEmailId("42");
        userr.setName("Name");
        userr.setPassword("iloveyou");
        userr.setUserrId(123);
        Optional<Userr> ofResult = Optional.of(userr);
        when(userrRepo.findById((Integer) any())).thenReturn(ofResult);
        assertSame(userr, userrService.fetchById(1));
        verify(userrRepo).findById((Integer) any());
    }




    @Test
    void testFetchById3() throws ResourceNotFoundException {
        when(userrRepo.findById((Integer) any()))
                .thenThrow(new DuplicateEntryException("Resource Name", "Field Name", "Field Value"));
        assertThrows(DuplicateEntryException.class, () -> userrService.fetchById(1));
        verify(userrRepo).findById((Integer) any());
    }


    @Test
    void testFetchAllUser() {
        ArrayList<Userr> userrList = new ArrayList<>();
        when(userrRepo.findAll()).thenReturn(userrList);
        List<Userr> actualFetchAllUserResult = userrService.fetchAllUser();
        assertSame(userrList, actualFetchAllUserResult);
        assertTrue(actualFetchAllUserResult.isEmpty());
        verify(userrRepo).findAll();
    }


    @Test
    void testFetchAllUser2() {
        when(userrRepo.findAll()).thenThrow(new DuplicateEntryException("Resource Name", "Field Name", "Field Value"));
        assertThrows(DuplicateEntryException.class, () -> userrService.fetchAllUser());
        verify(userrRepo).findAll();
    }


    @Test
    void testAddOrder() {
        Cart cart = new Cart();
        cart.setBslid(1);
        cart.setCartId(123);
        cart.setUserid(1);
        when(cartRepo.save((Cart) any())).thenReturn(cart);

        Userr userr = new Userr();
        userr.setEmailId("42");
        userr.setName("Name");
        userr.setPassword("iloveyou");
        userr.setUserrId(123);
        when(userrRepo.findByEmailId((String) any())).thenReturn(userr);
        assertSame(cart, userrService.addOrder(123, "jane.doe@example.org"));
        verify(cartRepo).save((Cart) any());
        verify(userrRepo).findByEmailId((String) any());
    }


    @Test
    void testAddOrder2() {
        when(cartRepo.save((Cart) any()))
                .thenThrow(new DuplicateEntryException("Resource Name", "Field Name", "Field Value"));

        Userr userr = new Userr();
        userr.setEmailId("42");
        userr.setName("Name");
        userr.setPassword("iloveyou");
        userr.setUserrId(123);
        when(userrRepo.findByEmailId((String) any())).thenReturn(userr);
        assertThrows(DuplicateEntryException.class, () -> userrService.addOrder(123, "jane.doe@example.org"));
        verify(cartRepo).save((Cart) any());
        verify(userrRepo).findByEmailId((String) any());
    }
}

