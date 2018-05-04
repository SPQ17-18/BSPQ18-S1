package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;


public class PeliculaDAOTest {

	
	private static PeliculaDAO peliculaDAO;
	
	private Pelicula peli1;
	private Pelicula peli2;
	
	
	private List<Usuario> listUsuarios=new ArrayList<>();
	
	static Logger logger = Logger.getLogger(PeliculaDAOTest.class.getName());
    
	@BeforeClass
	public static void setUpClass() {
		peliculaDAO = new PeliculaDAO();
	}
	
	@Before
	public void setUp() throws Exception {
		logger.info("Almacenando peliculas");
		//peli1 = new Pelicula(1, "Cadena perpetua", 142, "vida de prisioneros", 1994, "Drama", 14,listUsuarios, "14");
		//peli2 = new Pelicula(2, "Alternativa", 140, "vida de prisioneros 2", 1995, "Suspense", 15,listUsuarios,"15");
		Pelicula  peli3 = new Pelicula(3, "Alien", 120, "el octavo pasagero", 1979, "Terror", 9,listUsuarios,"9");
		Pelicula  peli4 = new Pelicula(4, "Star Trek", 128, "el futuro comienza", 2009, "ciencia ficcion", 5,listUsuarios,"5");
		Pelicula  spq = new Pelicula(5, "Prueba", 0, "prueba", 2018, "SPQ", 10,listUsuarios,"10");
	    
	    peliculaDAO.storePelicula(peli3);
	    peliculaDAO.storePelicula(peli4);
	    peliculaDAO.storePelicula(spq);
	
	}
	
	@Test
	public void testStorePelicula() throws Exception {
		logger.info("testStorePelicula()");
		Pelicula alien3 = new Pelicula(6, "Alien 3", 120, "el regreso", 1979, "Terror", 9, listUsuarios, "9");

		peliculaDAO.storePelicula(alien3);
		Pelicula prueba2 = peliculaDAO.getPelicula("Alien 3");
		logger.info(prueba2.getNombre());
		assertEquals("Alien 3", prueba2.getNombre());
		assertEquals("Terror", prueba2.getCategoria());
		assertEquals("1979", prueba2.getAnyo());
		assertEquals("120", prueba2.getDuracion());
		//assertEquals(peli3, prueba2);
	}
	
	@Test
	public void getPeliculaTest() throws Exception{
		logger.info("getPeliculaTest()");
		Pelicula  startrek2 = new Pelicula(7, "Star Trek 2", 142, "La ira de khan", 1994, "ciencia ficcion", 14, listUsuarios, "14");
		peliculaDAO.storePelicula(startrek2);
		Pelicula prueba2 = peliculaDAO.getPelicula("Star Trek 2");
		 
		assertEquals(startrek2.getNombre(), prueba2.getNombre());
		 
	}
	
	@Test
	public void updateUsuarioTest() throws Exception{
		logger.info("updateUsuarioTest()");
		Pelicula prueba1 = new Pelicula (8, "Star Wars", 125, "Una nueva esperanza", 1970, "ciencia ficcion", 6,listUsuarios,"6");
		peliculaDAO.storePelicula(prueba1);
		
		Pelicula prueba2 = peliculaDAO.getPelicula("Star Wars");
		prueba2.setAnyo(1977);
		peliculaDAO.updatePelicula(prueba2);
		
		Pelicula prueba3 = peliculaDAO.getPelicula("Star Wars");
		assertEquals("1977",prueba3.getAnyo());
		//assertEquals(prueba2, prueba3);
	}
	
}
