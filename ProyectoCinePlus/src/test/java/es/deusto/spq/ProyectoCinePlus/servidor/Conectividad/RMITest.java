package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

import static org.junit.Assert.*;
import junit.framework.JUnit4TestAdapter;

import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.Test;

import es.deusto.spq.ProyectoCinePlus.cliente.util.GUI.VentanaRegistro;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;

import org.junit.AfterClass;
import org.apache.log4j.Logger;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.junit.After;

public class RMITest {
	
	private static String cwd = RMITest.class.getProtectionDomain().getCodeSource().getLocation().getFile();
	private static Thread rmiRegistryThread = null;
	private static Thread rmiServerThread = null;
	
	static int iteration = 0; 
	
	private ICinePlus cineplus;
	
	static Logger logger = Logger.getLogger(RMITest.class.getName());

	public static junit.framework.Test suite() {
		return new JUnit4TestAdapter(RMITest.class);
	}


	@BeforeClass static public void setUp() {
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
			logger.info("sleeping 4000ms");
			Thread.sleep(4000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	
	}
	

	@Before public void setUpClient() {
		try {
			
		//System.getProperty("java.security.policy", "target\\test-classes\\security\\java.policy");

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		String name = "//127.0.0.1:1099/CinePlusServer";
		logger.info("BeforeTest - Setting the client ready for calling TestServer name: " + name);
		cineplus = (ICinePlus) java.rmi.Naming.lookup(name);
		}
		catch (Exception re) {
			logger.error(" # CinePlusServer RemoteException: " + re.getMessage());
	//		re.printStackTrace();
			System.exit(-1);
		} 
		
	}
	
	////TODO Modificar
	
	@Test
	@PerfTest(invocations = 100, threads = 10)
	@Required(max = 10, average = 10)
	
	/*
	 * Login Test
	 */	
	public void loginNewUserTest() {
		logger.info("loginNewUserTest");
		boolean resul=false;
		try{
			logger.info("Test 1 - Loging new user");
			resul=cineplus.usuarioRegistrado("noesta@gmail.com", "noesta");//Usuario y contraseña
		}
		catch (Exception re) {
			logger.error(" # CinePlus RemoteException: " + re.getMessage());
		} 
		/*
		 * Very simple test, inserting a valid new user
		 */
		logger.info("Si es TRUE, se ha logeado");
		assertFalse( resul );
	}
	
	@PerfTest(invocations = 100, threads = 10)
	@Required(max = 1000, average = 1000)
	@Test public void loginExistingUserTest() {
		logger.info("loginExistingUserTest");
		boolean resul=false;
		try{
			logger.info("Test 2 - Login existing user.");
			resul=cineplus.usuarioRegistrado("spq@gmail.com", "spq");			
		}
		catch (Exception re) {
			logger.error(" # CinePlus RemoteException: " + re.getMessage());
		} 
		
		logger.info("Si es TRUE, se ha logeado");
		assertTrue( resul );
	}
	
	
	
	/*
	//@Test		
	public void registerNewUserTest() {
		logger.info("registerNewUserTest");
		
		boolean resul=false;
		iteration++;
		
		String user="user"+iteration;
		String email=user+"@gmail.com";
		String surname= user+"_surname";
		
		try{
			logger.info("Test 3 - Register new user");
			resul=cineplus.registrarUsuario(user, email, user, surname, "P@ssw0rd", "es", false);
		}
		catch (Exception re) {
			logger.error(" # CinePlus RemoteException: " + re.getMessage());
		} 
		
		
		
		logger.info("Si es TRUE, se ha registrado");
		assertTrue( resul );
	}
	
	
	public void checkUserTest() {
		
		logger.info("CheckingSeveralUsersTest");
		boolean resul=false;
		for (int i =0;i<iteration;i++) {
			String user="user"+i;
			String email=user+"@gmail.com";
			String surname= user+"_surname";
			
			try{
				logger.info("Test 4 - Check new user");
				resul=cineplus.checkUser(user, email, user, surname, "P@ssw0rd", "es", false);
			}
			catch (Exception re) {
				logger.error(" # CinePlus RemoteException: " + re.getMessage());
			} 
			
			logger.info("Si es TRUE, se ha encontrado");
			assertTrue( resul );
		}
				
	}
	
*/
	
	
	
	@Test public void registerExistingUserTest() {
		logger.info("registerExistingUserTest");
		boolean resul=false;
		try{
			logger.info("Test 4 - Register existing user. Change password");
			resul=cineplus.registrarUsuario("Javier", "Javier@gmail.com", "Javier", "Fernandez", "Javier", "es", false);
		}
		catch (Exception re) {
			logger.error(" # CinePlus RemoteException: " + re.getMessage());
		} 
		
		
		
		logger.info("Si es TRUE, no se ha podido registar");
		assertTrue( resul );
	}
	

	/*
	
	@After public  void deleteDatabase() {
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();
        try
        {
            tx.begin();
	
            logger.info("Deleting test users from persistence. Cleaning up.");
            Query<Usuario> q1 = pm.newQuery(Usuario.class);
            long numberInstancesDeleted = q1.deletePersistentAll();
            logger.info("Deleted " + numberInstancesDeleted + " user");
			
            tx.commit();
        }
        finally
        {
            if (tx.isActive())
            {
                tx.rollback();
            }
            pm.close();
        }
		
	}
	
	*/
	

	
	@AfterClass static public void tearDown() {
		try	{
			rmiServerThread.join();
			rmiRegistryThread.join();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}	

	} 
	
}

