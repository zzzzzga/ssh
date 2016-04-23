package zust.usr.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import zust.usr.entities.Employee;

public class EmployeeDao {
	
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public List<Employee> showAll() {
		String hql = "FROM Employee as e LEFT OUTER JOIN FETCH e.department";
		return getSession().createQuery(hql).list();
	}
	
	public int delete(int id) {
		String hql = "DELETE FROM Employee e WHERE e.id = ?";
		return getSession().createQuery(hql).setInteger(0, id).executeUpdate();
	}

}
