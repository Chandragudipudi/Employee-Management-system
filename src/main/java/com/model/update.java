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
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		double salary=Double.parseDouble(request.getParameter("salary"));
		int age=Integer.parseInt(request.getParameter("age"));
		Employee emp=new Employee();
		EmployeeDao em=new EmployeeDao();
		emp.setId(id);
		emp.setAge(age);
		emp.setName(name);
		emp.setEmail(email);
		emp.setSalary(salary);
         if(em.update(emp))
         {
        	 response.sendRedirect("display");
         }
         else
         {
        	 response.getWriter().write("Employee not updated.");
         }
		
	}
	

	
}
