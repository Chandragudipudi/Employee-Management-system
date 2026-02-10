package com.service;



import com.Entity.USER;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class UserDao {


	private EntityManagerFactory factory=Persistence.createEntityManagerFactory("vamsi");
	public void addUser(USER user)
	{
		EntityManager em=factory.createEntityManager();
		EntityTransaction et =em.getTransaction();
		et.begin();
		em.persist(user);
		et.commit();
	}
	public USER getUserByUsername(String username)
	{
		EntityManager em=factory.createEntityManager();
		TypedQuery<USER> query=em.createQuery("from User u where u.username = :username",USER.class);
		query.setParameter("username", username);
		USER user=null;
		try
		{
			user=query.getSingleResult();
			
		}
		catch(NoResultException e)
		{
			System.out.println("Nouser found"+username);
		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		em.close();
		
		return user;
	}
	public boolean isUserExist(String username) {
        try {
            getUserByUsername(username);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
	}


