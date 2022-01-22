package com.learn.microserviceb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class MicroserviceBApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceBApplication.class, args);
	}

	@Traced
	@GetMapping("b/{num}")
	public String endpointB(@PathVariable("num") Integer num) throws InterruptedException {
		Thread.sleep(300);
		System.out.println("service b : num: "+num);
		return ""+num*3;
	}
}
