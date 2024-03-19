package com.spring.security.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.security.entity.Employee;
import com.spring.security.service.EmployeeService;


@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService service;

	public EmployeeRestController(EmployeeService service) {
		this.service = service;
	}

	@GetMapping(value = "/employees")
	public List<Employee> getEmployees() {
		return service.findAll();
	}
	
	@GetMapping(value = "/employees/{employeeId}")
	public Employee getEmployee(@PathVariable("employeeId") int employeeId) {
		return service.findById(employeeId);
	}
	
	@PostMapping(value = "/employees")
	public Employee addEmployee(@RequestBody Employee empolyee) {
		return service.save(empolyee);
	}
	
	@DeleteMapping(value = "/employees/{employeeId}")
	public String deleteEmployee(@PathVariable("employeeId") int employeeId) {
		service.deleteById(employeeId);
		return "Deleted Employee ID = "+employeeId;
	}
	
	@PutMapping(value = "/employees")
	public Employee updateEmployee(@RequestBody Employee employee) {
		return service.save(employee);
	}
}
