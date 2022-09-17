package com.Myproject.OBM.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Myproject.OBM.model.OrderList;

public interface OderRepo extends JpaRepository<OrderList, Integer> {

}
