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
 * Servlet implementation class Add
 */
@WebServlet("/Add")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    EmployeeDao emp=new EmployeeDao();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		double Salary=Double.parseDouble(request.getParameter("salary"));
		int age=Integer.parseInt(request.getParameter("age"));
		Employee e=new Employee();
		e.setName(name);
		e.setAge(age);
		e.setEmail(email);
		e.setSalary(Salary);
		emp.addEmployee(e);
		response.sendRedirect("Welcome.html");
		
}     
}