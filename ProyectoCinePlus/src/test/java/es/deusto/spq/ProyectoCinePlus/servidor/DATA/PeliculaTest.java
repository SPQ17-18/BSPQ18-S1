package es.deusto.spq.ProyectoCinePlus.servidor.DATA;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.deusto.spq.ProyectoCinePlus.servidor.DAO.PeliculaDAO;
import es.deusto.spq.ProyectoCinePlus.servidor.DAO.UsuarioDAO;

public class PeliculaTest {

	private Pelicula pelicula1;
	private Pelicula pelicula2;
	private Usuario spq;
	
	@Before
	public void setUp() throws Exception {
		List<Usuario> listUsuarios=new ArrayList<>();
        Usuario spq = new Usuario("spq", "spq@gmail.com", "spq", "spq", "spq", "spq", false);
        
        listUsuarios.add(spq);
        
        //UsuarioDAO usuarioDAO=new UsuarioDAO();
        //PeliculaDAO peliculaDAO= new PeliculaDAO();
        
		pelicula1 = new Pelicula (1, "Cadena perpetua", 142, "vida de prisioneros", 1994, "Drama", 14, listUsuarios,"14");
		pelicula2 = new Pelicula (2, "Alternativa", 140, "vida de prisioneros 2", 1995, "Suspense", 15, listUsuarios,"15");
	}


	@Test
	public void comprobarcamposPelicula1test() {
		assertEquals("Cadena perpetua", pelicula1.getNombre());
		assertEquals(142, pelicula1.getDuracion());
		assertEquals("vida de prisioneros", pelicula1.getDescripcion());
		assertEquals(1994, pelicula1.getAnyo());
		assertEquals("Drama", pelicula1.getCategoria());
		assertEquals("14", pelicula1.getPrecio());
	}
	
	@Test
	public void comprobarcamposPelicula2test() {
		assertEquals("Alternativa", pelicula2.getNombre());
		assertEquals(140, pelicula2.getDuracion());
		assertEquals("vida de prisioneros", pelicula2.getDescripcion());
		assertEquals(1995, pelicula2.getAnyo());
		assertEquals("Suspense", pelicula2.getCategoria());
		assertEquals("15", pelicula2.getPrecio());
	}


}
