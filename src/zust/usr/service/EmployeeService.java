package zust.usr.service;

import java.util.List;

import zust.usr.dao.EmployeeDao;
import zust.usr.entities.Employee;

public class EmployeeService {

	private EmployeeDao employeeDao;
	
	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	public List<Employee> getAll() {
		return employeeDao.showAll();
	}
	
	public int delete(int id) {
		return employeeDao.delete(id);
	}
	
}
