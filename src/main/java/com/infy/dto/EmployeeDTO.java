package com.infy.dto;





public class EmployeeDTO {

	
	private int id;
	private String name;
	private String jobRole;
	private String email;
	//constructors get setters hashcode equals
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
	public String getJobRole() {
		return jobRole;
	}
	public void setJobRole(String jobRole) {
		this.jobRole = jobRole;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public EmployeeDTO(int id, String name, String jobRole, String email) {
		super();
		this.id = id;
		this.name = name;
		this.jobRole = jobRole;
		this.email = email;
	}
	public EmployeeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmployeeDTO [id=" + id + ", name=" + name + ", jobRole=" + jobRole + ", email=" + email + "]";
	}
	
	
}
