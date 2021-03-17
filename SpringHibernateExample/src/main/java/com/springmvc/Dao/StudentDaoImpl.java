package com.springmvc.Dao;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.springmvc.Model.Country;

import com.springmvc.Model.Student;

@Repository("studentDao")
public class StudentDaoImpl extends AbstractDao<Integer, Student>  implements StudentDao{

	public void saveStudent(Student student) {
		// TODO Auto-generated method stub
		persist(student);
	}
	
	
	@SuppressWarnings("unchecked")
	public List<Country> findAllCountries() {
		Query query = getSession().createQuery("from country");
		return (List<Country>) query.list();
	}

}
