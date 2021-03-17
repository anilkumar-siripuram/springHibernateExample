package com.springmvc.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.Dao.EmployeeDao;
import com.springmvc.Model.Employee;
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeDao dao;

	public Employee findById(int id) {
		
		return dao.findByID(id);
	}

	public void saveEmployee(Employee employee) {
		
		dao.saveEmpolyee(employee);
		
	}

	public void updateEmployee(Employee employee) {
	Employee entity= dao.findByID(employee.getId());
	if(entity!=null) {
		entity.setName(employee.getName());
		entity.setJoiningDate(employee.getJoiningDate());
		entity.setSalary(employee.getSalary());
		entity.setSsn(employee.getSsn());
	}
		
	}

	public void deleteEmployeeBySsn(String ssn) {
		dao.deleteEmployee(ssn);
		
	}
	
	/*public Employee deleteEmployee(int id) {
		return dao.deleteEmployee(id);
	}*/

	public List<Employee> findAllEmployees() {
		return dao.findAllEmployees();

	}

	public Employee findEmployeeBySsn(String ssn) {
		return dao.findEmployeeBySsn(ssn);
	}

	public boolean isEmployeeSsnUnique(Integer id, String ssn) {
		 Employee employee = findEmployeeBySsn(ssn);
	     return ( employee == null || ((id != null) && (employee.getId() == id)));
	}

	@Override
	public List userLogin() {
		
		return dao.userLogin();
		
	}

}
