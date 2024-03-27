package com.spring.mvc.thymeleaf.controller;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/hello")
	public String sayHello(Model addModel) {
		addModel.addAttribute("theDate", new Date());
		return "helloword";
	}
}
