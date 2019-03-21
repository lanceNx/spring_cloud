package com.lance.eshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GreetingService {

	 @Autowired
     private RestTemplate restTemplate;

	 // 用SAY-HELLO-SERVICE这个服务名替代实际的ip地址
	 // ribbon负载在多个服务实例之间负载均衡，每次调用随机挑选一个实例，然后替换服务名
     public String greeting(String name) {
         return restTemplate.getForObject("http://SERVICE-SAY-HELLO/sayHello?name="+name, String.class);
     }
	
}
