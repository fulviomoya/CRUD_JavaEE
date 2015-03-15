package com.fulvio.persistencia.service;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.fulvio.persistencia.entities.Ciudadano;

@Stateless
@LocalBean
public class GenericoDAOImpl implements GenericoDAO<Ciudadano>{
	@PersistenceContext(unitName="PersistenceManager")
	private EntityManager em;
	
	protected Ciudadano entityClass;
	public GenericoDAOImpl() {
		 /*ParameterizedType genericSuperClass = (ParameterizedType) getClass().getGenericSuperclass();
		 this.entityClass= (Ciudadano) genericSuperClass.getActualTypeArguments()[1];  */
	}

	@Override
	public boolean guardar(Ciudadano entity) {
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public boolean actualizar(Ciudadano entity) {
		em.getTransaction().begin();
		em.merge(entity);
		em.getTransaction().commit();
		return true;
	}

	@Override
	public void eliminar(Ciudadano entity) {
		em.getTransaction().begin();
		em.remove(entity);
		em.getTransaction().commit();
	}

	@Override
	public Ciudadano bucarPorId(int id) {
		em.find(Ciudadano.class, id);
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ciudadano> listarTodos() {
		Query query = em.createQuery("SELECT c FROM CIUDADANO c");
		return (List<Ciudadano>) query.getResultList();
	}
	
}
