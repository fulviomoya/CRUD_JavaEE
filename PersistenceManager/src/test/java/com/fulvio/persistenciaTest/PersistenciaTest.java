package com.fulvio.persistenciaTest;


import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.fulvio.persistencia.entities.Ciudadano;
import com.fulvio.persistencia.entities.Ciudadano.Sexo;
import com.fulvio.persistencia.entities.Direccion;
import com.fulvio.persistencia.service.CiudadanoEJBImpl;

public class PersistenciaTest {
	CiudadanoEJBImpl gdao = new CiudadanoEJBImpl();
	
	@Test
	public void insercionNuevoCiudadanoTest() {
		Direccion dir = new Direccion();
		dir.setCalle("Calle i#A");
		Ciudadano c = new Ciudadano("Wanny", "Belleta", Sexo.FEMENINO,dir, "wanny@test.net");
		assertTrue(gdao.guardar(c));
	}
}
