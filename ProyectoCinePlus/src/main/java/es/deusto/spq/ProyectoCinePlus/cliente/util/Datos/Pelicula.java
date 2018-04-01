package es.deusto.spq.ProyectoCinePlus.cliente.util.Datos;

public class Pelicula {
	private int id_pelicula;
	private String nombre;
	private int duracion;
	private String descripcion;
	private int anyo;
	private String categoria;
	private int disponibles;
	private float precio;
	
	public Pelicula(int id_pelicula, String nombre, int duracion, String descripcion, int anyo, String categoria,
		int disponibles, float precio) {
		this.id_pelicula = id_pelicula;
		this.nombre = nombre;
		this.duracion = duracion;
		this.descripcion = descripcion;
		this.anyo = anyo;
		this.categoria = categoria;
		this.disponibles = disponibles;
		this.precio = precio;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
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

	public int getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(int disponibles) {
		this.disponibles = disponibles;
	}

}
