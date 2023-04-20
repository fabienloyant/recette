package com.projet_recette;

import javax.persistence.EntityManagerFactory;

public class Connection {

	private static Connection instance = null;
	
	private final EntityManagerFactory emf = HibernateUtil.getSessionFactory();
	
	//constructeur
	private Connection() {}
	
	
	/*************************************************************
	 * méthode pour se connecter
	 * Singleton permettant l'instance unique de la classe ConnectionParXml
	 * @return ConnectionParXm
	 ************************************************************/
	
	public static Connection getInstance() {
		//élaboration du singleton
		if (instance == null) {
			instance = new Connection();
		}
		
		return instance;
	}
	
	
	/***************************************************
	* méthode pour se déconnecter de la bdd
	 *************************************************/
	
	public void deconnection() {
		instance = null;
	}
	
	
	//getter ; méthode retournant le driver
	public EntityManagerFactory getEmf() {
		return emf;
	}

}