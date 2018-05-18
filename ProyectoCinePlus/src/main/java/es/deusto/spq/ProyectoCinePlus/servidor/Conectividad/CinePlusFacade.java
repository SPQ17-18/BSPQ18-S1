/** @package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad
*   @brief Fachada del servidor. May 17, 2018
*
*   Se trata de una barrera para evitar mostrar la funcionalidad de los metodos a conexiones externas. 
*   Este sera el primer nivel del servidor.
*/

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
 * Clase CinePlusFacade que implementa los metodos de ICinePlus y se encarga de realizar las llamadas a los diferentes metodos del servidor.
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
	 * @param usuario String con el nombre de usuario dentro de la plataforma
	 * @param email String con el email asociado al usuario
	 * @param nombre String con nombre de la persona fisica
	 * @param apellido String con el apellido de la persona
	 * @param password String contrasenya de 6 caracteres minimo
	 * @param pais String pais de residencia actual
	 * @param admin boolean es administrador o no
	 * 
	 * @return boolean - <code>true</code> si se ha registrado correctamente.
	 * @throws RemoteException
	 */
	public boolean registrarUsuario(String usuario, String email, String nombre, String apellido, String password, String pais, boolean admin)  throws RemoteException {
		return cpser.registrarUsuario(usuario, email, nombre, apellido, password, pais, admin);
	}
	
	/**
	 * Metodo que se encarga de llamar al metodo de registrarUsuario de CinePlusServer con parametros (anyadiendo el saldo), y devuelve true si se ha podido registrar.
	 * @param usuario - String
	 * @param email - String
	 * @param nombre - String
	 * @param apellido - String
	 * @param password - String
	 * @param pais - String
	 * @param saldo - float
	 * @param admin - boolean
	 * 
	 * @return boolean - <code>true</code> si se ha registrado correctamente.
	 * @throws RemoteException
	 */
	public boolean registrarUsuario(String usuario, String email, String nombre, String apellido, String password, String pais, float saldo, boolean admin)  throws RemoteException {
		return cpser.registrarUsuario(usuario, email, nombre, apellido, password, pais, saldo, admin);
	}

	/**
	 * Metodo que se encarga de llamar al metodo de usuarioRegistrado de CinePlusServer para mirar si un usuario con una contrasenya existe en la base de datos.
	 * @param usuario - String
	 * @param password - String
	 * 
	 * @return boolean - <code>true</code> si ha iniciado sesion correctamente.
	 * @throws RemoteException
	 */
	public boolean usuarioRegistrado(String usuario, String password) throws RemoteException {
		return cpser.usuarioRegistrado(usuario, password);
	}
	
	/**
	 * Metodo que se encarga de llamar al metodo de Busqueda de CinePlusServer  pasandole el nombre, anyo y genero y devuelve una lista de peliculas.
	 * @param nombre - String
	 * @param anyo - String
	 * @param genero - String
	 * 
	 * @return List<Pelicula> - Lista con la película buscada
	 * @throws RemoteException
	 */
	public List<Pelicula> Busqueda(String nombre, String anyo,String genero) throws RemoteException {
		return cpser.Busqueda(nombre, anyo,genero);
	}
	
	/**
	 * Metodo que se encarga de llamar al metodo de getPeliUsuario de CinePlusServer , que devuelve la lista de peliculas de un usuario identificado con el email.
	 * 
	 * @param email String con el email del usuario
	 * @return List<Pelicula> - Lista de peliculas del usuario
	 * @throws RemoteException
	 */
	public List<Pelicula> getPeliUsuario(String email) throws RemoteException {
		return cpser.getPeliUsuario(email);
	}
	
	/**
	 * Metodo que se encarga de llamar al metodo Anyos de CinePlusServer y devuelve una lista con los a�os de las pelicualas.
	 * @throws RemoteException
	 */
	public List<String> Anyos() throws RemoteException {
		return cpser.Anyos();
	}

	/**
	 * Metodo que se encarga de llamar al metodo Alquilar de CinePlusServer pasandole un objeto PelisPerfil y nos devuelve un true si se ha podido realizar.
	 * 
	 * @param PelisPerfil 
	 * @return boolean <code>true</code> si ha alquilado una pelicula correctamente.
	 * @throws RemoteException
	 */
	public boolean Alquilar(PelisPerfil PelisPerfil) throws RemoteException {
		return cpser.Alquilar(PelisPerfil);
	}
	
	/**
	 * Metodo que se encarga de llamar al metodo Generos de CinePlusServer y devuelve una lista con los generos de las peliculas. 
	 * @throws RemoteException
	 */
	public List<String> Generos() throws RemoteException {
		return cpser.Generos();
	}
	
	/**
	 * Metodo que se encarga de llamar al metodo devuelveUsuario de CinePlusServer, pasandole un email de usuario y devuelve el usuario completo.
	 *
	 * @param email - String
	 * @return Usuario - Devuelve un usuario
	 * @throws RemoteException
	 */
	@Override
	public Usuario devuelveUsuario(String usuario) throws RemoteException {
		return cpser.devuelveUsuario(usuario);
	}
	
	/**
	 * Metodo que se encarga de llamar al metodo actualizarUsuario de CinePlusServer, pasandole un objeto usuario y se encarga de actualizarlo.
	 *
	 * @param user objeto <code>Usuario</code> a actualizar
	 * @throws RemoteException
	 */
	@Override
	public void actualizarUsuario(Usuario user) throws RemoteException {
		cpser.actualizarUsuario(user);
	}
	
	/**
	 * Metodo que se encarga de llamar al metodo actualizarUsuario de CinePlusServer pasandole un objeto usuario y se encarga de eliminarlo.
	 *
	 * @param user Objeto <code>Usuario</code> a eliminar
	 * @throws RemoteException
	 */
	@Override
	public void eliminarUsuario(Usuario user) throws RemoteException {
		cpser.eliminarUsuario(user);
	}
	
	/**
	 * Metodo que se encarga de llamar al metodo checkUsuario de CinePlusServer, para comprobar si existe el usuario.
	 *
	 * @param user Objeto <code>Usuario</code> a checkear
	 * @throws RemoteException
	 */
	@Override
	public boolean checkUsuario(Usuario user) throws RemoteException {
		return cpser.checkUsuario(user);
	}
	
}
