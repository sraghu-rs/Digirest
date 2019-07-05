package com.digirest.db;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.digirest.bean.AccountBean;
import com.digirest.bean.RequestAccountBean;


public class DBAccountProcessor {
	
	public AccountBean withdrawMoney(RequestAccountBean accBean)
	{
		 SessionFactory factory=HibernateLoader.loadHibernateSession();
	     Session session = factory.openSession();
	     Transaction tx = null;
	     AccountBean accountBean =new AccountBean();

	     
	      int accNo=accBean.getAccount_number();
	      double amount = accBean.getWithdraw_amount();
	      try {
	         tx = session.beginTransaction();
	         String hsql="from AccountBean where account_number="+accNo + " and owner_id=(select id from UsersBean where username='"+accBean.getUsername() + "')";
	         Query query=session.createQuery(hsql);
	         
	         accountBean = (AccountBean)query.getSingleResult();
	     
	         double currBalance=accountBean.getCurrent_balance();
	         currBalance=currBalance-amount;
	      // Update the database with new balance
	         accountBean.setCurrent_balance(currBalance);
	        session.update(accountBean);
	     System.out.println("Updated account:"+accountBean.getAccount_number());
	        tx.commit();
	        
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return accountBean;
	}

}
