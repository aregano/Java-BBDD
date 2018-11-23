package com.andresbank.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andresbank.dao.CuentaDAO;
import com.andresbank.models.Cuenta;

public class BorrarCuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BorrarCuentaServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		

		if (request.getSession().getAttribute("dni") != null) {
			
			String cid = (String) request.getParameter("cid");
			int cidint = Integer.parseInt(cid);
			
			try {
				Cuenta borrarcuenta = CuentaDAO.getInstance().getCuentaByCid(cidint);
				boolean eliminarcuenta = CuentaDAO.getInstance().borrarCuenta(borrarcuenta);
				
				if (eliminarcuenta) {
					response.sendRedirect("cuentas");
				} else {
					request.getRequestDispatcher("./errorborrar.jsp").forward(request, response);
				}
			} catch (Exception e) {
				System.out.println("Exception: " + e.getMessage());
				request.getRequestDispatcher("./errorborrar.jsp").forward(request, response);
			}

		} else {
			request.getRequestDispatcher("./errorborrar.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}
}