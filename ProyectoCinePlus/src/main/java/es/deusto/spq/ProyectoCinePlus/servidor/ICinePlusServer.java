package es.deusto.spq.ProyectoCinePlus.servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICinePlusServer extends Remote{

	public boolean registerUser(String usuario, String email, String nombre, String apellido, String password, String pais, boolean admin) throws RemoteException;
	public boolean loginUser(String usuario, String password) throws RemoteException;
	
}
