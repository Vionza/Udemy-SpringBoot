package com.spring.mvc.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWordController {

	@GetMapping("/showForm")
	public String showForm() {
		return "helloword-form";
	}

	@GetMapping("/processForm")
	public String processForm() {
		return "helloword";
	}

	@GetMapping("processFormV2")
	public String processV2(HttpServletRequest request, Model model) {
		model.addAttribute("message", "Hi! ".concat(request.getParameter("studentName").toUpperCase()));
		return "helloword";
	}
	
	@PostMapping("processFormV3")
	public String processV3(@RequestParam(value = "studentName") String name, Model model) {
		model.addAttribute("message", "Koniciwa! ".concat(name.toUpperCase()));
		return "helloword";
	}
}
