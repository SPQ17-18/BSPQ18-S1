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

	public void registrarUsuario(String nombre, String contrasenya, String correo) throws RemoteException {
		cpser.registrarUsuario(nombre, contrasenya, correo);
	}

	public int UsuarioRegistrado(String nombre, String contrasenya) throws RemoteException {
		return cpser.UsuarioRegistrado(nombre, contrasenya);
	}
}
