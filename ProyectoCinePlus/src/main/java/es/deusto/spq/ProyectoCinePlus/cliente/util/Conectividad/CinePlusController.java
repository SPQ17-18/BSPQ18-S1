package es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad;

import java.rmi.RemoteException;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.RMIServiceLocator;

public class CinePlusController {
	
	private RMIServiceLocator rsl;

	public CinePlusController(RMIServiceLocator rmi) {
		this.rsl = rmi;
	}

	public boolean RegistrarUsuario(String usuario, String email, String nombre, String apellido, String password,
			String pais, boolean admin) throws RemoteException {
		return rsl.getCinePlusService().registrarUsuario(usuario, email, nombre, apellido, password, pais, admin);
	}

	public boolean LoginUsuario(String usuario, String password) throws RemoteException {
		return rsl.getCinePlusService().usuarioRegistrado(usuario, password);
	}

	
}
