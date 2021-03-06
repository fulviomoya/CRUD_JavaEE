package com.fulvio.persistencia.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@SuppressWarnings("serial")
@Entity
public class Direccion implements Serializable{
	@Id 
	private int id;
	private int noCasa;
	private String calle;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Sector sector;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Ciudad ciudad;
	@OneToOne(cascade = CascadeType.PERSIST)
	private Pais pais;
	
	
	public int getNoCasa() {
		return noCasa;
	}
	public void setNoCasa(int noCasa) {
		this.noCasa = noCasa;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Sector getSector() {
		return sector;
	}
	public void setSector(Sector sector) {
		this.sector = sector;
	}
	public Ciudad getCiudad() {
		return ciudad;
	}
	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}
	public Pais getPais() {
		return pais;
	}
	public void setPais(Pais pais) {
		this.pais = pais;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
