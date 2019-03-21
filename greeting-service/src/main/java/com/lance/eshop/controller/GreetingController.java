package com.lance.eshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lance.eshop.service.GreetingService;
import com.lance.eshop.service.SayHelloService;

@RestController
public class GreetingController {
	
	@Autowired
	private GreetingService greetingService;
	
	@Autowired//这个fegin会自动把service丢入spring容器
	private SayHelloService sayHelloService;
	

	@GetMapping("greeting")
	public String greeting(String name) {
		return greetingService.greeting(name);
	}
	
	@GetMapping("sayHello")
	public String sayHello(String name) {
		return sayHelloService.sayHello(name);
	}
	
}
