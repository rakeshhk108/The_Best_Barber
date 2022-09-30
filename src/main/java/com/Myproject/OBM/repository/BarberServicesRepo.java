package com.Myproject.OBM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Myproject.OBM.model.BarberServiceList;

public interface BarberServicesRepo extends JpaRepository<BarberServiceList, Integer> {	

}
