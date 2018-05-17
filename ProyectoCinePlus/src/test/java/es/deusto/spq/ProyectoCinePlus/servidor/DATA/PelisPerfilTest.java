package es.deusto.spq.ProyectoCinePlus.servidor.DATA;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.BeforeClass;
import org.junit.Test;

public class PelisPerfilTest {
	
	static Logger logger = Logger.getLogger(PelisPerfilTest.class.getName());
	
	private static PelisPerfil pelisperfil1;
	private static PelisPerfil pelisperfil2;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		pelisperfil1 = new PelisPerfil("javi@gmail.com",1);
		pelisperfil2 = new PelisPerfil("mikel@gmail.com",3);
	}

	@Test
	public void comprobarDatosTest() {
		assertEquals("mikel@gmail.com",pelisperfil2.getEmail());
		assertEquals(3,pelisperfil2.getId_pelicula());
	}
	
	@Test
	public void setEmailTest() {
		pelisperfil1.setEmail("aritz@gmail.com");
		assertEquals("aritz@gmail.com", pelisperfil1.getEmail());
	}

}
