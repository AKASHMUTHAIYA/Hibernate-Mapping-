package com.model;


import org.hibernate.SessionFactory;
//import org.hibernate.boot.Metadata;
//import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtill {
	//private static StandardServiceRegistry registry=null;
	private static SessionFactory sf;
      
	public static SessionFactory buildFactory() {		
			try {
				
		//	registry=new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
			// MetadataSources mds=new MetadataSources(registry);
			// Metadata md=mds.getMetadataBuilder().build();
			Configuration cfg=new Configuration();
		
			cfg.configure("hibernate.cfg.xml");
			ServiceRegistry sr= new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();	
			SessionFactory sf=cfg.buildSessionFactory(sr);
			return sf;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}
	public static SessionFactory getSesFactory()
	{
		if(sf==null) 
			sf=buildFactory();
		return sf;
	}
		
	}


