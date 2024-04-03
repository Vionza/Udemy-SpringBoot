package com.spring.mvc.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.crud.entity.Employee;
import com.spring.mvc.crud.repository.EmployeeRepository;



@Service
public class EmployeeServiceImpl implements EmployeeService {


	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int employeeId) {
		return employeeRepository.findById(employeeId).orElse(new Employee());
	}

	@Transactional
	@Override
	public Employee save(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Transactional
	@Override
	public void deleteById(int employeeId) {
		employeeRepository.deleteById(employeeId);

	}

}
