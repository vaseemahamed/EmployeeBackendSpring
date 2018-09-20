package com.example.test.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;
import com.example.test.config.RepositoryConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { RepositoryConfig.class })
public class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	public void testEmployeeRepository() {

		Employee emp = new Employee();
		emp.setFirstName("ee");
		emp.setLastName("ee");
		emp.setGender("male");
		emp.setDepartment("ss");
		emp.setDOB(new Date());
		assertNull(emp.getId()); // null before save
		employeeRepository.save(emp);
		assertNotNull(emp.getId()); // not null after save

		Employee fetchedProduct = employeeRepository.findById(emp.getId()).orElse(null);
		assertNotNull(fetchedProduct);
		assertEquals(emp.getId(), fetchedProduct.getId());
		assertEquals(emp.getFirstName(), fetchedProduct.getFirstName());

		Iterable<Employee> employees = employeeRepository.findAll();
		int count = 0;
		for (Employee p : employees) {
			count++;
		}
		assertEquals(count, 1);
	}
}
