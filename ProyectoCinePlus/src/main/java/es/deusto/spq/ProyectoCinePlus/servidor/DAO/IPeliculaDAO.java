package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import java.util.List;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;

/**
 *
 * @package es.deusto.spq.ProyectoCinePlus.servidor.DAO
 * @version 1.0.0
 * @since May 17, 2018
 * @author Fercol
 * 
 * Interfaz remota de PeliculaDAO. Esta implementada por
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
	 * Metodo que realiza una consulta a la base de datos para almacenar un objeto, 
	 * y devuelve un true si se ha podido almacenar. 
	 *  
	 * @param Pelicula - Pelicula
	 */
	public void storeObject(Pelicula Pelicula);
	
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

