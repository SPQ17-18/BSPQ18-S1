/** @package es.deusto.spq.ProyectoCinePlus.servidor.DATA
    @brief Clase Pelicula. May 17, 2018
    @since 1.0.0

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
 * Esta es la clase Pelicula. Aqui se define como es el objeto pelicula con sus atributos. 
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
	 * 
	 * @param id_pelicula int con identificador unico
	 * @param nombre String con el nombre de la pelicula
	 * @param duracion int con la duracion en minutos de la pelicula
	 * @param descripcion String con breve descripcion de menos de 150 palabras
	 * @param anyo int con el anyo de pelicula
	 * @param categoria String con la categoria de la pelicula
	 * @param precio float con el precio de la pelicula en euros
	 * @param usuariosList List<Usuario> lista de usuarios que poseen la pelicula
	 * 									(este campo no se usa - introduce null por favor)
	 * @param portada String nombre de la imagen de portada
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
	 * Constructor Pelicula con parametros pero sin lista de alquilados
	 * 
	 * @param id_pelicula int con identificador unico
	 * @param nombre String con el nombre de la pelicula
	 * @param duracion int con la duracion en minutos de la pelicula
	 * @param descripcion String con breve descripcion de menos de 150 palabras
	 * @param anyo int con el anyo de pelicula
	 * @param categoria String con la categoria de la pelicula
	 * @param precio float con el precio de la pelicula en euros
	 * @param portada String nombre de la imagen de portada
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
	 * Metodo getId_pelicula
	 * @return id_pelicula int
	 */
	public int getId_pelicula() {
		return id_pelicula;
	}
	/**
	 * Metodo setId_pelicula
	 * @param id_pelicula int
	 */
	public void setId_pelicula(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}
	/**
	 * Metodo getNombre
	 * @return nombre String
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo setNombre
	 * @param nombre String
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo getDuracion
	 * @return duracion int
	 */
	public int getDuracion() {
		return duracion;
	}
	/**
	 * Metodo setDuracion
	 * @param duracion int
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	/**
	 * Metodo getDescripcion
	 * @return descripcion String
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * Metodo setDescripcion
	 * @param descripcion String
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * Metodo getAnyo
	 * @return anyo int
	 */
	public int getAnyo() {
		return anyo;
	}
	/**
	 * Metodo setAnyo
	 * @param anyo int
	 */
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	/**
	 * Metodo getCategoria
	 * @return categoria String
	 */
	public String getCategoria() {
		return categoria;
	}
	/**
	 * Metodo setCategoria
	 * @param categoria String
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	/**
	 * Metodo getPrecio
	 * @return precio float
	 */
	public float getPrecio() {
		return precio;
	}
	/**
	 * Metodo setPrecio
	 * @param precio - float
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}


	/**
	 * Metodo getPortada
	 * @return - String
	 */
	public String getPortada() {
		return portada;
	}
	/**
	 * Metodo setPortada
	 * @param portada String
	 */
	public void setPortada(String portada) {
		this.portada = portada;
	}
	/**
	 * Metodo que copia una pelicula
	 * @param peli Pelicula a copiar
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
	 * Metodo ToString
	 * @return String con todos los campos del objeto
	 */
	@Override
	public String toString() {
		return "Pelicula [id_pelicula=" + id_pelicula + ", nombre=" + nombre + ", duracion=" + duracion
				+ ", descripcion=" + descripcion + ", anyo=" + anyo + ", categoria=" + categoria + ", precio=" + precio
				+ ", portada=" + portada + "]";
	}
	
	
	
}