package com.spring.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.security.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
