package com.spring.mvc.crud.service;

import java.util.List;

import com.spring.mvc.crud.entity.Employee;




public interface EmployeeService {
	List<Employee> findAll();

	Employee findById(int employeeId);

	Employee save(Employee employee);

	void deleteById(int employeeId);

}
