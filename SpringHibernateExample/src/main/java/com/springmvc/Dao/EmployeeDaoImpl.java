package com.springmvc.Dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.springmvc.Model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl extends AbstractDao<Integer, Employee> implements EmployeeDao {
	@SuppressWarnings("unchecked")
	public List<Employee> findAllEmployees() {
		Query query = getSession().createQuery("from Employee where isDeleteInd = :code");
		query.setParameter("code", "Y");
		return (List<Employee>) query.list();
	}

	public Employee findEmployeeBySsn(String ssn) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("ssn", ssn));
		return (Employee) criteria.uniqueResult();
	}

	public Employee findByID(int id) {
		return getByKey(id);
	}

	public void saveEmpolyee(Employee employee) {
		
		persist(employee);
		
	}
	
	/*public Employee deleteEmployee(int id) {
		return getByKey(id);
	}
*/

	public void deleteEmployee(String ssn) {
		Query query = getSession().createSQLQuery("update Employee set isDeleteInd = :isDeleteInd"+" where ssn = :ssn");
		query.setString("isDeleteInd", "N");
		query.setString("ssn", ssn);
		query.executeUpdate();
		
	}

	@Override
	public List userLogin() {
		
		Query query = (Query) getSession().createQuery("select username,password from users");
		return (List) query.list();
		
	}

	/*public Employee findEmployeeBySsn(String ssn) {
		Criteria criteria = createEntityCriteria(); where ssn = :ssn"
		return (Employee) criteria.list();
	}*/
}
