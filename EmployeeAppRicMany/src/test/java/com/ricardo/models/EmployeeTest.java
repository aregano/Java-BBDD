package com.ricardo.models;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeTest {

	private static SessionFactory sf = null;

	@BeforeClass
	public static void createSessionFactory() {
		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	@Test
	public void testSession() {
		Session session = sf.openSession();

		assertNotNull(session);
	}

	@Test
	public void testInsert() {
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		String[] employeeData = { "Peter Oven", "Allan Norman" };
		String[] rolesData = { "Director", "Developer" };

		List<Role> roles = new ArrayList<Role>();
		for (String rol : rolesData) {
			roles.add(new Role(0, rol, "Una desc"));
		}

		for (String emp : employeeData) {
			Employee employee = new Employee(0, emp.split(" ")[0], emp.split(" ")[1]);

			employee.setRoles(roles);
			session.persist(employee);

			assertNotNull(employee);
		}

		t.commit();
		session.close();
	}

	@Test
	public void testSelect() {
		Session session = sf.openSession();

		List<Employee> employeeList = session.createQuery("FROM Employee").list();
		
		assertNotNull(employeeList);
	
		for (Employee employee : employeeList) {
			System.out.println("Roles para "+ employee.getNombre() + " -> "+employee.getRoles());
			assertNotNull(employee.getRoles());
		}

		session.close();
	}

	@Test
	public void testGet() {
		Session session = sf.openSession();

		Employee recE = session.get(Employee.class, 3);

		System.out.println("Empleado recibido:" + recE.getNombre());

		session.close();
	}

	@Test
	public void testLoad() {
		Session session = sf.openSession();

		List<Employee> empleados = session.createQuery("from Employee WHERE id>5", Employee.class).getResultList();

		for (Employee employee : empleados) {
			System.out.println("Empleados:" + employee.getId());
		}

		session.close();
	}

	@Test
	public void testDelete() {
		Session session = sf.openSession();

		Transaction t = session.beginTransaction();

		Employee unE = session.get(Employee.class, 3); // new Employee(3,"","");
		session.delete(unE);

		t.commit();
		session.close();
	}

	@Test
	public void testUpdate() {
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		Employee unE = session.load(Employee.class, 6);
		unE.setNombre("Nombre2 cambiado");

		session.update(unE);

		t.commit();
		session.close();
	}

}
