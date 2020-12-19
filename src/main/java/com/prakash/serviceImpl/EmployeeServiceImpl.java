/**
 * 
 */
package com.prakash.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prakash.entities.Employee;
import com.prakash.entities.EmployeeDepartment;
import com.prakash.exception.ResourceNotFoundException;
import com.prakash.repository.EmployeeRepository;
import com.prakash.service.EmployeeService;

/**
 * @author Prakash M
 *
 */
@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
    private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> getAllEmployees() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> getEmployeeById(Long employeeId) {
		
		return employeeRepository.findById(employeeId);
	}

	@Override
	@Transactional
	public Employee createEmployee(Employee employee) {
		Employee emp = new Employee();
		emp.setEmail(employee.getEmail());
		emp.setFirstName(employee.getFirstName());
		emp.setMiddleName(employee.getMiddleName());
		emp.setLastName(employee.getLastName());
		EmployeeDepartment obj = new EmployeeDepartment();
		List<EmployeeDepartment> list = new ArrayList<EmployeeDepartment>();
			obj.setDepartmentName("IBSO");
			obj.setDeptNo(10);
			obj.setEmpId(emp);
			list.add(obj);
		emp.setEmployeeDepartment(list);
		return employeeRepository.save(emp);
	}

	

	@Override
	@Transactional
	public Employee updateEmployee(Long employeeId, Employee employeeDetails) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
		        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		employee.setEmail(employee.getEmail());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setMiddleName(employeeDetails.getMiddleName());
        final Employee updatedEmployee = employeeRepository.save(employee);
		return updatedEmployee;
	}

	@Override
	public void deleteEmployee(Long employeeId) throws ResourceNotFoundException {
		Employee employee = employeeRepository.findById(employeeId)
			       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		 employeeRepository.delete(employee);
		}
	
}
