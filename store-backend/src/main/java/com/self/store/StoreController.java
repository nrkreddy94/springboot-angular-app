package com.self.store;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class StoreController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ShippingService shippingService;

	@GetMapping("/store/products")
	public List<Product> getAllProducts() {

		return productService.getAllProducts();
	}

	@GetMapping("/store/product")
	public Product getProductById(@RequestParam Integer id) {
		return productService.getProductById(id);
	}

	@GetMapping("/store/shippings")
	public List<Shipping> getShippingCharges() {

		return shippingService.getShippingCharges();
	}

	@GetMapping("/store/time")
	public Map<String, String> getCurrentTime() {
		Map<String, String> response = new HashMap<String, String>();
		response.put("currentTime", Calendar.getInstance().getTime().toString());
		return response;
	}
}
