
package com.niit.test;

import com.niit.model.Customer;
import com.niit.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestHQL 
{
    public static void displayCustomers()
    {
        SessionFactory factory=NewHibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        List<Customer> customers=session.createQuery("from com.niit.model.Customer").list();
        
        for (Customer customer : customers) 
        {
            System.out.println(customer.getCust_id());
            System.out.println(customer.getCustomername());
            System.out.println("");
        }
    }
    
    //Named Arguments
    public static void displayCustomerById1(int id)
    {
        SessionFactory factory=NewHibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        
        Query query=session.createQuery("from com.niit.model.Customer where cust_id = :c_id");
        query.setParameter("c_id", id);
        List<Customer> customers=query.list();
        
        for (Customer customer : customers) 
        {
            System.out.println(customer.getCust_id());
            System.out.println(customer.getCustomername());
            System.out.println("");
        }
    }
    
    //Positional Arguments
    public static void displayCustomerById2(int id)
    {
        SessionFactory factory=NewHibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        
        Query query=session.createQuery("from com.niit.model.Customer where cust_id = ?");
        query.setParameter(0, id);
        List<Customer> customers=query.list();
        
        for (Customer customer : customers) 
        {
            System.out.println(customer.getCust_id());
            System.out.println(customer.getCustomername());
            System.out.println("");
        }
    }
    
    public static void main(String[] args) 
    {
        //displayCustomers();
        //displayCustomerById1(2);
        displayCustomerById2(2);
    }
}
