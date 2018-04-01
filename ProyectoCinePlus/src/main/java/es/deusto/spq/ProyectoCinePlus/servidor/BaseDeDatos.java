package es.deusto.spq.ProyectoCinePlus.servidor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import es.deusto.spq.ProyectoCinePlus.cliente.util.Datos.Alquiler;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Datos.Categoria;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Datos.Cliente;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Datos.Direccion;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Datos.Inventario;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Datos.Pelicula;

public class BaseDeDatos {

	private Connection conexion;
	private static Statement statement;

	/*
	 * metodo que crea una sentencia para acceder a la base de datos
	 */

	public void crearSentencia() {
		try {
			statement = conexion.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * metodo que sirve para conectar con la base de datos
	 */
	public void conectar() {
		try {
			Class.forName("org.sqlite.JDBC");
			conexion = DriverManager.getConnection("jdbc:sqlite:BaseDeDatosUsuarios.db");
			crearSentencia();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("No se ha podido conectar a la base de datos");
			e.printStackTrace();
		}
	}

	/*
	 * metodo que sirve para cerrar una sentencia
	 */
	public void cerrarSentencia() {
		try {
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * metodo que sirve para desconectarse de la base de datos
	 */
	public void desconectar() {
		try {
			cerrarSentencia();
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// constructor
	public BaseDeDatos() {
		conectar();
	}

	// a partir de aqui, implementaremos los metodos para nuestro proyecto
	// VIDEOTHEK
	/**
	 * Este metodo sirve para saber si el usuario introducido en la ventana
	 * principal esta registrado o no.
	 * 
	 * @param nombre:
	 *            nombre introducido por el usuario
	 * @param contrasenya:
	 *            contrasenya introducida por el usuario
	 * @return : 0 - Si no existe el usuario 1 - Si s� existe el usuario pero la
	 *         contrase�a no es correcta 2 - Si el nombre de usuario es correcto
	 *         y la contrase�a tambi�n pero el correo es incorrecto
	 */

	public int UsuarioRegistrado(String nombre, String contrasenya) {
		String query = "SELECT * FROM usuario WHERE nombre = '" + nombre + "'";
		int resultado = 0;
		try {
			ResultSet rs = statement.executeQuery(query);
			if (rs.next())// comprobamos si ha devuelto una fila
			{
				String nom = rs.getString("nombre");
				String con = rs.getString("contrasenya");

				if (!nom.equals(nombre))// comprobamos si el nombre obtenido de
										// la base de datos no es igual al del
										// parametro
				{
					resultado = 0;
				}

				else if (!con.equals(contrasenya)) // comprobamos si la
													// contrase�a obtenida de la
													// base de datos no es igual
													// al del parametro
				{
					resultado = 1;
				}

				else {

					resultado = 2;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultado;

	}

	/**
	 * Este metodo sirve para registrar los usuarios en la base de datos y as�
	 * acceder a la plataforma de VIDEOTHEK.
	 * 
	 * @param nombre:
	 *            El nombre introducido por el usuario
	 * @param contrasenya:
	 *            La contrase�a introducida por el usuario.
	 * @param correo:
	 *            el correo introducido por el usuario.
	 */

	public void registrarUsuario(String nombre, String contrasenya, String correo) {
		String query = "INSERT INTO usuario(nombre,contrasenya,correo) VALUES ('" + nombre + "','" + contrasenya + "','"
				+ correo + "')";
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Este m�todo sirve para saber si un administrador existe en la base de
	 * datos
	 * 
	 * @param usuario:
	 *            El nombre de usuario introducido
	 * @param contrasenya:
	 *            La contrase�a introducida.
	 * @return 0 - Si no existe el administrador 1 - Si s� existe el
	 *         administrador pero la contrase�a no es correcta 2 - Si el nombre
	 *         del administrador es correcto y la contrase�a tambi�n
	 */
	public int adminRegistrado(String usuario, String contrasenya) {
		String query = "SELECT * FROM administrador WHERE usuario = '" + usuario + "'";
		int resul = 0;

		try {
			ResultSet rs = statement.executeQuery(query);
			if (rs.next())// comprobamos si ha devulto una fila
			{
				String usu = rs.getString("usuario");
				String con = rs.getString("contrasenya");

				if (!usu.equals(usuario)) {
					resul = 0;
				}

				else if (!con.equals(contrasenya)) {
					resul = 1;
				}

				else {
					resul = 2;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resul;

	}

	public String devuelveContrasenya(String correo) {
		String query = "SELECT * FROM usuario WHERE correo ='" + correo + "'";
		String contrasenya = "";
		try {
			ResultSet rs = statement.executeQuery(query);
			if (rs.next()) {

				contrasenya = contrasenya + rs.getString("contrasenya");

			} else
				contrasenya = contrasenya + " no hay contrase�a ";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return contrasenya;

	}

	/**
	 * M�todo para obtener una lista de pel�culas de la base de datos:
	 * 
	 * @return
	 */
	public List<Pelicula> obtenerPeliculas() {
		// Creamos nueva lista para guardar las pel�culas que vamos sacando de
		// la base de datos:
		List<Pelicula> arrayPeliculas = new ArrayList<Pelicula>();
		// Obtenemos antes las categorias de la bd:
		List<Categoria> arrayCategorias = obtenerCategorias();
		// Obtenemos antes el inventario de peliculas:
		List<Inventario> arrayInventarios = obtenerInventarios();

		String query = "SELECT * FROM pelicula";
		try {
			ResultSet rs = statement.executeQuery(query);

			while (rs.next() == true) {

				// Vamos almacenando todos los datos de cada una en la lista:
				arrayPeliculas.add(new Pelicula(rs.getInt("id_pelicula"), rs.getString("nombre"), rs.getInt("duracion"),
						rs.getString("descripcion"), rs.getInt("anyo"),
						obtenerCategoria(arrayCategorias, rs.getInt("categoria")),
						obtenerPeliculasDisponibles(arrayInventarios, rs.getInt("id_pelicula")),
						rs.getFloat("precio")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrayPeliculas;
	}

	public List<Categoria> obtenerCategorias() {
		// Creamos nueva lista para guardar las categorias que vamos sacando de
		// la base de datos:
		List<Categoria> arrayCategorias = new ArrayList<Categoria>();

		String query = "SELECT * FROM categoria";
		try {
			ResultSet rs = statement.executeQuery(query);

			while (rs.next() == true) {
				// Vamos almacenando todos los datos de cada una en la lista:
				arrayCategorias.add(new Categoria(rs.getInt("id_categoria"), rs.getString("nombre")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrayCategorias;
	}

	private String obtenerCategoria(List<Categoria> arrayCategorias, int id) {
		String devCategoria = "";
		for (int i = 0; i < arrayCategorias.size(); i++) {
			if (arrayCategorias.get(i).getId_categoria() == id) {
				devCategoria = arrayCategorias.get(i).getNombre();
			}
		}

		return devCategoria;
	}

	public List<Inventario> obtenerInventarios() {
		// Creamos nueva lista para guardar las categorias que vamos sacando de
		// la base de datos:
		List<Inventario> arrayInventarios = new ArrayList<Inventario>();

		String query = "SELECT * FROM inventario";
		try {
			ResultSet rs = statement.executeQuery(query);

			while (rs.next() == true) {
				// Vamos almacenando todos los datos de cada una en la lista:
				arrayInventarios.add(
						new Inventario(rs.getInt("id_inventario"), rs.getInt("disponible"), rs.getInt("pelicula")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrayInventarios;
	}

	private int obtenerPeliculasDisponibles(List<Inventario> arrayInventarios, int id) {
		int devDisponibles = 0;
		for (int i = 0; i < arrayInventarios.size(); i++) {
			if (arrayInventarios.get(i).getPelicula() == id) {
				devDisponibles = arrayInventarios.get(i).getDisponibles();
			}
		}

		return devDisponibles;
	}

	/**
	 * 
	 * @return
	 * @throws ParseException
	 */
	public List<Cliente> obtenerClientes() throws ParseException {
		// Creamos nueva lista para guardar las categorias que vamos sacando de
		// la base de datos:
		List<Cliente> arrayClientes = new ArrayList<Cliente>();
		List<Direccion> arrayDirecciones = obtenerDirecciones();
		int posDIR = 0;
		String query = "SELECT * FROM cliente";
		try {
			ResultSet rs = statement.executeQuery(query);

			while (rs.next() == true) {
				posDIR = obtenerDireccion(arrayDirecciones, rs.getInt("direccion"));
				// Vamos almacenando todos los datos de cada una en la
				// lista:
				try {
					arrayClientes
							.add(new Cliente(rs.getInt("id_cliente"), rs.getString("nombre"), rs.getString("apellido"),
									new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fecha_nac")),
									arrayDirecciones.get(posDIR).getCalle(), arrayDirecciones.get(posDIR).getCiudad(),
									arrayDirecciones.get(posDIR).getPais()));
				} catch (Exception E) {
					arrayClientes.add(new Cliente(rs.getInt("id_cliente"), rs.getString("nombre"),
							rs.getString("apellido"), new SimpleDateFormat("yyyy-MM-dd").parse("1995-07-15"),
							arrayDirecciones.get(posDIR).getCalle(), arrayDirecciones.get(posDIR).getCiudad(),
							arrayDirecciones.get(posDIR).getPais()));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrayClientes;
	}

	/**
	 * 
	 * @return
	 */
	public List<Direccion> obtenerDirecciones() {
		List<Direccion> arrayDirecciones = new ArrayList<Direccion>();

		String query = "SELECT * FROM direccion";
		try {
			ResultSet rs = statement.executeQuery(query);

			while (rs.next() == true) {
				// Vamos almacenando todos los datos de cada una en la lista:
				arrayDirecciones.add(new Direccion(rs.getInt("id_direccion"), rs.getString("calle"),
						rs.getString("ciudad"), rs.getString("pais")));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrayDirecciones;
	}

	/**
	 * 
	 * @param arrayDirecciones
	 * @param id
	 * @return
	 */
	private int obtenerDireccion(List<Direccion> arrayDirecciones, int id) {
		int devDirPOS = 0;
		for (int i = 0; i < arrayDirecciones.size(); i++) {
			if (arrayDirecciones.get(i).getId_direccion() == id) {
				devDirPOS = i;
			}
		}

		return devDirPOS;
	}

	/**
	 * M�todo para obtener el id del cliente de la tabla usuarios:
	 * 
	 * @param user
	 * @return
	 */
	public int obtenerIdCliente(String user) {
		int dev = 0;
		String query = "SELECT * FROM Usuario";
		try {
			ResultSet rs = statement.executeQuery(query);

			while (rs.next() == true) {
				if (user.equals(rs.getString("nombre"))) {
					dev = rs.getInt("cliente");
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return dev;
	}

	/**
	 * 
	 * @return
	 * @throws ParseException
	 */
	public List<Alquiler> obtenerAlquileres() throws ParseException {
		List<Alquiler> arrayAlquileres = new ArrayList<Alquiler>();
		String query = "SELECT * FROM alquiler";
		try {
			ResultSet rs = statement.executeQuery(query);

			while (rs.next() == true) {
				// Vamos almacenando todos los datos de cada una en la lista:
				arrayAlquileres.add(new Alquiler(rs.getInt("id_alquiler"),
						new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fech_alquiler")),
						new SimpleDateFormat("yyyy-MM-dd").parse(rs.getString("fech_devolucion")), rs.getInt("cliente"),
						rs.getInt("inventario")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return arrayAlquileres;
	}

	/**
	 * 
	 * @param id_pelicula
	 */
	public void eliminarPelicula(int id_pelicula) {
		String query = "DELETE FROM pelicula WHERE id_pelicula = " + id_pelicula;
		String query_2 = "DELETE FROM inventario WHERE pelicula = " + id_pelicula;
		try {
			// Primero eliminamos la pel�cula de la tabla pel�cula:
			statement.executeUpdate(query);
			// Segundo eliminamos el inventario donde est� situada la pel�cula
			// en ela tabla inventario:
			statement.executeUpdate(query_2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param nombre
	 * @param duracion
	 * @param descripcion
	 * @param anyo
	 * @param id_categoria
	 * @return
	 */
	public boolean insertarPelicula(String nombre, int duracion, String descripcion, int anyo, int id_categoria,
			float precio) {
		boolean dev = true;
		// No hace falta indicar el id_pelicula a asignar porque es incremental
		String query = "INSERT INTO pelicula(nombre,duracion,descripcion,anyo,categoria,precio) VALUES ('" + nombre
				+ "','" + duracion + "','" + descripcion + "','" + anyo + "','" + id_categoria + "','" + precio + "')";
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "�ERROR NO SE PUDO INSERTAR PELICULA!");
			dev = false;
		}

		return dev;
	}

	/**
	 * 
	 * @param disponibles
	 * @param id_pelicula
	 * @return
	 */
	public boolean insertarInventario(int disponibles, int id_pelicula) {
		boolean dev = true;
		// No hace falta indicar el id_pelicula a asignar porque es incremental
		String query = "INSERT INTO inventario(disponible,pelicula) VALUES ('" + disponibles + "','" + id_pelicula
				+ "')";
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "�ERROR NO SE PUDO INSERTAR EL INVENTARIO!");
			dev = false;
		}

		return dev;
	}

	/**
	 * M�todo para insertar un nuevo alquiler:
	 * 
	 * @param alquiler
	 * @return
	 */
	public boolean insertarAlquiler(Alquiler alquiler) {
		boolean dev = true;
		// No hace falta indicar el id_pelicula a asignar porque es incremental
		String query = "INSERT INTO alquiler(fech_alquiler,fech_devolucion,cliente,inventario) VALUES ('"
				+ alquiler.getFecha_alquiler() + "','" + alquiler.getFecha_devolucion() + "','" + alquiler.getCliente()
				+ "','" + alquiler.getInventario() + "')";
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Se ha alquilado la pelicula correctamente.");
			dev = false;
		}

		return dev;
	}

	/**
	 * M�todo para actualizar la disponibilidad de las peliculas:
	 * 
	 * @param disponibles
	 * @param id_pelicula
	 * @return
	 */
	public boolean actualizarPeliculasDisponibles(int disponibles, int id_pelicula) {
		boolean dev = true;
		// No hace falta indicar el id_pelicula a asignar porque es incremental
		String query = "UPDATE inventario SET disponible='" + disponibles + "'" + "WHERE pelicula='" + id_pelicula
				+ "'";
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "�ERROR NO SE PUDO ACTUALIZAR LA DISPONIBILIDAD DE LA PEL�CULA!");
			dev = false;
		}

		return dev;
	}

	/**
	 * M�todo para actualizar el precio de una pel�cula:
	 * 
	 * @param disponibles
	 * @param id_pelicula
	 * @return
	 */
	public boolean actualizarPrecioPelicula(float precio, int id_pelicula) {
		boolean dev = true;
		// No hace falta indicar el id_pelicula a asignar porque es incremental
		String query = "UPDATE pelicula SET precio='" + precio + "' " + "WHERE id_pelicula='" + id_pelicula + "'";
		try {
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "�ERROR NO SE PUDO ACTUALIZAR EL PRECIO DE LA PEL�CULA!");
			dev = false;
		}

		return dev;
	}
	/**
	 * M�todo para insertar nuevo cliente a partir del registro de un usuario:
	 * 
	 * @param cliente
	 */
	public void insertarCliente(Cliente cliente) {
		// Lo primero es comprobar si la direcci�n donde vive no corresponda ya
		// a una de la base de datos,
		// Si es igual a una de la de la base de datos entonces solo asignaremos
		// el id de esa direcci�n,
		// Si no es igual entonces crearemos una nueva direcci� y le asignaremos
		// la nueva creada:
		List<Direccion> arrayDirecciones = obtenerDirecciones();
		String queryCliente = "";
		boolean direccionRepetida = false;
		int id_direccion_nueva = arrayDirecciones.size() + 1;
		int id_direccion_repetida = 0;
		for (int i = 0; i < arrayDirecciones.size(); i++) {
			if (arrayDirecciones.get(i).getPais().equals(cliente.getPais())
					&& arrayDirecciones.get(i).getCalle().equals(cliente.getCalle())
					&& arrayDirecciones.get(i).getCiudad().equals(cliente.getCiudad())) {
				direccionRepetida = true;
				id_direccion_repetida = i + 1;
			}
		}

		if (direccionRepetida == false) {
			queryCliente = "INSERT INTO cliente(nombre,apellido,fecha_nac,direccion) VALUES ('" + cliente.getNombre()
					+ "','" + cliente.getApellidos() + "','" + cliente.getFecha_nacimiento() + "','"
					+ id_direccion_nueva + "')";
		} else {
			queryCliente = "INSERT INTO cliente(nombre,apellido,fecha_nac,direccion) VALUES ('" + cliente.getNombre()
					+ "','" + cliente.getApellidos() + "','" + cliente.getFecha_nacimiento() + "','"
					+ id_direccion_repetida + "')";
		}
		String queryDireccion = "INSERT INTO direccion(calle,ciudad,pais) VALUES ('" + cliente.getCalle() + "','"
				+ cliente.getCiudad() + "','" + cliente.getPais() + "')";
		try {
			// Si ha puesto una direcci�n nueva:
			if (direccionRepetida == false) {
				statement.executeUpdate(queryDireccion);
			}
			// Sino ponemos la repetida y fuera:
			statement.executeUpdate(queryCliente);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
}
