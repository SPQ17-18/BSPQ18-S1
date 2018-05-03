package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;


public class PeliculaDAOTest {

	
	private static PeliculaDAO peliculaDAO;
	private Pelicula peli1;
	private Pelicula peli2;
	private Pelicula peli3;
	private Pelicula peli4;
	private Pelicula spq;
	
	@BeforeClass
	public static void setUpClass() {
		peliculaDAO = new PeliculaDAO();
	}
	
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
