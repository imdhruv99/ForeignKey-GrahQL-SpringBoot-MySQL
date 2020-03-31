package com.GraphQL.EmployeeGraphQL.repository;

import org.springframework.data.repository.CrudRepository;

import com.GraphQL.EmployeeGraphQL.models.EmployeeAddress;

public interface EmployeeAddressRepository extends CrudRepository<EmployeeAddress, Long>{

}
