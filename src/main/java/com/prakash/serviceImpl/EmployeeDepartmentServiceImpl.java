/**
 * 
 */
package com.prakash.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prakash.entities.EmployeeDepartment;
import com.prakash.exception.ResourceNotFoundException;
import com.prakash.repository.EmployeeDepartmentRepository;
import com.prakash.service.EmployeeDepartmentService;

/**
 * @author Prakash M
 *
 */
@Service
public class EmployeeDepartmentServiceImpl implements EmployeeDepartmentService{
	
	@Autowired
	EmployeeDepartmentRepository repo;

	@Override
	public List<EmployeeDepartment> getAlldepartment() {
		
		return repo.findAll();
	}

	@Override
	public List<EmployeeDepartment> getEmployeeDepartmentById(Long deptno) {
		
		return repo.getDepartmentList(deptno);
	}

	@Override
	@Transactional
	public EmployeeDepartment createEmployeeDept(EmployeeDepartment employeeDept) {
		return  repo.save(employeeDept);
	}

	@Override
	@Transactional
	public EmployeeDepartment updateEmployeeDepartment(Long Id, EmployeeDepartment employeeDepartmentDetails)
			throws ResourceNotFoundException {
		EmployeeDepartment employee = repo.findById(Id)
		        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + Id));
		employee.setDepartmentName(employeeDepartmentDetails.getDepartmentName());
		employee.setDeptNo(employeeDepartmentDetails.getDeptNo());
		employee.setEmpId(employeeDepartmentDetails.getEmpId());
        final EmployeeDepartment updatedEmployee = repo.save(employee);
		return updatedEmployee;
	}
}
