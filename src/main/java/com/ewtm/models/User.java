package com.ewtm.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name= "users")
public class User {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Email(message = "Please provide a valid email")
	@NotEmpty(message = " be not empty")
	private String email;
	
	@Column
	@NotEmpty(message = "Can be not empty")
	private String name;
	
	@Column
	@NotEmpty(message = "Can be not empty")
	private String lastName;
	
	@Column
	@NotEmpty(message = "Can be not empty")
	@Length(min = 5 , message = "You need to provid a password that contains at least 5 characters")
	private String password;
	
	@Column
	private Boolean active;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles",
				joinColumns = @JoinColumn(name="user_id"),
				inverseJoinColumns = @JoinColumn(name="role_id"))
	private Set<Role> roles;
	
	public User() {
		
	}
	
	public User(Long id, String email, String name, String lastName, String password, Boolean active) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.lastName = lastName;
		this.password = password;
		this.active = active;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}
