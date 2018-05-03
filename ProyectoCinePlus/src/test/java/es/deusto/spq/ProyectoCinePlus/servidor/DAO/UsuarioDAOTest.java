package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.deusto.spq.ProyectoCinePlus.servidor.Conectividad.RMITest;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;

public class UsuarioDAOTest {

	
	static Logger logger = Logger.getLogger(UsuarioDAOTest.class.getName());
	
	private static UsuarioDAO usuarioDAO;
	private Usuario mikel;
	private Usuario xabi;
	private Usuario aritz;
	private Usuario javi;
	private Usuario spq;
	
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
		
		logger.info("almacenando "+mikel.getEmail());
		usuarioDAO.storeUsuario(mikel);
		
		logger.info("almacenando "+xabi.getEmail());		
		usuarioDAO.storeUsuario(xabi);
		

		logger.info("almacenando "+spq.getEmail());
		usuarioDAO.storeUsuario(spq);
	}
	
	@Test
	public void testStoreUsuario() throws Exception{
		logger.info("Test para introducir nuevo usuario");
		Usuario prueba1 = new Usuario ("MikelSPQ", "prueba1@gmail.com", "Mikel", "Fernandez", "P@ssw0rd", "España", false);
		usuarioDAO.storeUsuario(prueba1);
		Usuario prueba2 = usuarioDAO.getUsuario("prueba1@gmail.com");
		assertEquals("MikelSPQ",prueba2.getUsuario());
		assertEquals("Mikel",prueba2.getNombre());
		assertEquals("Fernandez",prueba2.getApellido());
		//assertEquals(prueba1, prueba2);
	}
	
	@Test
	public void updateUsuarioTest() throws Exception{
		logger.info("Test para hacer un update de usuario");
		Usuario prueba1 = new Usuario ("MikelSPQ", "prueba1@gmail.com", "Mikel", "Fernandez", "P@ssw0rd", "España", false);
		usuarioDAO.storeUsuario(prueba1);
		Usuario prueba2 = usuarioDAO.getUsuario("prueba1@gmail.com");
		
		prueba1.setUsuario("MikelSPQ_2");
		usuarioDAO.updateUsuario(prueba1);
		
		Usuario prueba3 = usuarioDAO.getUsuario("prueba1@gmail.com");
		assertEquals("MikelSPQ_2",prueba3.getUsuario());

	}
	
	@Test
	public void getUsuarioTest() throws Exception{

		logger.info("Test para obtener un usuario de la base de datos");
		Usuario prueba1 = new Usuario ("MikelSPQ", "prueba1@gmail.com", "Mikel", "Fernandez", "P@ssw0rd", "España", false);
		usuarioDAO.storeUsuario(prueba1);
		Usuario prueba2 = usuarioDAO.getUsuario("prueba1@gmail.com");
		assertEquals(prueba1.getEmail(), prueba2.getEmail());
	}
	
	/*
	 * Login correcto
	 */
	@Test
	public void loginUserTestOK() throws Exception{
		boolean resul;
		usuarioDAO.storeUsuario(spq);
		resul = usuarioDAO.loginUser(spq.getEmail(),spq.getPassword());
		assertTrue(resul);
	}
	/*
	 * Login incorrecto
	 */
	@Test
	public void loginUserTestFAIL() throws Exception{
		boolean resul;
		resul = usuarioDAO.loginUser(javi.getEmail(),javi.getPassword());
		assertFalse(resul);
	}
	
	/*
	 * Existe usuario
	 */
	@Test
	public void checkUserTestOK() throws Exception{
		boolean resul;
		resul = usuarioDAO.checkUser(spq);
		assertTrue(resul);
	}
	
	/*
	 * No existe usuario
	 */
	@Test
	public void checkUserTestFAIL() throws Exception{
		boolean resul;
		resul = usuarioDAO.checkUser(javi);
		assertFalse(resul);
	}
	
	@Test
	public void getUsuariosTest() throws Exception{
		List<Usuario> listUsuarios = new ArrayList<>();
		listUsuarios=usuarioDAO.getUsuarios();
		assertTrue(listUsuarios.size()>3);
	}
	
	
}
