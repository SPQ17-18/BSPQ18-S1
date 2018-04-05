package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad;

import java.rmi.Naming;

import es.deusto.spq.ProyectoCinePlus.servidor.Conectividad.EasyBookingFacade;





public class EasyBookingManagerServer {
	
	public static void main(String[] args) {
		if (args.length != 4) {
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String nameEasyBooking = "//" + args[0] + ":" + args[1] + "/" + args[3];

		try {
			EasyBookingServer ebser = new EasyBookingServer();
			
			//IEasyBooking easybookingser = new EasyBookingFacade(ebser);			
			//Naming.rebind(nameEasyBooking, easybookingser);
			System.out.println("* EasyBooking Service '" + nameEasyBooking + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("$ EasyBookingManagerServer exception: " + e.getMessage());
			e.printStackTrace();
		}
		
	}

}
