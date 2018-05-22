/** @package ees.deusto.spq.ProyectoCinePlus.servidor.DATA;
*   @brief Test UsuarioDAOTest. May 18, 2018
*
*   Este es el test que comprueba los metodos de PelisPerfilTest.
*/
package es.deusto.spq.ProyectoCinePlus.servidor.DATA;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
/**
* @author mikelgol7
* @since 3.0.0
* 
* Este es el test que comprueba que se han introducido los de las peliculas.
*/
public class PelisPerfilTest {
	
	static Logger logger = Logger.getLogger(PelisPerfilTest.class.getName());
	
	private PelisPerfil pelisperfil1;
	private PelisPerfil pelisperfil2;


	/**
	 * Metodo que se encarga de inicializar el objeto PelisPerfil con emails y con el id_peliculas
	 * @throws Exception lanza excepcion
	 */
	@Before
	public void setUpBefore() throws Exception{
		pelisperfil1 = new PelisPerfil("javi@gmail.com",1);
		pelisperfil2 = new PelisPerfil("mikel@gmail.com",3);
	}
	/**
	 * Metodo que se encarga de comprobar que el email de un pelisperfil es correcto y el id:peliculas.
	 */
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
