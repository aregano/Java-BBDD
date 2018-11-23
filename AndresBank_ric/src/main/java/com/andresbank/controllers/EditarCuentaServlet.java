package com.andresbank.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.andresbank.models.Cuenta;
import com.andresbank.dao.CuentaDAO;
import com.andresbank.dao.CuentasDAO;

public class EditarCuentaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditarCuentaServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cid = (String) request.getParameter("cid");
		int cidint = Integer.parseInt(cid); 
		
		try {
			Cuenta cuenta = CuentaDAO.getInstance().getCuentaByCid(cidint);
			request.setAttribute("editarcuenta", cuenta);
			request.getRequestDispatcher("./editarcuenta.jsp").forward(request, response);

		} catch (Exception e) {
			System.out.println("Exception:"+e.getMessage());
			request.setAttribute("mensaje_error", "Error, consulta al Maestro Pita");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	if (request.getSession().getAttribute("dni") !=null) {
		
		try {
			String nombrerecibido = request.getParameter("nombre");
			String saldorecibido = request.getParameter("saldo");
			String numerorecibido = request.getParameter("numero");
			String cid = (String) request.getParameter("cid");
			int cidint = Integer.parseInt(cid); 
			double saldodbl = Double.parseDouble(saldorecibido);
		
			Cuenta cuentamod = new Cuenta(cidint, nombrerecibido, numerorecibido, saldodbl);
		
			boolean cuentaact = CuentaDAO.getInstance().editarCuenta(cuentamod);
		
			if(cuentaact) {
				response.sendRedirect("cuentas");
			}else {
				request.setAttribute("mensaje_error", "Revisa los campos");
			} 
			
		}catch (Exception e){
			System.out.println("Exception: "+e.getMessage());
			request.setAttribute("mensaje_error", "Ha ocurrido un error");
			doGet(request,response);
			}
	}else {
		request.getSession().invalidate();
		response.sendRedirect("login");
		
		}
	}
}


