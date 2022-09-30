package com.Myproject.OBM.servises;

import com.Myproject.OBM.model.Admin;
import com.Myproject.OBM.model.BarberServiceList;

import java.util.List;

public interface AdminServiceIf {

    public Admin fetchAdminByEmailId(String email);
    public BarberServiceList addBarberService(BarberServiceList barberServiceList);
    public BarberServiceList updateService(Integer serviceId, BarberServiceList barberServiceList);
    public  String deleteService(int serviceId);
    public List<BarberServiceList> getallServices();
    public Admin fetchUserByemailIdAndPassword(Admin admin);


}
