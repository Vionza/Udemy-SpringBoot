package com.spring.mvc.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.crud.entity.Employee;
import com.spring.mvc.crud.service.EmployeeService;

@Controller
@RequestMapping(path = "/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping(path = "/list")
	public String listEmployee(Model model) {

		model.addAttribute("employees", employeeService.findAll());
		model.addAttribute("employee", new Employee());

		return "list-employees";
	}

	@PostMapping(path = "/save")
	public String saveEmployee(@ModelAttribute(value = "employee") Employee employee) {
		employeeService.save(employee);
		return "redirect:/employees/list";
	}

	@GetMapping(path = "/remove")
	public String deleteEmployee(@RequestParam("id") Integer employeeId) {
		employeeService.deleteById(employeeId);
		return "redirect:/employees/list";
	}
}
