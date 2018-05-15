/** @package es.deusto.spq.ProyectoCinePlus.servidor.DATA
    @brief Clase Usuario. May 15, 2018

    Esta es la clase de usuario, con los respectivos parametros de datanucleus para crear las tablas de la base de datos. 
    Con esta clase definimos el objeto de Usuario.
*/
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
 * Esta es la clase Usuario. Aqu� se define como es el objeto usuario con sus atributos. 
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
	 * @param usuario - String
	 * @param email - String
	 * @param nombre - String
	 * @param apellido - String
	 * @param password - String
	 * @param pais - String
	 * @param admin - boolean
	 * @param peliculasList - List<Pelicula>
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
	 * Constructor con parametros de Usuario.
	 * @param usuario - String
	 * @param email - String
	 * @param nombre - String
	 * @param apellido - String
	 * @param password - String
	 * @param pais - String
	 * @param admin - boolean
	 * @param saldo - float
	 * @param peliculasList - List<Pelicula>
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
	 * Constructor con parametros de Usuario.
	 * @param usuario - String
	 * @param email - String
	 * @param nombre - String
	 * @param apellido - String
	 * @param password - String
	 * @param pais - String
	 * @param admin - boolean
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
	 * M�todo getUsuario
	 * @return usuario - String
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * M�todo setUsuario
	 * @param usuario - String
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * M�todo getEmail
	 * @return email - String
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * M�todo setEmail
	 * @param email - String
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * M�todo getNombre
	 * @return nombre - String
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * M�todo setNombres
	 * @param nombre - String
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * M�todo getApellidos
	 * @return apellido - String
	 */
	public String getApellido() {
		return apellido;
	}
	/**
	 * M�todo setApellido
	 * @param apellido - String
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * M�todo getPassword
	 * @return password - password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * M�todo setPassword
	 * @param password - password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * M�todo getPais
	 * @return pais - String
	 */
	public String getPais() {
		return pais;
	}
	/**
	 * M�todo getPais
	 * @param pais - String
	 */ 
	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * M�todo getPeliculasList
	 * @return peliculasList - List<Pelicula>
	 */
	public List<Pelicula> getPeliculasList() {
		return peliculasList;
	}
	/**
	 * M�todo setPeliculasList
	 * @param peliculasList - List<Pelicula>
	 */
	public void setPeliculasList(List<Pelicula> peliculasList) {
		this.peliculasList = peliculasList;
	}
	/**
	 * M�todo isAdmin
	 * @return admin - boolean
	 */
	public boolean isAdmin() {
		return admin;
	}
	/**
	 * M�todo setAdmin
	 * @param admin - boolean
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	/**
	 * M�todo getSaldo
	 * @return saldo - float
	 */
	public float getSaldo() {
		return saldo;
	}
	/**
	 * M�todo setSaldo
	 * @param saldo - float
	 */
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	/**
	 * M�todo que copia un usuario
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
	 * M�todo ToString
	 * @return String
	 */
	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", email=" + email + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", password=" + password + ", pais=" + pais + ", admin=" + admin + ", saldo=" + saldo
				+ ", peliculasList=" + "]";
	}
	
}
