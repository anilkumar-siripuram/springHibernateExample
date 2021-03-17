package com.springmvc.Dao;

import java.util.List;

import com.springmvc.Model.Employee;

public interface EmployeeDao {

	Employee findByID(int id);
	void saveEmpolyee(Employee employee);
	void deleteEmployee(String ssn);
	//Employee deleteEmployee(int id);
	List<Employee> findAllEmployees();
	Employee findEmployeeBySsn(String ssn);
	List userLogin();
}
