package com.rest.crud.service;

import java.util.List;

import com.rest.crud.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();

	Employee findById(int employeeId);

	Employee save(Employee employee);

	void deleteById(int employeeId);

}
