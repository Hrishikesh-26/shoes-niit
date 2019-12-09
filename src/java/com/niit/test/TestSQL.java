package com.niit.test;

import com.niit.model.Customer;
import com.niit.util.NewHibernateUtil;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestSQL 
{
    public static void displayCustomers()
    {
        SessionFactory factory=NewHibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        
        List<Customer> customers=session.createSQLQuery("select * from customers").addEntity(Customer.class).list();
        
        for (Customer customer : customers) 
        {
            System.out.println("Customer Id: "+customer.getCust_id());
            System.out.println("Customer name: "+customer.getCustomername());
            System.out.println();
        }
    }
    
    //Positional Arguments
    public static void displayCustomerById1(int id)
    {
        SessionFactory factory=NewHibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        
        SQLQuery query=session.createSQLQuery("select * from customers where cust_id=?").addEntity(Customer.class);
        query.setParameter(0, id);
        List<Customer> customers=query.list();
        
        for (Customer customer : customers) 
        {
            System.out.println("Customer Id: "+customer.getCust_id());
            System.out.println("Customer name: "+customer.getCustomername());
            System.out.println();
        }
    }
    
    //Named Arguments
    public static void displayCustomerById2(int id)
    {
        SessionFactory factory=NewHibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        
        SQLQuery query=session.createSQLQuery("select * from customers where cust_id= :id").addEntity(Customer.class);
        query.setParameter("id", id);
        List<Customer> customers=query.list();
        
        for (Customer customer : customers) 
        {
            System.out.println("Customer Id: "+customer.getCust_id());
            System.out.println("Customer name: "+customer.getCustomername());
            System.out.println();
        }
    }
    
    public static void main(String[] args) 
    {
        //displayCustomers();
        //displayCustomerById1(1);
        displayCustomerById2(3);
    }
}
