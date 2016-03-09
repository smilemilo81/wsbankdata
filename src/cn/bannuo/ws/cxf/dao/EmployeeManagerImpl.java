package cn.bannuo.ws.cxf.dao;

import java.util.ArrayList;
import java.util.List;

import cn.bannuo.ws.cxf.model.Employee;

public class EmployeeManagerImpl implements EmployeeManager {
	
	private List<Employee> employees = new ArrayList();
	
	@Override
	public void add(Employee employee) {
		employees.add(employee);
	}
	
	@Override
	public List<Employee> query() {
		return employees;
	}
}
