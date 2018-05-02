package es.deusto.spq.ProyectoCinePlus.cliente.util.GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.CinePlusController;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaUsuario extends JFrame {


	private static final long serialVersionUID = 1L;


	private CinePlusController controller;
	
	private JPanel contentPane;
 
	private int anchuraPanel = 1080;
	private int alturaPanel = 720;
	private JTextField textFieldNombrePeli;
	 
	private JLabel lblLogo;
	private JLabel label_3;
	private JLabel lblSaldo;
	private JLabel label;
	private JLabel label_2;
	private JLabel lblNombre;
	private JLabel lblAnio;
	private JLabel lblGnero; 
	
	private JPanel panel;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_1;
	private JPanel panel_14;
	private JPanel panel_15;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_16;
	private JPanel panel_17;
	private JPanel panel_18;
	private JPanel panel_19;
	private JPanel panel_9;
	private JPanel panel_5; 
	private JPanel panel_12; 
	private JPanel panel_24;
	private JPanel panel_22;
	private JPanel panel_21;
	private JPanel panel_23;
	private JPanel panel_20;
	private JPanel panel_13; 
	private JPanel panel_8; 
	private JPanel panel_25; 
	private JPanel panel_26;
	private JPanel panel_30;
	
	private JSeparator separator_2;
	private JSeparator separator_3;
	
	private JComboBox<?> comboBox;
	private JComboBox<?> comboBoxAnio; 
	private JScrollPane scrollPane;
	private JLabel lblpeliculas;
	private JSeparator separator;
	private JLabel lblnumpelis;
	
	protected ResourceBundle resourceBundle;
	private JButton btnCerrarSesion;
	private JPanel panel_27;
	private JPanel panel_28;
	private JPanel panel_29;
	private JButton btnAnadirSaldo;
	private JButton btnBuscar;
	private List<Pelicula> prueba=new ArrayList<Pelicula>();
	static Logger logger = Logger.getLogger(VentanaUsuario.class.getName());
	/**
	 * Create the frame.
	 */

	public VentanaUsuario(CinePlusController controller, ResourceBundle resourceBundle, Usuario userLogeado) {
		logger.info("VentanaUsuario");
		this.controller =controller;
		this.resourceBundle=resourceBundle;
		setTitle(resourceBundle.getString("user_panel_msg"));
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(VentanaPrincipal.pathn+"logocuadrado50.png"));
		} catch (IOException e) {
		}
		setIconImage(img);
		//setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaUsuario.class.getResource("/es/deusto/spq/ProyectoCinePlus/cliente/util/Resources/Imagenes/logocuadrado50.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, anchuraPanel, alturaPanel);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 3, 0, 0));
		
		panel_10 = new JPanel();
		panel.add(panel_10);
		
		lblLogo = new JLabel("");
		
		BufferedImage img2 = null;
		try {
		    img2 = ImageIO.read(new File(VentanaPrincipal.pathn+"logo300.png"));
		} catch (IOException e) {
		}
		ImageIcon a1=new ImageIcon(img2);
		
		//lblLogo.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/es/deusto/spq/ProyectoCinePlus/cliente/util/Resources/Imagenes/logo300.png")));
		panel.add(lblLogo);
		
		panel_11 = new JPanel();
		panel.add(panel_11);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(1, 4, 0, 0));
		
		panel_14 = new JPanel();
		panel_1.add(panel_14);
		
		panel_15 = new JPanel();
		panel_1.add(panel_15);
		
		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.WEST);
		
		panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.EAST);
		
		panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.NORTH);
		
		panel_7 = new JPanel();
		panel_4.add(panel_7, BorderLayout.SOUTH);
		panel_7.setLayout(new GridLayout(0, 4, 0, 0));
		
		panel_16 = new JPanel();
		panel_7.add(panel_16);
		panel_16.setLayout(new GridLayout(3, 1, 0, 0));
		
		label = new JLabel(resourceBundle.getString("welcome_msg"));
		panel_16.add(label);
		
		separator_2 = new JSeparator();
		panel_16.add(separator_2);
		
		label_2 = new JLabel(userLogeado.getUsuario());
		label_2.setFont(new Font("Segoe UI", Font.ITALIC, 18));
		panel_16.add(label_2);
		
		panel_17 = new JPanel();
		panel_7.add(panel_17);
		panel_17.setLayout(new GridLayout(3, 1, 0, 0));
		
		lblpeliculas = new JLabel(resourceBundle.getString("number_films_msg"));
		panel_17.add(lblpeliculas);
		
		separator = new JSeparator();
		panel_17.add(separator);
		
		lblnumpelis = new JLabel(String.valueOf(userLogeado.getPeliculasList().size()));
		lblnumpelis.setFont(new Font("Segoe UI", Font.ITALIC, 18));
		panel_17.add(lblnumpelis);
		
		
		panel_19 = new JPanel();
		panel_7.add(panel_19);
		panel_19.setLayout(new GridLayout(3, 1, 0, 0));
		
		label_3 = new JLabel(resourceBundle.getString("balance_msg"));
		panel_19.add(label_3);
		
		separator_3 = new JSeparator();
		panel_19.add(separator_3);
		
		lblSaldo = new JLabel(String.valueOf(userLogeado.getSaldo()));
		lblSaldo.setFont(new Font("Segoe UI", Font.ITALIC, 18));
		panel_19.add(lblSaldo);
		
		panel_18 = new JPanel();
		panel_7.add(panel_18);
		panel_18.setLayout(new GridLayout(3, 1, 0, 0));
		 
		panel_28 = new JPanel();
		panel_18.add(panel_28);
		
		panel_29 = new JPanel();
		panel_18.add(panel_29);
		
		btnAnadirSaldo = new JButton(resourceBundle.getString("title_balance_msg"));
		btnAnadirSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.info("Boton añadir saldo");
				VentanaSaldo ventanaSaldo = new VentanaSaldo(controller,resourceBundle);
				ventanaSaldo.setVisible(true);
			}
		});
		panel_29.add(btnAnadirSaldo);
		
		panel_27 = new JPanel();
		panel_18.add(panel_27);
		
		btnCerrarSesion = new JButton(resourceBundle.getString("logout_msg"));
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logger.info("Boton cerrar sesion");
				VentanaPrincipal.frame.setVisible(true);
				dispose();
			}
		});
		panel_27.add(btnCerrarSesion);
		
		panel_9 = new JPanel();
		panel_4.add(panel_9, BorderLayout.EAST);
		
		panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		panel_12 = new JPanel();
		panel_5.add(panel_12, BorderLayout.NORTH);
		panel_12.setLayout(new GridLayout(0, 6, 0, 0));
		
		panel_24 = new JPanel();
		panel_12.add(panel_24);
		
		lblNombre = new JLabel(resourceBundle.getString("title_msg"));
		panel_24.add(lblNombre);
		
		panel_25 = new JPanel();
		panel_12.add(panel_25);
		
		textFieldNombrePeli = new JTextField();
		panel_25.add(textFieldNombrePeli);
		textFieldNombrePeli.setColumns(15);//FIXME 10
		//////////////////
		panel_30= new JPanel();
		

		
		btnBuscar = new JButton(resourceBundle.getString("logout_msg"));//FIXME cambiar esto por: buscar
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logger.info("Boton busqueda");
				//TODO añadir la busqueda y linkearlo con la lista de pelis que se muestra
				String nombre=textFieldNombrePeli.getText();
				String anyo="a";
				//FIXME el toString da nullpointer
				if(comboBoxAnio.getSelectedItem().toString()!=null) {anyo=comboBoxAnio.getSelectedItem().toString();}
				String genero="a";
				if(comboBoxAnio.getSelectedItem().toString()!=null) {genero=comboBox.getSelectedItem().toString();}
				System.out.println(nombre);
				System.out.println(anyo);
				System.out.println(genero);
				try {
					System.out.println("Entra en el try");
					prueba=controller.Busqueda(nombre, anyo, genero);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, resourceBundle.getString("error_in_search_msg"), resourceBundle.getString("error_in_search_msg"),
							JOptionPane.WARNING_MESSAGE);
					logger.info("Busqueda sin resultados");
					e.printStackTrace();
				}
				System.out.println("La primera peli:"+prueba.get(0));
				logger.info("Busqueda completada");
			}
		});
		panel_30.add(btnBuscar);
		panel_12.add(panel_30);
		
		panel_22 = new JPanel();
		panel_12.add(panel_22);
		
		lblAnio = new JLabel(resourceBundle.getString("year_msg"));
		panel_22.add(lblAnio);
		
		panel_21 = new JPanel();
		panel_12.add(panel_21);
		
		comboBoxAnio = new JComboBox<Object>();
		List<String> lo = null;
		try {
			lo = controller.ObtenerAnyo();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		comboBoxAnio.setModel(new DefaultComboBoxModel(lo.toArray()));
		panel_21.add(comboBoxAnio);
		
		panel_23 = new JPanel();
		panel_12.add(panel_23);
		
		lblGnero = new JLabel(resourceBundle.getString("kind_msg"));
		panel_23.add(lblGnero);
		
		panel_20 = new JPanel();
		panel_12.add(panel_20);
		
		comboBox = new JComboBox<Object>();
		List<String> ls = null;
		try {
			ls = controller.ObtenerGenero();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		comboBox.setModel(new DefaultComboBoxModel(ls.toArray()));
		panel_20.add(comboBox);
		
		panel_13 = new JPanel();
		panel_5.add(panel_13, BorderLayout.SOUTH);
		
		scrollPane = new JScrollPane();
		panel_5.add(scrollPane, BorderLayout.CENTER);
		
		panel_26 = new JPanel();
		scrollPane.setViewportView(panel_26);
		
		panel_8 = new JPanel();
		panel_4.add(panel_8, BorderLayout.WEST);
	}

	
}
