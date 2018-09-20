package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;

@RestController
@RequestMapping("/employee")
@Api(value = "Employee Registry")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	/**
	 * Method to retrieve all the Employees
	 * 
	 * @return
	 */
	@ApiOperation(value = "View a list of available employees", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "/getAllEmployees", method = RequestMethod.GET)
	public Iterable<Employee> getAllProducts() {
		return employeeService.getAllEmployee();
	}

	/**
	 * Method to save the employee details
	 * 
	 * @param employee
	 * @return
	 */
	@ApiOperation(value = "Save a new Employee", response = Iterable.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public HttpStatus saveEmpoyee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}
}
