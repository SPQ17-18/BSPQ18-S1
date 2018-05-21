package es.deusto.spq.ProyectoCinePlus.servidor.DATA;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

/**
 * <h3>Nivel --- DATA</h3>
 * 
 * Esta es la clase Usuario. Aqui se define como es el objeto usuario con sus atributos. 
 * @author Fercol
 *
 */
@PersistenceCapable (detachable = "true")
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Usuario implements Serializable{

	private static final long serialVersionUID = 2L;
	private String usuario;
	@PrimaryKey
	private String email;
	private String nombre;
	private String apellido;
	private String password;
	private String pais;
	private boolean admin;
	private float saldo;
	
	//@Persistent(defaultFetchGroup="true", mappedBy="usuario", dependentElement="true")
	//@Persistent(mappedBy="usuario")
	@Join
	private List<Pelicula> peliculasList;// = new ArrayList<Pelicula>();

	/**
	 * Constructor vacio de la clase Usuario.
	 */
	public Usuario() {
		
	}
	
	/**
	 * Constructor con parametros de Usuario.
	 * @param usuario usuario
	 * @param email correo
	 * @param nombre nombre
	 * @param apellido apellido
	 * @param password contrasenia
	 * @param pais pais
	 * @param admin administrador
	 * @param peliculasList lista de pelis
	 */
	public Usuario(String usuario, String email, String nombre, String apellido, String password, String pais,
			boolean admin, List<Pelicula> peliculasList) {
		super();
		this.usuario = usuario;
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.pais = pais;
		this.admin = admin;
		this.saldo = 0;
		this.peliculasList = peliculasList;
	}
	
	/**
	 * Constructor con parametros de Usuario y un saldo base.
	 * 
	 * @param usuario usuario
	 * @param email correo
	 * @param nombre nombre
	 * @param apellido apellido
	 * @param password contrasenia
	 * @param pais pais
	 * @param admin admin
	 * @param saldo saldo
	 * @param peliculasList lista de peliculas
	 */
	public Usuario(String usuario, String email, String nombre, String apellido, String password, String pais,
			boolean admin, float saldo, List<Pelicula> peliculasList) {
		super();
		this.usuario = usuario;
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.pais = pais;
		this.admin = admin;
		this.saldo = saldo;
		this.peliculasList = peliculasList;
	}
	
	/**
	 * Constructor con parametros de Usuario sin saldo ni lista de peliculas.
	 * 
	 * @param usuario usuario
	 * @param email correo
	 * @param nombre nombre
	 * @param apellido apellido
	 * @param password contrasenia
	 * @param pais pais
	 * @param admin admin
	 */
	public Usuario(String usuario, String email, String nombre, String apellido, String password, String pais,
			boolean admin) {
		super();
		this.usuario = usuario;
		this.email = email;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.pais = pais;
		this.admin = admin;
		this.saldo = 0;
	}

	/**
	 * Metodo getUsuario
	 * @return usuario usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * Metodo setUsuario
	 * @param usuario usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * Metodo getEmail
	 * @return email correo
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Metodo setEmail
	 * @param email email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Metodo getNombre
	 * @return nombre nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo setNombres
	 * @param nombre nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo getApellidos
	 * @return apellido apellido
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * Metodo setApellido
	 * @param apellido apellido
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * Metodo getPassword
	 * @return password password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * Metodo setPassword
	 * @param password password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * Metodo getPais
	 * @return pais pais
	 */
	public String getPais() {
		return pais;
	}
	/**
	 * Metodo getPais
	 * @param pais pais
	 */ 
	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * Metodo getPeliculasList
	 * @return peliculasList lista peliculas
	 */
	public List<Pelicula> getPeliculasList() {
		return peliculasList;
	}
	/**
	 * Metodo setPeliculasList
	 * @param peliculasList lista peliculas
	 */
	public void setPeliculasList(List<Pelicula> peliculasList) {
		this.peliculasList = peliculasList;
	}
	/**
	 * Metodo isAdmin
	 * @return admin admin
	 */
	public boolean isAdmin() {
		return admin;
	}
	/**
	 * Metodo setAdmin
	 * @param admin admin
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	/**
	 * Metodo getSaldo
	 * @return saldo - float
	 */
	public float getSaldo() {
		return saldo;
	}
	/**
	 * Metodo setSaldo
	 * @param saldo - float
	 */
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	/**
	 * Metodo que copia un usuario
	 * @param user - Usuario
	 */
	public void copiarUsuario(Usuario user) {
		this.usuario = user.usuario;
		this.email = user.email;
		this.nombre = user.nombre;
		this.apellido = user.apellido;
		this.password = user.password;
		this.pais = user.pais;
		this.admin = user.admin;
		this.saldo = user.saldo;
//		for (int i = 0; i < user.getPeliculasList().size(); i++) {
//			Pelicula peli = new Pelicula(user.peliculasList.get(i).getId_pelicula(),user.peliculasList.get(i).getNombre(), user.peliculasList.get(i).getDuracion(), user.peliculasList.get(i).getDescripcion(), user.peliculasList.get(i).getAnyo(), user.peliculasList.get(i).getCategoria(), user.peliculasList.get(i).getPrecio(), user.peliculasList.get(i).getPortada());
//			this.peliculasList.add(peli);
//		}
//		
	}
	
	/**
	 * Metodo tostring
	 */
	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", email=" + email + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", password=" + password + ", pais=" + pais + ", admin=" + admin + ", saldo=" + saldo
				+ ", peliculasList=" + "]";
	}
	
}
