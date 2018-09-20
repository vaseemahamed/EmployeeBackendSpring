package com.example.service;

import java.util.List;

import org.springframework.http.HttpStatus;

import com.example.entity.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployee();

	HttpStatus saveEmployee(Employee employee);

}
