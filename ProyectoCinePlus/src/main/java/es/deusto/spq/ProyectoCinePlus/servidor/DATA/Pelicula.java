/** @package es.deusto.spq.ProyectoCinePlus.servidor.DATA
    @brief Clase Pelicula. May 15, 2018

    Esta es la clase de pelicula, con los respectivos parametros de datanucleus para crear las tablas de la base de datos. 
    Con esta clase definimos el objeto de Pelicula.
*/
package es.deusto.spq.ProyectoCinePlus.servidor.DATA;

import java.io.Serializable;
import java.util.List;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

/**
 * Esta es la clase Pelicula. Aquí se define como es el objeto pelicula con sus atributos. 
 * @author Fercol
 *
 */
@PersistenceCapable (detachable = "true")
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Pelicula implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	@PrimaryKey
	private int id_pelicula;
	private String nombre;
	private int duracion;
	private String descripcion;
	private int anyo;
	private String categoria;
	private float precio;
	private String portada;
//	@Join
//	private List<Usuario> usuariosList = new ArrayList<Usuario>();
	
	/**
	 * Contructor Pelicula vacio
	 */
	public Pelicula() {
		
	}
	/**
	 * Constructor Pelicula con parametros
	 * @param id_pelicula - int
	 * @param nombre - String
	 * @param duracion - int
	 * @param descripcion - String
	 * @param anyo - int
	 * @param categoria  - String
	 * @param precio - float
	 * @param usuariosList - List<Usuario>
	 * @param portada - String
	 */
	public Pelicula(int id_pelicula, String nombre, int duracion, String descripcion, int anyo, String categoria,
			 float precio, List<Usuario> usuariosList ,String portada) {
		super();
		this.id_pelicula = id_pelicula;
		this.nombre = nombre;
		this.duracion = duracion;
		this.descripcion = descripcion;
		this.anyo = anyo;
		this.categoria = categoria;
		this.precio = precio;
		//this.usuariosList = usuariosList;
		this.portada = portada;
	}
	/**
	 * Constructor Pelicula con parametros
	 * @param id_pelicula - int
	 * @param nombre - String
	 * @param duracion - int
	 * @param descripcion - String
	 * @param anyo - int
	 * @param categoria  - String
	 * @param precio - float
	 * @param portada - String
	 */
	public Pelicula(int id_pelicula, String nombre, int duracion, String descripcion, int anyo, String categoria,
			 float precio ,String portada) {
		super();
		this.id_pelicula = id_pelicula;
		this.nombre = nombre;
		this.duracion = duracion;
		this.descripcion = descripcion;
		this.anyo = anyo;
		this.categoria = categoria;
		this.precio = precio;
		this.portada = portada;
	}

	/**
	 * Método getId_pelicula
	 * @return id_pelicula - int
	 */
	public int getId_pelicula() {
		return id_pelicula;
	}
	/**
	 * Método setId_pelicula
	 * @param id_pelicula - int
	 */
	public void setId_pelicula(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}
	/**
	 * Método getNombre
	 * @return nombre - String
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Método setNombre
	 * @param nombre - String
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Método getDuracion
	 * @return duracion - int
	 */
	public int getDuracion() {
		return duracion;
	}
	/**
	 * Método setDuracion
	 * @param duracion - int
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	/**
	 * Método getDescripcion
	 * @return descripcion - String
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * Método setDescripcion
	 * @param descripcion - String
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * Método getAnyo
	 * @return anyo - int
	 */
	public int getAnyo() {
		return anyo;
	}
	/**
	 * Método setAnyo
	 * @param anyo - int
	 */
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	/**
	 * Método getCategoria
	 * @return categoria - String
	 */
	public String getCategoria() {
		return categoria;
	}
	/**
	 * Método setCategoria
	 * @param categoria - String
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	/**
	 * Método getPrecio
	 * @return precio - float
	 */
	public float getPrecio() {
		return precio;
	}
	/**
	 * Método setPrecio
	 * @param precio - float
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}

//	public List<Usuario> getUsuariosList() {
//		return usuariosList;
//	}
//
//	public void setUsuariosList(List<Usuario> usuariosList) {
//		this.usuariosList = usuariosList;
//	}
	/**
	 * Método getPortada
	 * @return - String
	 */
	public String getPortada() {
		return portada;
	}
	/**
	 * Método setPortada
	 * @param portada - String
	 */
	public void setPortada(String portada) {
		this.portada = portada;
	}
	/**
	 * Método que copia una pelicula
	 * @param peli - Pelicula
	 */
	public void copiarPelicula(Pelicula peli) {
		
		this.id_pelicula = peli.id_pelicula;
		this.nombre = peli.nombre;
		this.duracion = peli.duracion;
		this.descripcion = peli.descripcion;
		this.anyo = peli.anyo;
		this.categoria = peli.categoria;
		this.precio = peli.precio;
		this.portada = peli.portada;
		
	}
	/**
	 * Método ToString
	 * @return String
	 */
	@Override
	public String toString() {
		return "Pelicula [id_pelicula=" + id_pelicula + ", nombre=" + nombre + ", duracion=" + duracion
				+ ", descripcion=" + descripcion + ", anyo=" + anyo + ", categoria=" + categoria + ", precio=" + precio
				+ ", portada=" + portada + "]";
	}
	
	
	
}