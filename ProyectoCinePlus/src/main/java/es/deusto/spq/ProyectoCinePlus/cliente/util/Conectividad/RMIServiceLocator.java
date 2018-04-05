package es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad;

import es.deusto.spq.ProyectoCinePlus.servidor.Conectividad.IEasyBooking;


public class RMIServiceLocator {
	private IEasyBooking IEB;


	public IEasyBooking getEasyBookingtService() {
		return IEB;
	}
	
	public RMIServiceLocator(){ 
    }
	

	public void setService(String[] args) {
		try {
			String name = "//" + args[0] + ":" + args[1] + "/" + args[3];
			IEB = (IEasyBooking) java.rmi.Naming.lookup(name);

		} catch (Exception e) {
			System.err.println("- Exception running EasyBooking: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
