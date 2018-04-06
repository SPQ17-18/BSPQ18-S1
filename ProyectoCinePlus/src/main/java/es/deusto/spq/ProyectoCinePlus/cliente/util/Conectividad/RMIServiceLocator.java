package es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad;

import es.deusto.spq.ProyectoCinePlus.servidor.Conectividad.ICinePlus;


public class RMIServiceLocator {
	private ICinePlus ICP;


	public ICinePlus getCinePlusService() {
		return ICP;
	}
	
	public RMIServiceLocator(){ 
    }
	

	public void setService(String[] args) {
		try {
			String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
			ICP = (ICinePlus) java.rmi.Naming.lookup(name);

		} catch (Exception e) {
			System.err.println("- Exception running CinePlus: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
