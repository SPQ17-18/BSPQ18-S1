package es.deusto.spq.ProyectoCinePlus.servidor.DAO;



//Tiene la funcion de DAO + JDO
public class InventarioDAO {

	private int id_inventario;
	private int disponibles;
	private int pelicula;
	
	public InventarioDAO(int id_inventario, int disponibles, int pelicula) {
		this.id_inventario = id_inventario;
		this.disponibles = disponibles;
		this.pelicula = pelicula;
	}

	public int getId_inventario() {
		return id_inventario;
	}

	public void setId_inventario(int id_inventario) {
		this.id_inventario = id_inventario;
	}

	public int getDisponibles() {
		return disponibles;
	}

	public void setDisponibles(int disponibles) {
		this.disponibles = disponibles;
	}

	public int getPelicula() {
		return pelicula;
	}

	public void setPelicula(int pelicula) {
		this.pelicula = pelicula;
	}
	
	
	
}
