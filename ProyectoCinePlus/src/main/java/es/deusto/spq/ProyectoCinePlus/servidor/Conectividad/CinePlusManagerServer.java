package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;

import org.apache.log4j.Logger;

/**
 * 
 * @author Aritzmetal
 * @version 3.0.1
 * @since May 17, 2018
 * 
 * Clase CinePlusManagerServer, donde se inicia el servidor de la aplicacion.
 *
 */
public class CinePlusManagerServer  {
	static Logger logger = Logger.getLogger(CinePlusManagerServer.class.getName());
	
	/**
	 * Metodo main del servidor. Recibe por parametros los argumentos para establecer la conexion. Se queda esperando hasta que se lee un caracter.
	 * @param args - nombre, puerto, ip
	 */
	public static void main(String[] args) {
		if (args.length != 3) {
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		logger.info("This is a test to check how mvn test executes this test without external interaction; JVM properties by program");
		System.setProperty("java.security.policy", "target\\classes\\security\\java.policy");


		try {
			ICinePlus objServer = new CinePlusFacade();
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
