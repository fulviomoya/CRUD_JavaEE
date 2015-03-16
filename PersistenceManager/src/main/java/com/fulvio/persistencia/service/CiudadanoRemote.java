package com.fulvio.persistencia.service;

import java.util.List;

import javax.ejb.Remote;

import com.fulvio.persistencia.entities.Ciudadano;

@Remote
public interface CiudadanoRemote{
	boolean guardar (Ciudadano entity) throws Exception;
	boolean actualizar (Ciudadano entity);
	void eliminar (Ciudadano entity);
	Ciudadano bucarPorId (int Id);
	List<Ciudadano> listarTodos();
}
