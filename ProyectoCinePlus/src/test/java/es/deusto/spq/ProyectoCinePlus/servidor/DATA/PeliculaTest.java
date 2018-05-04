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

public class PeliculaTest {

	
	static Logger logger = Logger.getLogger(PeliculaTest.class.getName());
	
	private Pelicula pelicula1;
	private Pelicula pelicula2;
	private Usuario spq;
	
	@Before
	public void setUp() throws Exception {
		List<Usuario> listUsuarios=new ArrayList<>();
        Usuario spq = new Usuario("spq", "spq@gmail.com", "spq", "spq", "spq", "spq", false);
        
        listUsuarios.add(spq);
        
		pelicula1 = new Pelicula (1, "Cadena perpetua", 142, "vida de prisioneros", 1994, "Drama", 14,listUsuarios,"14");
		pelicula2 = new Pelicula (2, "Alternativa", 140, "vida de prisioneros 2", 1995, "Suspense", 15,listUsuarios,"15");
	}


	@Test
	public void comprobarcamposPelicula1test() {
		assertEquals("Cadena perpetua", pelicula1.getNombre());
		assertEquals(142, pelicula1.getDuracion());
		assertEquals("vida de prisioneros", pelicula1.getDescripcion());
		assertEquals(1994, pelicula1.getAnyo());
		assertEquals("Drama", pelicula1.getCategoria());
		assertEquals("14.0", String.valueOf(pelicula1.getPrecio()));
	}
	
	@Test
	public void comprobarcamposPelicula2test() {
		assertEquals("Alternativa", pelicula2.getNombre());
		assertEquals(140, pelicula2.getDuracion());
		assertEquals("vida de prisioneros 2", pelicula2.getDescripcion());
		assertEquals(1995, pelicula2.getAnyo());
		assertEquals("Suspense", pelicula2.getCategoria());
		assertEquals("15.0", String.valueOf(pelicula2.getPrecio()));
	}

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
