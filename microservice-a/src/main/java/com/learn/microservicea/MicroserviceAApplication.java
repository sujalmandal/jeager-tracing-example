package com.learn.microservicea;

import io.opentracing.Span;
import io.opentracing.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

@SpringBootApplication
@RestController
public class MicroserviceAApplication {
	private static final Logger LOG = Logger.getLogger(MicroserviceAApplication.class.getName());
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAApplication.class, args);
	}

	RestTemplate restTemplate = new RestTemplate();

	@GetMapping("a/{num}")
	public String endpointA(@PathVariable("num") Integer num){
		System.out.println("service a : num: "+num);
		String result = restTemplate.getForObject("http://localhost:8000/b/" + num, String.class);
		return result;
	}
}
