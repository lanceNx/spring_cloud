package com.lance.eshop.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "SERVICE-SAY-HELLO", fallback = SayHelloServiceFallback.class)//声明远程服务接口，就是需要调用的服务
public interface SayHelloService {
	
	@RequestMapping(value = "sayHello")//调用这个服务的哪个接口
	String sayHello(@RequestParam("name") String name);//要声明传输参数

}

@Component
class SayHelloServiceFallback implements SayHelloService {

	@Override
	public String sayHello(String name) {
		return "error, " + name;
	}
	
}
