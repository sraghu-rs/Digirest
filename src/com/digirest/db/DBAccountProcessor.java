package com.digirest.db;

import java.util.Date;


import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.digirest.bean.AccountBean;
import com.digirest.bean.AccountTransactionBean;
import com.digirest.bean.RequestAccountBean;


public class DBAccountProcessor {
	
	public String withdrawMoney(RequestAccountBean accBean)
	{
		 SessionFactory factory=HibernateLoader.loadHibernateSession();
	     Session session = factory.openSession();
	     Transaction tx = null;
	     AccountBean accountBean =new AccountBean();

	     
	      Long accNo=accBean.getAccount_number();
	      
	      double amount = accBean.getWithdraw_amount();
	      String retmsg="";
	      try {
	         tx = session.beginTransaction();
	         String hsql="from AccountBean where account_number="+accNo + " and owner_id=(select id from UsersBean where username='"+accBean.getUsername() + "')";
	         Query query=session.createQuery(hsql);
	         
	         
	         accountBean = (AccountBean)query.getSingleResult();
	         double currBalance=0;
	         int transaction_state_id=0;
	         int transaction_type_id=40;
	         
	         if(accountBean!=null)
	         {
	         currBalance=accountBean.getCurrent_balance();
	        if(currBalance<amount)
	        {
	        	retmsg= "In sufficient Balance. ";
	        	transaction_state_id=50;
	        }
	        else
	        {
	        	transaction_state_id=52;
	         currBalance=currBalance-amount;
	      // Update the database with new balance
	         accountBean.setCurrent_balance(currBalance);
	        session.update(accountBean);
	        retmsg= "Your payment is successful. ";
	        System.out.println("Updated account:"+accountBean.getAccount_number());
	        } 
	    
	        // Get the max no of ID from Transaction table
	        // Enter into Transaction table:
			
			
	         AccountTransactionBean actransbean= new AccountTransactionBean();
	         amount=amount * -1;
	         actransbean.setAmount(amount);
	         actransbean.setDescription("PetClinic: Online Payment");
	         actransbean.setRunning_balance(currBalance);
		     actransbean.setTransaction_date(new Date());			
	         //Generate RAndom number;
	         Double transaction_number = Math.random()* 100000;
	         actransbean.setTransaction_number(transaction_number.intValue());
	         System.out.println("Account no:"+accNo);
	         actransbean.setAccount_id(accountBean.getId());
	         actransbean.setTransaction_state_id(transaction_state_id);
	         actransbean.setTransaction_type_id(transaction_type_id);
			 actransbean.setTransaction_category_id(65);
	         session.save(actransbean);
	         System.out.println("Transaction Saved");
	         tx.commit();
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
