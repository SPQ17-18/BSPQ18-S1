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
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;

public class UsuarioDAOTest {

	private static UsuarioDAO usuarioDAO;
	
	static Logger logger = Logger.getLogger(UsuarioDAOTest.class.getName());
	

	
	@BeforeClass
	public static void setUpClass() {
		usuarioDAO = new UsuarioDAO();
		
		
		logger.info("Almacenando usuarios");
		//users
		Usuario mikel = new Usuario ("MikelSPQ", "Mikel@gmail.com", "Mikel", "Fernandez", "P@ssw0rd", "España", false);
		Usuario xabi = new Usuario ("XabiSPQ", "Xabi@gmail.com", "Xabi", "Sarrionandia", "P@ssw0rd", "España", false);
		Usuario aritz = new Usuario ("AritzSPQ", "aritz@gmail.com", "Aritz", "Rasines", "P@ssw0rd", "España", false);
		Usuario javi = new Usuario ("JaviSPQ", "javi@gmail.com", "Javi", "Fernandez", "P@ssw0rd", "España", true);
		Usuario spq = new Usuario("spq", "spq@gmail.com", "spq", "spq", "spq", "spq", false);		
		
		//User for store
		Usuario prueba1 = new Usuario ("MikelSPQ", "prueba1@gmail.com", "Mikel", "Fernandez", "P@ssw0rd", "España", false);
		
		logger.info("almacenando "+mikel.getEmail());
		usuarioDAO.storeUsuario(mikel);
		
		logger.info("almacenando "+xabi.getEmail());		
		usuarioDAO.storeUsuario(xabi);
		

		logger.info("almacenando "+aritz.getEmail());
		usuarioDAO.storeUsuario(aritz);
		
		logger.info("almacenando "+javi.getEmail());
		usuarioDAO.storeUsuario(javi);
		
		logger.info("almacenando "+spq.getEmail());
		usuarioDAO.storeUsuario(spq);
	}
	
	@Before
	public void setUp() throws Exception {
	
	}
	
	@Test
	public void test_1testStoreUsuario() throws Exception{
		logger.info("Test 1 para introducir nuevo usuario");		
		usuarioDAO.storeUsuario(new Usuario("MikelSPQ", "prueba1@gmail.com", "Mikel", "Fernandez", "P@ssw0rd", "España", false));
		Usuario prueba2 = usuarioDAO.getUsuario("prueba1@gmail.com");
		assertEquals("MikelSPQ",prueba2.getUsuario());
		assertEquals("Mikel",prueba2.getNombre());
		assertEquals("Fernandez",prueba2.getApellido());
		
	}
	
	/*
	 * Login correcto
	 */
	@Test
	public void test_2loginUserTestOK() throws Exception{
		boolean resul;
		logger.info("Test 2 Logeando el usuario " + "Xabi@gmail.com");
		resul = usuarioDAO.loginUser("Xabi@gmail.com","P@ssw0rd");
		assertTrue(resul);
	}
	
	
	/*
	 * Login incorrecto
	 */
	
	@Ignore
	public void test_3deleteUsuarioTest() throws Exception{
		logger.info("Test 3 para hacer un update de usuario");
		logger.info("Eliminando usuario");
		usuarioDAO.deleteUsuario(new Usuario("MikelSPQ", "prueba1@gmail.com", "Mikel", "Fernandez", "P@ssw0rd", "España", false));		
		Usuario prueba3 = usuarioDAO.getUsuario("prueba1@gmail.com");
		logger.info(prueba3.toString());
		assertEquals(null,prueba3.getEmail());

	}
	
	
	@Test
	public void test_4loginUserTestFAIL() throws Exception{
		boolean resul;
		logger.info("Test 4 Logeando incorrectamente el usuario " + "Xabi@gmail.com");
		 resul = usuarioDAO.loginUser("Xabi@gmail.com","ContrasenyaFalsa123");
		assertFalse(resul);
	}
	
	
	@Test
	public void test_5getUsuarioTest() throws Exception{

		logger.info("Test 5 para obtener un usuario de la base de datos");
		Usuario prueba2 = usuarioDAO.getUsuario("aritz@gmail.com");
		assertEquals("aritz@gmail.com", prueba2.getEmail());
		
	}

	
	/*
	 * Existe usuario
	 */
	@Test
	@PerfTest(invocations = 100, threads = 10)
	@Required(max = 20, average = 10)
	public void test_6checkUserTestOK() throws Exception{
		boolean resul;
		logger.info("Test 6 para realizar un login correcto");
		 resul = usuarioDAO.checkUser(new Usuario("spq", "spq@gmail.com", "spq", "spq", "spq", "spq", false));
		assertTrue(resul);
	}
	
	/*
	 * No existe usuario
	 */
	@Test
	public void test_7checkUserTestFAIL() throws Exception{
		boolean resul;
		logger.info("Test 7 para intentar obtener usuario pero da fallo");
		resul = usuarioDAO.checkUser(new Usuario("MikelSPQ2", "prueba12@gmail.com", "Mikel2", "Fernandez2", "P@ssw0rd", "España", false));
		assertFalse(resul);
	}
	
	@Test
	public void test_8getUsuariosTest() throws Exception{
		List<Usuario> listUsuarios = new ArrayList<>();
		logger.info("Test 8 para comprobar que obtiene usuarios");
		listUsuarios=usuarioDAO.getUsuarios();
		assertTrue(listUsuarios.size()>4);
	}
	
	
	
	
	@AfterClass
	public static void deleteAll() throws Exception {
		
		usuarioDAO.deleteUsuario(new Usuario ("MikelSPQ", "Mikel@gmail.com", "Mikel", "Fernandez", "P@ssw0rd", "España", false));
		usuarioDAO.deleteUsuario( new Usuario ("MikelSPQ", "Mikel@gmail.com", "Mikel", "Fernandez", "P@ssw0rd", "España", false));
		usuarioDAO.deleteUsuario(new Usuario ("AritzSPQ", "aritz@gmail.com", "Aritz", "Rasines", "P@ssw0rd", "España", false));
		usuarioDAO.deleteUsuario(new Usuario ("JaviSPQ", "javi@gmail.com", "Javi", "Fernandez", "P@ssw0rd", "España", true));
		usuarioDAO.deleteUsuario(new Usuario("spq", "spq@gmail.com", "spq", "spq", "spq", "spq", false));
	}
	
	
}