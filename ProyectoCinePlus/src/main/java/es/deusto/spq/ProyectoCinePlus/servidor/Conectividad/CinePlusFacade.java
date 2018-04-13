package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import es.deusto.spq.ProyectoCinePlus.servidor.Conectividad.CinePlusServer;



public class CinePlusFacade extends UnicastRemoteObject implements ICinePlus{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CinePlusServer cpser;
	
	public CinePlusFacade(CinePlusServer cpser) throws RemoteException {
		super();
		this.cpser=cpser;
	}
	
	public boolean registrarUsuario(String usuario, String email, String nombre, String apellido, String password, String pais, boolean admin)  throws RemoteException {
		System.out.println("Estamos en cineplusFacade");
		System.out.println(usuario+ email+ nombre+ apellido+ password+ pais+ admin);
		return cpser.registrarUsuario(usuario, email, nombre, apellido, password, pais, admin);
		
	}

	public boolean usuarioRegistrado(String usuario, String password) throws RemoteException {
		return cpser.usuarioRegistrado(usuario, password);
		
	}
}
