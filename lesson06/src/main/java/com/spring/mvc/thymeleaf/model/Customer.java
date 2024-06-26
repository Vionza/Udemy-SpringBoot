package com.spring.mvc.thymeleaf.model;

import com.spring.mvc.thymeleaf.validation.CourseCode;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	private String firstName;
	
	@NotNull(message = "is required")
	@Size(min = 1, message = "is required")
	private String lastName;
	
	@NotNull(message = "is required")
	@Min(value = 0, message = "must be greater then or equal to 0")
	@Max(value = 10, message = "must be less then or equal to 10")
	private Integer freePasses;
	
	@Pattern(regexp = "^[a-zA-Z0-9]{5}", message = "only 5 digit/char")
	private String postalCode;
	
	@CourseCode(value = "TEST", message = "must start with TEST")
	private String courseCode;
}
