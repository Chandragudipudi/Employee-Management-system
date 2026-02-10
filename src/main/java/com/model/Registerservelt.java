package com.model;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAo.UserDao;
import com.DAo.UserService;
import com.Entity.User;


@WebServlet("/RegisterServlet")
public class Registerservelt extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
  

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        UserDao usedao=new UserDao();
       if(!usedao.isUserExist(username))
       {
    	   
        User user=new User();
        
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        System.out.println(user);
        UserService use=new UserService();
       use.registerUser(user);
       response.sendRedirect("Login.html");
       }
       else
       {
    	   response.getWriter().println("User Already exists");
       }
}
}

