package es.deusto.spq.ProyectoCinePlus.servidor.DATA;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UsuarioTest {

	private Usuario mikel;
	private Usuario xabi;
	private Usuario aritz;
	private Usuario javi;

	@Before
	public void setUp() throws Exception {
		mikel = new Usuario ("MikelSPQ", "Mikel@gmail.com", "Mikel", "Fernandez", "P@ssw0rd", "España", false);
		xabi = new Usuario ("XabiSPQ", "Xabi@gmail.com", "Xabi", "Sarrionandia", "P@ssw0rd", "España", false);
		xabi.setSaldo(50);
		aritz = null;
		javi = null;
				
	}

	@Test
	public void comprobarcamposMikeltest() {
		assertEquals("MikelSPQ", mikel.getUsuario());
		assertEquals("Mikel@gmail.com", mikel.getEmail());
		assertEquals("Mikel", mikel.getNombre());
		assertEquals("Fernandez", mikel.getApellido());
		assertEquals("P@ssw0rd", mikel.getPassword());
		assertEquals("España", mikel.getPais());
		assertEquals(false, mikel.isAdmin());
	}
	
	@Test
	public void comprobarcamposXabitest() {
		assertEquals("XabiSPQ", xabi.getUsuario());
		assertEquals("Xabi@gmail.com", xabi.getEmail());
		assertEquals("Xabi", xabi.getNombre());
		assertEquals("Sarrionandia", xabi.getApellido());
		assertEquals("P@ssw0rd", xabi.getPassword());
		assertEquals("España", xabi.getPais());
		assertFalse( xabi.isAdmin());
	}

	@Test
	public void copiarUsuarioTest() {
		aritz.copiarUsuario(xabi);
		assertEquals(aritz, xabi);
	}

	@Test
	public void comprobarUsuarioAdminTest() {
		javi.copiarUsuario(xabi);
		javi.setAdmin(true);
		assertTrue(javi.isAdmin());
	}

}
