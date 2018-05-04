package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import es.deusto.spq.ProyectoCinePlus.servidor.Conectividad.RMITest;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UsuarioDAOTest {

	
	static Logger logger = Logger.getLogger(UsuarioDAOTest.class.getName());
	
	private static UsuarioDAO usuarioDAO;
	private Usuario mikel;
	private Usuario xabi;
	private Usuario aritz;
	private Usuario javi;
	private Usuario spq;
	
	
	private Usuario prueba1;
	
	@BeforeClass
	public static void setUpClass() {
		usuarioDAO = new UsuarioDAO();
	}
	
	@Before
	public void setUp() throws Exception {
		logger.info("Almacenando usuarios");
		//users
		mikel = new Usuario ("MikelSPQ", "Mikel@gmail.com", "Mikel", "Fernandez", "P@ssw0rd", "España", false);
		xabi = new Usuario ("XabiSPQ", "Xabi@gmail.com", "Xabi", "Sarrionandia", "P@ssw0rd", "España", false);
		aritz = new Usuario ("AritzSPQ", "aritz@gmail.com", "Aritz", "Rasines", "P@ssw0rd", "España", false);
		javi = new Usuario ("JaviSPQ", "javi@gmail.com", "Javi", "Fernandez", "P@ssw0rd", "España", true);
		spq = new Usuario("spq", "spq@gmail.com", "spq", "spq", "spq", "spq", false);		
		
		//User for store
		prueba1 = new Usuario ("MikelSPQ", "prueba1@gmail.com", "Mikel", "Fernandez", "P@ssw0rd", "España", false);
		
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
	
	@Test
	public void test_1testStoreUsuario() throws Exception{
		logger.info("Test 1 para introducir nuevo usuario");		
		usuarioDAO.storeUsuario(prueba1);
		Usuario prueba2 = usuarioDAO.getUsuario("prueba1@gmail.com");
		assertEquals("MikelSPQ",prueba2.getUsuario());
		assertEquals("Mikel",prueba2.getNombre());
		assertEquals("Fernandez",prueba2.getApellido());
<<<<<<< HEAD
=======
		//assertEquals(prueba1, prueba2);
	}
	
	@Test
	public void deleteUsuarioTest() throws Exception{
		logger.info("Test para hacer un update de usuario");
		logger.info("Eliminando usuario");
		usuarioDAO.deleteUsuario(xabi);
>>>>>>> branch 'master' of https://github.com/SPQ17-18/BSPQ18-S1.git
		
<<<<<<< HEAD
=======
		Usuario prueba3 = usuarioDAO.getUsuario("Xabi@gmail.com");
		logger.info(prueba3.toString());
		assertEquals(null,prueba3.getNombre());

	}
	
	@Test
	public void getUsuarioTest() throws Exception{
		logger.info("Test para obtener un usuario de la base de datos");
		Usuario prueba2 = usuarioDAO.getUsuario("Mikel@gmail.com");
		assertEquals(mikel.getEmail(), prueba2.getEmail());
>>>>>>> branch 'master' of https://github.com/SPQ17-18/BSPQ18-S1.git
	}
	
	/*
	 * Login correcto
	 */
	@Test
	public void test_2loginUserTestOK() throws Exception{
		boolean resul;
		logger.info("Test 2 Logeando el usuario " + prueba1.getEmail());
		resul = usuarioDAO.loginUser(prueba1.getEmail(),prueba1.getPassword());
		assertTrue(resul);
	}
	
	
	/*
	 * Login incorrecto
	 */
	
	@Test
	public void test_3deleteUsuarioTest() throws Exception{
		logger.info("Test 3 para hacer un update de usuario");
		logger.info("Eliminando usuario");
		usuarioDAO.deleteUsuario(prueba1);		
		Usuario prueba3 = usuarioDAO.getUsuario("prueba1@gmail.com");
		logger.info(prueba3.toString());
		assertEquals(null,prueba3.getNombre());

	}
	
	
	@Test
	public void test_4loginUserTestFAIL() throws Exception{
		boolean resul;
		logger.info("Test 4 Logeando incorrectamente el usuario " + prueba1.getEmail());
		 resul = usuarioDAO.loginUser(prueba1.getEmail(),prueba1.getPassword());
		assertFalse(resul);
	}
	
	
	@Test
	public void test_5getUsuarioTest() throws Exception{

		logger.info("Test 5 para obtener un usuario de la base de datos");
		Usuario prueba2 = usuarioDAO.getUsuario(aritz.getEmail());
		assertEquals(aritz.getEmail(), prueba2.getEmail());
		
	}

	
	/*
	 * Existe usuario
	 */
	@Test
	public void test_6checkUserTestOK() throws Exception{
		boolean resul;
		logger.info("Test 6 para realizar un login correcto");
		 resul = usuarioDAO.checkUser(spq);
		assertTrue(resul);
	}
	
	/*
	 * No existe usuario
	 */
	@Test
	public void test_7checkUserTestFAIL() throws Exception{
		boolean resul;
		logger.info("Test 7 para intentar obtener usuario pero da fallo");
		resul = usuarioDAO.checkUser(prueba1);
		assertFalse(resul);
	}
	
	@Test
	public void test_8getUsuariosTest() throws Exception{
		List<Usuario> listUsuarios = new ArrayList<>();
		logger.info("Test 8 para comprobar que obtiene usuarios");
		listUsuarios=usuarioDAO.getUsuarios();
		assertTrue(listUsuarios.size()>4);
	}
	
	
	
	
	@After
	public void deleteAll() throws Exception {
		usuarioDAO.deleteUsuario(mikel);
		usuarioDAO.deleteUsuario(xabi);
		usuarioDAO.deleteUsuario(aritz);
		usuarioDAO.deleteUsuario(javi);
		usuarioDAO.deleteUsuario(spq);
	}
	
	
}
