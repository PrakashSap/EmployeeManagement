/**
 * 
 */
package com.prakash.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Prakash M
 *
 */

@Entity
@Table(name = "department",schema ="employee")
public class EmployeeDepartment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false)
	private long id; 
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "EMPID")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private Employee empId;
	

	@Column(name = "DEPTNO", nullable = false)
	private long deptNo;
	
	@Column(name = "DEPARTMENTNAME", nullable = false)
	private String departmentName;
	
	public Employee getEmpId() {
		return empId;
	}
	public void setEmpId(Employee empId) {
		this.empId = empId;
	}
	public long getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(long deptNo) {
		this.deptNo = deptNo;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	
	
}
