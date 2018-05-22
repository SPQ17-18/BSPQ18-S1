/** @package ees.deusto.spq.ProyectoCinePlus.servidor.DAO;
*   @brief Test UsuarioDAOTest. May 18, 2018
*
*   Este es el test que comprueba los metodos de UsuarioDAO
*/
package es.deusto.spq.ProyectoCinePlus.servidor.DAO;
/**
* @author mikelgol7
* @since 3.0.0
* 
* Este es el test que comprueba los metodos de UsuarioDAO.
*/
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;
import junit.framework.JUnit4TestAdapter;


public class UsuarioDAOTest {

	private static UsuarioDAO usuarioDAO;
	
	static Logger logger = Logger.getLogger(UsuarioDAOTest.class.getName());
	
	

	private Usuario mikel;
	private Usuario aritz;
	private Usuario javi;
	private Usuario xabi;
	private Usuario usfalso;
	
	@Rule public ContiPerfRule rule = new ContiPerfRule();
	
	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(UsuarioDAOTest.class);
	}
	
	@BeforeClass
	public static void setUpClass() {
		usuarioDAO = new UsuarioDAO();	
		logger.info("Almacenando usuarios");
	
	}
	
	/**
	 * Creo usuarios, compruebo si existen, y los almaceno en caso d eno existir.
	 * @throws Exception lanza excepcion
	 */
	@Before
	public void setUp() throws Exception {

		 
		 mikel = new Usuario ("MikelSPQ", "Mikel@gmail.com", "Mikel", "Fernandez", "P@ssw0rd", "Euskadi", false);
		 xabi = new Usuario ("XabiSPQ", "Xabi@gmail.com", "Xabi", "Sarrionandia", "P@ssw0rd", "Euskadi", false);
		 aritz = new Usuario ("AritzSPQ", "aritz@gmail.com", "Aritz", "Rasines", "P@ssw0rd", "Euskadi", false);
		 javi = new Usuario ("JaviSPQ", "javi@gmail.com", "Javi", "Fernandez", "P@ssw0rd", "Euskadi", true);
		 usfalso = new Usuario("MikelSPQ2", "prueba12@gmail.com", "Mikel2", "Fernandez2", "P@ssw0rd", "Euskadi", false);

			 usuarioDAO.storeUsuario(mikel);

			 usuarioDAO.storeUsuario(xabi);

			 usuarioDAO.storeUsuario(aritz);

			 usuarioDAO.storeUsuario(javi);

	}
	

	
	/**
	 * Test de login correcto
	 */
	@Test
	@Required(throughput = 4)
	public void test_2loginUserTestOK() throws Exception{
		logger.info("Test 2 Logeando el usuario " + "Xabi@gmail.com");
		assertTrue(usuarioDAO.loginUser("Xabi@gmail.com","P@ssw0rd"));
	}
	
	
	
	/**
	 * Test que realiza un login de usuario fallido
	 * 
	 * @throws Exception lanza excepcion
	 */
	
	@Test
	@Required(totalTime = 10)
	public void test_4loginUserTestFAIL() throws Exception{	
		logger.info("Test 4 Logeando incorrectamente el usuario " + "Xabi@gmail.com");
		assertFalse(usuarioDAO.loginUser("Xabi@gmail.com","ContrasenyaFalsa123"));
	}
	
	/**
	 * Test que devuelve un usuario previamente almacenado
	 * 
	 * @throws Exception lanza excepcion
	 */
	
	@Test
	@Required(max = 20, percentile90 =13)
	public void test_5getUsuarioTest() throws Exception{

		logger.info("Test 5 para obtener un usuario de la base de datos");
		assertEquals("aritz@gmail.com", usuarioDAO.getUsuario("aritz@gmail.com").getEmail());
		
	}

	
	/**
	 * Test de comprobacion de usuario en tiempo optimo
	 */
	@Test
	@PerfTest(invocations = 100, threads = 10)
	@Required(max = 270, average = 135)
	public void test_6checkUserTestOK() throws Exception{
		logger.info("Test 6 para realizar un login correcto");
		assertTrue(usuarioDAO.checkUser(xabi));
	}
	
	/**
	 *  Test que comprueba que no existe usuario
	 *  
	 * @throws Exception lanza excepcion
	 */
	@Test
	@PerfTest(invocations = 300, threads = 3)
	@Required(max = 270, average = 70)
	public void test_7checkUserTestFAIL() throws Exception{
		logger.info("Test 7 para intentar obtener usuario pero da fallo");
		assertFalse(usuarioDAO.checkUser(usfalso));
	}
	
	/**
	 * Test que comprueba que se obtienen usuarios (mas que 0)
	 * @throws Exception lanza excepcion
	 */
	@Test
	@PerfTest(duration = 500)
	@Required(max = 1550, average = 1500)
	public void test_8getUsuariosTest() throws Exception{
		List<Usuario> listUsuarios = new ArrayList<>();
		logger.info("Test 8 para comprobar que obtiene usuarios");
		listUsuarios=usuarioDAO.getUsuarios();
		assertTrue(listUsuarios.size()>4);
	}
	
	
	@After
	public void deleteAfter() throws Exception {
		
	
		 
		 //resto de usuarios
	
			 usuarioDAO.deleteUsuario(mikel);	
			 usuarioDAO.deleteUsuario(xabi);		
			 usuarioDAO.deleteUsuario(aritz);
			 usuarioDAO.deleteUsuario(javi);

	}
	
	
}