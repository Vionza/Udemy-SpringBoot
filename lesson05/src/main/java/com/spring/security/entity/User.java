package com.spring.security.entity;

import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "members")
@Data
public class User {
	@Id
	@Column(name = "user_id")
	private String userId;
	@Column(name = "pw")
	private String password;
	@Column(name = "active")
	private int active;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private Collection<Role> roles;
}
