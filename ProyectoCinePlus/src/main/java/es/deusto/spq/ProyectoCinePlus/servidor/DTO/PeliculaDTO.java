package es.deusto.spq.ProyectoCinePlus.servidor.DTO;

import java.util.ArrayList;
import java.util.List;

public class PeliculaDTO {
		
		private int id_pelicula;
		private String nombre;
		private int duracion;
		private String descripcion;
		private int anyo;
		private String categoria;
		private float precio;
		private List<UsuarioDTO> usuariosList = new ArrayList<UsuarioDTO>();
		
		public PeliculaDTO(int id_pelicula, String nombre, int duracion, String descripcion, int anyo, String categoria,
				 float precio, List<UsuarioDTO> usuariosList) {
			super();
			this.id_pelicula = id_pelicula;
			this.nombre = nombre;
			this.duracion = duracion;
			this.descripcion = descripcion;
			this.anyo = anyo;
			this.categoria = categoria;
			this.precio = precio;
			this.usuariosList = usuariosList;
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

		public List<UsuarioDTO> getUsuariosList() {
			return usuariosList;
		}

		public void setUsuariosList(List<UsuarioDTO> usuariosList) {
			this.usuariosList = usuariosList;
		}
		
}
