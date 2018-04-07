package es.deusto.spq.ProyectoCinePlus.servidor.DTO;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDTO {

	private String usuario;
	private String email;
	private String nombre;
	private String apellido;
	private String password;
	private String pais;
	private boolean admin;
	private List<PeliculaDTO> peliculasList = new ArrayList<PeliculaDTO>();
	
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public List<PeliculaDTO> getPeliculasList() {
		return peliculasList;
	}
	public void setPeliculasList(List<PeliculaDTO> peliculasList) {
		this.peliculasList = peliculasList;
	}
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
	
}
