/**
 * 
 */
package com.prakash.service;

import java.util.List;
import java.util.Optional;

import com.prakash.entities.Employee;
import com.prakash.exception.ResourceNotFoundException;

/**
 * @author Prakash M
 *
 */
public interface EmployeeService {
	
	 public List<Employee> getAllEmployees();
	 
	 public Optional<Employee> getEmployeeById(Long employeeId);
	 
	 public Employee createEmployee(Employee employee);
	 
	 public Employee updateEmployee(Long employeeId,Employee employeeDetails) throws ResourceNotFoundException;
	 
	 public void deleteEmployee(Long employeeId) throws ResourceNotFoundException;

}
