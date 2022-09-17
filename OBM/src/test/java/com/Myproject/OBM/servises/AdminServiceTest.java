package com.Myproject.OBM.servises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.Myproject.OBM.exception.ResourceNotFoundException;
import com.Myproject.OBM.model.Admin;
import com.Myproject.OBM.model.BarberServiceList;
import com.Myproject.OBM.repository.Adminrepo;
import com.Myproject.OBM.repository.BarberServicesRepo;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {AdminService.class})
@ExtendWith(SpringExtension.class)
class AdminServiceTest {
    @Autowired
    private AdminService adminService;

    @MockBean
    private Adminrepo adminrepo;

    @MockBean
    private BarberServicesRepo barberServicesRepo;


    @Test
    void testFetchAdminByEmailId() {
        Admin admin = new Admin();
        admin.setAdminEmail("rakesh@gmail.com");
        admin.setAdminId(123);
        admin.setAdminName("Rakesh");
        admin.setAdminPassword("123");
        Optional<Admin> ofResult = Optional.of(admin);
        when(adminrepo.findByAdminEmail((String) any())).thenReturn(ofResult);
        assertSame(admin, adminService.fetchAdminByEmailId("rakesh@gmail.com"));
        verify(adminrepo).findByAdminEmail((String) any());
    }


    @Test
    void testFetchAdminByEmailId2() {
        when(adminrepo.findByAdminEmail((String) any())).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> adminService.fetchAdminByEmailId("rakesh@gmail.com"));
        verify(adminrepo).findByAdminEmail((String) any());
    }


    @Test
    void testFetchAdminByEmailId3() {
        when(adminrepo.findByAdminEmail((String) any()))
                .thenThrow(new ResourceNotFoundException("Admin", "Admin", "Field Value"));
        assertThrows(ResourceNotFoundException.class, () -> adminService.fetchAdminByEmailId("jane.doe@example.org"));
        verify(adminrepo).findByAdminEmail((String) any());
    }


    @Test
    void testAddBarberService() {
        BarberServiceList barberServiceList = new BarberServiceList();
        barberServiceList.setServiceId(123);
        barberServiceList.setServiceName("Service Name");
        barberServiceList.setServicePrice(1);
        when(barberServicesRepo.save((BarberServiceList) any())).thenReturn(barberServiceList);

        BarberServiceList barberServiceList1 = new BarberServiceList();
        barberServiceList1.setServiceId(123);
        barberServiceList1.setServiceName("Service Name");
        barberServiceList1.setServicePrice(1);
        assertSame(barberServiceList, adminService.addBarberService(barberServiceList1));
        verify(barberServicesRepo).save((BarberServiceList) any());
    }


    @Test
    void testAddBarberService2() {
        when(barberServicesRepo.save((BarberServiceList) any()))
                .thenThrow(new ResourceNotFoundException("Resource Name", "Field Name", "Field Value"));

        BarberServiceList barberServiceList = new BarberServiceList();
        barberServiceList.setServiceId(123);
        barberServiceList.setServiceName("Service Name");
        barberServiceList.setServicePrice(1);
        assertThrows(ResourceNotFoundException.class, () -> adminService.addBarberService(barberServiceList));
        verify(barberServicesRepo).save((BarberServiceList) any());
    }


    @Test
    void testUpdateService() {
        BarberServiceList barberServiceList = new BarberServiceList();
        barberServiceList.setServiceId(123);
        barberServiceList.setServiceName("Service Name");
        barberServiceList.setServicePrice(1);
        when(barberServicesRepo.saveAndFlush((BarberServiceList) any())).thenReturn(barberServiceList);

        BarberServiceList barberServiceList1 = new BarberServiceList();
        barberServiceList1.setServiceId(123);
        barberServiceList1.setServiceName("Service Name");
        barberServiceList1.setServicePrice(1);
        assertSame(barberServiceList, adminService.updateService(barberServiceList1));
        verify(barberServicesRepo).saveAndFlush((BarberServiceList) any());
    }

    @Test
    void testUpdateService2() {
        when(barberServicesRepo.saveAndFlush((BarberServiceList) any()))
                .thenThrow(new ResourceNotFoundException("Resource Name", "Field Name", "Field Value"));

        BarberServiceList barberServiceList = new BarberServiceList();
        barberServiceList.setServiceId(123);
        barberServiceList.setServiceName("Service Name");
        barberServiceList.setServicePrice(1);
        assertThrows(ResourceNotFoundException.class, () -> adminService.updateService(barberServiceList));
        verify(barberServicesRepo).saveAndFlush((BarberServiceList) any());
    }


    @Test
    void testDeleteService() {
        doNothing().when(barberServicesRepo).deleteById((Integer) any());
        assertEquals("Deleted", adminService.deleteService(123));
        verify(barberServicesRepo).deleteById((Integer) any());
    }

    @Test
    void testDeleteService2() {
        doThrow(new ResourceNotFoundException("Deleted", "Deleted", "Field Value")).when(barberServicesRepo)
                .deleteById((Integer) any());
        assertThrows(ResourceNotFoundException.class, () -> adminService.deleteService(123));
        verify(barberServicesRepo).deleteById((Integer) any());
    }


    @Test
    void testGetallServices() {
        ArrayList<BarberServiceList> barberServiceListList = new ArrayList<>();
        when(barberServicesRepo.findAll()).thenReturn(barberServiceListList);
        List<BarberServiceList> actualGetallServicesResult = adminService.getallServices();
        assertSame(barberServiceListList, actualGetallServicesResult);
        assertTrue(actualGetallServicesResult.isEmpty());
        verify(barberServicesRepo).findAll();
    }


    @Test
    void testGetallServices2() {
        when(barberServicesRepo.findAll())
                .thenThrow(new ResourceNotFoundException("Resource Name", "Field Name", "Field Value"));
        assertThrows(ResourceNotFoundException.class, () -> adminService.getallServices());
        verify(barberServicesRepo).findAll();
    }


    @Test
    void testFetchUserByemailIdAndPassword() {
        Admin admin = new Admin();
        admin.setAdminEmail("jane.doe@example.org");
        admin.setAdminId(123);
        admin.setAdminName("Admin Name");
        admin.setAdminPassword("iloveyou");
        when(adminrepo.findByAdminEmailAndAdminPassword((String) any(), (String) any())).thenReturn(admin);

        Admin admin1 = new Admin();
        admin1.setAdminEmail("jane.doe@example.org");
        admin1.setAdminId(123);
        admin1.setAdminName("Admin Name");
        admin1.setAdminPassword("iloveyou");
        assertSame(admin, adminService.fetchUserByemailIdAndPassword(admin1));
        verify(adminrepo).findByAdminEmailAndAdminPassword((String) any(), (String) any());
    }
}

