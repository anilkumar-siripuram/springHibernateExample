package com.springmvc.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springmvc.Model.Employee;


public interface EmployeeService {


	Employee findById(int id);
	
	void saveEmployee(Employee employee);
	
	void updateEmployee(Employee employee);
	
	void deleteEmployeeBySsn(String ssn);
	
	List<Employee> findAllEmployees(); 
	
	Employee findEmployeeBySsn(String ssn);

	boolean isEmployeeSsnUnique(Integer id, String ssn);
	
	List userLogin();
}
