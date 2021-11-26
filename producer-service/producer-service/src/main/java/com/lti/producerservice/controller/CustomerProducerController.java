package com.lti.producerservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.producerservice.model.Customer;
import com.lti.producerservice.repo.CustomerRepo;

@RestController
public class CustomerProducerController {

	@Autowired
	private CustomerRepo repo;
	
	@Autowired
	private Environment env;
	
	@PostMapping("/save")
	public Customer saveCustomer(@RequestBody Customer c) {
		
		Customer cu= repo.save(c);
		cu.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return cu;
	}
	
	@GetMapping("/getall")
	public List<Customer> getCustomers(){
		return repo.findAll();
	}
	
	@GetMapping("/getone/{id}")
	public Customer getById(@PathVariable Integer id) {
		
		Customer c= repo.findById(id).orElse(null);
		c.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return c;
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteById(@PathVariable Integer id) {
		repo.deleteById(id);
		return id+ "deleted";
		
		
	}
}
