package es.deusto.spq.ProyectoCinePlus.servidor.DATA;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.Join;
import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable
@Inheritance(strategy = InheritanceStrategy.NEW_TABLE)
public class Usuario {

	private String usuario;
	private String email;
	private String nombre;
	private String apellido;
	private String password;
	private String pais;
	private boolean admin;
	private float saldo;
	@Join
	private List<Pelicula> peliculasList = new ArrayList<Pelicula>();

	public Usuario() {
		
	}
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
	public List<Pelicula> getPeliculasList() {
		return peliculasList;
	}
	public void setPeliculasList(List<Pelicula> peliculasList) {
		this.peliculasList = peliculasList;
	}
	
	public boolean isAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	

	public void copiarUsuario(Usuario user) {
		
		this.usuario = user.usuario;
		this.email = user.email;
		this.nombre = user.nombre;
		this.apellido = user.apellido;
		this.password = user.password;
		this.pais = user.pais;
		this.admin = user.admin;
		this.saldo = user.saldo;
		for (int i = 0; i < user.getPeliculasList().size(); i++) {
			this.peliculasList.add(user.getPeliculasList().get(i));
		}
		
	}
	
}
