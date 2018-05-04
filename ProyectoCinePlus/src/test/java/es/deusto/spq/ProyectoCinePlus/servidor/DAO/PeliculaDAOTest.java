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
	
	private Pelicula  peli3;
	private Pelicula  peli4;
	private Pelicula  spq ;
	
	private Pelicula alien3;
	
	private Pelicula  startrek2;
	
	private Pelicula prueba1;
	
	
	private List<Usuario> listUsuarios=new ArrayList<>();
	
	static Logger logger = Logger.getLogger(PeliculaDAOTest.class.getName());
    
	@BeforeClass
	public static void setUpClass() {
		peliculaDAO = new PeliculaDAO();
	}
	
	@Before
	public void setUp() throws Exception {
		logger.info("Almacenando peliculas");
		  peli3 = new Pelicula(3, "Alien", 120, "el octavo pasagero", 1979, "Terror", 9,listUsuarios,"9");
		  peli4 = new Pelicula(4, "Star Trek", 128, "el futuro comienza", 2009, "ciencia ficcion", 5,listUsuarios,"5");
		  spq = new Pelicula(5, "Prueba", 0, "prueba", 2018, "SPQ", 10,listUsuarios,"10");
	    
		  //Pelicula del test StorePelicula
		  alien3 = new Pelicula(6, "Alien 3", 120, "el regreso", 1979, "Terror", 9, listUsuarios, "9");
		  
		  //GetPeliculaTest
		  startrek2 = new Pelicula(7, "Star Trek 2", 142, "La ira de khan", 1994, "ciencia ficcion", 14, listUsuarios, "14");

		  //UpdateUsuarioTest
		  prueba1 = new Pelicula (8, "Star Wars", 125, "Una nueva esperanza", 1970, "ciencia ficcion", 6,listUsuarios,"6");
		  
	    peliculaDAO.storePelicula(peli3);
	    peliculaDAO.storePelicula(peli4);
	    peliculaDAO.storePelicula(spq);
	
	}
	
	@Test
	public void testStorePelicula() throws Exception {
		logger.info("testStorePelicula()");
	
		Pelicula prueba2 = null;
		peliculaDAO.storePelicula(alien3);
		
		List<Pelicula> lista = peliculaDAO.getPeliculas("Alien 3", "1979", "Terror");
		
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
	
	@Test
	public void getPeliculaTest() throws Exception{
		logger.info("getPeliculaTest()");
		peliculaDAO.storePelicula(startrek2);
		
		Pelicula prueba2 = null;
		List<Pelicula> lista = peliculaDAO.getPeliculas("Star Trek 2", "1994", "ciencia ficcion");
		
		
		for(Pelicula peli:lista) {
			if(peli.getNombre().equals("Star Trek 2")) {
				prueba2 =peli;
			}
		}
		
		 
		assertEquals(startrek2.getNombre(), prueba2.getNombre());
		 
	}
	
	@Test
	public void updateUsuarioTest() throws Exception{
		logger.info("updateUsuarioTest()");
		peliculaDAO.storePelicula(prueba1);
		
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
