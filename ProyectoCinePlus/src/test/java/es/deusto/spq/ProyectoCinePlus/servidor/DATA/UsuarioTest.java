/** @package ees.deusto.spq.ProyectoCinePlus.servidor.DATA;
*   @brief Test UsuarioTest. May 18, 2018
*
*   Este es el test que comprueba los metodos de Usuario.
*/
package es.deusto.spq.ProyectoCinePlus.servidor.DATA;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.deusto.spq.ProyectoCinePlus.servidor.DAO.UsuarioDAOTest;

/** @package es.deusto.spq.ProyectoCinePlus.servidor.DATA
* @brief Test UsuarioTest. May 17, 2018
* @since 2.0.0
* 
* Este es el test que comprueba los datos del Usuario.
*/
public class UsuarioTest {

	
	static Logger logger = Logger.getLogger(UsuarioTest.class.getName());
	
	private static Usuario mikel;
	private static Usuario xabi;
	private static Usuario aritz;
	private static Usuario javi;

	/**
	 * Metodo que se encarga de inicializar los usuarios que hemos definidos.
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		mikel = new Usuario ("MikelSPQ", "Mikel@gmail.com", "Mikel", "Fernandez", "P@ssw0rd", "Euskadi", false);
		xabi = new Usuario ("XabiSPQ", "Xabi@gmail.com", "Xabi", "Sarrionandia", "P@ssw0rd", "Euskadi", false);
		xabi.setSaldo(50);
		aritz = new Usuario (" ", " ", " ", " ", " ", "Euskadi", false);
		javi = new Usuario (" ", " ", " ", " ", " ", "Euskadi", false);
				
	}

	/**
	 * Metodo que se encarga de comprobar los campos del usuario.
	 */
	@Test
	public void comprobarcamposMikeltest() {
		assertEquals("MikelSPQ", mikel.getUsuario());
		assertEquals("Mikel@gmail.com", mikel.getEmail());
		assertEquals("Mikel", mikel.getNombre());
		assertEquals("Fernandez", mikel.getApellido());
		assertEquals("P@ssw0rd", mikel.getPassword());
		assertEquals("Euskadi", mikel.getPais());
		assertEquals(false, mikel.isAdmin());
	}
	
	/**
	 * Metodo que se encarga de comprobar los campos del usuario.
	 */
	@Test
	public void comprobarcamposXabitest() {
		assertEquals("XabiSPQ", xabi.getUsuario());
		assertEquals("Xabi@gmail.com", xabi.getEmail());
		assertEquals("Xabi", xabi.getNombre());
		assertEquals("Sarrionandia", xabi.getApellido());
		assertEquals("P@ssw0rd", xabi.getPassword());
		assertEquals("Euskadi", xabi.getPais());
		assertFalse( xabi.isAdmin());
	}

	/**
	 * Metodo que se encarga de comprobar que se ha copiado bien el usuario.
	 */
	@Test
	public void copiarUsuarioTest() {
		aritz.copiarUsuario(xabi);
		logger.info(aritz.toString());
		
		assertEquals("XabiSPQ", aritz.getUsuario());
		assertEquals("Xabi@gmail.com", aritz.getEmail());
		assertEquals("Xabi", aritz.getNombre());
		assertEquals("Sarrionandia", aritz.getApellido());
		assertEquals("P@ssw0rd", aritz.getPassword());
		assertEquals("Euskadi", aritz.getPais());
		assertFalse( aritz.isAdmin());
	}

	/**
	 * Metodo que se encarga de comprobar que el usuario es administrador.
	 */
	@Test
	public void comprobarUsuarioAdminTest() {
		javi.copiarUsuario(xabi);
		javi.setAdmin(true);
		assertTrue(javi.isAdmin());
	}

}
