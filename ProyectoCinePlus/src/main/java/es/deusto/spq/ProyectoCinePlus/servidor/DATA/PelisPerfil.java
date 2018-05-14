package es.deusto.spq.ProyectoCinePlus.servidor.DATA;

import java.io.Serializable;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.ForeignKeyAction;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class PelisPerfil implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getId_pelicula() {
		return id_pelicula;
	}


	public void setId_pelicula(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}


	@Persistent
	@ForeignKey(name="email", deleteAction=ForeignKeyAction.RESTRICT)
	private String email;
	@ForeignKey(name="id_pelicula", deleteAction=ForeignKeyAction.RESTRICT)
	private int id_pelicula;

	
	public PelisPerfil(String email,int id_pelicula) {
		this.email=email;
		this.id_pelicula=id_pelicula;
	}
	
	
	
	
}
