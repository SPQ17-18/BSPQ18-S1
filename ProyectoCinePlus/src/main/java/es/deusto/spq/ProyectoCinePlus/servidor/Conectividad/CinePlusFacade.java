package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import es.deusto.spq.ProyectoCinePlus.servidor.Conectividad.CinePlusServer;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.PelisPerfil;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;

/**
 * 
 * @author Fercol
 * @package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad
 * @version 3.0.1
 * @since May 17, 2018
 * 
 * Clase CinePlusFacade que implementa os metodos de ICinePlus y se encarga de realizar las llamadas a los diferentes metodos del servidor.
 *
 */
public class CinePlusFacade extends UnicastRemoteObject implements ICinePlus{
	
	
	private static final long serialVersionUID = 1L;
	private CinePlusServer cpser;
	
	/**
	 * Constructor de la clase CinePlusFacade
	 * @throws RemoteException
	 */
	public CinePlusFacade() throws RemoteException {
		super();
		this.cpser=new CinePlusServer();
	}

	/**
	 * Metodo que se encarga de llamar a registrarUsuario de CinePlusServer parasandole los parametros y devuelve un true si se ha podido registrar.
	 */
	public boolean registrarUsuario(String usuario, String email, String nombre, String apellido, String password, String pais, boolean admin)  throws RemoteException {
		return cpser.registrarUsuario(usuario, email, nombre, apellido, password, pais, admin);
	}
	
	/**
	 * Metodo que se encarga de llamar al metodo de registrarUsuario de CinePlusServer con parametros (anyadiendo el saldo), y devuelve true si se ha podido registrar.
	 */
	public boolean registrarUsuario(String usuario, String email, String nombre, String apellido, String password, String pais, float saldo, boolean admin)  throws RemoteException {
		return cpser.registrarUsuario(usuario, email, nombre, apellido, password, pais, saldo, admin);
	}

	/**
	 * Metodo que se encarga de llamar al metodo de usuarioRegistrado de CinePlusServer para mirar si un usuario con una contraseña existe en la base de datos.
	 */
	public boolean usuarioRegistrado(String usuario, String password) throws RemoteException {
		return cpser.usuarioRegistrado(usuario, password);
	}
	
	/**
	 * Metodo que se encarga de llamar al metodo de Busqueda de CinePlusServer  pasandole el nombre, anyo y genero y devuelve una lista de peliculas.
	 */
	public List<Pelicula> Busqueda(String nombre, String anyo,String genero) throws RemoteException {
		return cpser.Busqueda(nombre, anyo,genero);
	}
	
	/**
	 * Metodo que se encarga de llamar al metodo de getPeliUsuario de CinePlusServer , que devuelve la lista de peliculas de un usuario identificado con el email.
	 */
	public List<Pelicula> getPeliUsuario(String email) throws RemoteException {
		return cpser.getPeliUsuario(email);
	}
	
	/**
	 * Metodo que se encarga de llamar al metodo Anyos de CinePlusServer y devuelve una lista con los años de las pelicualas.
	 */
	public List<String> Anyos() throws RemoteException {
		return cpser.Anyos();
	}

	/**
	 * Metodo que se encarga de llamar al metodo Alquilar de CinePlusServer pasandole un objeto PelisPerfil y nos devuelve un true si se ha podido realizar.
	 */
	public boolean Alquilar(PelisPerfil PelisPerfil) throws RemoteException {
		return cpser.Alquilar(PelisPerfil);
	}
	
	/**
	 * Metodo que se encarga de llamar al metodo Generos de CinePlusServer y devuelve una lista con los generos de las peliculas. 
	 */
	public List<String> Generos() throws RemoteException {
		return cpser.Generos();
	}
	
	/**
	 * Metodo que se encarga de llamar al metodo devuelveUsuario de CinePlusServer, pasandole un email de usuario y devuelve el usuario completo.
	 */
	@Override
	public Usuario devuelveUsuario(String usuario) throws RemoteException {
		return cpser.devuelveUsuario(usuario);
	}
	
	/**
	 * Metodo que se encarga de llamar al metodo actualizarUsuario de CinePlusServer, pasandole un objeto usuario y se encarga de actualizarlo.
	 */
	@Override
	public void actualizarUsuario(Usuario user) throws RemoteException {
		cpser.actualizarUsuario(user);
	}
	
	/**
	 * Metodo que se encarga de llamar al metodo actualizarUsuario de CinePlusServer pasandole un objeto usuario y se encarga de eliminarlo.
	 */
	@Override
	public void eliminarUsuario(Usuario user) throws RemoteException {
		cpser.actualizarUsuario(user);
	}
	
	/**
	 * Metodo que se encarga de llamar al metodo checkUsuario de CinePlusServer, para comprobar si existe el usuario.
	 */
	@Override
	public boolean checkUsuario(Usuario user) throws RemoteException {
		return cpser.checkUsuario(user);
	}
	
}
