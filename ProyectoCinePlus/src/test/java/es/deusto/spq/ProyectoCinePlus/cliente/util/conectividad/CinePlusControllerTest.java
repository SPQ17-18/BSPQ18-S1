package es.deusto.spq.ProyectoCinePlus.cliente.util.conectividad;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import org.apache.log4j.Logger;
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

import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.CinePlusController;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.RMIServiceLocator;
import es.deusto.spq.ProyectoCinePlus.servidor.Conectividad.CinePlusFacade;
import es.deusto.spq.ProyectoCinePlus.servidor.Conectividad.CinePlusServer;
import es.deusto.spq.ProyectoCinePlus.servidor.Conectividad.ICinePlus;
import es.deusto.spq.ProyectoCinePlus.servidor.DAO.PeliculaDAO;
import es.deusto.spq.ProyectoCinePlus.servidor.DAO.PelisPerfilDAO;
import es.deusto.spq.ProyectoCinePlus.servidor.DAO.UsuarioDAO;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.PelisPerfil;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;
import junit.framework.JUnit4TestAdapter;


public class CinePlusControllerTest {

	
	
	private static CinePlusController cineplus;
	
	private static PeliculaDAO peliculaDAO;
	private static UsuarioDAO usuarioDAO;
	private static PelisPerfilDAO pelisPerfilDAO;
	
	private Usuario user;
	private Usuario user2;
	private Usuario user3;
	
	private Pelicula pelicula1;
	
	private PelisPerfil alquiler1;
	private PelisPerfil alquiler2;
	private PelisPerfil alquiler3;
	
	private static String cwd = CinePlusControllerTest.class.getProtectionDomain().getCodeSource().getLocation().getFile();
	private static Thread rmiRegistryThread = null;
	private static Thread rmiServerThread = null;
	
	
	static Logger logger = Logger.getLogger(CinePlusControllerTest.class.getName());

	
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(CinePlusControllerTest.class);
	}
	

	
	@BeforeClass
	public static void setUp() throws Exception {
		
		
		logger.info("Launch the RMI registry");
		class RMIRegistryRunnable implements Runnable {
			public void run() {
				try {
					java.rmi.registry.LocateRegistry.createRegistry(1099);
					logger.info("BeforeClass: RMI registry ready.");
				} catch (Exception e) {
					logger.info("Exception starting RMI registry:");
					e.printStackTrace();
				}	
			}
		}
		
		rmiRegistryThread = new Thread(new RMIRegistryRunnable());
		rmiRegistryThread.start();
		try {
			logger.info("sleeping 4000ms");
			Thread.sleep(4000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		//Lanzar servidor
		class RMIServerRunnable implements Runnable {

			public void run() {
				logger.info("This is a test to check how mvn test executes this test without external interaction; JVM properties by program");
				logger.info("**************: " + cwd);
				System.setProperty("java.rmi.server.codebase", "file:" + cwd);
				System.setProperty("java.security.policy", "target\\classes\\security\\java.policy");

				if (System.getSecurityManager() == null) {
					System.setSecurityManager(new SecurityManager());
				}

				String name = "//127.0.0.1:1099/CinePlusServer";
				logger.info("BeforeClass - Setting the server ready TestServer name: " + name);

				try {
					
					ICinePlus cineplus = new CinePlusFacade();
					Naming.rebind(name, cineplus);
				} catch (RemoteException re) {
					logger.error(" # CinePlusServer RemoteException: " + re.getMessage());
					re.printStackTrace();
					System.exit(-1);
				} catch (MalformedURLException murle) {
					logger.error(" # CinePlusServer MalformedURLException: " + murle.getMessage());
					murle.printStackTrace();
					System.exit(-1);
				}
			}
		}
		rmiServerThread = new Thread(new RMIServerRunnable());
		rmiServerThread.start();
		try {
			logger.info("sleeping 8000ms");
			Thread.sleep(4000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	
		usuarioDAO = new UsuarioDAO();
		peliculaDAO = new PeliculaDAO();
		pelisPerfilDAO = new PelisPerfilDAO();
		
		Pelicula pelicula1 = new Pelicula(1, "Cadena perpetua", 142, "vida de prisioneros", 1994, "Drama", 14, null, "14");
	
		peliculaDAO.storePelicula(pelicula1);
			
	}
	
	
	
	@Before public void setUpClient() {
		try {
			
		System.getProperty("java.security.policy", "target\\test-classes\\security\\java.policy");

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		String name = "//127.0.0.1:1099/CinePlusServer";
		logger.info("BeforeTest - Setting the client ready for calling TestServer name: " + name);
		
		String args[] = new String[3];
		args[0] = "127.0.0.1";
		args[1] = "1099";
		args[2] = "CinePlusServer";
		RMIServiceLocator rmi = new RMIServiceLocator();
		rmi.setService(args);
		cineplus = new CinePlusController(rmi);
		}
		catch (Exception re) {
			logger.error(" # CinePlusServer RemoteException: " + re.getMessage());
			System.exit(-1);
		} 
		
		
			
		 
	}
	
	@Before
	public void setUpClass() {
		
		user = new Usuario("Javi", "javi@gmail.com", "Javi", "Fernandez", "P@ssw0rd", "España", true);
		user2 = new Usuario("Javi2", "javi2@gmail.com", "Javi2", "Fernandez", "P@ssw0rd", "España", true);
		user3 = new Usuario("Mengano", "nuevoEmailgiroGuion@gmail.com", "Mengano", "HijodeMenganez", "pass", "Myanmar",false);

		alquiler1 = new PelisPerfil("javi2@gmail.com", 1);
		alquiler2 = new PelisPerfil("javi2@gmail.com", 3);
		alquiler3 = new PelisPerfil("javi2@gmail.com", 5);

		 if(usuarioDAO.checkUser(user) == false) {
			 usuarioDAO.storeUsuario(user);
			 logger.info("almacenando "+user.getEmail());
			
		 }
		 
		 if(usuarioDAO.checkUser(user2) == false) {
			 usuarioDAO.storeUsuario(user2);
			 logger.info("almacenando "+user2.getEmail());
			
		 }
		 

		 if(pelisPerfilDAO.checkPelis(alquiler1) == false) {
			 pelisPerfilDAO.storePelisPerfil(alquiler1);
			 logger.info("almacenando "+user2.getEmail());
			
		 }
		 
		 if(pelisPerfilDAO.checkPelis(alquiler2) == false) {
			 pelisPerfilDAO.storePelisPerfil(alquiler2);
			 logger.info("almacenando "+user2.getEmail());
			
		 }
		
	}

	@Test
	public void Test1_RegistrarUsuario1Test() throws RemoteException {
		assertFalse(cineplus.RegistrarUsuario("Javi","javi@gmail.com","Javi","Fernandez","P@ssw0rd", "España", true));
	}

	@Ignore
	public void Test2_RegistrarUsuario2Test() throws RemoteException {
		
		cineplus.eliminarUsuario(user);
		
		assertTrue(cineplus.RegistrarUsuario("Javi","javi@gmail.com","Javi","Fernandez","P@ssw0rd", "España", true));
	}
	
	
	@Test
	@PerfTest(duration = 40, invocations = 100, threads = 10)
    @Required(max = 50, average = 20)
	public void Test3_LoginUsuarioTest() throws RemoteException {
		logger.info("Realizando el login para: "+ "javi@gmail.com" + " " + "P@ssw0rd");
		assertTrue(cineplus.LoginUsuario("javi@gmail.com","P@ssw0rd"));
	}
	
	@Test
	public void Test4_ObtenerAnyoTest() throws RemoteException {
		assertTrue(cineplus.ObtenerAnyo().size() > 0);
	}
	
	@Test
	public void Test5_ObtenerGeneroTest() throws RemoteException {
		assertTrue(cineplus.ObtenerGenero().size() >0);
	}
	
	@Test
	public void Test6_BusquedaTest() throws RemoteException {
		assertTrue(cineplus.Busqueda("Cadena perpetua", "1994", "Drama").size() > 0);
	}
	
	@Test
	public void Test7_DevolverUsuarioTest() throws RemoteException {
		assertEquals(cineplus.DevolverUsuario("javi@gmail.com").getNombre(), "Javi");
	}
	
	
	@Test
	public void Test8_eliminarUsuarioTest() throws RemoteException {
		 cineplus.eliminarUsuario(user);
		 cineplus.eliminarUsuario(user2);
		 assertEquals(false,cineplus.LoginUsuario("javi@gmail.com", "P@ssw0rd"));
		 assertEquals(false,cineplus.LoginUsuario("javi2@gmail.com", "P@ssw0rd"));
	}
	
	@Test
	public void Test9_registrarUsuarioConSaldoTest() throws RemoteException {
		cineplus.RegistrarUsuario("Mengano", "nuevoEmailgiroGuion@gmail.com", "Mengano", "HijodeMenganez", "pass", "Myanmar", 10000,false);
		assertEquals(String.valueOf(cineplus.DevolverUsuario("nuevoEmailgiroGuion@gmail.com").getSaldo()),"10000.0");
	
	}
	
	@Test
	public void test10_AlquilerSatisfactorioT () throws RemoteException {
		assertTrue(cineplus.getPeliUsuario("javi2@gmail.com").size() ==2);
		cineplus.Alquilar(alquiler3);
		assertTrue(cineplus.getPeliUsuario("javi2@gmail.com").size() ==3);
		
	}
	
	
	@After
	public void deleteAll() {
		 if(usuarioDAO.checkUser(user) == true) {
			 usuarioDAO.deleteUsuario(user);
			 logger.info("eliminando user "+user.getEmail());
			
		 }
		 
		 if(usuarioDAO.checkUser(user2) == true) {
			 usuarioDAO.deleteUsuario(user2);
			 logger.info("eliminando user "+user2.getEmail());
			
		 }
		 
		 if(usuarioDAO.checkUser(user3) == true) {
			 usuarioDAO.deleteUsuario(user3);
			 logger.info("eliminando user "+user3.getEmail());
			
		 }
		 
		 

		 if(pelisPerfilDAO.checkPelis(alquiler1) == true) {
			 pelisPerfilDAO.deletePelisPerfil(alquiler1);
			 logger.info("eliminado alquiler"+alquiler1.getEmail());
			
		 }
		 
		 if(pelisPerfilDAO.checkPelis(alquiler2) == true) {
			 pelisPerfilDAO.deletePelisPerfil(alquiler2);
			 logger.info("eliminado alquiler"+alquiler2.getEmail());
			
		 }
		 
		 if(pelisPerfilDAO.checkPelis(alquiler3) == true) {
			 pelisPerfilDAO.deletePelisPerfil(alquiler3);
			 logger.info("eliminado alquiler"+alquiler3.getEmail());
			
		 }
	}
	
	@AfterClass
	public static void tearDown() {
		
		try	{
			rmiServerThread.join();
			rmiRegistryThread.join();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}	

	} 
	
}
