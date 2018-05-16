package com.doganilbars.dao;

import java.util.List;

import com.doganilbars.model.Employee;

public interface IEmployeeDAO {
	
	public Employee insertEmployee(Employee employee);

	public Employee findEmployee(int id);

	public List<Employee> findAllEmployees();

	public void removeEmployee(int id);

}
