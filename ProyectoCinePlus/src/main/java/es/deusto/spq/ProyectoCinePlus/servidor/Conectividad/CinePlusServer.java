package es.deusto.spq.ProyectoCinePlus.servidor.Conectividad;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;

import es.deusto.spq.ProyectoCinePlus.cliente.util.GUI.VentanaPrincipal;
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
	public static String pathn=(System.getProperty("user.dir")+ "\\src\\main\\resources\\images\\films\\");
	public CinePlusServer () throws RemoteException{
		super();
		Usuario mikel = new Usuario("mikel", "mikelspq@gmail.com", "mikel", "fernandez", "spq", "españa", false);
		Usuario spq = new Usuario("spq", "spq@gmail.com", "spq", "spq", "spq", "spq", false);
		//FIXME meter dos try catch para los duplicados(?)
		List<Usuario> listUsuarios=new ArrayList<>();
        listUsuarios.add(spq);
		usuarioDAO=new UsuarioDAO();
        
        peliculaDAO= new PeliculaDAO();
        peliculaDAO.storePelicula(new Pelicula(1, "Cadena perpetua", 142, "vida de prisioneros", 1994, "Drama", 14, listUsuarios,"14"));
        peliculaDAO.storePelicula(new Pelicula(2, "Alternativa", 140, "vida de prisioneros 2", 1995, "Suspense", 15, listUsuarios,"15"));

		usuarioDAO.storeUsuario(mikel);
		usuarioDAO.storeUsuario(spq);


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
//FIXME meter un catch de null pointer
		logger.info("NOMBRE="+nombre+" anyo="+anyo+" genero="+genero);

		List<Pelicula> a=new ArrayList<Pelicula>();
		List<Pelicula> aux=new ArrayList<Pelicula>();
		a=peliculaDAO.getPeliculas(nombre,anyo,genero);
		System.out.println("ESTOY EN CINEPLUS TAMAÑO="+a.size());
		String nombre1=nombre.toLowerCase();
		String anyo1=anyo.toLowerCase();
		String genero1=genero.toLowerCase();
		int it=0;
//		for(Pelicula p:a) {
		int cont=0;
		for(Pelicula p:a) {
			System.out.println("CONT p1="+cont);
			try {
			System.out.println(p.getNombre());
			}catch(NullPointerException e) {
				System.out.println("CONT p2="+cont);
				System.out.println("Null pointer");
			}
		}
		for(int j=0;j<a.size();j++) {
		//	if(it<(a.size()-1)) {//
			it++;
			String nom=a.get(j).getNombre().toLowerCase();
			String any=""+a.get(j).getAnyo();
			String gen=a.get(j).getCategoria().toLowerCase();
			System.out.println("NOMBRE PARAM="+nombre1);
			System.out.println("NOMBRE PELI="+nom);
			System.out.println("anyo PARAM="+anyo1);
			System.out.println("anyo PELI="+any);
			System.out.println("genero PARAM="+genero1);
			System.out.println("genero PELI="+gen);
			if(nom.contains(nombre1) && anyo1.equals(any) && genero1.equals(gen)) {
				System.out.println("AÑADIENDO PELI="+a.get(j));
				System.out.println("A LA LISTA AUX DE TAMAÑO="+aux.size());
				aux.add(a.get(j));
				System.out.println("Se ha añadido el p="+a.get(j).getDescripcion());
			}
		//}
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