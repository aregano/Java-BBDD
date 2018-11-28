package com.ricardo.persistencia;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ricardo.models.Role;

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

	public int createRole(Role unRol) throws Exception {
		if(unRol==null) return 0;
		
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		int id = ((Integer) session.save(unRol)).intValue();

		t.commit();
		session.close();

		return id;
	}

	public void updateRole(Role unRol) {
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();

		session.update(unRol);

		t.commit();
		session.close();

		
	}

}
