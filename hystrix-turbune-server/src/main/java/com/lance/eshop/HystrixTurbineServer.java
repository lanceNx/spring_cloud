package com.lance.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableTurbine
public class HystrixTurbineServer {

	 public static void main(String[] args) {
	     SpringApplication.run(HystrixTurbineServer.class, args);
	 }
}
