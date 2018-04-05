package es.deusto.spq.ProyectoCinePlus.servidor.DTO;

import java.util.Date;

public class AlquilerDTO {

	private int id_alquiler;
	private Date fecha_alquiler;
	private Date fecha_devolucion;
	private int cliente;
	private int inventario;
	
	public AlquilerDTO(int id_alquiler, Date fecha_alquiler, Date fecha_devolucion, int cliente, int inventario) {
		this.id_alquiler = id_alquiler;
		this.fecha_alquiler = fecha_alquiler;
		this.fecha_devolucion = fecha_devolucion;
		this.cliente = cliente;
		this.inventario = inventario;
	}

	public int getId_alquiler() {
		return id_alquiler;
	}

	public void setId_alquiler(int id_alquiler) {
		this.id_alquiler = id_alquiler;
	}

	public Date getFecha_alquiler() {
		return fecha_alquiler;
	}

	public void setFecha_alquiler(Date fecha_alquiler) {
		this.fecha_alquiler = fecha_alquiler;
	}

	public Date getFecha_devolucion() {
		return fecha_devolucion;
	}

	public void setFecha_devolucion(Date fecha_devolucion) {
		this.fecha_devolucion = fecha_devolucion;
	}

	public int getCliente() {
		return cliente;
	}

	public void setCliente(int cliente) {
		this.cliente = cliente;
	}

	public int getInventario() {
		return inventario;
	}

	public void setInventario(int inventario) {
		this.inventario = inventario;
	}
	
	
}
