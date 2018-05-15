package es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad;

import java.rmi.RemoteException;
import java.util.List;

import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.RMIServiceLocator;
import es.deusto.spq.ProyectoCinePlus.cliente.util.GUI.VentanaPrincipal;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.PelisPerfil;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;

/**
 * 
 * @author Fercol
 * @package es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad
 * @version 3.0.3
 * @author Fercol
 * @since May 15, 2018
 * 
 *        Clase de CinePLusController. Aqu� se encuentran los m�todos del cliente que llaman al servidor. 
 * 
 *
 */
public class CinePlusController {
	
	private RMIServiceLocator rsl;

	/**
	 * Constructor de CinePlusController
	 * @param rmi - RMIServiceLocator
	 */
	public CinePlusController(RMIServiceLocator rmi) {
		this.rsl = rmi;
	}
	
	/**
	 * M�todo RegistrarUsuario del Controlador, que se encarga de llamar al m�todo de registrarUsuario del CinePlusService y devuelve un true si se ha registrado correctamente. 
	 * @param usuario - String
	 * @param email - String
	 * @param nombre - String
	 * @param apellido - String
	 * @param password - String
	 * @param pais - String
	 * @param admin - boolean
	 * @return boolean - <code>true</code> si se ha registrado correctamente.
	 * @throws RemoteException
	 */
	public boolean RegistrarUsuario(String usuario, String email, String nombre, String apellido, String password,
			String pais, boolean admin) throws RemoteException {
		return rsl.getCinePlusService().registrarUsuario(usuario, email, nombre, apellido, password, pais, admin);
	}
	
	/**
	 * M�todo RegistrarUsuario del Controlador, que se encarga de llamar al m�todo de registrarUsuario del CinePlusService y devuelve un true si se ha registrado correctamente. 
	 * @param usuario - String
	 * @param email - String
	 * @param nombre - String
	 * @param apellido - String
	 * @param password - String
	 * @param pais - String
	 * @param saldo - float
	 * @param admin - boolean
	 * @return boolean - <code>true</code> si se ha registrado correctamente.
	 * @throws RemoteException
	 */
	public boolean RegistrarUsuario(String usuario, String email, String nombre, String apellido, String password,
			String pais, float saldo, boolean admin) throws RemoteException {
		return rsl.getCinePlusService().registrarUsuario(usuario, email, nombre, apellido, password, pais, saldo, admin);
	}
	
	/**
	 * M�todo LoginUsuario del controlador, que se encarga de llamar al m�todo de usuarioRegistrado del CinePlusService y vuelve un true si se ha iniciado sesi�n correctamente. 
	 * @param usuario - String
	 * @param password - String
	 * @return boolean - <code>true</code> si ha iniciado sesi�n correctamente.
	 * @throws RemoteException
	 */
	public boolean LoginUsuario(String usuario, String password) throws RemoteException {
		return rsl.getCinePlusService().usuarioRegistrado(usuario, password);
	}
	
	/**
	 * M�todo ObtenerAnyo del controlador, que se encarga de llamar al m�todo de Anyos del CinePlusService y devuelve una lista con todos los a�os de las pel�culas de la base de datos.
	 * @return List<String> - Lista de A�os de las pel�culas
	 * @throws RemoteException
	 */
	public List<String> ObtenerAnyo() throws RemoteException {
		return rsl.getCinePlusService().Anyos();
	}
	
	/**
	 * M�todo ObtenerGenero del controlador, que e encarga de llamar al m�todo Generos del CinePlusService y devuelve una lista con todos los generos de las pel�culas de la base de datos. 
	 * @return List<String> - Lista de Generos de las pel�culas
	 * @throws RemoteException
	 */
	public List<String> ObtenerGenero() throws RemoteException {
		return rsl.getCinePlusService().Generos();
	}
	
	/**
	 * M�todo Alquilar del controlador, que se encarga de llamar al m�todo Alquilar de CinePlusService y devuelve un true su se ha podido alquilar una pel�cula.
	 * @param PelisPerfil - PelisPerfil 
	 * @return boolean - <code>true</code> si ha alquilado una pel�cula correctamente.
	 * @throws RemoteException
	 */
	public boolean Alquilar(PelisPerfil PelisPerfil) throws RemoteException {
		return rsl.getCinePlusService().Alquilar(PelisPerfil);
	}
	
	/**
	 * M�todo Busqueda del controlador, que recibe el nombre el a�o y el genero y se encarga de llamar al m�todo Busqueda del CinePlusService.
	 * @param nombre - String
	 * @param anyo - String
	 * @param genero - String
	 * @return List<Pelicula> - Lista de peliculas buscadas
	 * @throws RemoteException
	 */
	public List<Pelicula> Busqueda(String nombre, String anyo,String genero) throws RemoteException {
		return rsl.getCinePlusService().Busqueda(nombre, anyo,genero);
	}
	
	/**
	 * M�todo getPeliUsuario del controlador, que dado un usuario se encarga de llamar al m�todo getPeliUsuario del CinePlusService.
	 * @param email - String
	 * @return List<Pelicula> - Lista de peliculas del usuario
	 * @throws RemoteException
	 */
	public List<Pelicula> getPeliUsuario(String email) throws RemoteException {
		return rsl.getCinePlusService().getPeliUsuario(email);
	}
	
	/**
	 * M�todo DevolverUsuario del controlador, que se encarga de llamar al m�todo de devuelveUsuario (pasandole un email) del CinePlusService. 
	 * @param email - String
	 * @return Usuario - Devuelve un usuario
	 * @throws RemoteException
	 */
	public Usuario DevolverUsuario(String email)throws RemoteException {
		return rsl.getCinePlusService().devuelveUsuario(email);
	}
	
	/**
	 * M�todo actualizarUsuario del controlador, que se encarga de llamar al m�todo de actualizarUsuario del CinePlusService. 
	 * @param user - Usuario
	 * @throws RemoteException
	 */
	public void actualizarUsuario(Usuario user)throws RemoteException {
		rsl.getCinePlusService().actualizarUsuario(user);
	}
	
	/**
	 * M�todo eliminarUsuario del controlador, que se encarga de llamar al m�todo de eliminarUsuario del CinePlusService y elimina un usuario de la base de datos.
	 * @param user - Usuario
	 * @throws RemoteException
	 */
	public void eliminarUsuario(Usuario user)throws RemoteException {
		 rsl.getCinePlusService().eliminarUsuario(user);
	}
	
	/**
	 * M�todo Main de la aplicaci�n cliente. Aqu� se inicia la aplicaci�n y se llama a la interfaz gr�fica. 
	 * @param args - String[]
	 */
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
