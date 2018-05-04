package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;

public interface ICinePlus extends Remote {
	public boolean registrarUsuario(String usuario, String email, String nombre, String apellido, String password, String pais, boolean admin) throws RemoteException;
	public boolean registrarUsuario(String usuario, String email, String nombre, String apellido, String password, String pais, float saldo, boolean admin) throws RemoteException;
	public boolean usuarioRegistrado(String usuario, String password) throws RemoteException;//Busca el usuario
	public List<Pelicula> Busqueda(String nombre, String anyo, String genero)throws RemoteException;//Busca peliculas
	public Usuario devuelveUsuario(String email) throws RemoteException;//Devuelve usuario
	public void actualizarUsuario(Usuario user) throws RemoteException;
	public List<String> Anyos() throws RemoteException;
	public List<String> Generos() throws RemoteException;
	public void eliminarUsuario(Usuario user)throws RemoteException;
	
}
