package com.doganilbars.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import com.doganilbars.model.Employee;
import com.doganilbars.utility.EntityManagerUtility;

public class EmployeeDAOImpl implements IEmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAOImpl() {
		EntityManagerFactory entityManagerFactory = EntityManagerUtility.getEntityManagerFactory();
		entityManager = entityManagerFactory.createEntityManager();
	}

	@Override
	public Employee insertEmployee(Employee employee) {
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();

		return employee;
	}

	@Override
	public Employee findEmployee(int id) {
		return entityManager.find(Employee.class, id);
	}

	@Override
	public List<Employee> findAllEmployees() {
		TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e", Employee.class);
		return query.getResultList();
	}

	@Override
	public void removeEmployee(int id) {
		Employee employee = findEmployee(id);

		if (employee != null) {
			entityManager.getTransaction().begin();
			entityManager.remove(employee);
			entityManager.getTransaction().commit();
		}

	}

}
