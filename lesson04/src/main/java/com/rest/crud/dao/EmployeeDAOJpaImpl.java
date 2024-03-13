/**
 * 
 */
package com.rest.crud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.rest.crud.entity.Employee;

import jakarta.persistence.EntityManager;

/**
 * 
 */
@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

	/**
	 * 
	 */
	private EntityManager entityManager;

	public EmployeeDAOJpaImpl(EntityManager manager) {
		this.entityManager = manager;
	}

	@Override
	public List<Employee> findAll() {

		return entityManager.createQuery("from Employee", Employee.class).getResultList();

	}

	@Override
	public Employee findById(int employeeId) {

		return entityManager.find(Employee.class, employeeId);
	}

	@Override
	public Employee save(Employee employee) {
		return entityManager.merge(employee);
	}

	@Override
	public void deleteById(int employeeId) {
		entityManager.remove(entityManager.find(Employee.class, employeeId));
	}

}
