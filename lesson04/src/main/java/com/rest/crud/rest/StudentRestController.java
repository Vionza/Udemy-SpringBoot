/**
 * 
 */
package com.rest.crud.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.crud.entity.Student;

import jakarta.annotation.PostConstruct;

/**
 * 
 */
@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> students;

	@PostConstruct
	public void loadData() {
		students = new ArrayList<>();
		students.add(new Student("Monkey", "D'luffy"));
		students.add(new Student("Roronoa", "Zoro"));
		students.add(new Student("Nico", "Robin"));
	}

	@GetMapping("/students")
	public List<Student> getStudents() {
		return students;
	}

	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable(name = "studentId") int studentId) {

		if (studentId >= students.size() || studentId < 0)
			throw new StudentNotFoundException("Student Id not Found " + studentId);
		return students.get(studentId);
	}
}
