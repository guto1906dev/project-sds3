package com.guto1906dev.dsvendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guto1906dev.dsvendas.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	

}
