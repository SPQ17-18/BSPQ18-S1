package es.deusto.spq.ProyectoCinePlus.cliente.util.Datos;

import java.util.Date;

public class Cliente {
	private int id_cliente;
	private String nombre;
	private String apellidos;
	private Date fecha_nacimiento;
	private String calle;
	private String ciudad;
	private String pais;
	
	public Cliente(int id_cliente, String nombre, String apellidos, Date fecha_nacimiento, String calle, String ciudad,
			String pais) {
		this.id_cliente = id_cliente;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fecha_nacimiento = fecha_nacimiento;
		this.calle = calle;
		this.ciudad = ciudad;
		this.pais = pais;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
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
