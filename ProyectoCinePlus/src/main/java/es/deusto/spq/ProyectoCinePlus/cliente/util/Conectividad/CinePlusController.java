package es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad;

import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.RMIServiceLocator;


public class CinePlusController {
	private RMIServiceLocator rsl;

	

	public CinePlusController(RMIServiceLocator rmi) {
		this.rsl = rmi;
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
	
	
//	  public static void main(String[] args) throws RemoteException {   
//	    	
//	    	final CinePlusController controlador = new CinePlusController(args);
//	    	
//			/**
//			 * Launch the application.
//			 */
//				EventQueue.invokeLater(new Runnable() {
//					public void run() {
//						try {
//							VentanaPrincipal.frame = new VentanaPrincipal(controlador);
//							VentanaPrincipal.frame.setVisible(true);
//						} catch (Exception e) {
//							e.printStackTrace();
//						}
//					}
//				});
//			
//	    }
}
