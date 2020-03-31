package com.GraphQL.EmployeeGraphQL.resolver;


import org.springframework.stereotype.Component;

import com.GraphQL.EmployeeGraphQL.models.Employee;
import com.GraphQL.EmployeeGraphQL.models.EmployeeAddress;
import com.GraphQL.EmployeeGraphQL.models.EmployeeDetails;
import com.GraphQL.EmployeeGraphQL.service.EmployeeService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class Mutation implements GraphQLMutationResolver {
	
	private EmployeeService employeeService;
	
	public Mutation(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	
	public Employee createEmployee(String email, String password, String salary, String dob, String experience, 
			String street, String postalCode, String city, String state, String country) {
		
		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setSalary(salary);
		employeeDetails.setDob(dob);
		employeeDetails.setExperience(experience);
		
		EmployeeAddress employeeAddress = new EmployeeAddress();
		employeeAddress.setStreet(street);
		employeeAddress.setPostalCode(postalCode);
		employeeAddress.setCity(city);
		employeeAddress.setState(state);
		employeeAddress.setCountry(country);
		
		Employee employee = new Employee();
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setEmployeeDetails(employeeDetails);
		employee.setEmployeeAddress(employeeAddress);
		
		return employeeService.saveEmployee(employee);
	}
	
	public Employee updateEmployee(String email, String password, String salary, String dob, String experience, 
			String street, String postalCode, String city, String state, String country) {
		
		Employee employee = employeeService.ValidateAndGetByEmailId(email);

		EmployeeDetails employeeDetails = new EmployeeDetails();
		employeeDetails.setSalary(salary);
		employeeDetails.setDob(dob);
		employeeDetails.setExperience(experience);
		
		EmployeeAddress employeeAddress = new EmployeeAddress();
		employeeAddress.setStreet(street);
		employeeAddress.setPostalCode(postalCode);
		employeeAddress.setCity(city);
		employeeAddress.setState(state);
		employeeAddress.setCountry(country);
		
		Employee employee1 = new Employee();
		employee.setEmail(email);
		employee.setPassword(password);
		employee.setEmployeeDetails(employeeDetails);
		employee.setEmployeeAddress(employeeAddress);  
		
		return employeeService.saveEmployee(employee1);
			
	}
	
	public Employee deleteEmployee(String email) {
		
		Employee employee = employeeService.ValidateAndGetByEmailId(email);
		employeeService.deleteEmployee(employee);
		return employee;
		
	}

}
