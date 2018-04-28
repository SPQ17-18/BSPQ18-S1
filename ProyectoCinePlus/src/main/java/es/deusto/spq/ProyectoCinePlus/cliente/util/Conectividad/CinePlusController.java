package es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad;

import java.rmi.RemoteException;
import java.util.List;

import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.RMIServiceLocator;
import es.deusto.spq.ProyectoCinePlus.cliente.util.GUI.VentanaPrincipal;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;

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
	
	public List<Pelicula> Busqueda(String nombre, String anyo,String genero) throws RemoteException {
		return rsl.getCinePlusService().Busqueda(nombre, anyo,genero);
		
	}
	
	public Usuario DevolverUsuario(String email)throws RemoteException {
		System.out.println("Controler");
		return rsl.getCinePlusService().devuelveUsuario(email);
	}
	
	public void actualizarUsuario(Usuario user)throws RemoteException {
		rsl.getCinePlusService().actualizarUsuario(user);
	}
	
	public static void main(String[] args) {
			if (args.length != 3) {
				System.out.println("Use: java [policy] [codebase] Client.Client [host] [port] [server]");
				System.exit(0);
			}
			
			if (System.getSecurityManager() == null) {
				System.setSecurityManager(new SecurityManager());
			}


						try {
							RMIServiceLocator rmi=new RMIServiceLocator();
							rmi.setService(args);
							CinePlusController cpc=new CinePlusController(rmi);
							VentanaPrincipal.frame = new VentanaPrincipal(rmi,cpc);
							VentanaPrincipal.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					
	}
}
