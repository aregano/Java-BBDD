package com.alvaro.persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.alvaro.models.Employee;

public class EmployeeManager {

	private static EmployeeManager instancia = null;
	private static SessionFactory sf = null;

	public static EmployeeManager getInstance() throws Exception {
		if (instancia == null)
			instancia = new EmployeeManager();

		return instancia;
	}

	private EmployeeManager() throws Exception {
		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public int createEmployee(Employee newE) throws Exception {
		Session session = sf.openSession();

		Transaction t = session.beginTransaction();

		int id = ((Integer) session.save(newE)).intValue();
		System.out.println("el Id nuevo es: " + id);

		t.commit();
		session.close();

		return id;
	}

	public Employee getEmployee(int id) throws Exception {
		Session session = sf.openSession();

		Employee recE = (Employee) session.get(Employee.class, id);

		session.close();
		
		return recE;

	}

}
