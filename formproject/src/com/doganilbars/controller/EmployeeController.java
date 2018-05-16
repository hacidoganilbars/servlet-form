package com.doganilbars.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doganilbars.model.Employee;
import com.doganilbars.service.EmployeeServiceImpl;
import com.doganilbars.service.IEmployeeService;

@WebServlet("/employeeController")
public class EmployeeController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String employeeName = req.getParameter("name");
		String employeeSurname = req.getParameter("surname");
		int employeeSalary = Integer.parseInt(req.getParameter("salary"));

		IEmployeeService employeeService = new EmployeeServiceImpl();
		Employee employee = new Employee(employeeName, employeeSurname, employeeSalary);
		employeeService.insertEmployee(employee);

		List<Employee> allEmployees = employeeService.findAllEmployees();
		req.setAttribute("allEmployees", allEmployees);

		RequestDispatcher view = req.getRequestDispatcher("employee.jsp");
		view.forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
		int employeeId = Integer.parseInt(req.getParameter("id"));
		employeeService.removeEmployee(employeeId);

		List<Employee> allEmployees = employeeService.findAllEmployees();
		req.setAttribute("allEmployees", allEmployees);

		RequestDispatcher view = req.getRequestDispatcher("employee.jsp");
		view.forward(req, resp);

	}
}
