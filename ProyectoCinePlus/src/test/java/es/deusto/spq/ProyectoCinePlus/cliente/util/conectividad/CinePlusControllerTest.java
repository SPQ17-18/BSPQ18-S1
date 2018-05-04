package es.deusto.spq.ProyectoCinePlus.cliente.util.conectividad;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.RMIServiceLocator;
import es.deusto.spq.ProyectoCinePlus.servidor.Conectividad.CinePlusServer;
import es.deusto.spq.ProyectoCinePlus.servidor.Conectividad.ICinePlus;
import es.deusto.spq.ProyectoCinePlus.servidor.Conectividad.RMITest;
import es.deusto.spq.ProyectoCinePlus.servidor.DAO.PeliculaDAO;
import es.deusto.spq.ProyectoCinePlus.servidor.DAO.UsuarioDAO;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;
import junit.framework.JUnit4TestAdapter;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CinePlusControllerTest {

	private String usuario;
	private String email;
	private String nombre;
	private String apellido;
	private String password;
	private String pais;
	private float saldo;
	private boolean admin;
	private String nombrePeli;
	private String anyo;
	private String genero;
	private Usuario user;
	private Pelicula pelicula1;
	private static PeliculaDAO peliculaDAO;
	private static UsuarioDAO usuarioDAO;
	private static RMIServiceLocator rsl;
	
	private static String cwd = CinePlusControllerTest.class.getProtectionDomain().getCodeSource().getLocation().getFile();
	private static Thread rmiRegistryThread = null;
	private static Thread rmiServerThread = null;
	
	
	static Logger logger = Logger.getLogger(CinePlusControllerTest.class.getName());

	
	
	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(CinePlusControllerTest.class);
	}
	

	
	@BeforeClass
	public static void setUp() throws Exception {
		
		rsl = new RMIServiceLocator();
		peliculaDAO = new PeliculaDAO();
		usuarioDAO = new UsuarioDAO();
		
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
					
					ICinePlus cineplus = new CinePlusServer();
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
	
		String[] valores = {"127.0.0.1","1099","CinePlusServer"};
		rsl.setService(valores);
		
		
		
		
	}
	
	
	@Before
	public void setUpClass() {
		
		
		usuario = "Javi";
		email = "javi@gmail.com";
		nombre = "Javi";
		apellido = "Fernandez";
		password = "P@ssw0rd";
		pais = "España";
		saldo = 10;
		admin = true;
		nombrePeli = "Star Trek";
		anyo = "2009";
		genero = "Ciencia ficcion";
		user = new Usuario (usuario, email, nombre, apellido, password, pais, admin);
		pelicula1 = new Pelicula (1, "Cadena perpetua", 142, "vida de prisioneros", 1994, "Drama", 14,null,"14");
		peliculaDAO.storePelicula(pelicula1);
		//usuarioDAO.storeUsuario(user);
	}

	@Test
	public void Test1_RegistrarUsuario1Test() throws RemoteException {
		assertTrue(rsl.getCinePlusService().registrarUsuario(usuario, email, nombre, apellido, password, pais, admin));
	}

	@Test
	public void Test2_RegistrarUsuario2Test() throws RemoteException {
		rsl.getCinePlusService().eliminarUsuario(user);
		assertTrue(rsl.getCinePlusService().registrarUsuario(usuario, email, nombre, apellido, password, pais, saldo, admin));
	}
	
	@Test
	public void Test3_LoginUsuarioTest() throws RemoteException {
		assertTrue(rsl.getCinePlusService().usuarioRegistrado(email, password));
	}
	
	@Test
	public void Test4_ObtenerAnyoTest() throws RemoteException {
		assertTrue(rsl.getCinePlusService().Anyos().size() > 0);
	}
	
	@Test
	public void Test5_ObtenerGeneroTest() throws RemoteException {
		assertTrue(rsl.getCinePlusService().Generos().size() >0);
	}
	
	@Test
	public void Test6_BusquedaTest() throws RemoteException {
		assertTrue(rsl.getCinePlusService().Busqueda(nombrePeli, anyo,genero).size() > 0);
	}
	
	@Test
	public void Test7_DevolverUsuarioTest() throws RemoteException {
		assertEquals(rsl.getCinePlusService().devuelveUsuario(email).getEmail(), email);
	}
	
	
	@Test
	public void Test8_eliminarUsuarioTest() throws RemoteException {
		 rsl.getCinePlusService().eliminarUsuario(user);
	}
	
	@AfterClass static public void tearDown() {
		try	{
			rmiServerThread.join();
			rmiRegistryThread.join();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}	

	} 
}
