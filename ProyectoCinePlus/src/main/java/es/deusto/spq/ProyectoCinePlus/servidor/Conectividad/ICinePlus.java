package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.PelisPerfil;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;

/**
 * 
 * @author Aritzmetal
 * @version 3.0.3
 * @since May 17, 2018
 * 
 * Interfaz remota del Servidor CinePlusServer Esta es implementada por
 * CinePlusFacade para realizar la conexion remota
 *
 */
public interface ICinePlus extends Remote {

	/**
	 * <h3>Nivel --- Interfaz Remota</h3>
	 * 
	 * Metodo que realiza el registro de un usuario y devuelve el resultado del
	 * proceso de insercion
	 * 
	 * @param usuario usuario 
	 * @param email email
	 * @param nombre nombre
	 * @param apellido apellido
	 * @param password contrasenia
	 * @param pais pais
	 * @param admin admin
	 * 
	 * @return <code>true</code> si se ha registrado correctamente
	 * 
	 * @throws RemoteException lanza excepcion
	 */
	public boolean registrarUsuario(String usuario, String email, String nombre, String apellido, String password,
			String pais, boolean admin) throws RemoteException;

	/**
	 * <h3>Nivel --- Interfaz Remota</h3>
	 * 
	 * Metodo que realiza el registro de usuario y devuelve el resultado del proceso
	 * y ademas se inicia con un @param saldo
	 * 
	 * @param usuario user
	 * @param email email
	 * @param nombre nombre
	 * @param apellido apellido
	 * @param password contrasenia
	 * @param pais pais
	 * @param saldo saldo 
	 * @param admin admin
	 * 
	 * @return <code>true</code> si se ha registrado correctamente
	 * 
	 * @throws RemoteException lanza excepcion
	 * 
	 */
	public boolean registrarUsuario(String usuario, String email, String nombre, String apellido, String password,
			String pais, float saldo, boolean admin) throws RemoteException;

	/**
	 * <h3>Nivel --- Interfaz Remota</h3>
	 * 
	 * Metodo utilizado para comprobar la existencia de un usuario
	 * 
	 * @param usuario usuario
	 * @param password password
	 * 
	 * @return <code>true</code> si se ha encontrado el usuario
	 * @throws RemoteException lanza excepcion
	 */
	public boolean usuarioRegistrado(String usuario, String password) throws RemoteException;

	/**
	 * <h3>Nivel --- Interfaz Remota</h3>
	 * 
	 * @since 2.0
	 * 
	 * Metodo utilizado para obtener una lista de peliculas
	 * 
	 * @param nombre nombre
	 * @param anyo anyio
	 * @param genero genero
	 * 
	 * @return lista de pelis con las peliculas con parametros
	 *         indicados
	 * @throws RemoteException lanza excepcion
	 */
	public List<Pelicula> Busqueda(String nombre, String anyo, String genero) throws RemoteException;

	/**
	 * <h3>Nivel --- Interfaz Remota</h3>
	 * 
	 * @since 2.0
	 * 
	 * Metodo utilizado para buscar las pelis que tiene un usuario
	 * 
	 * @param email email
	 * 
	 * @return lista de pelis con las peliculas del usuario
	 * @throws RemoteException lanza excepcion
	 */
	public List<Pelicula> getPeliUsuario(String email) throws RemoteException;

	/**
	 * <h3>Nivel --- Interfaz Remota</h3>
	 * 
	 * Metodo utilizado para devolver un usuario pasandole un email
	 * 
	 * @param email email
	 * 
	 * @return usuario correspondiente
	 * @throws RemoteException lanza excepcion
	 */
	public Usuario devuelveUsuario(String email) throws RemoteException;

	/**
	 * <h3>Nivel --- Interfaz Remota</h3>
	 * 
	 * Metodo utilizado para actualizar la informacion de un usuario
	 * 
	 * @param user usuario
	 * 
	 * @throws RemoteException lanza excepcion
	 */
	public void actualizarUsuario(Usuario user) throws RemoteException;

	/**
	 * <h3>Nivel --- Interfaz Remota</h3>
	 * 
	 * @since 2.1
	 * 
	 * Metodo utilizado para alquilar una pelicula seleccionada
	 * 
	 * 
	 * @param PelisPerfil pelis
	 * 
	 * @return <code>true</code> si se ha alquilado correctamente
	 * @throws RemoteException lanza excepcion
	 */
	public boolean Alquilar(PelisPerfil PelisPerfil) throws RemoteException;

	/**
	 * <h3>Nivel --- Interfaz Remota</h3>
	 * 
	 * @since 2.0
	 * 
	 * Metodo que devuelve una lista con los anyos disponibles
	 * 
	 * @return lista de anios lista con anyos
	 * @throws RemoteException lanza excepcion
	 */
	public List<String> Anyos() throws RemoteException;

	/**
	 * <h3>Nivel --- Interfaz Remota</h3>
	 * 
	 * @since 2.0
	 * 
	 * Metodo que devuelve una lista con los generos disponibles
	 * 
	 * @return lista de generos lista con generos
	 * @throws RemoteException lanza excepcion
	 */
	public List<String> Generos() throws RemoteException;

	/**
	 * <h3>Nivel --- Interfaz Remota</h3>
	 * 
	 * @since 2.0
	 * 
	 * Metodo que elimina un usuario especificado en la base de datos
	 * 
	 * @param user usuario
	 * @throws RemoteException lanza excepcion
	 */
	public void eliminarUsuario(Usuario user) throws RemoteException;

	/**
	 * <h3>Nivel --- Interfaz Remota</h3>
	 * 
	 * @since 2.0
	 * 
	 * Metodo que comprueba si un usuario se encuentra en la base de datos
	 * 
	 * @param user usuario
	 * @return <code>true</code> si el usuario existe
	 * @throws RemoteException lanza excepcion
	 */
	public boolean checkUsuario(Usuario user) throws RemoteException;

}
