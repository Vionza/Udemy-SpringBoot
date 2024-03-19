package com.spring.security.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.spring.security.entity.Employee;

@RepositoryRestResource(path = "employees", exported = false)
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@RestResource(exported = false)
	List<Employee> findByFirstName(String firstName);
	
	@Query(value = "select t from Employee t where t.email like '%:email%'")
	List<Employee> findAdjah(String email);
}
