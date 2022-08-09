package com.self.store;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

@Repository
public class ProductRepo {

	private static List<Product> products = new ArrayList<Product>();

	@PostConstruct
	private void buildRepo() {
		products.add(new Product(1, "Phone XL", 799, "A large phone with one of the best screens"));
		products.add(new Product(2, "Phone Mini", 699, "A great phone with one of the best cameras"));
		products.add(new Product(3, "Phone Standard", 399, "A basic phone with limited features"));
	}

	public List<Product> getAllProducts() {
		return products;
	}

	public Product getProductWithId(Integer id) {
		List<Product> filteredProduct = products.stream().filter(prodcut -> prodcut.id == id)
				.collect(Collectors.toList());

		return filteredProduct.isEmpty() ? new Product() : filteredProduct.get(0);
	}
}
