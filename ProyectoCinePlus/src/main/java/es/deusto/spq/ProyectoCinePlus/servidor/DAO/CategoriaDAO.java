package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManagerFactory;


//Tiene la funcion de DAO + JDO
public class CategoriaDAO {

	private PersistenceManagerFactory pmf; // Es necesario? No sigo por si acaso LOL
	private int id_categoria;
	private String nombre;
	
	public CategoriaDAO(int id_categoria, String nombre) {
		
		this.id_categoria = id_categoria;
		this.nombre = nombre;
	}
	
	public CategoriaDAO(){
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
