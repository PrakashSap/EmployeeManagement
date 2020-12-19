/**
 * 
 */
package com.prakash.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prakash.entities.Employee;
import com.prakash.entities.EmployeeDepartment;
import com.prakash.exception.ResourceNotFoundException;
import com.prakash.service.EmployeeDepartmentService;
import com.prakash.service.EmployeeService;

/**
 * @author Prakash M
 *
 */
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired 
	private EmployeeService service;
	
	@Autowired 
	private EmployeeDepartmentService deptService;
	
	@Autowired   
	private MessageSource messageSource;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/employees/{empId}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable(value = "empId") Long employeeId)
        throws ResourceNotFoundException {
        return ResponseEntity.ok().body(service.getEmployeeById(employeeId));
    }
    
    @GetMapping("/department")
    public List<EmployeeDepartment> getAlldepartment() {
        return deptService.getAlldepartment();
    }

    @GetMapping("/department/{deptNo}")
    public ResponseEntity<List<EmployeeDepartment>> getEmployeeDepartmentById(@PathVariable(value = "deptNo") Long deptno)
        throws ResourceNotFoundException {
        return ResponseEntity.ok().body(deptService.getEmployeeDepartmentById(deptno));
    }
    
    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody @Valid Employee employee) {
        return service.createEmployee(employee);
    }
    
    @PostMapping("/department")
    public EmployeeDepartment createEmployeeDepartment(@RequestBody @Valid  EmployeeDepartment employeeDept) {
        return deptService.createEmployeeDept(employeeDept);
    }

    @PutMapping("/employees/{empId}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "empId") Long employeeId,
         @RequestBody @Valid Employee employeeDetails) throws ResourceNotFoundException {
        return ResponseEntity.ok(service.updateEmployee(employeeId,employeeDetails));
    }
    
    @PutMapping("/department/{Id}")
    public ResponseEntity<EmployeeDepartment> updateEmployeeDepartment(@PathVariable(value = "Id") Long Id,
         @RequestBody @Valid EmployeeDepartment employeeDepartmentDetails) throws ResourceNotFoundException {
        return ResponseEntity.ok(deptService.updateEmployeeDepartment(Id,employeeDepartmentDetails));
    }

    @DeleteMapping("/employees/{empId}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "empId") Long employeeId)
         throws ResourceNotFoundException {
        service.deleteEmployee(employeeId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
    
	
	//internationalization  
	@GetMapping(path="/internationalized")  
	public String helloWorldInternationalized(Locale locale)  
	{  
	return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());  
	}  

}
