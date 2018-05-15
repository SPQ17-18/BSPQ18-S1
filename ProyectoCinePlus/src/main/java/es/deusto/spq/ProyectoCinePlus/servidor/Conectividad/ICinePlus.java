package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.PelisPerfil;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;

/**
 * 
 * @author Aritz
 * @package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad
 * @version 3.0.3
 * @since May 17, 2018
 * 
 * Interfaz remota del Servidor CinePlusServer
 * Esta es implementada por @class CinePlusFacade
 * para realizar la conexion remota
 *
 */
public interface ICinePlus extends Remote {
	
	/**
	 * Metodo que realiza el registro de un usuario y devuelve 
	 * el resultado del proceso de insercion
	 * --------------
	 * @param usuario
	 * @param email
	 * @param nombre
	 * @param apellido
	 * @param password
	 * @param pais
	 * @param admin
	 * --------------
	 * @return boolean registrado/no registrado
	 * 
	 * @throws RemoteException
	 */
	
	public boolean registrarUsuario(String usuario, String email, String nombre, String apellido, String password, String pais, boolean admin) throws RemoteException;
	
	
	/**
	 * --------------
	 * @param usuario
	 * @param email
	 * @param nombre
	 * @param apellido
	 * @param password
	 * @param pais
	 * +
	 * @param saldo
	 * +
	 * @param admin
	 * --------------
	 * @return boolean registrado/no registrado
	 * 
	 * @throws RemoteException
	 * 
	 */
	
	public boolean registrarUsuario(String usuario, String email, String nombre, String apellido, String password, String pais, float saldo, boolean admin) throws RemoteException;
	
	
	
	public boolean usuarioRegistrado(String usuario, String password) throws RemoteException;//Busca el usuario
	
	public List<Pelicula> Busqueda(String nombre, String anyo, String genero)throws RemoteException;//Busca peliculas
	
	public List<Pelicula> getPeliUsuario(String email)throws RemoteException;//Busca peliculas
	
	public Usuario devuelveUsuario(String email) throws RemoteException;//Devuelve usuario
	
	public void actualizarUsuario(Usuario user) throws RemoteException;
	
	public boolean Alquilar(PelisPerfil PelisPerfil) throws RemoteException;
	
	public List<String> Anyos() throws RemoteException;
	
	public List<String> Generos() throws RemoteException;
	
	public void eliminarUsuario(Usuario user)throws RemoteException;
	
	public boolean checkUsuario(Usuario user) throws RemoteException;
	
}
