package com.springmvc.Service;

import java.util.List;

import com.springmvc.Model.Country;
import com.springmvc.Model.Student;

public interface StudentService {

	public List<Country> findAllCountries();

	public void saveStudent(Student student);
	
}
