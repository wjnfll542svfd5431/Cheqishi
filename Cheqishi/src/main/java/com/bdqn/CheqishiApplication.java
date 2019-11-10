package com.bdqn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Controller
public class CheqishiApplication {
  
	public static void main(String[] args) {
		SpringApplication.run(CheqishiApplication.class, args);
	}
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
