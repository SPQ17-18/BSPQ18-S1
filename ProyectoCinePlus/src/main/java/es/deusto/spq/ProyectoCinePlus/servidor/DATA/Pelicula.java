package es.deusto.spq.ProyectoCinePlus.servidor.DATA;

import java.io.Serializable;
import java.util.List;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable (detachable = "true")
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Pelicula implements Serializable{
	
	/**
	 * 
	 */
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

	public int getId_pelicula() {
		return id_pelicula;
	}

	public void setId_pelicula(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public float getPrecio() {
		return precio;
	}

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

	public String getPortada() {
		return portada;
	}

	public void setPortada(String portada) {
		this.portada = portada;
	}
	
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

	@Override
	public String toString() {
		return "Pelicula [id_pelicula=" + id_pelicula + ", nombre=" + nombre + ", duracion=" + duracion
				+ ", descripcion=" + descripcion + ", anyo=" + anyo + ", categoria=" + categoria + ", precio=" + precio
				+ ", portada=" + portada + "]";
	}
	
	
	
}