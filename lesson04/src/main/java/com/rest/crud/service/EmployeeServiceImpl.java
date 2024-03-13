package com.rest.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rest.crud.dao.EmployeeDAO;
import com.rest.crud.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDAO employeeDao;

	public EmployeeServiceImpl(EmployeeDAO employee) {
		this.employeeDao = employee;
	}

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public Employee findById(int employeeId) {
		return employeeDao.findById(employeeId);
	}

	@Transactional
	@Override
	public Employee save(Employee employee) {
		return employeeDao.save(employee);
	}

	@Transactional
	@Override
	public void deleteById(int employeeId) {
		employeeDao.deleteById(employeeId);

	}

}
