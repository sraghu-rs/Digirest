package com.digirest.db;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateLoader {
	
	public static SessionFactory factory;
	 
	public static SessionFactory loadHibernateSession(int schoolId) {
	      
	      try {
	    	  
	    	  if(schoolId==1)
	    	  {
	    		  factory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();	  
	    	  }
	    	  else
	    	  {
	    		  String hibernateConfigName="/resources/hibernate_"+ schoolId+ ".cfg.xml";
	    		  
	    		  factory = new Configuration().configure(hibernateConfigName).buildSessionFactory();
	    	  }
	         
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	      return factory;
	   }
	
	public static SessionFactory loadHibernateSession() {
	      
	      try {
	    	  
	    		  factory = new Configuration().configure("/resources/hibernate.cfg.xml").buildSessionFactory();	  
	         
	      } catch (Throwable ex) { 
	         System.err.println("Failed to create sessionFactory object." + ex);
	         throw new ExceptionInInitializerError(ex); 
	      }
	      return factory;
	   }

}
