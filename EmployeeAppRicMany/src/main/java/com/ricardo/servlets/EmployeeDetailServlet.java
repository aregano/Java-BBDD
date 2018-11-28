package com.ricardo.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ricardo.models.Employee;
import com.ricardo.persistencia.EmployeeManager;

@WebServlet("/empleado")
public class EmployeeDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		
		try {
			int idInt=Integer.parseInt(id);
			
			Employee empl=EmployeeManager.getInstance().getEmployee(idInt);
			
			request.setAttribute("unE", empl);
			
		}catch (Exception e) {
			System.out.println("Exception: "+ e.getMessage());
			request.setAttribute("error", "Ooopss...");
		}
		
		request.getRequestDispatcher("/employee-detail.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
