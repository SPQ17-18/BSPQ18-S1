package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad;

import java.rmi.Naming;

public class CinePlusManagerServer {
	
	public static void main(String[] args) {
		if (args.length != 3) {
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}
		
		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			ICinePlus cpser = new CinePlusServer();
			Naming.rebind(name, cpser);
			System.out.println("* CinePlus Service '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("$ CinePlusManagerServer exception: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
