/**
 * 
 */
package com.prakash.service;

import java.util.List;
import java.util.Optional;

import com.prakash.entities.Employee;
import com.prakash.entities.EmployeeDepartment;
import com.prakash.exception.ResourceNotFoundException;

/**
 * @author Prakash M
 *
 */
public interface EmployeeDepartmentService {
	
	 public List<EmployeeDepartment> getAlldepartment();
	 
	 public List<EmployeeDepartment> getEmployeeDepartmentById(Long employeeId);
	 
	 public EmployeeDepartment createEmployeeDept(EmployeeDepartment employeeDept);
	 
	 public EmployeeDepartment updateEmployeeDepartment(Long Id,EmployeeDepartment employeeDepartmentDetails) throws ResourceNotFoundException;
	 
	 
}
