package com.GraphQL.EmployeeGraphQL.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.GraphQL.EmployeeGraphQL.models.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String>{

	Optional<Employee> findByEmail(String email);
}
