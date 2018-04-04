package es.deusto.spq.ProyectoCinePlus.cliente.util.Paneles;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import es.deusto.spq.ProyectoCinePlus.servidor.BaseDeDatos;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Datos.Alquiler;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Datos.Categoria;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Datos.Cliente;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Datos.Inventario;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Datos.Pelicula;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import javax.swing.JTextPane;

public class PanelAdministrador extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int anchuraPanel = 1080;
	private int alturaPanel = 720;
	private JTable table;
	private JScrollPane scrollPane;
	private JButton btnMostrarInventarioDe;
	private JButton btnMostrarAlquileresDe;
	private JButton btnMostrarClientes;
	private JButton btnInsertarNuevaPelcula;
	private JButton btnEliminarPelcula;
	private JLabel label;
	private JTextField textFieldNombrePelicula;
	private JComboBox<Integer> comboBoxAnyo;
	private JComboBox<Integer> comboBoxDuracion;
	private JComboBox<String> comboBoxCategoria;
	private JTextPane textPaneDescripcion;
	private JScrollPane scrollPane_2;
	private JButton btnInsertarNuevoInventario;
	private JTextPane textPaneMostrarDescripcion;
	private JScrollPane scrollPane_3;
	private JComboBox<Float> comboBoxPrecio;

	private DefaultTableModel tableModel = new DefaultTableModel();
	private JTable table_1;
	private JScrollPane scrollPane_1;

	/**
	 * Create the panel.
	 */
	public PanelAdministrador() {
		inicializar();
		componentes();
		anyadirComponentes();
		eventos();

		valoresComboBoxCategorias();
		valoresComboBoxAnyos();
		valoresComoboBoxDuraciones();
		valoresComboBoxPrecios();
	}

	private void inicializar() {
		btnMostrarInventarioDe = new JButton("Mostrar inventario de pel\u00EDculas");
		btnMostrarAlquileresDe = new JButton("Mostrar alquileres de pel\u00EDculas");
		btnMostrarClientes = new JButton("Mostrar clientes");
		btnInsertarNuevaPelcula = new JButton("Insertar nueva pel\u00EDcula");
		btnEliminarPelcula = new JButton("Eliminar pel\u00EDcula");
		scrollPane = new JScrollPane();
		table = new JTable();
		label = new JLabel();
		scrollPane_1 = new JScrollPane();
		table_1 = new JTable();
		textFieldNombrePelicula = new JTextField();
		comboBoxAnyo = new JComboBox<Integer>();
		comboBoxDuracion = new JComboBox<Integer>();
		comboBoxCategoria = new JComboBox<String>();
		scrollPane_2 = new JScrollPane();
		textPaneDescripcion = new JTextPane();
		btnInsertarNuevoInventario = new JButton("Insertar nuevo inventario");
		scrollPane_3 = new JScrollPane();
		textPaneMostrarDescripcion = new JTextPane();
		comboBoxPrecio = new JComboBox<Float>();
	}

	private void componentes() {
		btnMostrarInventarioDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMostrarInventarioDe.setBounds(12, 13, 232, 41);
		btnMostrarAlquileresDe.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMostrarAlquileresDe.setBounds(255, 13, 225, 41);
		btnMostrarClientes.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMostrarClientes.setBounds(492, 13, 135, 41);
		btnInsertarNuevaPelcula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInsertarNuevaPelcula.setBounds(12, 535, 185, 41);
		btnEliminarPelcula.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEliminarPelcula.setBounds(418, 535, 232, 41);
		scrollPane.setBounds(12, 67, 1056, 286);
		label.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Insertar pel\u00EDcula",
				TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 120, 215)));
		label.setBounds(12, 582, 1056, 125);
		table.setCellSelectionEnabled(true);
		table.setRowHeight(20);
		table.setGridColor(new Color(0, 51, 102));
		table.setFont(new Font("Tahoma", Font.BOLD, 15));
		table.setSelectionBackground(new Color(0, 0, 153));
		table.setSelectionForeground(new Color(0, 204, 102));
		scrollPane_1.setBounds(12, 356, 1056, 85);
		table_1.setSelectionForeground(new Color(0, 204, 102));
		table_1.setSelectionBackground(new Color(0, 0, 153));
		table_1.setRowHeight(20);
		table_1.setGridColor(new Color(0, 51, 102));
		table_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		table_1.setCellSelectionEnabled(true);
		textFieldNombrePelicula.setBackground(Color.DARK_GRAY);
		textFieldNombrePelicula.setBorder(new TitledBorder(null, "NOMBRE DE LA PELICULA", TitledBorder.CENTER,
				TitledBorder.TOP, null, SystemColor.textHighlight));
		textFieldNombrePelicula.setBounds(22, 598, 205, 94);
		textFieldNombrePelicula.setColumns(10);
		comboBoxAnyo.setBackground(Color.DARK_GRAY);
		comboBoxAnyo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "A\u00D1O",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 120, 215)));
		comboBoxAnyo.setBounds(359, 601, 93, 91);
		comboBoxDuracion.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "DURACION",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 120, 215)));
		comboBoxDuracion.setBackground(Color.DARK_GRAY);
		comboBoxDuracion.setBounds(464, 601, 127, 91);
		comboBoxCategoria.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "CATEGORIA",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 120, 215)));
		comboBoxCategoria.setBackground(Color.DARK_GRAY);
		comboBoxCategoria.setBounds(603, 601, 135, 91);
		scrollPane_2.setBounds(744, 600, 312, 92);
		scrollPane_2.setViewportView(textPaneDescripcion);
		textPaneDescripcion.setBackground(Color.DARK_GRAY);
		textPaneDescripcion.setBorder(new TitledBorder(null, "DESCRIPCION", TitledBorder.CENTER, TitledBorder.TOP, null,
				SystemColor.textHighlight));
		btnInsertarNuevoInventario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnInsertarNuevoInventario.setBounds(209, 535, 197, 41);
		scrollPane_1.setBorder(new TitledBorder(null,
				"Pel\u00EDculas alquiladas por los clientes - Nombre y descripci\u00F3n del cliente en particular",
				TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		textPaneMostrarDescripcion.setForeground(Color.WHITE);
		textPaneMostrarDescripcion.setBackground(Color.DARK_GRAY);
		textPaneMostrarDescripcion.setBorder(new TitledBorder(null,
				"Descripci\u00F3n total de la pel\u00EDcula (primero click en descripci\u00F3n de pel\u00EDcula)",
				TitledBorder.LEADING, TitledBorder.TOP, null, SystemColor.textHighlight));
		scrollPane_3.setBounds(12, 454, 1056, 70);
		comboBoxPrecio.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "PRECIO",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 120, 215)));
		comboBoxPrecio.setBackground(Color.DARK_GRAY);
		comboBoxPrecio.setBounds(233, 601, 114, 91);
	}

	private void anyadirComponentes() {
		setSize(anchuraPanel, alturaPanel);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		setBorder(null);

		add(btnMostrarInventarioDe);
		add(btnMostrarAlquileresDe);
		add(btnMostrarClientes);
		add(btnInsertarNuevaPelcula);
		add(btnEliminarPelcula);
		add(textFieldNombrePelicula);
		add(comboBoxAnyo);
		add(comboBoxDuracion);
		add(comboBoxCategoria);
		add(comboBoxPrecio);
		add(scrollPane_2);
		add(scrollPane);
		add(label);
		add(scrollPane_1);
		add(btnInsertarNuevoInventario);
		add(scrollPane_3);

		scrollPane_3.setViewportView(textPaneMostrarDescripcion);
		scrollPane.setViewportView(table);
		scrollPane_1.setViewportView(table_1);

	}

	private void eventos() {
		btnMostrarInventarioDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPeliculas();
				peliculasAlquiladasEnTabla = false;
				peliculasDescripcionEnTabla = true;
			}
		});
		btnMostrarAlquileresDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mostrarAlquileres();
					peliculasEnTabla = false;
					peliculasAlquiladasEnTabla = true;
					peliculasDescripcionEnTabla = false;
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnMostrarClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mostrarClientes();
					peliculasEnTabla = false;
					peliculasAlquiladasEnTabla = false;
					peliculasDescripcionEnTabla = false;
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnInsertarNuevaPelcula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Antes de insertar hay que comprobar si los campos est�n
				// correctos:
				boolean camposCorrectos = true;
				if (textFieldNombrePelicula.getText().equals("")) {
					camposCorrectos = false;
				}
				if (textPaneDescripcion.getText().equals("")) {
					camposCorrectos = false;
				}

				if (camposCorrectos == true) {
					insertarNuevaPeliculaEnLaBD();
				} else {
					JOptionPane.showMessageDialog(null, "�LOS CAMPOS EST�N INCOMPLETOS!", "�ERROR!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnEliminarPelcula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (peliculasEnTabla == true) {
					if (table.isRowSelected(rowSelected)) {
						// Eliminamos pel�cula:
						DefaultTableModel tm = (DefaultTableModel) table.getModel();
						eliminarPeliculaSeleccionada(Integer.parseInt( (String) tm.getValueAt(table.getSelectedRow(), 0)));
					} else {
						JOptionPane.showMessageDialog(null, "PRIMERO DEBES SELECCIONAR UNA PELICULA A ELIMINAR!",
								"�ERROR!", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "PRIMERO DIRIGETE A LA TABLA DE LAS PELICULAS!", "ERROR!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (peliculasAlquiladasEnTabla == true) {
					if (table.isCellSelected(table.getSelectedRow(), 3)) {
						mostrarClienteDelAlquiler();
					}
					if (table.isCellSelected(table.getSelectedRow(), 4)) {
						mostrarPeliculaAlquiladaDelAlquiler();
					}
				} else if (peliculasDescripcionEnTabla == true) {
					if (table.isCellSelected(table.getSelectedRow(), 3)) {
						mostrarDescripcionDePeliculas();
					} else if (table.isCellSelected(table.getSelectedRow(), 6)) {
						try {
							actualizarPeliculasDisponibles(Integer.parseInt(JOptionPane
									.showInputDialog("Introduzca cantidad de peliculas a poner disponibles: ")));
						} catch (Exception E) {
							JOptionPane.showMessageDialog(null, "OPERACION CANCELADA");
						}
					} else if (table.isCellSelected(table.getSelectedRow(), 7)) {
						try {
							actualizarPrecioPelicula(
									Float.parseFloat(JOptionPane.showInputDialog("Introduzca precio de pel�cula: ")));
						} catch (Exception E) {
							JOptionPane.showMessageDialog(null, "OPERACI�N CANCELADA");
						}
					}
				}
				rowSelected = table.getSelectedRow();
			}
		});
		btnInsertarNuevoInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Primero comprobamos si el usuario ha seleccionado el id de la
				// pel�cula de la tabla:
				if (peliculasEnTabla == true) {
					if (table.isCellSelected(table.getSelectedRow(), 0)) {
						DefaultTableModel tm = (DefaultTableModel) table.getModel();
						int id_pelicula = Integer.parseInt( (String)tm.getValueAt(table.getSelectedRow(), 0));
						insertarNuevoInventario(id_pelicula);
					} else {
						JOptionPane.showMessageDialog(null, "�PRIMERO DEBES SELECCIONAR EL ID PELICULA EN LA TABLA!",
								"�ERROR!", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "�NO EST�S EN LA TABLA DE INVENTARIO DE PEL�CULAS!", "�ERROR!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	private void valoresComboBoxCategorias() {
		BaseDeDatos bd = new BaseDeDatos();
		// Obtenemos primero las categorias de la base de datos:
		List<Categoria> arrayCategorias = bd.obtenerCategorias();
		// Introducimos las categorias en el combiBox:
		for (Categoria c : arrayCategorias) {
			comboBoxCategoria.addItem(c.getNombre());
		}
	}

	private void valoresComboBoxAnyos() {
		// Introducimos a�os desde 2017-1900:
		for (int i = 2017; i > 1900; i--) {
			comboBoxAnyo.addItem(i);
		}
	}

	private void valoresComoboBoxDuraciones() {
		// Introducimos duraciones desde 45 minutos hasta 345 minutos:
		for (int i = 345; i > 45; i--) {
			comboBoxDuracion.addItem(i);
		}
	}

	private void valoresComboBoxPrecios() {
		// Introducimos 100 precios diferentes:
		float precio = 0.25F;
		for (int i = 0; i < 100; i++) {
			comboBoxPrecio.addItem(Redondear(precio, 2));
			precio += 0.25F;
		}
	}

	public float Redondear(float pNumero, int pCantidadDecimales) {
		// the function is call with the values Redondear(625.3f, 2)
		BigDecimal value = new BigDecimal(pNumero);
		value = value.setScale(pCantidadDecimales, RoundingMode.HALF_EVEN); // here
																			// the
																			// value
																			// is
																			// correct
																			// (625.30)
		return value.floatValue(); // but here the values is 625.3
	}

	private int rowSelected = 0;

	private void columnasTabla(int i) {
		// Creacion de las columnas de la tabla:
		if (i == 0) {
			tableModel.addColumn("ID");
			tableModel.addColumn("NOMBRE");
			tableModel.addColumn("DURACION");
			tableModel.addColumn("DESCRIPCION");
			tableModel.addColumn("A�O");
			tableModel.addColumn("CATEGORIA");
			tableModel.addColumn("DISPONIBLES");
			tableModel.addColumn("PRECIO");
		} else if (i == 1) {
			tableModel.addColumn("ID");
			tableModel.addColumn("NOMBRE");
			tableModel.addColumn("APELLIDOS");
			tableModel.addColumn("FECHA NACIMIENTO");
			tableModel.addColumn("CALLE");
			tableModel.addColumn("CIUDAD");
			tableModel.addColumn("PAIS");
		} else if (i == 2) {
			tableModel.addColumn("ID");
			tableModel.addColumn("FECHA DE ALQUILER");
			tableModel.addColumn("FECHA DE DEVOLUCION");
			tableModel.addColumn("N� CLIENTE");
			tableModel.addColumn("N� INVENTARIO");
		}
	}

	private void resaltarColumnas(JTable tabla, int numeroColumnas, int[] columnasAResaltar, boolean coumnaModificable,
			int[] columnaAModificar) {
		for (int i = 0; i < numeroColumnas; i++) {
			// Indicamos como sera el resaltado de la tabla
			for (int j = 0; j < columnasAResaltar.length; j++) {
				if (i == columnasAResaltar[j]) {
					tabla.getColumnModel().getColumn(i)
							.setCellRenderer(new Resaltador(true, coumnaModificable, columnaAModificar));
					break;
				} else {
					tabla.getColumnModel().getColumn(i)
							.setCellRenderer(new Resaltador(false, coumnaModificable, columnaAModificar));
				}
			}
		}
	}

	private boolean peliculasEnTabla = false;
	private boolean peliculasAlquiladasEnTabla = false;
	private boolean peliculasDescripcionEnTabla = false;

	private void mostrarPeliculas() {
		BaseDeDatos bd = new BaseDeDatos();
		tableModel = new DefaultTableModel();
		columnasTabla(0);
		List<Pelicula> arrayPeliculas = bd.obtenerPeliculas();
		for (int i = 0; i < arrayPeliculas.size(); i++) {
			tableModel.addRow(new Object[] { arrayPeliculas.get(i).getId_pelicula(), arrayPeliculas.get(i).getNombre(),
					arrayPeliculas.get(i).getDuracion(), arrayPeliculas.get(i).getDescripcion(),
					arrayPeliculas.get(i).getAnyo(), arrayPeliculas.get(i).getCategoria(),
					arrayPeliculas.get(i).getDisponibles(), arrayPeliculas.get(i).getPrecio() });
		}

		// Introducimos el modelo en la tabla:
		table.setModel(tableModel);
		resaltarColumnas(table, 8, new int[] { 0, 3, 6, 7 }, true, new int[] { 6, 7 });
		peliculasEnTabla = true;
	}

	private void mostrarClientes() throws ParseException {
		BaseDeDatos bd = new BaseDeDatos();
		tableModel = new DefaultTableModel();
		columnasTabla(1);
		List<Cliente> arrayClientes = bd.obtenerClientes();
		for (int i = 0; i < arrayClientes.size(); i++) {
			tableModel.addRow(new Object[] { arrayClientes.get(i).getId_cliente(), arrayClientes.get(i).getNombre(),
					arrayClientes.get(i).getApellidos(), arrayClientes.get(i).getFecha_nacimiento(),
					arrayClientes.get(i).getCalle(), arrayClientes.get(i).getCiudad(),
					arrayClientes.get(i).getPais() });
		}

		// Introducimos el modelo en la tabla:
		table.setModel(tableModel);
		resaltarColumnas(table, 7, new int[] { -1 }, false, new int[] { -1 });
	}

	private void mostrarAlquileres() throws ParseException {
		BaseDeDatos bd = new BaseDeDatos();
		tableModel = new DefaultTableModel();
		columnasTabla(2);
		List<Alquiler> arrayAlquileres = bd.obtenerAlquileres();
		for (int i = 0; i < arrayAlquileres.size(); i++) {
			tableModel.addRow(new Object[] { arrayAlquileres.get(i).getId_alquiler(),
					arrayAlquileres.get(i).getFecha_alquiler(), arrayAlquileres.get(i).getFecha_devolucion(),
					arrayAlquileres.get(i).getCliente(), arrayAlquileres.get(i).getInventario() });
		}

		// Introducimos el modelo en la tabla:
		table.setModel(tableModel);
		resaltarColumnas(table, 5, new int[] { 3, 4 }, false, new int[] { -1 });
	}

	private void mostrarClienteDelAlquiler() {
		// Primero obtener el valor de la celda seleccionada:
		DefaultTableModel tm = (DefaultTableModel) table.getModel();
		int cliente = Integer.parseInt( (String)tm.getValueAt(table.getSelectedRow(), 3));

		// Ahora tenemos que buscar el valor en todos los clientes y si
		// corresponde mostrar el cliente:
		BaseDeDatos bd = new BaseDeDatos();
		tableModel = new DefaultTableModel();
		columnasTabla(1);
		List<Cliente> arrayClientes = null;
		try {
			arrayClientes = bd.obtenerClientes();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < arrayClientes.size(); i++) {
			if (arrayClientes.get(i).getId_cliente() == cliente) {
				// MOstramos el cliente en la tabla de abajo:
				tableModel.addRow(new Object[] { arrayClientes.get(i).getId_cliente(), arrayClientes.get(i).getNombre(),
						arrayClientes.get(i).getApellidos(), arrayClientes.get(i).getFecha_nacimiento(),
						arrayClientes.get(i).getCalle(), arrayClientes.get(i).getCiudad(),
						arrayClientes.get(i).getPais() });
			}
		}

		// Introducimos el modelo en la tabla:
		table_1.setModel(tableModel);
		resaltarColumnas(table_1, 7, new int[] { 0, 1, 2, 3, 4, 5, 6 }, false, new int[] { -1 });
	}

	private void mostrarPeliculaAlquiladaDelAlquiler() {
		// Primero obtener el valor de la celda seleccionada:
		DefaultTableModel tm = (DefaultTableModel) table.getModel();
		int inventario = Integer.parseInt( (String)tm.getValueAt(table.getSelectedRow(), 4));

		BaseDeDatos bd = new BaseDeDatos();
		tableModel = new DefaultTableModel();
		columnasTabla(0);
		List<Pelicula> arrayPeliculas = bd.obtenerPeliculas();
		List<Inventario> arrayInventarios = bd.obtenerInventarios();

		for (int i = 0; i < arrayInventarios.size(); i++) {
			// Buscamos el inventario:
			if (inventario == arrayInventarios.get(i).getId_inventario()) {
				// Buscamos la pel�cula:
				for (int j = 0; j < arrayPeliculas.size(); j++) {
					if (arrayPeliculas.get(j).getId_pelicula() == arrayInventarios.get(i).getPelicula()) {
						// Mostramos la pel�cula:
						tableModel.addRow(new Object[] { arrayPeliculas.get(i).getId_pelicula(),
								arrayPeliculas.get(i).getNombre(), arrayPeliculas.get(i).getDuracion(),
								arrayPeliculas.get(i).getDescripcion(), arrayPeliculas.get(i).getAnyo(),
								arrayPeliculas.get(i).getCategoria(), arrayPeliculas.get(i).getDisponibles(),
								arrayPeliculas.get(i).getPrecio() });
					}
				}
			}
		}

		// Introducimos el modelo en la tabla:
		table_1.setModel(tableModel);
		resaltarColumnas(table_1, 8, new int[] { 0, 1, 2, 3, 4, 5, 6, 7 }, true, new int[] { 6, 7 });
	}

	private void mostrarDescripcionDePeliculas() {
		// Primero obtener el valor de la celda seleccionada:
		DefaultTableModel tm = (DefaultTableModel) table.getModel();
		String descripcion = (String) tm.getValueAt(table.getSelectedRow(), 3);
		textPaneMostrarDescripcion.setText(descripcion);
	}

	/**
	 * M�todo para eliminar pel�cula:
	 * 
	 * @param id_pelicula
	 */
	private void eliminarPeliculaSeleccionada(int id_pelicula) {
		BaseDeDatos bd = new BaseDeDatos();
		bd.eliminarPelicula(id_pelicula);
		JOptionPane.showMessageDialog(null, "La pel�cula ha sido eliminada correctamente.");
	}

	/**
	 * M�todo para actualizar la disponibilidad de una pel�cula a partir de la
	 * celda seleccionada:
	 * 
	 * @param disponibles
	 */
	private void actualizarPeliculasDisponibles(int disponibles) {
		if (disponibles >= 0) {
			DefaultTableModel tm = (DefaultTableModel) table.getModel();
			int id_pelicula = Integer.parseInt( (String) tm.getValueAt(table.getSelectedRow(), 0));

			BaseDeDatos bd = new BaseDeDatos();
			if (bd.actualizarPeliculasDisponibles(disponibles, id_pelicula) == true) {
				JOptionPane.showMessageDialog(null,
						"Pel�cula actualizada correctamente, vuelva a actualizar el panel para ver los cambios.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "�CANTIDAD INCORRECTA!", "ERROR!", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * M�todo para actulizar el precio de una pel�cula a partir de la celda
	 * seleccionada:
	 * 
	 * @param precio
	 */
	private void actualizarPrecioPelicula(float precio) {
		if (precio >= 0) {
			DefaultTableModel tm = (DefaultTableModel) table.getModel();
			int id_pelicula = Integer.parseInt((String) tm.getValueAt(table.getSelectedRow(), 0));

			BaseDeDatos bd = new BaseDeDatos();
			if (bd.actualizarPrecioPelicula(precio, id_pelicula) == true) {
				JOptionPane.showMessageDialog(null,
						"Pel�cula actualizada correctamente, vuelva a actualizar el panel para ver los cambios.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "PRECIO INCORRECTO!", "ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * M�todo para insertar nueva pel�cula:
	 */
	private void insertarNuevaPeliculaEnLaBD() {
		// Primero debemos obtener todos los valores de los campos:
		String nombre = textFieldNombrePelicula.getText();
		String descripcion = textPaneDescripcion.getText();
		float precio = (float) Integer.parseInt((String) comboBoxPrecio.getSelectedItem());
		int anyo = Integer.parseInt((String) comboBoxAnyo.getSelectedItem());
		int duracion = Integer.parseInt((String) comboBoxDuracion.getSelectedItem());
		int id_categoria = 0;
		// El id de la categor�a se saca a partir del nombre:
		BaseDeDatos bd = new BaseDeDatos();
		List<Categoria> arrayCategoria = bd.obtenerCategorias();
		for (Categoria c : arrayCategoria) {
			// Si el nombre cuadra sacamos el id:
			if (c.getNombre().equals(comboBoxCategoria.getSelectedItem())) {
				id_categoria = c.getId_categoria();
			}
		}

		// Finalmente guardamos la pel�cula en la base de datos:
		if (bd.insertarPelicula(nombre, duracion, descripcion, anyo, id_categoria, precio) == true) {
			JOptionPane.showMessageDialog(null,
					"La pel�cula: " + nombre + " ha sido insertada correctamente en la base de datos.");
		}
	}

	/**
	 * M�todo para insertar un nuevo inventario en la base de datos con las
	 * pel�culas disponibles:
	 */
	private void insertarNuevoInventario(int id_pelicula) {
		// Primero comprobar si el id_pelicula seleccionado en la tabla no
		// corresponde ya a alg�n inventario:
		boolean todoCorrecto = true;
		BaseDeDatos bd = new BaseDeDatos();
		List<Inventario> arrayInventario = bd.obtenerInventarios();
		for (Inventario i : arrayInventario) {
			if (i.getPelicula() == id_pelicula) {
				JOptionPane.showMessageDialog(null, "�ESA PEL�CULA YA TIENE ASIGNADO UN INVENTARIO!", "�ERROR!",
						JOptionPane.ERROR_MESSAGE);
				todoCorrecto = false;
				break;
			}
		}

		// Si todo ha ido bien pasamos a introducir la cantidad de pel�culas de
		// la pel�cula en la tabla inventario:
		if (todoCorrecto == true) {
			// Pedimos cantidad de pel�cula para poner a disposici�n de los
			// clientes:
			try {
				int disponibles = Integer.parseInt(JOptionPane.showInputDialog(
						"Introduzca cantidad de pel�culas que desea poner a disposici�n de los clientes: "));
				if (disponibles >= 0) {
					// Insertamos valores en la BD:
					if (bd.insertarInventario(disponibles, id_pelicula) == true) {
						JOptionPane.showMessageDialog(null, "Inventario insertado correctamente. :D");
					}
				} else {
					JOptionPane.showMessageDialog(null, "�CANTIDAD INCORRECTA!", "�ERROR!", JOptionPane.ERROR_MESSAGE);
				}
			} catch (Exception E) {
				JOptionPane.showMessageDialog(null, "OPERACI�N CANCELADA.");
			}
		}
	}

	public class Resaltador implements TableCellRenderer {
		private boolean resaltado;
		private boolean columnaModificable;
		private int[] columna;
		public final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

		/**
		 * Creamos el resaltador indicando que columna se coloreara por defecto
		 * 
		 * @param columna
		 */
		public Resaltador(boolean resaltado, boolean columnaModificable, int[] columna) {
			this.resaltado = resaltado;
			this.columnaModificable = columnaModificable;
			this.columna = columna;
		}
		//TODO aqui había un override que daba error
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			// Obtenemos la celda que se esta renderizando
			Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
					column);
			DEFAULT_RENDERER.setHorizontalAlignment(SwingConstants.CENTER);

			// Solo marcaremos las columnas que quieran ser reslatadas:
			if (resaltado == true) {
				if (isSelected == true) {
					c.setBackground(Color.GREEN);
					c.setForeground(Color.BLACK);
				} else {
					c.setBackground(Color.BLUE);
					c.setForeground(Color.BLACK);
				}

				for (int i = 0; i < columna.length; i++) {
					if (columnaModificable == true && columna[i] == column) {
						c.setBackground(Color.GREEN);
						c.setForeground(Color.RED);
					}
				}

			}
			return c;
		}
	}
}