package com.doganilbars.service;

import java.util.List;

import com.doganilbars.dao.EmployeeDAOImpl;
import com.doganilbars.model.Employee;

public class EmployeeServiceImpl implements IEmployeeService {

	private EmployeeDAOImpl employeeDAOImpl;

	public EmployeeServiceImpl() {
		employeeDAOImpl = new EmployeeDAOImpl();
	}

	@Override
	public Employee insertEmployee(Employee employee) {

		return employeeDAOImpl.insertEmployee(employee);
	}

	@Override
	public Employee findEmployee(int id) {

		return employeeDAOImpl.findEmployee(id);
	}

	@Override
	public List<Employee> findAllEmployees() {

		return employeeDAOImpl.findAllEmployees();
	}

	@Override
	public void removeEmployee(int id) {
		employeeDAOImpl.removeEmployee(id);

	}

}
