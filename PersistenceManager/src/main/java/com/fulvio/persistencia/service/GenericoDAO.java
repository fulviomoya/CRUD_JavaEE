package com.fulvio.persistencia.service;

import java.util.List;

public interface GenericoDAO<E>{
	boolean guardar (E entity);
	boolean actualizar (E entity);
	void eliminar (E entity);
	E bucarPorId (int Id);
	List<E> listarTodos();
}
