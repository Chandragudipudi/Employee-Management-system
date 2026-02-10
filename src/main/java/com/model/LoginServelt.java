package com.model;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.service.Userservice;
import com.Entity.USER;

/**
 * Servlet implementation class LoginServelt
 */
@WebServlet("/LoginServelt")
public class LoginServelt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 private Userservice userservice =new Userservice();
		

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		 String password = request.getParameter("password");
		
		 
		USER user= userservice.loginUser(username, password);
		
		
		if(user !=null)
		{
			HttpSession session=request.getSession();
			session.setAttribute("loggedInUser", user);
			
			response.sendRedirect("dash");
			
		}
		else {
            // Invalid credentials, show error message
            request.setAttribute("error", "Invalid username or password");
            RequestDispatcher dispatcher = request.getRequestDispatcher("Login.html");
            dispatcher.forward(request, response);
        }
		
	}

}
