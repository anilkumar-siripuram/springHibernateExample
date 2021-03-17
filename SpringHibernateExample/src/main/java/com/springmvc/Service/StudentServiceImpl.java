package com.springmvc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.Dao.StudentDao;
import com.springmvc.Model.Country;
import com.springmvc.Model.Student;

@Service("studentService")
@Transactional
public class StudentServiceImpl implements StudentService{

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public List<Country> findAllCountries() {
		
		return studentDao.findAllCountries();
	}

	@Override
	public void saveStudent(Student student) {
		
		studentDao.saveStudent(student);
	}

}
