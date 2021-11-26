package com.lti.consumerservice;

import java.util.List;
import java.util.Optional;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.lti.consumerservice.model.Customer;

//@FeignClient(name="producer-service",url="http://localhost:8080")
@FeignClient(name="producer-service")
public interface CustomerConsumerProxy {
		
	@GetMapping("/getone/{id}")
	public Customer getById(@PathVariable Integer id);
	
	@GetMapping("/getall")
	public List<Customer> getCustomers();

}
