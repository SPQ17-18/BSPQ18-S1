package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import org.apache.log4j.Logger;


public class CinePlusManagerServer  {
	static Logger logger = Logger.getLogger(CinePlusManagerServer.class.getName());
	
	public static void main(String[] args) {
		if (args.length != 3) {
			System.exit(0);
		}
		
		Thread rmiRegistryThread = null;
		Thread rmiServerThread = null;

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		class RMIRegistryRunnable implements Runnable {

			public void run() {
				try {
					//java.rmi.registry.LocateRegistry.createRegistry(33060);
					logger.info("RMI registry ready.");
				} catch (Exception e) {
					logger.info("Exception starting RMI registry:");
					e.printStackTrace();
				}	
			}
		}
		
		rmiRegistryThread = new Thread(new RMIRegistryRunnable());
		rmiRegistryThread.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		class RMIServerRunnable implements Runnable {

		
			public void run() {
				logger.info("This is a test to check how mvn test executes this test without external interaction; JVM properties by program");
				System.setProperty("java.security.policy", "target\\classes\\security\\java.policy");


				try {
					ICinePlus objServer = new CinePlusServer();
					Naming.rebind(name, objServer);
					logger.info("Server '" + name + "' active and waiting...");
					InputStreamReader inputStreamReader = new InputStreamReader(System.in);
					BufferedReader stdin = new BufferedReader(inputStreamReader);
			        String line = stdin.readLine();
			       
			       
				} catch (RemoteException re) {
					logger.debug(" # Collector RemoteException: " + re.getMessage());
					re.printStackTrace();
					System.exit(-1);
				} catch (MalformedURLException murle) {
					logger.debug(" # Collector MalformedURLException: " + murle.getMessage());
					murle.printStackTrace();
					System.exit(-1);
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
		rmiServerThread = new Thread(new RMIServerRunnable());
		rmiServerThread.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
	

		
	}

}
