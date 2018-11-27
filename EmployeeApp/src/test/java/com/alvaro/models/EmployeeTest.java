package com.alvaro.models;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;

public class EmployeeTest {
	
	private static SessionFactory sf=null;
	
	@BeforeClass
	public static void createSessionFactory() {
		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}
	
	@Test
	public void testSession(){
		Session session = sf.openSession();
		
		assertNotNull(session);
	}
	
	@Test
	public void testInsert(){
		Session session = sf.openSession();
		
		Transaction t = session.beginTransaction();
		
		Employee newE = new Employee(0, "Pepe", "Perez");
		int id = ((Integer)session.save(newE)).intValue();
		System.out.println("el Id nuevo es: "+id);
		
		Employee newE2 = new Employee(0, "María", "Martinez");		
		session.save(newE2);
		
		t.commit();
		session.close();
	}
	
	@Test
	public void testGet() {
		Session session = sf.openSession();
		
		Employee recE = (Employee) session.get(Employee.class, 4);
		
		System.out.println("Empleado recibido: "+recE.getNombre());
		
		session.close();
		

	}
	
	@Test
	public void testLoad() {
		Session session = sf.openSession();

		List<Employee> empleados = session.createQuery("from Employee WHERE id>5", Employee.class).getResultList();
		
		for( Employee employee : empleados) {
		System.out.println("Empleado: "+employee.getId());}
		
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

}
