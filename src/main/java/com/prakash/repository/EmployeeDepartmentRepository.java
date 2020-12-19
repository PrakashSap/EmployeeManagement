/**
 * 
 */
package com.prakash.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.prakash.entities.EmployeeDepartment;

/**
 * @author I335749
 *
 */

@Repository
public interface EmployeeDepartmentRepository extends JpaRepository<EmployeeDepartment, Long>{
	
	@Query(value="select * from department T where T.DEPTNO=?", nativeQuery = true)
	public List<EmployeeDepartment> getDepartmentList(long id);

}
