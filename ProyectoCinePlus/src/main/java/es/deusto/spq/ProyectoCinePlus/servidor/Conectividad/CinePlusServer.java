package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import es.deusto.spq.ProyectoCinePlus.servidor.DAO.PeliculaDAO;
import es.deusto.spq.ProyectoCinePlus.servidor.DAO.UsuarioDAO;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;

public class CinePlusServer extends UnicastRemoteObject implements ICinePlus{
	private UsuarioDAO usuarioDAO;
	private PeliculaDAO peliculaDAO;
	static Logger logger = Logger.getLogger(CinePlusServer.class.getName());
	private static final long serialVersionUID = 1L;
	public static String pathn=(System.getProperty("user.dir")+ "\\src\\main\\resources\\images\\films\\");
	
	
	public CinePlusServer () throws RemoteException{
		super();
		
		List<Usuario> listUsuarios=new ArrayList<>();
		List<Pelicula> peliculasList = new ArrayList<Pelicula>();
		
		//Peliculas		
        peliculaDAO= new PeliculaDAO();
        Pelicula cadena = new Pelicula(1, "Cadena perpetua", 142, "vida de prisioneros", 1994, "Drama", 1, "14");
        Pelicula alternativa = new Pelicula(2, "Alternativa", 140, "vida de prisioneros 2", 1995, "Suspense", 1, "15");
        Pelicula alien = new Pelicula(3, "Alien", 120, "el octavo pasagero", 1979, "Terror", 1, listUsuarios, "30");
        Pelicula startrek = new Pelicula(4, "Star Trek", 128, "el futuro comienza", 2009, "ciencia ficcion", 2,  "31");
        Pelicula alien3 = new Pelicula(5, "Alien 3", 120, "el regreso", 1979, "Terror", 1, listUsuarios, "32");
        Pelicula startrek2 = new Pelicula(6, "Star Trek 2", 142, "La ira de khan", 1994, "ciencia ficcion", 2, "33");
        Pelicula starwars = new Pelicula(7, "Star Wars", 125, "Una nueva esperanza", 1970, "ciencia ficcion", 3, "34");
        
        peliculaDAO.storePelicula(cadena);
        peliculaDAO.storePelicula(alternativa);
        peliculaDAO.storePelicula(alien);
        peliculaDAO.storePelicula(startrek);
        peliculaDAO.storePelicula(alien3);
        peliculaDAO.storePelicula(startrek2);
        peliculaDAO.storePelicula(starwars);

        peliculasList.add(startrek);
        peliculasList.add(starwars);
        
        //usuarios
        usuarioDAO=new UsuarioDAO();
		Usuario mikel = new Usuario("mikel", "mikelspq@gmail.com", "mikel", "fernandez", "spq", "españa", false);
		Usuario spq = new Usuario("spq", "spq@gmail.com", "spq", "spq", "spq", "spq", false);
		
		//NO FUNCIONA
		//Usuario mikel = new Usuario("mikel", "mikelspq@gmail.com", "mikel", "fernandez", "spq", "españa", false, peliculasList);
		//Usuario spq = new Usuario("spq", "spq@gmail.com", "spq", "spq", "spq", "spq", false, peliculasList);
		
        listUsuarios.add(spq);
        
		usuarioDAO.storeUsuario(mikel);
		usuarioDAO.storeUsuario(spq);


	}
	
	public synchronized boolean registrarUsuario(String usuario, String email, String nombre, String apellido, String password,
	String pais, boolean admin) throws RemoteException {
		Usuario user = new Usuario (usuario, email, nombre, apellido, password, pais, admin);
		// 1.- Ese metodo comprueba que no esta el usuario y lo registra
		return usuarioDAO.storeUsuario(user);
	}

	public synchronized boolean registrarUsuario(String usuario, String email, String nombre, String apellido, String password,
			String pais, float saldo, boolean admin) throws RemoteException {
				Usuario user = new Usuario (usuario, email, nombre, apellido, password, pais, admin);
				user.setSaldo(saldo);
				// 1.- Ese metodo comprueba que no esta el usuario y lo registra
				return usuarioDAO.storeUsuario(user);
			}
	
	public synchronized boolean usuarioRegistrado (String usuario, String password) throws RemoteException {
		//1.- Ese metodo comprueba que existe el usuaio y que la contraseña es igual
        return usuarioDAO.loginUser(usuario, password);
	}


	public synchronized List<Pelicula> Busqueda(String nombre, String anyo, String genero) {
		logger.info("NOMBRE="+nombre+" anyo="+anyo+" genero="+genero);

		List<Pelicula> a=new ArrayList<Pelicula>();
		List<Pelicula> aux=new ArrayList<Pelicula>();
		a=peliculaDAO.getPeliculas(nombre,anyo,genero);
		logger.debug("ESTOY EN CINEPLUS TAMAÑO="+a.size());
		String nombre1=nombre.toLowerCase();
		String anyo1=anyo.toLowerCase();
		String genero1=genero.toLowerCase();
		for(int j=0;j<a.size();j++) {
			String nom=a.get(j).getNombre().toLowerCase();
			String any=""+a.get(j).getAnyo();
			String gen=a.get(j).getCategoria().toLowerCase();
			if(nom.contains(nombre1) && anyo1.equals(any) && genero1.equals(gen)) {
				aux.add(a.get(j));
			}
		}
		return aux;
	}
	
	@Override
	public Usuario devuelveUsuario(String email) throws RemoteException {
		return usuarioDAO.getUsuario(email);
	}

	@Override
	public void actualizarUsuario(Usuario user) throws RemoteException {
		usuarioDAO.updateUsuario(user);
	}

	@Override
	public List<String> Anyos() throws RemoteException {
		return peliculaDAO.Anyos();
	}

	@Override
	public List<String> Generos() throws RemoteException {
		return peliculaDAO.Generos();
	}
	
	public void eliminarUsuario(Usuario user) throws RemoteException {
		usuarioDAO.deleteUsuario(user);
	}
	
	public boolean checkUsuario(Usuario user) throws RemoteException {
		return usuarioDAO.checkUser(user);
	}
	
}