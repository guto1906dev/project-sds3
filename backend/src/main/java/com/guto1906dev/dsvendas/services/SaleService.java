package com.guto1906dev.dsvendas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guto1906dev.dsvendas.dto.SaleDTO;
import com.guto1906dev.dsvendas.dto.SaleSuccessDTO;
import com.guto1906dev.dsvendas.dto.SaleSumDTO;
import com.guto1906dev.dsvendas.entities.Sale;
import com.guto1906dev.dsvendas.repositories.SaleRepository;
import com.guto1906dev.dsvendas.repositories.SellerRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository repository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Transactional(readOnly = true)
	public Page<SaleDTO> findAll (Pageable pageable){
		sellerRepository.findAll();
		Page<Sale> result = repository.findAll(pageable);
		return result.map(x-> new SaleDTO(x));
	}
	
	@Transactional(readOnly = true)
	public List<SaleSumDTO> amountGropedBySeller(){
		return repository.amountGropedBySeller();
	}
	
	@Transactional(readOnly = true)
	public List<SaleSuccessDTO> successGropedBySeller(){
		return repository.successGropedBySeller();
	}

}
