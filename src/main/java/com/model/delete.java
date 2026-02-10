package com.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Employee;
import com.service.EmployeeDao;

/**
 * Servlet implementation class delete
 */
@WebServlet("/delete")
public class delete extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id= Integer.parseInt(request.getParameter("id"));
		EmployeeDao em=new EmployeeDao();
		
		
		
	if(	em.delete(id))
	{
		response.sendRedirect("display");
	}
	else {
        response.getWriter().write("Employee not found."); // Handle case where employee wasn't found
    }
	
	}

}