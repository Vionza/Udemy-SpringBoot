package com.spring.security.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "roles")
@Data
public class Role {

	@Id
	@Column(name = "user_id")
	private String userId;
	@Column(name = "role")
	private String roleName;
	

}
