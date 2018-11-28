package com.alvaro.models;

import static org.junit.Assert.*;

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

//	@Test ESTO ES UN POCO CAOS
//	public void testInsert() {
//		Session session = sf.openSession();
//
//		Transaction t = session.beginTransaction();
//
//		Employee newE = new Employee(0, "Pepe", "Perez");
//		session.save(newE);
//
//		List<Role> roles = new ArrayList<Role>();
//		roles.add(new Role(0, "Manager", "Da por culo"));
//		roles.add(new Role(0, "Feminazi", "Da mucho por culo"));
//		roles.add(new Role(0, "Hombre Aliado", "La lacra de la humanidad"));
//
//		for (Role role : roles) {
//			role.setEmployee(newE);
//			session.save(role);
//		}
//
//		newE.setRoles(roles);

//		
//		int id = ((Integer)session.save(newE)).intValue();
//		System.out.println("el Id nuevo es: "+id);
//		
//		Employee newE2 = new Employee(0, "María", "Martinez");		
//		session.save(newE2);
//
//		t.commit();
//		session.close();
//	}

	@Test
	public void testGet() {
		Session session = sf.openSession();

		Employee recE = (Employee) session.get(Employee.class, 2);

		System.out.println("Empleado recibido: " + recE.getNombre());

		session.close();

	}

	@Test
	public void testLoad() {
		Session session = sf.openSession();

		List<Employee> empleados = session.createQuery("from Employee WHERE id>5", Employee.class).getResultList();

		for (Employee employee : empleados) {
			System.out.println("Empleado: " + employee.getId());
		}

		session.close();

	}

	@Test
	public void testDelete() {
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		Employee unE = new Employee(3, "", "");
//		Employee unE = session.get(Employee.class, 3);
		session.delete(unE);

		t.commit();
		session.close();

	}

	@Test
	public void testUpdate() {
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		Employee unE = session.load(Employee.class, 6);
		unE.setNombre("Mariluz");
		session.update(unE);

		t.commit();
		session.close();
	}

	@Test
	public void testInsertManyToMany() {
		Session session = sf.openSession();

		Transaction t = session.beginTransaction();

		String[] employeeData = { "Peter Oven", "Allan Norman" };
		String[] rolesdata = { "IT Project", "Networking Project" };
		List<Role> roles = new ArrayList<Role>();

		for (String rol : rolesdata) {
			roles.add(new Role(0, rol, "una desc"));
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
	public void testInsertManyToManyTeam() {
		Session session = sf.openSession();

		Transaction t = session.beginTransaction();
		
		List<Employee> miembros = session.createQuery("FROM Employee").list();
		
		Team unTeam = new Team(0, "Equipo A", miembros);
		session.save(unTeam);
		
		t.commit();
		session.close();
	}


//	    @Test
//	    public void givenSession_whenRead_thenReturnsMtoMdata() {
//	        @SuppressWarnings("unchecked")
//	        List<Employee> employeeList = session.createQuery("FROM Employee")
//	          .list();
//	  
//	        assertNotNull(employeeList);
//	  
//	        for(Employee employee : employeeList) {
//	            assertNotNull(employee.getProjects());
//	        }
//	    }
//	
}
