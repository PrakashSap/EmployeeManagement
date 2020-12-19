/**
 * 
 */
package com.prakash.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Prakash M
 *
 */

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EMPID", nullable = false)
	private long empId;
	
	@Column(name = "FIRSTNAME", nullable = true)
	private String firstName;
	
	@Column(name = "MIDDLENAME", nullable = true)
	private String middleName;
	
	@Column(name = "LASTNAME", nullable = true)
	private String lastName;
	
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empId")
	//@JoinColumn(name = "EMPID", insertable = true, updatable = true)
	@JsonIgnore
	private List<EmployeeDepartment> employeeDepartment;
	
	public long getEmpId() {
		return empId;
	}
	public void setEmpId(long empId) {
		this.empId = empId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public List<EmployeeDepartment> getEmployeeDepartment() {
		return employeeDepartment;
	}
	public void setEmployeeDepartment(List<EmployeeDepartment> employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	
	

}
