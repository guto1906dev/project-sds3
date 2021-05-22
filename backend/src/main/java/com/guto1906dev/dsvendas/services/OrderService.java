package com.guto1906dev.dsvendas.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.datetime.standard.InstantFormatter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guto1906dev.dsvendas.dto.OrderDTO;
import com.guto1906dev.dsvendas.dto.ProductDTO;
import com.guto1906dev.dsvendas.entities.Order;
import com.guto1906dev.dsvendas.entities.OrderStatus;
import com.guto1906dev.dsvendas.entities.Product;
import com.guto1906dev.dsvendas.repositories.OrderRepository;
import com.guto1906dev.dsvendas.repositories.ProductRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository repository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDTO> findAll(){
		List<Order> list = repository.findOrderWithProducts();
		
		return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());		
		
	}
	
	@Transactional
	public OrderDTO insert(OrderDTO dto) {
		Order order = new Order(null, dto.getAddress(), dto.getLatitude(),
				dto.getLongitude(), Instant.now(), OrderStatus.PENDING);
		for(ProductDTO productDTO : dto.getProducts() ) {
			order.getProducts().add(productRepository.getOne(productDTO.getId()));			
		}
		order = repository.save(order);
			
		return new OrderDTO(order);
		
	}

}
