package com.infy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.dto.EmployeeDTO;
import com.infy.entity.Employee;
import com.infy.exception.EmployeeException;
import com.infy.repo.EmployeeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public String addEmployee(EmployeeDTO employeeDTO) throws EmployeeException {
		Optional<Employee> isExist = employeeRepository.findById(employeeDTO.getId());
		if (isExist.isPresent()) {
			throw new EmployeeException("Employee Already Exists");
		}

		Employee emp = new Employee();
		emp.setId(employeeDTO.getId());
		emp.setEmail(employeeDTO.getEmail());
		emp.setJobRole(employeeDTO.getJobRole());
		emp.setName(employeeDTO.getName());

		employeeRepository.save(emp);

		return "New Employee Successfully Added";
	}

	@Override
	public EmployeeDTO getEmployee(int id) throws EmployeeException {
		Optional<Employee> isExist = employeeRepository.findById(id);
		Employee employee = isExist.orElseThrow(() -> new EmployeeException("Employee Not Found"));

		EmployeeDTO emp = new EmployeeDTO();
		emp.setEmail(employee.getEmail());
		emp.setId(employee.getId());
		emp.setJobRole(employee.getJobRole());
		emp.setName(employee.getName());

		return emp;
	}

	@Override
	public List<EmployeeDTO> getAllEmployees() throws EmployeeException {

		Iterable<Employee> list = employeeRepository.findAll();
		List<EmployeeDTO> newList = new ArrayList<>();
		list.forEach(c -> {
			EmployeeDTO emp = new EmployeeDTO();
			emp.setEmail(c.getEmail());
			emp.setId(c.getId());
			emp.setJobRole(c.getJobRole());
			emp.setName(c.getName());
			newList.add(emp);

		});
		if (newList.isEmpty()) {
			throw new EmployeeException("No employees Found");
		}

		return newList;
	}

	@Override
	public String updateEmployee(int id, EmployeeDTO emp) throws EmployeeException {

		Optional<Employee> isExist = employeeRepository.findById(id);
		Employee emps = isExist.orElseThrow(() -> new EmployeeException("Employee not found"));
		emps.setEmail(emp.getEmail());
		emps.setId(emp.getId());
		emps.setJobRole(emp.getJobRole());
		emps.setName(emp.getName());

		return "Employee Details Updated Successfully";
	}

	@Override
	public String deleteEmployee(int id) throws EmployeeException {
		Optional<Employee> isExist = employeeRepository.findById(id);
		isExist.orElseThrow(() -> new EmployeeException("Employee not found"));
		employeeRepository.deleteById(id);

		return "Employee Deleted Successfully";
	}

}
