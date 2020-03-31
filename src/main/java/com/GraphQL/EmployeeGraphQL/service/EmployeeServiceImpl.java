package com.GraphQL.EmployeeGraphQL.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GraphQL.EmployeeGraphQL.exception.EmployeeNotFoundException;
import com.GraphQL.EmployeeGraphQL.models.Employee;

import com.GraphQL.EmployeeGraphQL.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Employee ValidateAndGetByEmailId(String email) {
		return employeeRepository.findByEmail(email)
				.orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found", "email", email));
	}

	@Override
	public Employee saveEmployee(Employee employee) {

		return employeeRepository.save(employee);
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		employeeRepository.delete(employee);
		return true;
	}

}
