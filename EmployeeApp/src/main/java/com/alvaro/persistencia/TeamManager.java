package com.alvaro.persistencia;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.alvaro.models.Employee;
import com.alvaro.models.Team;

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

	public int createTeam(Team newT) throws Exception {
		Session session = sf.openSession();

		Transaction t = session.beginTransaction();

		int tid = ((Integer) session.save(newT)).intValue();
		System.out.println("el Id nuevo es: " + tid);

		t.commit();
		session.close();

		return tid;
	}

	public Team getTeam(int tid) throws Exception {
		Session session = sf.openSession();

		Team recT = (Team) session.get(Team.class, tid);

		session.close();
		
		return recT;

	}
	
	public List<Team> dameChocolate() throws Exception{
		List<Team> equipos=null;
		Session session = sf.openSession();
		equipos = session.createQuery("FROM Team").list();
		session.close();
		return equipos;
	}

}
