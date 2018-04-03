package es.deusto.spq.ProyectoCinePlus.servidor.DAO;

public class DireccionDAO {

	private int id_direccion;
	private String calle;
	private String ciudad;
	private String pais;
	
	public DireccionDAO(int id_direccion, String calle, String ciudad, String pais) {
		this.id_direccion = id_direccion;
		this.calle = calle;
		this.ciudad = ciudad;
		this.pais = pais;
	}

	public int getId_direccion() {
		return id_direccion;
	}

	public void setId_direccion(int id_direccion) {
		this.id_direccion = id_direccion;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
	
}
