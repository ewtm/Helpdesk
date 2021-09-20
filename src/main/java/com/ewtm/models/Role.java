package com.ewtm.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;


@Entity
@Table(name = "roles")
public class Role {

	@Id
	@GeneratedValue
	@Column
	private Long id;
	
	@Column
	@NotEmpty(message = "Can not be empty")
	private String role;
	
	public Role(String role) {
		
	}
	
	public Role(Long id, String role) {
		super();
		this.id = id;
		this.role = role;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
