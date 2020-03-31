package com.GraphQL.EmployeeGraphQL.service;

import java.util.List;

import com.GraphQL.EmployeeGraphQL.models.Employee;

public interface EmployeeService {
	
	List<Employee> getAllEmployee();
	
	Employee ValidateAndGetByEmailId(String email);
	
	Employee saveEmployee(Employee employee);
	
	boolean deleteEmployee(Employee employee);
}
