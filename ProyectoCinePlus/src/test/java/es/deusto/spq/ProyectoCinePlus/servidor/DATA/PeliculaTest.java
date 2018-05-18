/** @package ees.deusto.spq.ProyectoCinePlus.servidor.DATA;
*   @brief Test PeliculaTest. May 18, 2018
*
*   Este es el test que comprueba los metodos de Pelicula.
*/
package es.deusto.spq.ProyectoCinePlus.servidor.DATA;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.deusto.spq.ProyectoCinePlus.servidor.DAO.PeliculaDAO;
import es.deusto.spq.ProyectoCinePlus.servidor.DAO.UsuarioDAO;
/**
* @author mikelgol7
* @package es.deusto.spq.ProyectoCinePlus.servidor.DATA
* @brief Test PeliculaTest. May 18, 2018
* @since 2.0.0
* 
* Este es el test que comprueba los datos de las Pelicula.
*/
public class PeliculaTest {

	
	static Logger logger = Logger.getLogger(PeliculaTest.class.getName());
	
	private static Pelicula pelicula1;
	private static Pelicula pelicula2;
	private static Usuario spq;
	
	/**
	 * Metodo que se encarga de inicializar las peliculas que hemos definidos.
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		List<Usuario> listUsuarios=new ArrayList<>();
        Usuario spq = new Usuario("spq", "spq@gmail.com", "spq", "spq", "spq", "spq", false);
        
        listUsuarios.add(spq);
        
		pelicula1 = new Pelicula (1, "Cadena perpetua", 142, "vida de prisioneros", 1994, "Drama", 14,listUsuarios,"14");
		pelicula2 = new Pelicula (2, "Alternativa", 140, "vida de prisioneros 2", 1995, "Suspense", 15,listUsuarios,"15");
	}

	/**
	 * Metodo que se encarga de comprobar los campos de la pelicula 1.
	 */
	@Test
	public void comprobarcamposPelicula1test() {
		assertEquals("Cadena perpetua", pelicula1.getNombre());
		assertEquals(142, pelicula1.getDuracion());
		assertEquals("vida de prisioneros", pelicula1.getDescripcion());
		assertEquals(1994, pelicula1.getAnyo());
		assertEquals("Drama", pelicula1.getCategoria());
		assertEquals("14.0", String.valueOf(pelicula1.getPrecio()));
	}
	/**
	 * Metodo que se encarga de comprobar los campos de la pelicula 2.
	 */
	@Test
	public void comprobarcamposPelicula2test() {
		assertEquals("Alternativa", pelicula2.getNombre());
		assertEquals(140, pelicula2.getDuracion());
		assertEquals("vida de prisioneros 2", pelicula2.getDescripcion());
		assertEquals(1995, pelicula2.getAnyo());
		assertEquals("Suspense", pelicula2.getCategoria());
		assertEquals("15.0", String.valueOf(pelicula2.getPrecio()));
	}
	/**
	 * Metodo que se encarga de comprobar que se ha copiado bien la pelicula.
	 */
	@Test
	public void copiarPeliculaTest() {
		pelicula1.copiarPelicula(pelicula2);
		logger.info(pelicula1.toString());
		
		assertEquals("Alternativa", pelicula2.getNombre());
		assertEquals(140, pelicula2.getDuracion());
		assertEquals("vida de prisioneros 2", pelicula2.getDescripcion());
		assertEquals(1995, pelicula2.getAnyo());
		assertEquals("Suspense", pelicula2.getCategoria());
		assertEquals("15.0", String.valueOf(pelicula2.getPrecio()));
	}

	
}
