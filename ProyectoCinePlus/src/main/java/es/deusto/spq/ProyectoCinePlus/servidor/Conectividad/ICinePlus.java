package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICinePlus extends Remote {
	public void registrarUsuario(String nombre, String contrasenya, String correo) throws RemoteException;
	public int UsuarioRegistrado(String nombre, String contrasenya) throws RemoteException;//Busca el usuario
}
