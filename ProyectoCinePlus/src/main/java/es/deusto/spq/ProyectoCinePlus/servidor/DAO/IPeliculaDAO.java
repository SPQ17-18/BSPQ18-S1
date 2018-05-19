/** @package  es.deusto.spq.ProyectoCinePlus.servidor.DAO
*   @brief Interfaz de Objetos e implementacion. May 17, 2018
*
*   Se trata de las interfaz que ofrece los servicios de DAO.
*   
*/

package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import java.util.List;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;

/**
 * @author Fercol
 * @package es.deusto.spq.ProyectoCinePlus.servidor.DAO
 * @version 1.0.0
 * @since May 17, 2018
 * 
 * 
 * Interfaz remota de PeliculaDAO. Esta es implementada por
 * la clase PeliculaDAO para realizar las consultas a la base de datos
 * de los objetos de Pelicula.
 *
 */
public interface IPeliculaDAO {
	
	/**
	 * Metodo que realiza una consulta a la base de datos para aniadir una pelicula y 
	 * devuelve un true si la pelicula se ha podido almacenar.
	 * 
	 * @param Pelicula - Pelicula
	 */
	public void storePelicula(Pelicula Pelicula);
	
	
	/**
	 * Metodo que realiza una consulta a la base de datos con los parametros nombre, anyo y genero
	 * para comprobar si existe una pelicula en la base de datos que cumple con estas condiciones.
	 * En caso de que exista, devolvera un true. 
	 * 
	 * @param nombre - String
	 * @param anyo - String
	 * @param genero - String
	 * @return <code>true</code> si exsite la pelicula que cumple con las condiciones.
	 */
	public List<Pelicula> getPeliculas(String nombre,String anyo,String genero);

}

