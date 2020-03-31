package com.GraphQL.EmployeeGraphQL.resolver;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.GraphQL.EmployeeGraphQL.models.Employee;
import com.GraphQL.EmployeeGraphQL.service.EmployeeService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver {
	
	@Autowired
	private  EmployeeService employeeService;
	
	private Query(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	public List<Employee> getAllEmployees() {
		return employeeService.getAllEmployee();
	}
	
	public Employee getEmployeeByEmailId(String email) {
		return employeeService.ValidateAndGetByEmailId(email);
	}
}
