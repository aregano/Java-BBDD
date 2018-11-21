package com.andresbank.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andresbank.dao.ClienteDAO;
import com.andresbank.ddbb.DDBB;
import com.andresbank.models.Cliente;
import com.andresbank.models.Cuenta;

public class CuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CuentaServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cid = request.getParameter("cid");

		int cidint = Integer.parseInt(cid);

		try{
			Cuenta cuenta = DDBB.getInstance().getCuentaByCid(cidint);
		

		if (cuenta != null) {
			request.setAttribute("cuenta", cuenta);
			request.getRequestDispatcher("cuenta.jsp").forward(request, response);
		} else {
			request.setAttribute("mensaje_error", "La Cuenta no existe hulio");
			request.getRequestDispatcher("cuenta.jsp").forward(request, response);
			}
		} catch(Exception e) {
			System.out.println("Excepcion: "+e.getMessage());		
			request.setAttribute("mensaje_error", "Alguien la ha liado y no he sido yo");
			doGet(request, response);
			}


	}

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
