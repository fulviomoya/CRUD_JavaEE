package com.fulvio.persistencia.service;

import java.util.List;

import javax.ejb.Remote;

import com.fulvio.persistencia.entities.Ciudadano;

@Remote
public interface CiudadanoBeanRemote{
	boolean guardar (Ciudadano entity);
	boolean actualizar (Ciudadano entity);
	void eliminar (Ciudadano entity);
	Ciudadano bucarPorId (int Id);
	List<Ciudadano> listarTodos();
}
