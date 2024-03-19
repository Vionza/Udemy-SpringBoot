package com.spring.security.service;

import java.util.List;

import com.spring.security.entity.Employee;


public interface EmployeeService {
	List<Employee> findAll();

	com.spring.security.entity.Employee findById(int employeeId);

	Employee save(Employee employee);

	void deleteById(int employeeId);

}
