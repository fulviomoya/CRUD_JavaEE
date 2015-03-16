package com.fulvio.persistencia.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity
public class Sector implements Serializable{
	@Id
	private int id;
	private String nombre;
	
	public Sector () {
		//
	}
	public Sector(int id, String nombre) {
		this.id = id;
		this.nombre = nombre;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescripcion() {
		return nombre;
	}
	public void setDescripcion(String descripcion) {
		this.nombre = descripcion;
	}
}
