package com.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Entity.Employee;
import com.service.EmployeeDao;

/**
 * Servlet implementation class display
 */
@WebServlet("/display")
public class display extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EmployeeDao emp=new EmployeeDao();
		List<Employee>em=emp.display();
		  response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<html><head><title>Employee List</title>");
	        out.println("<link rel='stylesheet' type='text/css' href='css/display.css'>");
	        out.println("</head><body>");
	        out.println("<h1>Employee List</h1>");
	        out.println("<table><tr><th>ID</th><th>Name</th><th>Age</th><th>Salary</th><th>Email</th></tr>");
	        for(Employee e1:em)
	        {
	        	 out.println("<tr>");
	             out.println("<td>" + e1.getId() + "</td>");
	             out.println("<td>" + e1.getName() + "</td>");
	             out.println("<td>" + e1.getAge() + "</td>");
	             out.println("<td>" + e1.getSalary() + "</td>");
	             out.println("<td>" + e1.getEmail() + "</td>");
	             out.println("</tr>");
	        }
	        out.println("</table>");

	        out.println("</body></html>");
	        out.close();
	}
	

	
}
