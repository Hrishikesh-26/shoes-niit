
package com.niit.test;

import com.niit.model.Customer;
import com.niit.util.NewHibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class AddCustomerTest 
{
    public static void main(String[] args) 
    {
        SessionFactory factory=NewHibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        Transaction tx=tx=session.beginTransaction();;
        try
        {
            Customer customer=new Customer();
            customer.setCustomername("Mitesh");

            session.save(customer);
            tx.commit();
            System.out.println("Customer Data Saved Successfully!!!");
        }
        catch(Exception e)
        {
            tx.rollback();
            System.out.println(e);
        }
    }
}
