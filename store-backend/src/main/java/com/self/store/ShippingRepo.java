package com.self.store;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.springframework.util.FileCopyUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class ShippingRepo {

	private static List<Shipping> shippingList = new ArrayList<Shipping>();
	final ObjectMapper objectMapper = new ObjectMapper();

	@PostConstruct
	private void buildRepo() {
		shippingList = readJsonFileEntries();
	}

	private List<Shipping> readJsonFileEntries() {

		List<Shipping> _shippingList = new ArrayList<Shipping>();
		try {
		
			
			byte[] dataArr = FileCopyUtils.copyToByteArray( new ClassPathResource("shipping.json").getInputStream());
			String data = new String(dataArr, StandardCharsets.UTF_8);
			
			_shippingList = objectMapper.readValue(data,
					new TypeReference<List<Shipping>>() {
					});
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return _shippingList;
	}

	public List<Shipping> getShippingCharges() {
		return shippingList;
	}

}
