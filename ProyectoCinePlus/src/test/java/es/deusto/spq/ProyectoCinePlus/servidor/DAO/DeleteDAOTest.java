package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.PelisPerfil;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;
import junit.framework.JUnit4TestAdapter;

public class DeleteDAOTest {

	
	private static PelisPerfilDAO pelisPerfilDAO;
	private static UsuarioDAO usuarioDAO;
	
	private  PelisPerfil pelisperfil1;
	private  PelisPerfil pelisperfil2;
	private  PelisPerfil pelisperfil3;
	
	private Usuario mikel;
	private Usuario aritz;
	private Usuario javi;
	private Usuario xabi;
	
	static Logger logger = Logger.getLogger(DeleteDAOTest.class.getName());
	
	@Rule public ContiPerfRule rule = new ContiPerfRule();

	
	public static junit.framework.Test suite() {
		 return new JUnit4TestAdapter(DeleteDAOTest.class);
	}
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception{
		pelisPerfilDAO = new PelisPerfilDAO();
		usuarioDAO = new UsuarioDAO();	

	}

	/**
	 * Creo objetos pelisperfil y los subo a la base de datos si no existen.
	 * @throws Exception lanza excepcion
	 */
	@Before
	public void setUp() throws Exception{
		pelisperfil1 = new PelisPerfil("javitxu@gmail.com",1);
		pelisperfil2 = new PelisPerfil("mikel@gmail.com",3);
		pelisperfil3 = new PelisPerfil("javitxu@gmail.com",5);
		
		 mikel = new Usuario ("MikelSPQ", "Mikel@gmail.com", "Mikel", "Fernandez", "P@ssw0rd", "Euskadi", false);
		 xabi = new Usuario ("XabiSPQ", "Xabi@gmail.com", "Xabi", "Sarrionandia", "P@ssw0rd", "Euskadi", false);
		 aritz = new Usuario ("AritzSPQ", "aritz@gmail.com", "Aritz", "Rasines", "P@ssw0rd", "Euskadi", false);
		 javi = new Usuario ("JaviSPQ", "javi@gmail.com", "Javi", "Fernandez", "P@ssw0rd", "Euskadi", true);
		 
		 usuarioDAO.storeUsuario(mikel);
		 usuarioDAO.storeUsuario(xabi);
		 usuarioDAO.storeUsuario(aritz);
		 usuarioDAO.storeUsuario(javi);
					
		pelisPerfilDAO.storePelisPerfil(pelisperfil1);
		pelisPerfilDAO.storePelisPerfil(pelisperfil2);
		pelisPerfilDAO.storePelisPerfil(pelisperfil3);
		 
	}


	
	/**
	 * Test que comprueba que se hayan eliminado todas las pelis de la bd satisfactoriamente
	 */
	
	@Test
	@Required(totalTime = 300)
	public void deleteObjectTest(){
		pelisPerfilDAO.deletePelisPerfil(pelisperfil1);
		pelisPerfilDAO.deletePelisPerfil(pelisperfil2);
		pelisPerfilDAO.deletePelisPerfil(pelisperfil3);
		
		assertFalse(pelisPerfilDAO.checkPelis(pelisperfil1));
		assertFalse(pelisPerfilDAO.checkPelis(pelisperfil2));
		assertFalse(pelisPerfilDAO.checkPelis(pelisperfil3));
	}


	/**
	 * Test de eliminacion de un usuario
	 * 
	 * @throws Exception lanza excepcion
	 */
	
	@Test
	public void test_3deleteUsuarioTest() throws Exception{
		logger.info("Test 3 para hacer un update de usuario");
		logger.info("Eliminando usuarios");
		usuarioDAO.deleteUsuario(javi);		
		usuarioDAO.deleteUsuario(aritz);	
		usuarioDAO.deleteUsuario(xabi);	
		usuarioDAO.deleteUsuario(mikel);	
		
		javi = usuarioDAO.getUsuario("javi@gmail.com");
		aritz = usuarioDAO.getUsuario("aritz@gmail.com");
		xabi = usuarioDAO.getUsuario("Xabi@gmail.com");
		mikel = usuarioDAO.getUsuario("Mikel@gmail.com");
		
		assertEquals(null,javi.getEmail());
		assertEquals(null,aritz.getEmail());
		assertEquals(null,xabi.getEmail());
		assertEquals(null,mikel.getEmail());
	}
	
	
	

}
