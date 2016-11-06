package com.innovention.hystrix.api.customers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class CustomerApiApplication {
	
	@RequestMapping(value="/customers")
	public List<Customer> customers() {
		
		ArrayList<Customer> list = new ArrayList<>();
		Customer cust1 = new Customer();
		cust1.accountId = "testClientA";
		cust1.name="Yann";
		cust1.surename="Chaput";
		cust1.policyIds = Arrays.asList(1516515,41411961);
		cust1.commercialType="HABITATION";
		list.add(cust1);
		cust1 = new Customer();
		cust1.accountId = "testClientB";
		cust1.name="Damien";
		cust1.surename="Brenas";
		cust1.policyIds = Arrays.asList(5478923,4145632);
		cust1.commercialType="AUTO";
		list.add(cust1);
		return list;
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerApiApplication.class, args);

	}

}
