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
	//Maantener esto para unir sesion de usuario/servidor para los metodos o(?)
	private UsuarioDAO usuarioDAO;
	private PeliculaDAO peliculaDAO;
	static Logger logger = Logger.getLogger(CinePlusServer.class.getName());
	private static final long serialVersionUID = 1L;
	
	public CinePlusServer () throws RemoteException {
		super();
		usuarioDAO=new UsuarioDAO();
        usuarioDAO.storeUsuario(new Usuario("mikel", "spq@gmail.com", "mikel", "fernandez", "spq", "españa", false));
        usuarioDAO.storeUsuario(new Usuario("spq", "spq@gmail.com", "spq", "spq", "spq", "spq", false));
        List<Usuario> a=new ArrayList<>();
        a.add(new Usuario("mikel", "spq@gmail.com", "mikel", "fernandez", "spq", "españa", false));
        peliculaDAO= new PeliculaDAO();
        peliculaDAO.storePelicula(new Pelicula(1, "Cadena perpetua", 142, "vida de prisioneros", 1994, "Drama", 14, a));
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

		List<Pelicula> a=new ArrayList<Pelicula>();
		List<Pelicula> aux=new ArrayList<Pelicula>();
		a=peliculaDAO.getPeliculas(nombre,anyo,genero);
		System.out.println("ESTOY EN CINEPLUS TAMAÑO="+a.size());
		String nombre1=nombre.toLowerCase();
		String anyo1=anyo.toLowerCase();
		String genero1=genero.toLowerCase();
		int it=0;
		for(Pelicula p:a) {
			if(it<(a.size()-1)) {
			it++;
			String nom=p.getNombre().toLowerCase();
			String any=""+p.getAnyo();
			String gen=p.getCategoria().toLowerCase();
			System.out.println("NOMBRE PARAM="+nombre1);
			System.out.println("NOMBRE PELI="+nom);
			System.out.println("anyo PARAM="+anyo1);
			System.out.println("anyo PELI="+any);
			System.out.println("genero PARAM="+genero1);
			System.out.println("genero PELI="+gen);
			if(nom.contains(nombre1) && anyo1.equals(any) && genero1.equals(gen)) {
				System.out.println("AÑADIENDO PELI="+p);
				System.out.println("A LA LISTA AUX DE TAMAÑO="+aux.size());
				aux.add(p);
				System.out.println("Se ha añadido el p="+p.getDescripcion());
			}
		}
		//System.out.println("aux 1="+aux.get(0).getId_pelicula());
		}
		return aux;
//		return peliculaDAO.getPeliculas(nombre,anyo,genero);
	}
	
	@Override
	public Usuario devuelveUsuario(String email) throws RemoteException {
		return usuarioDAO.getUsuario(email);
	}

	@Override
	public boolean actualizarUsuario(Usuario user) throws RemoteException {
		return usuarioDAO.updateUsuario(user);
	}

	@Override
	public List<String> Anyos() throws RemoteException {
		return peliculaDAO.Anyos();
	}

	@Override
	public List<String> Generos() throws RemoteException {
		return peliculaDAO.Generos();
	}
}