package com.guto1906dev.dsvendas.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guto1906dev.dsvendas.dto.OrderDTO;
import com.guto1906dev.dsvendas.entities.Order;
import com.guto1906dev.dsvendas.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> list = repository.findOrderWithProducts();
		
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
		
		
	}

}
