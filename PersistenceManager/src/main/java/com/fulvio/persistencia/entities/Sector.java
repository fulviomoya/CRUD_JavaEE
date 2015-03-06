package com.fulvio.persistencia.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Sector implements Serializable{
	@Id
	private int id;
	private int nombre;
	
	public Sector () {
		//
	}
	public Sector(int id, int nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDescripcion() {
		return nombre;
	}
	public void setDescripcion(int descripcion) {
		this.nombre = descripcion;
	}
}
