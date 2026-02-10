package com.service;

import java.util.List;

import com.Entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class EmployeeDao {
	 private EntityManagerFactory factory = Persistence.createEntityManagerFactory("vamsi");
	 EntityManager em=factory.createEntityManager();
	 EntityTransaction et =em.getTransaction();
	 public void addEmployee(Employee e)
	 {
		 
			et.begin();
			em.persist(e);
			et.commit();
	 }
	 public List<Employee> display()
	 {
		 Query query=em.createQuery("from Employee");
		 List<Employee> employees=query.getResultList();
		 return employees;
	 }
	/* public static void main(String []args)
	 {
		 EmployeeDao d=new EmployeeDao();
		List<Employee>emp= d.display();
		for(Employee em:emp)
		{
			System.out.println(em.getName());
		}*/
	 public  boolean delete(int id)
	 {
		Employee e1=em.find(Employee.class, id);
		if(e1!=null)
		{
			et.begin();
			em.remove(e1);
			et.commit();
			return true;
		}
		return false;
	 }
public boolean update(Employee employee)
{
	et.begin();
    Employee e = em.find(Employee.class, employee.getId());

    if (e != null) {
        
        if (employee.getAge() != 0) {
            e.setAge(employee.getAge());
        }
        if (employee.getEmail() != null ) {
            e.setEmail(employee.getEmail());
        }
        if (employee.getSalary() != 0) {
            e.setSalary(employee.getSalary());
        }
        if(employee.getName()!=null)
        {
        	e.setName(employee.getName());
        }
        em.merge(e);

        et.commit();
        return true;

    }
    return false;
}


}
	 

