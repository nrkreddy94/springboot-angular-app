package com.self.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	@Autowired
	private ProductRepo repo;
	
	public List<Product> getAllProducts(){
		
		return repo.getAllProducts();
	}

	public Product getProductById(Integer id) {
		return repo.getProductWithId(id);
	}
}
