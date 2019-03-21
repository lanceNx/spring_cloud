package com.lance.eshop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@SpringBootApplication
@EnableEurekaClient
@RestController
@EnableHystrix
@EnableHystrixDashboard
@EnableCircuitBreaker
public class SayHelloApplication {

	public static void main(String[] args) { 
        SpringApplication.run(SayHelloApplication.class, args);
    }
	
	@Value("${server.port}")
	private String port;
	
    @RequestMapping(value = "/sayHello")
    @HystrixCommand(fallbackMethod = "sayHelloFabllback")
    public String home(@RequestParam String name) {
        return "hello, " + name + " from port:" +port;
    }
    
    public String sayHelloFabllback(String name) {
    	return "error, " + name;
    }
	
}
