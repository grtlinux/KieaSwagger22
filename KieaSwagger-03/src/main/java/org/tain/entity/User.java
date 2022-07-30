package org.tain.entity;

import io.swagger.annotations.ApiModelProperty;

public class User {

	@ApiModelProperty(notes = "User Id",name="id",required=true,value="1")
	private int id;

	@ApiModelProperty(notes = "User Name",name="name",required=true,value="test name")
	private String name;

	@ApiModelProperty(notes = "User Role",name="role",required=true,value="test role")
	private String role;

	@ApiModelProperty(notes = "User Email Id",name="email",required=true,value="test email")
	private String email;

	public User(int id, String name, String role, String email) {
		this.id = id;
		this.name = name;
		this.role = role;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				", role='" + role + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
