package es.deusto.spq.ProyectoCinePlus.servidor.DATA;

import java.io.Serializable;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.ForeignKeyAction;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

/**
 * <h3>Nivel --- DATA</h3>
 * 
 * Esta es la clase PelisPerfil. Aqui se define como es el objeto PelisPerfil
 * con sus atributos.
 * 
 * @since 3.0.0
 *
 */
@PersistenceCapable
public class PelisPerfil implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Persistent
	@ForeignKey(name="email", deleteAction=ForeignKeyAction.RESTRICT)
	private String email;
	@ForeignKey(name="id_pelicula", deleteAction=ForeignKeyAction.RESTRICT)
	private int id_pelicula;
	
	/**
	 * Constructor de PelisPerfil
	 * 
	 * @param email String con el mail del usuario
	 * @param id_pelicula int con el identificador individual de la pelicula
	 */
	public PelisPerfil(String email,int id_pelicula) {
		this.email=email;
		this.id_pelicula=id_pelicula;
	}
	
	/**
	 * Metodo getEmail
	 * @return email String que devuelve el mail del propietario
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Metodo setEmail
	 * @param email String con el email a modificar
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Metodo getId_pelicula
	 * @return id_pelicula int con el identificador de la pelicula
	 */
	public int getId_pelicula() {
		return id_pelicula;
	}


}
