package com.spring.mvc.thymeleaf.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String> {

	private String coursePrefix;

	@Override
	public void initialize(CourseCode constraintAnnotation) {
		// TODO Auto-generated method stub
		coursePrefix = constraintAnnotation.value();
		// ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub

		return value == null ? Boolean.FALSE : value.startsWith(coursePrefix);
	}

}
