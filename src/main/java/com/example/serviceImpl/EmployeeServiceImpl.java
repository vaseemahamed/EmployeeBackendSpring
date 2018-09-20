package com.example.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import com.example.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> products = employeeRepository.findAll();
		if (products != null) {
			return products;
		}
		return null;
	}

	@Override
	public HttpStatus saveEmployee(Employee employee) {
		Employee postEmployee = employeeRepository.save(employee);
		return postEmployee != null ? HttpStatus.ACCEPTED : HttpStatus.SERVICE_UNAVAILABLE;
	}
}
