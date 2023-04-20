package com.projet_recette;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	//définit notre factory
	public static SessionFactory getSessionFactory() {
		
		if (sessionFactory == null) {
			
			try {
				
				//configurer notre connection à la BDD
				Configuration configuration = new Configuration();
				
				//définition des properties (plus de xml ici donc on les fait là)
				Properties dbSettings = new Properties ();
				dbSettings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver"); //le driver
				dbSettings.put(Environment.URL, "");
				dbSettings.put(Environment.USER, "");
				dbSettings.put(Environment.PASS, "");
				dbSettings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
				dbSettings.put(Environment.SHOW_SQL, "true");
				
				//configuration de hibernate
				configuration.setProperties(dbSettings);
				configuration.setProperty("hibernate.hbm2ddl.auto", "update");
				
				//ajout des classes a mapper
//				configuration.addAnnotatedClass(AdresseEntity.class);
				
				//création du Serviceregistry
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties())
						.build();
				
				//création de la sessionFactory
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return sessionFactory;
	}
	
}