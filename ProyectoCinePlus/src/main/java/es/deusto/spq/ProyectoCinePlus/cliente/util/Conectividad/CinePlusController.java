package es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad;

import java.awt.EventQueue;
import java.rmi.RemoteException;

import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.RMIServiceLocator;
import es.deusto.spq.ProyectoCinePlus.cliente.util.GUI.VentanaPrincipal;


public class CinePlusController {
	private RMIServiceLocator rsl;
	private VentanaPrincipal cineplus;
	

	public CinePlusController(String [] args) throws RemoteException{
		rsl = new RMIServiceLocator();
		rsl.setService(args);
		
		
	}
	

	public void RegistrarUsuario(String nombre, String contrasenya, String correo) {
		try {
			rsl.getCinePlusService().registrarUsuario(nombre, contrasenya, correo);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	public int LoginUsuario(String nombre, String contrasenya) {
		int login=0;
		try {
			login=rsl.getCinePlusService().UsuarioRegistrado(nombre, contrasenya);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return login;
	}
	
	
	  public static void main(String[] args) throws RemoteException {   
	    	
	    	final CinePlusController controlador = new CinePlusController(args);
	    	
			/**
			 * Launch the application.
			 */
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							VentanaPrincipal.frame = new VentanaPrincipal(controlador);
							VentanaPrincipal.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			
	    }
}
