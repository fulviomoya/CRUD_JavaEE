package com.fulvio.persistencia.service;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface GenericoDAO<E>{
	boolean guardar (E entity);
	boolean actualizar (E entity);
	void eliminar (E entity);
	E bucarPorId (int Id);
	List<E> listarTodos();
}
