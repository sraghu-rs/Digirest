package com.digirest.db;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.digirest.bean.AccountBean;
import com.digirest.bean.RequestAccountBean;


public class DBAccountProcessor {
	
	public String withdrawMoney(RequestAccountBean accBean)
	{
		 SessionFactory factory=HibernateLoader.loadHibernateSession();
	     Session session = factory.openSession();
	     Transaction tx = null;
	     AccountBean accountBean =new AccountBean();

	     
	      int accNo=accBean.getAccount_number();
	      double amount = accBean.getWithdraw_amount();
	      String retmsg="";
	      try {
	         tx = session.beginTransaction();
	         String hsql="from AccountBean where account_number="+accNo + " and owner_id=(select id from UsersBean where username='"+accBean.getUsername() + "')";
	         Query query=session.createQuery(hsql);
	         
	         
	         accountBean = (AccountBean)query.getSingleResult();
	      
	         if(accountBean!=null)
	         {
	     
	         double currBalance=accountBean.getCurrent_balance();
	        if(currBalance<amount)
	        {
	        	retmsg= "In sufficient Balance. ";
	        }
	        else
	        {
	         currBalance=currBalance-amount;
	      // Update the database with new balance
	         accountBean.setCurrent_balance(currBalance);
	        session.update(accountBean);
	        retmsg= "Your payment is successful. ";
	        System.out.println("Updated account:"+accountBean.getAccount_number());
	        tx.commit();
	        } 
	        } 
	         else
	         {
	        	 System.out.println("No Record Found.");
	        	 retmsg= "Wrong Credentials Provided. ";
	         }
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return retmsg;
	}

}
