package com.innovention.hystrix.api.client;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.innovention.hystrix.api.beans.Client;


@RestController
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrixDashboard
@RequestMapping(value="/api")
public class ClientApiApplication {
	
	@Autowired
	private ClientApiService clientService;
	
	@RequestMapping(value="/client",method=RequestMethod.GET)
	public @ResponseBody Client client(@RequestParam(value="account",defaultValue="default",required=false) String account) {
		
		return clientService.getClientDetails(account);
	}
	

	public static void main(String[] args) {
		SpringApplication.run(ClientApiApplication.class, args);

	}

}
