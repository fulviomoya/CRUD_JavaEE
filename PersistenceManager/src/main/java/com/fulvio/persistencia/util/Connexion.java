package com.fulvio.persistencia.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Connexion {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceManager");
	private EntityManager em;
	
	public Connexion() {
		 em = emf.createEntityManager();
		
	}
	
}
