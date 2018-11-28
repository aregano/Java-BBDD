package com.alvaro.persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.alvaro.models.Role;

public class RoleManager {

	private static RoleManager instancia = null;
	private static SessionFactory sf = null;

	public static RoleManager getInstance() throws Exception {
		if (instancia == null)
			instancia = new RoleManager();

		return instancia;
	}

	private RoleManager() throws Exception {
		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public int createRole(Role newR) throws Exception {
		Session session = sf.openSession();

		Transaction t = session.beginTransaction();
		
		

		int id = ((Integer) session.save(newR)).intValue();
		System.out.println("el Id nuevo es: " + id);

		t.commit();
		session.close();

		return id;
	}

	public void updateRole(Role newR) throws Exception {
		Session session = sf.openSession();

		Transaction t = session.beginTransaction();
		
		session.update(newR);

		t.commit();
		session.close();
	}
}
