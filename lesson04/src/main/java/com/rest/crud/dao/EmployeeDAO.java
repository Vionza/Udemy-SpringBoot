/**
 * 
 */
package com.rest.crud.dao;

import java.util.List;

import com.rest.crud.entity.Employee;

/**
 * 
 */
public interface EmployeeDAO {

	List<Employee> findAll();

	Employee findById(int employeeId);

	Employee save(Employee employee);

	void deleteById(int employeeId);
}
