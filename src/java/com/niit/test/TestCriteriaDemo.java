
package com.niit.test;

import com.niit.model.Customer;
import com.niit.util.NewHibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

public class TestCriteriaDemo 
{
    public static void equalToMethod()
    {
        SessionFactory factory=NewHibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        Criteria ctx=session.createCriteria(Customer.class);
        
        List<Customer> customers=ctx.add(Restrictions.eq("cust_id", 1)).list();
        
        for (Customer customer : customers) 
        {
            System.out.println("Customer Id: "+customer.getCust_id());
            System.out.println("Customer Name: "+customer.getCustomername());
            System.out.println("");
        }
    }
    
    public static void greaterThan()
    {
        SessionFactory factory=NewHibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        Criteria ctx=session.createCriteria(Customer.class);
        
        List<Customer> customers=ctx.add(Restrictions.gt("cust_id", 1)).list();
        
        for (Customer customer : customers) 
        {
            System.out.println("Customer Id: "+customer.getCust_id());
            System.out.println("Customer Name: "+customer.getCustomername());
            System.out.println("");
        }
    }
    
    public static void lessThan()
    {
        SessionFactory factory=NewHibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        Criteria ctx=session.createCriteria(Customer.class);
        
        List<Customer> customers=ctx.add(Restrictions.lt("cust_id", 1)).list();
        
        for (Customer customer : customers) 
        {
            System.out.println("Customer Id: "+customer.getCust_id());
            System.out.println("Customer Name: "+customer.getCustomername());
            System.out.println("");
        }
    }
    
    
    public static void greaterThanEqualTo()
    {
        SessionFactory factory=NewHibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        Criteria ctx=session.createCriteria(Customer.class);
        
        List<Customer> customers=ctx.add(Restrictions.ge("cust_id", 1)).list();
        
        for (Customer customer : customers) 
        {
            System.out.println("Customer Id: "+customer.getCust_id());
            System.out.println("Customer Name: "+customer.getCustomername());
            System.out.println("");
        }
    }
    
    public static void lessThanEqualTo()
    {
        SessionFactory factory=NewHibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        Criteria ctx=session.createCriteria(Customer.class);
        
        List<Customer> customers=ctx.add(Restrictions.le("cust_id", 1)).list();
        
        for (Customer customer : customers) 
        {
            System.out.println("Customer Id: "+customer.getCust_id());
            System.out.println("Customer Name: "+customer.getCustomername());
            System.out.println("");
        }
    }
    
    public static void notEqualTo()
    {
        SessionFactory factory=NewHibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        Criteria ctx=session.createCriteria(Customer.class);
        
        List<Customer> customers=ctx.add(Restrictions.ne("cust_id", 1)).list();
        
        for (Customer customer : customers) 
        {
            System.out.println("Customer Id: "+customer.getCust_id());
            System.out.println("Customer Name: "+customer.getCustomername());
            System.out.println("");
        }
    }
    
    //Case insensitive
    public static void ilikeMethod()
    {
        SessionFactory factory=NewHibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        Criteria ctx=session.createCriteria(Customer.class);
        
        List<Customer> customers=ctx.add(Restrictions.ilike("customername", "%A%")).list();
        
        for (Customer customer : customers) 
        {
            System.out.println("Customer Id: "+customer.getCust_id());
            System.out.println("Customer Name: "+customer.getCustomername());
            System.out.println("");
        }
    }
    
    
    //Case Sensitive
    public static void likeMethod()
    {
        SessionFactory factory=NewHibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        Criteria ctx=session.createCriteria(Customer.class);
        
        List<Customer> customers=ctx.add(Restrictions.like("customername", "%A%")).list();
        
        for (Customer customer : customers) 
        {
            System.out.println("Customer Id: "+customer.getCust_id());
            System.out.println("Customer Name: "+customer.getCustomername());
            System.out.println("");
        }
    }
    
    public static void andMethod()
    {
        SessionFactory factory=NewHibernateUtil.getSessionFactory();
        Session session=factory.openSession();
        Criteria ctx=session.createCriteria(Customer.class);
        
        Criterion ct1=Restrictions.gt("cust_id", 1);
        Criterion ct2=Restrictions.ilike("customername", "%p%");
        Criterion ct3=Restrictions.and(ct1,ct2);
        
        List<Customer> customers=ctx.add(ct3).list();
        
        for (Customer customer : customers) 
        {
            System.out.println("Customer id: "+customer.getCust_id());
            System.out.println("Customer name: "+customer.getCustomername());
            System.out.println();
        }
        
    }
    
    public static void main(String[] args) 
    {
        //equalToMethod();
        //greaterThan();
        //lessThan();
        //greaterThanEqualTo();
        //lessThanEqualTo();
        //notEqualTo();
        //likeMethod();
        //ilikeMethod();
        andMethod();
    }
}
