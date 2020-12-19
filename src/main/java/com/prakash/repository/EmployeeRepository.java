/**
 * 
 */
package com.prakash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.prakash.entities.Employee;

/**
 * @author I335749
 *
 */

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	@Query(value="select * from employee T", nativeQuery = true)
	public List<Employee> findAllEmployees();

}
