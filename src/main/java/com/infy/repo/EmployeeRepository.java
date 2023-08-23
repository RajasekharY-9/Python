package com.infy.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.entity.Employee;
//repository crud pagenationandsorting jparepo
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
