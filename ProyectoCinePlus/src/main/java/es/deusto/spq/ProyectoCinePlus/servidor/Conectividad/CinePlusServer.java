package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import es.deusto.spq.ProyectoCinePlus.servidor.DAO.IUsuarioDAO;
import es.deusto.spq.ProyectoCinePlus.servidor.DAO.UsuarioDAO;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;
import es.deusto.spq.ProyectoCinePlus.servidor.DAO.UsuarioDAO;

public class CinePlusServer extends UnicastRemoteObject implements ICinePlus{
	//Maantener esto para unir sesion de usuario/servidor para los metodos o(?)
	private UsuarioDAO usuarioDAO;
	private static final long serialVersionUID = 1L;
	
	public CinePlusServer () throws RemoteException {
		super();
		usuarioDAO=new UsuarioDAO();
        usuarioDAO.storeUsuario(new Usuario("mikel", "spq@gmail.com", "mikel", "fernandez", "spq", "españa", false));
//        for(Usuario us: usuarioDAO.getUsuarios()) {
//        	System.out.println("Estamos haciendo algo util");
//        	System.out.println(us.toString());
//        }
	}
	
	public synchronized boolean registrarUsuario(String usuario, String email, String nombre, String apellido, String password,
	String pais, boolean admin) throws RemoteException {
		Usuario user = new Usuario (usuario, email, nombre, apellido, password, pais, admin);
		// 1.- Ese metodo comprueba que no esta el usuario y lo registra
		return usuarioDAO.storeUsuario(user);
	}


	public synchronized boolean usuarioRegistrado (String usuario, String password) throws RemoteException {
		//1.- Ese metodo comprueba que existe el usuaio y que la contraseña es igual
    	
    	 

	        return usuarioDAO.loginUser(usuario, password);
	}
	

}