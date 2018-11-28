package com.ricardo.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricardo.models.Employee;
import com.ricardo.models.Role;
import com.ricardo.persistencia.EmployeeManager;
import com.ricardo.persistencia.RoleManager;

@WebServlet("/rol")
public class CreateRoleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/create-rol.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id= request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String desc = request.getParameter("desc");

		try {
			
			int idInt= (id!=null && !id.equals(""))?Integer.parseInt(id):0;
			
			Role unRol = new Role(idInt,nombre,desc);
			if(idInt<=0) {
				int rid= RoleManager.getInstance().createRole(unRol);
				unRol.setId(rid);	
			}else {
				RoleManager.getInstance().updateRole(unRol);
			}
			
			request.setAttribute("newRol", unRol);
			request.setAttribute("mensaje", "Rol creado!");			
		} catch (Exception e) {
			System.out.println("Exception: " + e.getMessage());
			request.setAttribute("error", "Ooopss...");
		}

		doGet(request, response);
	}

}
