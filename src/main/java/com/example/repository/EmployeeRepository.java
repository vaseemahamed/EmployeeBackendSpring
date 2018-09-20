package com.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.Employee;

@Repository
@Transactional
public interface EmployeeRepository extends MongoRepository<Employee, String>{

}
