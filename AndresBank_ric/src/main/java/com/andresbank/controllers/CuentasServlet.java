package com.andresbank.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andresbank.dao.CuentasDAO;
import com.andresbank.ddbb.DDBB;

public class CuentasServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("dni") != null) {
//			request.getSession().getAttribute("dni") devuelve un objeto: Debo por tanto especificar de manera implicita que lo debo convertir a String.
//			este proceso se llama casting. 
			String dni = (String) request.getSession().getAttribute("dni");
			try {
				request.setAttribute("lista_cuentas", CuentasDAO.getInstance().getCuentasByDni(dni));

			} catch (Exception e) {
				System.out.println("Error");
				e.printStackTrace();
			}
			request.getRequestDispatcher("/cuentas.jsp").forward(request, response);
		} else {
			request.getSession().invalidate();
			response.sendRedirect("login");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
