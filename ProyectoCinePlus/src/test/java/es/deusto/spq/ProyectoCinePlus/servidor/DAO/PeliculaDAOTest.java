package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;


public class PeliculaDAOTest {

	
	private static PeliculaDAO peliculaDAO;
	private static List<Usuario> listUsuarios;
		
	static Logger logger = Logger.getLogger(PeliculaDAOTest.class.getName());
    
	@BeforeClass
	public static void setUpClass() {
		
		listUsuarios=new ArrayList<>();
		peliculaDAO = new PeliculaDAO();
		
		logger.info("Almacenando peliculas");
		Pelicula peli3 = new Pelicula(3, "Alien", 120, "el octavo pasagero", 1979, "Terror", 9, listUsuarios, "9");
		Pelicula peli4 = new Pelicula(4, "Star Trek", 128, "el futuro comienza", 2009, "ciencia ficcion", 5, listUsuarios, "5");
		Pelicula spq = new Pelicula(5, "Prueba", 0, "prueba", 2018, "SPQ", 10, listUsuarios, "10");

		
		peliculaDAO.storePelicula(peli3);
		peliculaDAO.storePelicula(peli4);
		peliculaDAO.storePelicula(spq);
	}
	
	@Before
	public void setUp() throws Exception {
		
	

	}
	
	@Test
	public void testStorePelicula() throws Exception {
		logger.info("testStorePelicula()");
	
		Pelicula prueba2 = null;
		peliculaDAO.storePelicula(new Pelicula(6, "Alien 3", 120, "el regreso", 1979, "Terror", 9, listUsuarios, "9"));
		
		List<Pelicula> lista = peliculaDAO.getPeliculas(" ", " ", " ");
		
		for(Pelicula peli:lista) {
			if(peli.getNombre().equals("Alien 3")) {
				prueba2 =peli;
			}
		}
		
		
		logger.info(prueba2.getNombre());
		assertEquals("Alien 3", prueba2.getNombre());
		assertEquals("Terror", prueba2.getCategoria());
		assertEquals("1979", String.valueOf(prueba2.getAnyo()));
		assertEquals("120", String.valueOf(prueba2.getDuracion()));
	
	}
	
	
	/**
	 * Test para comprobar que realiza busquedas de peliculas en tiempo optimo
	 * @throws Exception
	 */
	@Test
	@PerfTest(invocations = 120, threads = 5)
	@Required(max = 3, average = 2)
	public void getPeliculaTest() throws Exception{
		logger.info("getPeliculaTest()");
		peliculaDAO.storePelicula( new Pelicula(7, "Star Trek 2", 142, "La ira de khan", 1994, "ciencia ficcion", 14, listUsuarios,"14"));
		
		
		Pelicula prueba2 = null;
		List<Pelicula> lista = peliculaDAO.getPeliculas(" ", " ", " ");
			
		for(Pelicula peli:lista) {
			if(peli.getNombre().equals("Star Trek 2")) {
				prueba2 =peli;
			}
		}
		
		 
		assertEquals("Star Trek 2", prueba2.getNombre());
		 
	}
	
	@Test
	public void updateUsuarioTest() throws Exception{
		logger.info("updateUsuarioTest()");
		peliculaDAO.storePelicula(new Pelicula(8, "Star Wars", 125, "Una nueva esperanza", 1970, "ciencia ficcion", 6, listUsuarios,"6"));
		
		Pelicula prueba2 =null;
		Pelicula prueba3 =null;
		List<Pelicula> lista = peliculaDAO.getPeliculas(" ", " ", " ");
		for(Pelicula peli:lista) {
			if(peli.getNombre().equals("Star Wars")) {
				prueba2 =peli;
			}
		}
		prueba2.setAnyo(1977);
		peliculaDAO.updatePelicula(prueba2);
		
		List<Pelicula> lista2 = peliculaDAO.getPeliculas(" ", " ", " ");
		for(Pelicula peli:lista) {
			if(peli.getNombre().equals("Star Wars")) {
				prueba3 =peli;
			}
		}
		
		assertEquals("1977",String.valueOf(prueba3.getAnyo()));
		
	}
	
	
}
