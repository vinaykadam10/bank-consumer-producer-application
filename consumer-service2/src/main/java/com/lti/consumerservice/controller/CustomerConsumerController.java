package com.lti.consumerservice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.lti.consumerservice.CustomerConsumerProxy;
import com.lti.consumerservice.model.Customer;

@RestController
public class CustomerConsumerController {
	
	@Autowired
	private CustomerConsumerProxy proxy;

	@SuppressWarnings("unchecked")
	@GetMapping("/getone/{id}")
	public Customer getCustomer(@PathVariable Integer id){
		
		/*
		 * Map<String, Integer> uriVariables=new HashMap<>(); uriVariables.put("id",id);
		 * 
		 * ResponseEntity<Customer> responseEntity=new
		 * RestTemplate().getForEntity("http://localhost:8080/getone/{id}",
		 * Customer.class, uriVariables);
		 */	
		Customer response=proxy.getById(id);
	
		return new Customer(response.getId(),response.getName(),response.getAddress(),response.getTypeOfAccount(),response.getPort());
	}
	
	
	@SuppressWarnings("unchecked")
	@GetMapping("/getall")
	public List<Customer> getCustomers(){
		
		List<Customer> response=proxy.getCustomers();
		
		return response;
	}	
		
	}
