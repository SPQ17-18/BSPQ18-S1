package es.deusto.spq.ProyectoCinePlus.cliente.util.conectividad;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.RMIServiceLocator;
import es.deusto.spq.ProyectoCinePlus.servidor.DAO.PeliculaDAO;
import es.deusto.spq.ProyectoCinePlus.servidor.DAO.UsuarioDAO;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;

public class CinePlusControllerTest {

	private String usuario;
	private String email;
	private String nombre;
	private String apellido;
	private String password;
	private String pais;
	private float saldo;
	private boolean admin;
	private String nombrePeli;
	private String anyo;
	private String genero;
	private Usuario user;
	private Pelicula pelicula1;
	private static PeliculaDAO peliculaDAO;
	private static UsuarioDAO usuarioDAO;
	private static RMIServiceLocator rsl;

	@BeforeClass
	public static void setUpClass() {
		rsl = new RMIServiceLocator();
		peliculaDAO = new PeliculaDAO();
		usuarioDAO = new UsuarioDAO();
	}
	
	@Before
	public void setUp() throws Exception {
		usuario = "Javi";
		email = "javi@gmail.com";
		nombre = "Javi";
		apellido = "Fernandez";
		password = "P@ssw0rd";
		pais = "España";
		saldo = 10;
		admin = true;
		nombrePeli = "Star Trek";
		anyo = "2009";
		genero = "Ciencia ficcion";
		user = new Usuario (usuario, email, nombre, apellido, password, pais, admin);
		pelicula1 = new Pelicula (1, "Cadena perpetua", 142, "vida de prisioneros", 1994, "Drama", 14,null,"14");
		peliculaDAO.storePelicula(pelicula1);
		usuarioDAO.storeUsuario(user);
	}

	@Test
	public void RegistrarUsuarioTest() throws RemoteException {
		assertTrue(rsl.getCinePlusService().registrarUsuario(usuario, email, nombre, apellido, password, pais, admin));
	}

	@Test
	public void RegistrarUsuario2Test() throws RemoteException {
		assertTrue(rsl.getCinePlusService().registrarUsuario(usuario, email, nombre, apellido, password, pais, saldo, admin));
	}
	
	@Test
	public void LoginUsuarioTest() throws RemoteException {
		assertTrue(rsl.getCinePlusService().usuarioRegistrado(usuario, password));
	}
	
	@Test
	public void ObtenerAnyoTest() throws RemoteException {
		assertTrue(rsl.getCinePlusService().Anyos().size() > 0);
	}
	
	@Test
	public void ObtenerGeneroTest() throws RemoteException {
		assertTrue(rsl.getCinePlusService().Generos().size() >0);
	}
	
	@Test
	public void BusquedaTest() throws RemoteException {
		assertTrue(rsl.getCinePlusService().Busqueda(nombrePeli, anyo,genero).size() > 0);
	}
	
	@Test
	public void DevolverUsuarioTest() throws RemoteException {
		assertEquals(rsl.getCinePlusService().devuelveUsuario(email), user);
	}
	
	/*
	@Test
	public void eliminarUsuarioTest() throws RemoteException {
		 rsl.getCinePlusService().eliminarUsuario(user);
	}
	*/
	
}