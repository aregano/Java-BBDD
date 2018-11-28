package com.alvaro.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alvaro.models.Role;
import com.alvaro.persistencia.RoleManager;

public class RoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RoleServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/role.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		String nombrerecibido = request.getParameter("name");
		String descrecibida = request.getParameter("descripcion");
		
		try {
			
			int idInt= (id!=null && !id.equals(""))?Integer.parseInt(id):0;
			Role nuevorol = new Role(0, nombrerecibido, descrecibida);
			
			if(idInt<=0) {
				
			RoleManager.getInstance().createRole(nuevorol);
			request.setAttribute("mensaje", "se ha creado el rol");}
			else {
				
				RoleManager.getInstance().updateRole(nuevorol);
				request.setAttribute("mensaje", "se ha actualizado el rol");

			}
			
		}catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			request.setAttribute("mensaje", "La Base de Datos la ha liao");
			
			
		}
		
		doGet(request, response);

	}

}
