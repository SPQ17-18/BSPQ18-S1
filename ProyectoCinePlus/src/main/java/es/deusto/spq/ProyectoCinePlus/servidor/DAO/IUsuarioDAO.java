package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import java.rmi.RemoteException;
import java.util.List;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;

/**
 * 
 * @author Fercol
 * @package es.deusto.spq.ProyectoCinePlus.servidor.DAO
 * @version 1.0.0
 * @since May 17, 2018
 * 
 * Interfaz remota del UsuarioDAO. Esta implementada por
 * la clase UsuarioDAO para realizar las consultas a la base de datos
 * de los objetos de Usarios
 *
 */
public interface IUsuarioDAO {

	/**
	 * Metodo que realiza una consulta a la base de datos para aniadir un usuario y 
	 * devuelve un true si el usuario se ha podido almacenar.
	 * 
	 * @param usuario 
	 * @return <code>true</code> si se ha añadido el usuario correctamente
	 */
	public boolean storeUsuario(Usuario usuario);
	
	/**
	 * Metodo que realiza una consulta a la base de datos para almacenar un objeto, 
	 * y devuelve un true si se ha podido almacenar. 
	 * 
	 * @param usuario
	 * @return <code>true</code> si se ha añadido el usuario correctamente
	 */
	public boolean storeObject(Usuario usuario);
	
	/**
	 * Metodo que realiza una consulta a la base de datos con los parametros email y contraseña
	 * para comprobar si existe un usuario en la base de datos que cumple con estas condiciones.
	 * En caso de que exista, devolvera un true. 
	 * 
	 * @param email - String
	 * @param password - String
	 * @return <code>true</code> si el usuario y la contraseña coinciden con las de la Base de datos
	 */
	public boolean loginUser(String email, String password);
	
	/**
	 * Metodo que realiza una consulta a la base de datos y obtiene todos los usuarios de la base de 
	 * datos devolvindolos en una lista. 
	 * 
	 * @return List<Usuario> - Lista con usuarios que cumplen la condicion.
	 */
	public List<Usuario> getUsuarios();
	
	/**
	 * Metodo que realiza una cnsulta a la base de datos y devuelve una lista con los usuarios en una lista.
	 * 
	 * @param condition - Parametro por el que buscar.
	 * @return List<Usuario> - Lista con usuarios que cumplen la condicion.
	 */
	public List<Usuario> getUsuarios(String condition);
	
	/**
	 * Metodo que realiza una consulta a la base de datos y obtiene el objeto usuario que coincida con el 
	 * email que se le pasa. 
	 * 
	 * @param email - String
	 * @return Usuario 
	 */
	public Usuario getUsuario(String email);
	
	/**
	 * Metodo que recbe un usuario y lo actualiza en la base de datos. 
	 * 
	 * @param usuario - Usuario
	 */
	public void updateUsuario(Usuario usuario);
	
	/**
	 * Metodo que recibe un objeto usuario y lo elimina de la base de datos. 
	 * 
	 * @param usuario - Usuario
	 */
	public void deleteUsuario(Usuario usuario);
	

	
}
