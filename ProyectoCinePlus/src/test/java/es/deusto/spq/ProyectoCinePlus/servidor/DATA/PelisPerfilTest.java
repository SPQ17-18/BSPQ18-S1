package es.deusto.spq.ProyectoCinePlus.servidor.DATA;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class PelisPerfilTest {
	
	static Logger logger = Logger.getLogger(PelisPerfilTest.class.getName());
	
	private PelisPerfil pelisperfil1;
	private PelisPerfil pelisperfil2;


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}
	
	@Before
	public void setUpBefore() throws Exception{
		pelisperfil1 = new PelisPerfil("javi@gmail.com",1);
		pelisperfil2 = new PelisPerfil("mikel@gmail.com",3);
	}

	@Test
	public void comprobarDatosTest() {
		assertEquals("mikel@gmail.com",pelisperfil2.getEmail());
		assertEquals(3,pelisperfil2.getId_pelicula());
	}
	
	/**
	 * Test que comprueba que se hayan cambiado los mails de los propietarios
	 * del perfil en el que se encuentran de las peliculas
	 */
	@Test
	public void setEmailTest() {		
		pelisperfil1.setEmail("aritz@gmail.com");
		pelisperfil2.setEmail("nuevomail@hotmail.com");
		assertEquals("aritz@gmail.com", pelisperfil1.getEmail());
		assertEquals("nuevomail@hotmail.com", pelisperfil2.getEmail());
	}

}
