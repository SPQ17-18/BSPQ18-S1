package es.deusto.spq.ProyectoCinePlus.servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import es.deusto.spq.ProyectoCinePlus.servidor.DAO.UsuarioDAO;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;

public class CinePlusServer extends UnicastRemoteObject implements ICinePlusServer {

	
	private static final long serialVersionUID = 1L;
	private UsuarioDAO usuarioDAO;
	
	
	/**
	 * The server side main method which establish the remote connexion with the client
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("How to invoke: java [policy] [codebase] Server.Server [host] [port] [server]");
			System.exit(0);
		}

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {
			ICinePlusServer objServer = new CinePlusServer();
			Naming.rebind(name, objServer);
			System.out.println("Server '" + name + "' active and waiting...");
			InputStreamReader inputStreamReader = new InputStreamReader(System.in);
			BufferedReader stdin = new BufferedReader(inputStreamReader);
			String line = stdin.readLine();
		} catch (Exception e) {
			System.err.println("Remote exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * @throws RemoteException
	 */
	public CinePlusServer() throws RemoteException {
		super();
		usuarioDAO = new UsuarioDAO();
	}


	@Override
	public boolean registerUser(String usuario, String email, String nombre, String apellido, String password,
			String pais, boolean admin) throws RemoteException {
		// TODO Auto-generated method stub
		Usuario user = new Usuario (usuario, email, nombre, apellido, password, pais, admin);
		return usuarioDAO.storeUsuario(user);
	}


	@Override
	public boolean loginUser(String usuario, String password) throws RemoteException {
		// TODO Auto-generated method stub
		return usuarioDAO.loginUser(usuario, password);
	}
}
