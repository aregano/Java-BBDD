package com.alvaro.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alvaro.models.Employee;
import com.alvaro.persistencia.EmployeeManager;

public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EmployeeServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("id");

		int idint = Integer.parseInt(id);

		try {
			Employee empleado = EmployeeManager.getInstance().getEmployee(idint);

			if (empleado != null) {
				request.setAttribute("empleado", empleado);
				request.getRequestDispatcher("employee.jsp").forward(request, response);
			} else {
				request.setAttribute("mensaje_error", "El empleado no existe hulio");
				request.getRequestDispatcher("employee.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			request.setAttribute("mensaje_error", "La Base de Datos la ha liao");
			doGet(request, response);
		}

		request.getRequestDispatcher("employee.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
