package es.deusto.spq.ProyectoCinePlus.cliente;

import java.awt.EventQueue;

import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.CinePlusController;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.RMIServiceLocator;
import es.deusto.spq.ProyectoCinePlus.cliente.util.GUI.VentanaPrincipal;
import es.deusto.spq.ProyectoCinePlus.servidor.Conectividad.ICinePlus;

public class Cliente {
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Use: java [policy] [codebase] Client.Client [host] [port] [server]");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		try {
			String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
			ICinePlus objServer = (ICinePlus) java.rmi.Naming.lookup(name);
			// Register to be allowed to send messages
//			objServer.registerUser("dipina", "dipina");
//			objServer.registerUser("dipina", "cortazar");
//			User u = objServer.getUserMessages("dipina");
//			for (Message m: u.getMessages()) {
//				
//				System.out.println(m);
//				
//			}
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						RMIServiceLocator rmi=new RMIServiceLocator();
						rmi.setService(args);
						CinePlusController cpc=new CinePlusController(rmi);
						VentanaPrincipal.frame = new VentanaPrincipal(rmi,cpc);
						VentanaPrincipal.frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		
		} catch (Exception e) {
			System.err.println("RMI Example exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
