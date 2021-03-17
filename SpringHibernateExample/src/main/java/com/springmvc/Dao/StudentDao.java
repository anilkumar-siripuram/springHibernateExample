package com.springmvc.Dao;

import java.util.List;

import com.springmvc.Model.Country;
import com.springmvc.Model.Student;

public interface StudentDao {

	public List<Country> findAllCountries();
	
	public void saveStudent(Student student);
	
	
}
