package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import es.deusto.spq.ProyectoCinePlus.servidor.Conectividad.CinePlusServer;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;



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
		return cpser.registrarUsuario(usuario, email, nombre, apellido, password, pais, admin);
	}

	public boolean usuarioRegistrado(String usuario, String password) throws RemoteException {
		return cpser.usuarioRegistrado(usuario, password);
	}
	public List<Pelicula> Busqueda(String nombre, String anyo,String genero) throws RemoteException {
		return cpser.Busqueda(nombre, anyo,genero);
	}
}
