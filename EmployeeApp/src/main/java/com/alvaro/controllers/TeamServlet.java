package com.alvaro.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alvaro.models.Team;
import com.alvaro.persistencia.TeamManager;

public class TeamServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TeamServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			List<Team> listaEquipos = TeamManager.getInstance().dameChocolate();
			request.setAttribute("equipos", listaEquipos);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			request.setAttribute("mensaje_error", "Fallo catastrofico");
		}
		
		request.getRequestDispatcher("team.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
