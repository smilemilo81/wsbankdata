package cn.bannuo.ws.cxf.dao;

import java.util.List;

import javax.jws.WebService;

import cn.bannuo.ws.cxf.model.Employee;

@WebService
public interface EmployeeManager {

	public void add(Employee employee);
	public List<Employee> query();
	
}
