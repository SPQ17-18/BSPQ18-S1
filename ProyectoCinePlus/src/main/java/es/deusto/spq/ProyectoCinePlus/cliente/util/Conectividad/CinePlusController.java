package es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad;

import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.RMIServiceLocator;


public class CinePlusController {
	private RMIServiceLocator rmi;

	public CinePlusController(RMIServiceLocator rmi) {
		this.rmi = rmi;
	}
	

	public void RegistrarUsuario(String nombre, String contrasenya, String correo) {
		try {
			rmi.getCinePlusService().registrarUsuario(nombre, contrasenya, correo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	public int LoginUsuario(String nombre, String contrasenya) {
		int login=0;
		try {
			login=rmi.getCinePlusService().UsuarioRegistrado(nombre, contrasenya);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return login;
	}

}
