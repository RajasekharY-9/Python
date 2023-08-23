package com.infy.service;

import java.util.List;

import com.infy.dto.EmployeeDTO;
import com.infy.exception.EmployeeException;

public interface EmployeeService {

	//c r u d 
	
	public String addEmployee(EmployeeDTO employeeDTO) throws EmployeeException;
	
	public EmployeeDTO getEmployee(int id) throws EmployeeException;
	
	public List<EmployeeDTO> getAllEmployees()throws EmployeeException;
	
	public String updateEmployee(int id,EmployeeDTO emp) throws EmployeeException;
	
	public String deleteEmployee(int id)throws EmployeeException;
	
	
	
	
}
