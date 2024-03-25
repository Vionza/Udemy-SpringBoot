package com.spring.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.spring.security.entity.User;

public interface UserService extends UserDetailsService{

	User findById(String username);

}
