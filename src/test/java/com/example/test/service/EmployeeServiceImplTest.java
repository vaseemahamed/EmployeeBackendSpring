package com.example.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import com.example.serviceImpl.EmployeeServiceImpl;

public class EmployeeServiceImplTest {

	private EmployeeServiceImpl employeeServiceImpl;

	@Mock
	private EmployeeRepository empRepository;

	@Mock
	private Employee employee;

	@Before
	public void setupMock() {
		MockitoAnnotations.initMocks(this);
		employeeServiceImpl = new EmployeeServiceImpl();
	}

	@Test
	public void shouldReturnEmployees_whenGetAllEmployessIsCalled() throws Exception {
		List<Employee> employeeList = new ArrayList<>();
		when(empRepository.findAll()).thenReturn(employeeList);
		List<Employee> retrievedEmployeeList = employeeServiceImpl.getAllEmployee();
		assertEquals(retrievedEmployeeList.size(), employeeList.size());
	}
}
