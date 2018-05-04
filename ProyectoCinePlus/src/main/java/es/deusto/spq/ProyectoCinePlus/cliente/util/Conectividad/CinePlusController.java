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

	public boolean RegistrarUsuario(String usuario, String email, String nombre, String apellido, String password,
			String pais, float saldo, boolean admin) throws RemoteException {
		return rsl.getCinePlusService().registrarUsuario(usuario, email, nombre, apellido, password, pais, saldo, admin);
	}
	
	public boolean LoginUsuario(String usuario, String password) throws RemoteException {
		return rsl.getCinePlusService().usuarioRegistrado(usuario, password);
	}
	public List<String> ObtenerAnyo() throws RemoteException {
		return rsl.getCinePlusService().Anyos();
	}
	public List<String> ObtenerGenero() throws RemoteException {
		return rsl.getCinePlusService().Generos();
	}
	public List<Pelicula> Busqueda(String nombre, String anyo,String genero) throws RemoteException {
		return rsl.getCinePlusService().Busqueda(nombre, anyo,genero);
		
	}
	public Usuario DevolverUsuario(String email)throws RemoteException {
		return rsl.getCinePlusService().devuelveUsuario(email);
	}
	public boolean actualizarUsuario(Usuario user)throws RemoteException {
		return rsl.getCinePlusService().actualizarUsuario(user);
	}
	
	public void eliminarUsuario(Usuario user)throws RemoteException {
		 rsl.getCinePlusService().eliminarUsuario(user);
	}
	
	public static void main(String[] args) {
			if (args.length != 3) {
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
