package com.ricardo.persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.ricardo.models.Employee;
import com.ricardo.models.Team;

public class TeamManager {

	private static TeamManager instancia = null;
	private static SessionFactory sf = null;

	public static TeamManager getInstance() throws Exception {
		if (instancia == null)
			instancia = new TeamManager();

		return instancia;
	}

	private TeamManager() throws Exception {
		sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public List<Team> dameTodosLosEquipos() throws Exception {
		List<Team> equipos=null;
		
		Session session = sf.openSession();
		
		equipos = session.createQuery("FROM Team").list();
		
//		session.close();
		return equipos;
	}


}
