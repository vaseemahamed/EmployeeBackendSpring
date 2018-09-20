package com.example.test.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;

import com.example.controller.EmployeeController;
import com.example.entity.Employee;
import com.example.serviceImpl.EmployeeServiceImpl;

public class EmployeeControllerTest {

	@InjectMocks
	private EmployeeController empController;

	@Mock
	EmployeeServiceImpl empServiceImpl;

	@Before
	public void setup() {
		this.empController = new EmployeeController();
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void verifyGetAllEmployees() throws Exception {
		Employee emp = new Employee();
		emp.setFirstName("tt");
		List<Employee> Testlist = new ArrayList<>();
		Testlist.add(emp);
		when(empController.getAllEmployees()).thenReturn(Testlist);
		List<Employee> dd = empController.getAllEmployees();
		assertEquals(dd.size(), 1);
	}

	@Test
	public void verifySaveEmployee() throws Exception {
		Employee emp = new Employee();
		emp.setFirstName("tt");
		HttpStatus stats = empController.saveEmpoyee(emp);
		assertEquals(HttpStatus.ACCEPTED, stats.ACCEPTED);
	}
}
