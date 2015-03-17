package com.fulvio.persistencia.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.fulvio.persistencia.entities.Ciudadano;

@Stateless
public class CiudadanoBean implements CiudadanoRemote, CiudadanoLocal{
	private EntityManager entityManager;
	private EntityManagerFactory emf;
	
	public CiudadanoBean() {
		emf = Persistence.createEntityManagerFactory("CRUD_JavaEE_PU");
		entityManager = emf.createEntityManager();
	}
	
	@Override
	public boolean guardar(Ciudadano entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		entityManager.getTransaction();
		return true;
	}

	@Override
	public boolean actualizar(Ciudadano entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
		return true;
	}

	@Override
	public void eliminar(Ciudadano entity) {
		entityManager.getTransaction().begin();
		entityManager.remove(entity);
		entityManager.getTransaction().commit();
	}

	@Override
	public Ciudadano bucarPorId(int id) {
		entityManager.find(Ciudadano.class, id);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ciudadano> listarTodos() {
		Query query = entityManager.createQuery("SELECT c FROM CIUDADANO c");
		return (List<Ciudadano>) query.getResultList();
	}
	
}
