package es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad;

import es.deusto.spq.ProyectoCinePlus.servidor.Conectividad.ICinePlus;

/**
 * 
 * @author Fercol
 * @package es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad
 * @version 3.0.3
 * @author Fercol
 * @since May 15, 2018
 * 
 *        Clase del RMI SERVICE LOCATOR
 * 
 *
 */

public class RMIServiceLocator {
	private ICinePlus ICP;

	/**
	 * Constructor RMIServiceLocator
	 */
	public RMIServiceLocator(){ 
    }
	
	/**
	 * Metodo que devuelve el servicio 
	 * @return ICP - ICinePlus
	 */
	public ICinePlus getCinePlusService() {
		return ICP;
	}
	
	/**
	 * Metodo que busca y pone en marcha el servicio
	 * @param args - String[]
	 */
	public void setService(String[] args) {
		try {
			String name = "//" + args[0] + ":" + args[1] + "/" + args[2];
			ICP = (ICinePlus) java.rmi.Naming.lookup(name);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
