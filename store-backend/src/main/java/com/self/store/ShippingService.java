package com.self.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShippingService {

	@Autowired
	private ShippingRepo repo;
	
	public List<Shipping> getShippingCharges() {
		return repo.getShippingCharges();
	}
}
