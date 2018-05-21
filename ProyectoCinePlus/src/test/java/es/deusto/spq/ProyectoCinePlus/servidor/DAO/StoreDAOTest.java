package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.databene.contiperf.PerfTest;
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

public class StoreDAOTest {

		
		private static PelisPerfilDAO pelisPerfilDAO;
		private static UsuarioDAO usuarioDAO;
		
		private  PelisPerfil pelisperfil1;
		private  PelisPerfil pelisperfil2;
		private  PelisPerfil pelisperfil3;
		
		private Usuario mikel;
		private Usuario aritz;
		private Usuario javi;
		private Usuario xabi;
		private Usuario usaux;
		
		static Logger logger = Logger.getLogger(PelisPerfilDAOTest.class.getName());
		
		@Rule public ContiPerfRule rule = new ContiPerfRule();

		
		public static junit.framework.Test suite() {
			 return new JUnit4TestAdapter(PelisPerfilDAOTest.class);
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
			 usaux = null;

			 
		}


		/**
		 * Test que comprueba si se almacena el objeto pelisperfil
		 */
		@Test
		public void StorePelisPerfiltest(){
			assertTrue(pelisPerfilDAO.storePelisPerfil(pelisperfil1));
			assertTrue(pelisPerfilDAO.storePelisPerfil(pelisperfil2));
			assertTrue(pelisPerfilDAO.storePelisPerfil(pelisperfil3));
		}
		
		
		/**
		 * Test de almacenamiento de un usuario
		 * @throws Exception lanza excepcion
		 */
		
		@Test
		public void test_1testStoreUsuario() throws Exception{
			logger.info("Test 1 para introducir nuevo usuario");
			usuarioDAO.storeUsuario(xabi);
			 usuarioDAO.storeUsuario(aritz);
			 usuarioDAO.storeUsuario(mikel);			 
			 usuarioDAO.storeUsuario(javi);
			 
			usaux = usuarioDAO.getUsuario("Mikel@gmail.com");
			assertEquals("MikelSPQ",usaux.getUsuario());
			assertEquals("Mikel",usaux.getNombre());
			assertEquals("Fernandez",usaux.getApellido());
			
			usaux = usuarioDAO.getUsuario("Xabi@gmail.com");
			assertEquals("XabiSPQ",usaux.getUsuario());
			assertEquals("Xabi",usaux.getNombre());
			assertEquals("Sarrionandia",usaux.getApellido());
			
			usaux = usuarioDAO.getUsuario("aritz@gmail.com");
			assertEquals("AritzSPQ",usaux.getUsuario());
			assertEquals("Aritz",usaux.getNombre());
			assertEquals("Rasines",usaux.getApellido());
			
			usaux = usuarioDAO.getUsuario("javi@gmail.com");
			assertEquals("JaviSPQ",usaux.getUsuario());
			assertEquals("Javi",usaux.getNombre());
			assertEquals("Fernandez",usaux.getApellido());
			
		}


		
		@After
		public void deleteUsers() throws Exception{
			 
				 pelisPerfilDAO.deletePelisPerfil(pelisperfil1);
				 pelisPerfilDAO.deletePelisPerfil(pelisperfil2);
				 pelisPerfilDAO.deletePelisPerfil(pelisperfil3);
				 
				 usuarioDAO.deleteUsuario(aritz);
				 usuarioDAO.deleteUsuario(mikel);
				 usuarioDAO.deleteUsuario(javi);
				 usuarioDAO.deleteUsuario(xabi);

			  
		}
		
		
	
}
