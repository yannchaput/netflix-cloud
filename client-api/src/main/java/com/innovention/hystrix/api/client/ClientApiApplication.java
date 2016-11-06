package com.innovention.hystrix.api.client;

import java.net.URI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.innovention.hystrix.api.customers.Customer;

@RestController
@SpringBootApplication
@RequestMapping(value="/api")
public class ClientApiApplication {
	
	@RequestMapping(value="/client",method=RequestMethod.GET)
	public @ResponseBody Client client(@RequestParam(value="account",defaultValue="default",required=false) String account) {
		
		RestTemplate restTemplate = new RestTemplate();
	    URI uri = URI.create("http://localhost:8080/api/customer?account="+account);

	    String cust = restTemplate.getForObject(uri, String.class);
	    Client client = new Client();
	    client.setCust(cust);
		return client;
	}
	

	public static void main(String[] args) {
		SpringApplication.run(ClientApiApplication.class, args);

	}

}
