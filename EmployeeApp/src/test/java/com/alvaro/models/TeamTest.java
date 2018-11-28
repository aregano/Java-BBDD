package com.alvaro.models;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.BeforeClass;
import org.junit.Test;

public class TeamTest {
	
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
	public void testInsertManyToManyTeam() {
		Session session = sf.openSession();

		Transaction t = session.beginTransaction();
		
		List<Employee> miembros = session.createQuery("FROM Employee").list();
		
		Team unTeam = new Team(0, "Equipo A", miembros);
		session.save(unTeam);
		
		t.commit();
		session.close();
	}
	
}
