package com.fulvio.logica;

import static org.junit.Assert.assertTrue;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.fulvio.persistencia.entities.Ciudad;
import com.fulvio.persistencia.entities.Ciudadano;
import com.fulvio.persistencia.entities.Ciudadano.Sexo;
import com.fulvio.persistencia.entities.Direccion;
import com.fulvio.persistencia.entities.Pais;
import com.fulvio.persistencia.entities.Sector;
import com.fulvio.persistencia.service.CiudadanoBean;

@RunWith(Arquillian.class)
public class PruebaPersistencia {
	CiudadanoBean cbr;

	public PruebaPersistencia() {
		cbr = new CiudadanoBean();
	}

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class).addClass(Direccion.class)
				.addClass(Ciudadano.class).addClass(Sector.class)
				.addClass(Ciudadano.class)
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Test
	public void insercionNuevoCiudadanoTest() throws Exception {
		Direccion dir = new Direccion();
		dir.setId(10);
		dir.setCalle("Calle i");
		dir.setCiudad(new Ciudad(2, "Santiago"));
		dir.setPais(new Pais(2, "RD"));
		dir.setSector(new Sector(3, "Los Mina"));

		Ciudadano c = new Ciudadano(11, "Fulvio", "Moya", Sexo.MASCULINO, dir,
				"type.asd12@aol.com");

		assertTrue(cbr.guardar(c));
	}

}
