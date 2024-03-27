package com.spring.mvc.thymeleaf.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.mvc.thymeleaf.model.Student;

@Controller
public class StudentController {

	@Value("${country}")
	List<String> countries;
	
	@Value("${language}")
	List<String> languages;
	
	@Value("${system}")
	List<String> systems;
	
	@GetMapping("/showStudent")
	public String showStudent(Model model) {
		model.addAttribute("student", new Student());
		model.addAttribute("countries", countries);
		model.addAttribute("languages", languages);
		model.addAttribute("systems", systems);

		return "student-form";
	}
	
	@PostMapping("/processStudentForm")
	public String processForm(@ModelAttribute(value = "student") Student student) {
		return "student-confirmation";
		
	}
}
