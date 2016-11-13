package com.innovention.hystrix.api.client;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.innovention.hystrix.api.beans.Client;
import com.innovention.hystrix.api.beans.Customer;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class ClientApiService {
	
	private final RestTemplate restTemplate;
	
	public ClientApiService(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}
	
	@HystrixCommand(fallbackMethod="fallback")
	public Client getClientDetails(String idAccount) {
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl("http://localhost:8080")
				.pathSegment("api","customer")
				.queryParam("account", idAccount);

	    Customer cust = restTemplate.getForObject(builder.build().encode().toUri(), Customer.class);
	    Client client = new Client();
	    client.setCust(cust);
		return client;
	}
	
	private Client fallback(String idAccount) {
		// Custom fail : stale data
		Client client = new Client();
		Customer cust = new Customer();
		cust.setAccountId("fallback");
		cust.setName("fallback");
		cust.setSurename("fallback");
		cust.setPolicyId(Collections.EMPTY_LIST);
		client.setCust(cust);
		return client;
	}
}
