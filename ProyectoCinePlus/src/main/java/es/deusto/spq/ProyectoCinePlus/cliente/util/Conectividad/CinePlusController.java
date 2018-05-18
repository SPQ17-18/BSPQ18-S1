/** @package es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad
*    @brief Clase de CinePLusController. May 17, 2018
*
*    Este es el controller del cliente donde se encuentran los metodos que apuntan al servidor y donde esta el main.
*/
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
 * @author Fercol
 * @since 1.0.0
 * 
 *        Clase de CinePLusController. Aqui se encuentran los metodos del cliente que llaman al servidor. 
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
	 * Metodo RegistrarUsuario del Controlador, que se encarga de llamar al metodo
	 * de registrarUsuario del CinePlusService y devuelve un true si se ha
	 * registrado correctamente.
	 * 
	 * @param usuario String con el nombre de usuario dentro de la plataforma
	 * @param email String con el email asociado al usuario
	 * @param nombre String con nombre de la persona fisica
	 * @param apellido String con el apellido de la persona
	 * @param password String contrasenya de 6 caract minimo
	 * @param pais String pais de residencia actual
	 * @param admin boolean es administrador o no
	 * 
	 * @return boolean - <code>true</code> si se ha registrado correctamente.
	 * @throws RemoteException
	 */
	public boolean RegistrarUsuario(String usuario, String email, String nombre, String apellido, String password,
			String pais, boolean admin) throws RemoteException {
		return rsl.getCinePlusService().registrarUsuario(usuario, email, nombre, apellido, password, pais, admin);
	}
	
	/**
	 * Metodo RegistrarUsuario del Controlador, que se encarga de llamar al metodo de registrarUsuario del CinePlusService y devuelve un true si se ha registrado correctamente. 
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
	 * Metodo LoginUsuario del controlador, que se encarga de llamar al metodo de usuarioRegistrado del CinePlusService y vuelve un true si se ha iniciado sesion correctamente. 
	 * @param usuario - String
	 * @param password - String
	 * @return boolean - <code>true</code> si ha iniciado sesion correctamente.
	 * @throws RemoteException
	 */
	public boolean LoginUsuario(String usuario, String password) throws RemoteException {
		return rsl.getCinePlusService().usuarioRegistrado(usuario, password);
	}
	
	/**
	 * Metodo ObtenerAnyo del controlador, que se encarga de llamar al metodo de Anyos del CinePlusService y devuelve una lista con todos los anyos de las peliculas de la base de datos.
	 * @return List<String> - Lista de Anyos de las peliculas
	 * @throws RemoteException
	 */
	public List<String> ObtenerAnyo() throws RemoteException {
		return rsl.getCinePlusService().Anyos();
	}
	
	/**
	 * Metodo ObtenerGenero del controlador, que e encarga de llamar al metodo Generos del CinePlusService y devuelve una lista con todos los generos de las peliculas de la base de datos. 
	 * @return List<String> - Lista de Generos de las peliculas
	 * @throws RemoteException
	 */
	public List<String> ObtenerGenero() throws RemoteException {
		return rsl.getCinePlusService().Generos();
	}
	
	/**
	 * Metodo Alquilar del controlador, que se encarga de llamar al metodo Alquilar
	 * de CinePlusService e indica si se ha podido alquilar o no
	 * 
	 * @param PelisPerfil 
	 * @return boolean <code>true</code> si ha alquilado una pelicula
	 *         correctamente.
	 * @throws RemoteException
	 */
	public boolean Alquilar(PelisPerfil PelisPerfil) throws RemoteException {
		return rsl.getCinePlusService().Alquilar(PelisPerfil);
	}
	
	/**
	 * Metodo Busqueda del controlador, que recibe el nombre el anyo y el genero y
	 * se encarga de llamar al metodo Busqueda del CinePlusService.
	 * 
	 * @param nombre String con el nombre de la pelicula
	 * @param anyo String con el anyo de la pelicula
	 * @param genero String con el genero de la pelicula
	 * 
	 * @return List<Pelicula> - Lista de peliculas buscadas
	 * @throws RemoteException
	 */
	public List<Pelicula> Busqueda(String nombre, String anyo,String genero) throws RemoteException {
		return rsl.getCinePlusService().Busqueda(nombre, anyo,genero);
	}
	
	/**
	 * Metodo getPeliUsuario del controlador, que dado un email
	 * llama al metodo getPeliUsuario del CinePlusService.
	 * 
	 * @param email String con el email del usuario
	 * @return List<Pelicula> - Lista de peliculas del usuario
	 * @throws RemoteException
	 */
	public List<Pelicula> getPeliUsuario(String email) throws RemoteException {
		return rsl.getCinePlusService().getPeliUsuario(email);
	}
	
	/**
	 * Metodo DevolverUsuario del controlador, que se encarga de llamar al metodo de
	 * devuelveUsuario (pasandole un email) del CinePlusService.
	 * 
	 * @param email - String
	 * @return Usuario - Devuelve un usuario
	 * @throws RemoteException
	 */
	public Usuario DevolverUsuario(String email)throws RemoteException {
		return rsl.getCinePlusService().devuelveUsuario(email);
	}
	
	/**
	 * Metodo actualizarUsuario del controlador, que  llama al metodo
	 * de actualizarUsuario del CinePlusService.
	 * Actualiza todos los campos de este aunque sean iguales
	 * 
	 * @param user objeto <code>Usuario</code> a actualizar
	 * @throws RemoteException
	 */
	public void actualizarUsuario(Usuario user)throws RemoteException {
		rsl.getCinePlusService().actualizarUsuario(user);
	}
	
	/**
	 * Metodo eliminarUsuario del controlador, que se encarga de llamar al metodo de
	 * eliminarUsuario del CinePlusService y elimina un usuario de la base de datos.
	 * 
	 * @param user Objeto <code>Usuario</code> a eliminar
	 * @throws RemoteException
	 */
	public void eliminarUsuario(Usuario user)throws RemoteException {
		 rsl.getCinePlusService().eliminarUsuario(user);
	}
	
	/**
	 * Metodo Main de la aplicacion cliente. Aqui se inicia la aplicacion y se llama
	 * a la interfaz grafica.
	 * 
	 * @param args String[3]
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
