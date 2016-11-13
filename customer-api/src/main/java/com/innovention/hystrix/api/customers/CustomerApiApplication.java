package com.innovention.hystrix.api.customers;

import java.util.Arrays;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.innovention.hystrix.api.beans.Customer;

@RestController
@SpringBootApplication
@RequestMapping(value="/api")
public class CustomerApiApplication {
	
	@Autowired
	private HashMap<String,Customer> jdd;
	
	@RequestMapping(value="/customer", method=RequestMethod.GET)
	public @ResponseBody Customer customer(@RequestParam(value="account",defaultValue="default",required=false) String account) {
		if (jdd.containsKey(account)) {
			return jdd.get(account);
		}
		else return null;
	}
	
	
	@Bean
	HashMap<String,Customer> customers() {
		HashMap<String,Customer> map = new HashMap<>();
		Customer cust = new Customer();
		cust.setAccountId("default");
		cust.setName("default");
		cust.setSurename("default");
		cust.setPolicyId(Arrays.asList(1516515,41411961));
		map.put(cust.getAccountId(), cust);
		cust = new Customer();
		cust.setAccountId("test1");
		cust.setName("Yann");
		cust.setSurename("Chaput");
		cust.setPolicyId(Arrays.asList(1516515,41411961));
		map.put(cust.getAccountId(), cust);
		cust = new Customer();
		cust.setAccountId("test2");
		cust.setName("Damien");
		cust.setSurename("Brenas");
		cust.setPolicyId(Arrays.asList(1516515,41411961));
		map.put(cust.getAccountId(), cust);
		cust = new Customer();
		cust.setAccountId("test3");
		cust.setName("Fabrice");
		cust.setSurename("Gueant");
		cust.setPolicyId(Arrays.asList(1516515,41411961));
		map.put(cust.getAccountId(), cust);
		
		return map;
	}

	public static void main(String[] args) {
		SpringApplication.run(CustomerApiApplication.class, args);

	}

}
