package com.fulvio.persistencia.service;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public abstract class GenericoDAOImpl implements GenericoDAO<Object>{
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceManager");
	private EntityManager em;
	protected Class<?> entityClass;
	
	public GenericoDAOImpl() {
		 em = emf.createEntityManager();
		 ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
		 this.entityClass= (Class<?>) genericSuperClass.getActualTypeArguments()[1];  
	}

	@Override
	public boolean guardar(Object entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public boolean actualizar(Object entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public void eliminar(Object entity) {
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}

	@Override
	public Object bucarPorId(int id) {
		em.find(entityClass, id);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object> listarTodos() {
		Query query = em.createQuery("SELECT c FROM CIUDADANO c");
		return (List<Object>) query.getResultList();
	}
	
}
