package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICinePlus extends Remote {
	public boolean registrarUsuario(String usuario, String email, String nombre, String apellido, String password, String pais, boolean admin) throws RemoteException;
	public boolean usuarioRegistrado(String usuario, String password) throws RemoteException;//Busca el usuario
}
