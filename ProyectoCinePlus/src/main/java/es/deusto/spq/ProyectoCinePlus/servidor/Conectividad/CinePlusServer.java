package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import es.deusto.spq.ProyectoCinePlus.cliente.util.GUI.VentanaRegistro;
import es.deusto.spq.ProyectoCinePlus.servidor.DAO.PeliculaDAO;
import es.deusto.spq.ProyectoCinePlus.servidor.DAO.UsuarioDAO;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;

public class CinePlusServer extends UnicastRemoteObject implements ICinePlus{
	//Maantener esto para unir sesion de usuario/servidor para los metodos o(?)
	private UsuarioDAO usuarioDAO;
	private PeliculaDAO peliculaDAO;
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(CinePlusServer.class.getName());
	
	public CinePlusServer () throws RemoteException {
		super();
		usuarioDAO=new UsuarioDAO();
        //usuarioDAO.storeUsuario(new Usuario("mikel", "spq@gmail.com", "mikel", "fernandez", "spq", "españa", false));
        //List<Usuario> a=new ArrayList<>();
        //a.add(new Usuario("spq", "spq@gmail.com", "spq", "spq", "spq", "spq", false));
        //usuarioDAO.storeUsuario(new Usuario("spq", "spq@gmail.com", "spq", "spq", "spq", "spq", false));
        peliculaDAO= new PeliculaDAO();
        //peliculaDAO.storePelicula(new Pelicula(1, "Cadena perpetua", 142, "vida de prisioneros", 1994, "Drama", 14));
        //TODO una busqueda test
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

	public synchronized List<Pelicula> Busqueda(String nombre, String anyo, String genero) {
		//Devuelve una lista de peliculas
		//FIXME no se si esta comprobacion habria que hacerla al principio y enviar un determinado string y posteriormente comprobarlo con equals
		//Por ejemplo hacer que el string=="vacio" al enviar y que luego lo compruebe
		//Lo de abajo seria el concepto si envia null
		logger.info("NOMBRE="+nombre+" anyo="+anyo+" genero="+genero);
//		if(anyo==null && genero==null) {return peliculaDAO.getPeliculas(nombre,"a","a");}
//		else if(anyo==null) {return peliculaDAO.getPeliculas(nombre,"a",genero);}
//		else if(genero==null) {return peliculaDAO.getPeliculas(nombre,anyo,"a");}
//		else {
//		return peliculaDAO.getPeliculas(nombre,anyo,genero);}
		return peliculaDAO.getPeliculas();
	}

	@Override
	public Usuario devuelveUsuario(String email) throws RemoteException {
		// TODO Auto-generated method stub
		return usuarioDAO.getUsuario(email);
	}

	@Override
	public void actualizarUsuario(Usuario user) throws RemoteException {
		// TODO Auto-generated method stub
		usuarioDAO.updateUsuario(user);
	}
	

}