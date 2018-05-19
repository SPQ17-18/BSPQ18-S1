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
	 * 
	 * @param usuario String con nombre del usuario
	 * @param email String con el email del usuario
	 * @param nombre String con nombre de la persona fisica
	 * @param apellido String con apellido de la persona fisica
	 * @param password String con contrasenya de mas de 6 caracteres
	 * @param pais String con el pais actual de residencia
	 * @param admin boolean <code>true</code> si es admin
	 * @param peliculasList List<Pelicula> lista de peliculas alquiladas
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
	 * @param usuario String con nombre del usuario
	 * @param email String con el email del usuario
	 * @param nombre String con nombre de la persona fisica
	 * @param apellido String con apellido de la persona fisica
	 * @param password String con contrasenya de mas de 6 caracteres
	 * @param pais String con el pais actual de residencia
	 * @param admin boolean <code>true</code> si es admin
	 * @param saldo float con el saldo base
	 * @param peliculasList List<Pelicula> lista de peliculas alquiladas
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
	 * @param usuario String con nombre del usuario
	 * @param email String con el email del usuario
	 * @param nombre String con nombre de la persona fisica
	 * @param apellido String con apellido de la persona fisica
	 * @param password String con contrasenya de mas de 6 caracteres
	 * @param pais String con el pais actual de residencia
	 * @param admin boolean <code>true</code> si es admin
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
	 * @return usuario String
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * Metodo setUsuario
	 * @param usuario String
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * Metodo getEmail
	 * @return email String
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Metodo setEmail
	 * @param email - String
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Metodo getNombre
	 * @return nombre String
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo setNombres
	 * @param nombre String
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo getApellidos
	 * @return apellido String
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * Metodo setApellido
	 * @param apellido String
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
	 * @return pais String
	 */
	public String getPais() {
		return pais;
	}
	/**
	 * Metodo getPais
	 * @param pais String
	 */ 
	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * Metodo getPeliculasList
	 * @return peliculasList List<Pelicula>
	 */
	public List<Pelicula> getPeliculasList() {
		return peliculasList;
	}
	/**
	 * Metodo setPeliculasList
	 * @param peliculasList List<Pelicula>
	 */
	public void setPeliculasList(List<Pelicula> peliculasList) {
		this.peliculasList = peliculasList;
	}
	/**
	 * Metodo isAdmin
	 * @return admin boolean
	 */
	public boolean isAdmin() {
		return admin;
	}
	/**
	 * Metodo setAdmin
	 * @param admin - boolean
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
	 * Metodo ToString
	 * @return String con todos los campos de la clase
	 */
	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", email=" + email + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", password=" + password + ", pais=" + pais + ", admin=" + admin + ", saldo=" + saldo
				+ ", peliculasList=" + "]";
	}
	
}
