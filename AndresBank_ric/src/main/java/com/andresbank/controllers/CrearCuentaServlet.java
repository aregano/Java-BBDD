package com.andresbank.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andresbank.dao.ClienteDAO;
import com.andresbank.dao.CuentaDAO;
import com.andresbank.dao.CuentasDAO;
import com.andresbank.models.Cliente;
import com.andresbank.models.Cuenta;

public class CrearCuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CrearCuentaServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("dni") != null) {

			String dni = (String) request.getSession().getAttribute("dni");
			request.getRequestDispatcher("/crearcuenta.jsp").forward(request, response);
		} else {
			request.getSession().invalidate();
			response.sendRedirect("login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("dni") != null) {

			String nombrerecibido = request.getParameter("name");
			String saldorecibido = request.getParameter("saldo");
			String numerorecibido = request.getParameter("numero");

			try {
				double saldoDbl = Double.parseDouble(saldorecibido);
				String dnisess = (String) request.getSession().getAttribute("dni");

				Cuenta nuevaCuenta = new Cuenta(0, nombrerecibido, numerorecibido, saldoDbl);
				Cliente miCliente = ClienteDAO.getInstance().getUserByDNI(dnisess);
				
				int newCid = CuentaDAO.getInstance().crearCuenta(nuevaCuenta, miCliente);
				

				if (newCid > 0) {
					response.sendRedirect("cuentas");
				} else {
					request.setAttribute("mensaje_error", "Ooops, Error, la cuenta no se ha creado");
					doGet(request, response);
				}

			} catch (Exception e) {
				System.out.println("Exception:"+e.getMessage());
				request.setAttribute("mensaje_error", "OOps, Intentalo mas tarde");
				doGet(request, response);
			}

		}
	}
}
