package com.service;



import com.Entity.USER;

public class Userservice {
	private UserDao us=new UserDao();
	public void registerUser(USER user)
	{
		us.addUser(user);
	}
	
public USER loginUser(String username,String password)
{
	USER user=us.getUserByUsername(username);
	if(user !=null && user.getPassword().equals(password))
	{
		
		return user;
		
	}
	return null;
}
}
