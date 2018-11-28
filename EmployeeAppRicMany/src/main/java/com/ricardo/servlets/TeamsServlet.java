package com.ricardo.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricardo.models.Team;
import com.ricardo.persistencia.TeamManager;

@WebServlet("/teams")
public class TeamsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			List<Team> listaEquipos = TeamManager.getInstance().dameTodosLosEquipos();

			request.setAttribute("equipos", listaEquipos);
		} catch (Exception e) {
			System.out.println("Exception:"+e.getMessage());
			request.setAttribute("error", "Oooopss....");
		}

		request.getRequestDispatcher("/teams.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
