package com.spring.mvc.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.mvc.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
