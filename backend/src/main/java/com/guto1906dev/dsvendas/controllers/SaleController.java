package com.guto1906dev.dsvendas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guto1906dev.dsvendas.dto.SaleDTO;
import com.guto1906dev.dsvendas.dto.SaleSuccessDTO;
import com.guto1906dev.dsvendas.dto.SaleSumDTO;
import com.guto1906dev.dsvendas.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {
	
	@Autowired
	private SaleService service;
	
	@GetMapping
	public ResponseEntity<Page<SaleDTO>> findAll(Pageable pageable){
		Page<SaleDTO> list = service.findAll(pageable);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/amount-by-seller")
	public ResponseEntity<List<SaleSumDTO>> amountGropedBySeller(){
		List<SaleSumDTO> list = service.amountGropedBySeller();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(value = "/success-by-seller")
	public ResponseEntity<List<SaleSuccessDTO>> successGropedBySeller(){
		List<SaleSuccessDTO> list = service.successGropedBySeller();
		return ResponseEntity.ok(list);
	}

}
