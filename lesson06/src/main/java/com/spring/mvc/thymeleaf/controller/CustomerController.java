package com.spring.mvc.thymeleaf.controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.spring.mvc.thymeleaf.model.Customer;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class CustomerController {

	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
	}
	
	@GetMapping(path = "/")
	public String showForm(@ModelAttribute(value = "customer") Customer customer) {

		return "customer-form";
	}
	
	@PostMapping(path = "/processForm")
	public String postMethodName(@Valid @ModelAttribute(value = "customer") Customer customer, BindingResult result) {
		
		if(result.hasErrors()) return "customer-form";
		
		return "customer-confirmation";
	}
	
}
