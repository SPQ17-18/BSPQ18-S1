package es.deusto.spq.ProyectoCinePlus.cliente.util.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.CinePlusController;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import java.awt.Panel;
import javax.swing.JButton;

public class VentanaUsuario extends JFrame {

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
	
	private JSeparator separator_2;
	private JSeparator separator_3;
	
	private JComboBox comboBox;
	private JComboBox comboBoxAnio; 
	private JScrollPane scrollPane;
	private JLabel lblpeliculas;
	private JSeparator separator;
	private JLabel lblnumpelis;
	
	protected ResourceBundle resourceBundle;
	private JButton btnCerrarSesion;
	private JPanel panel_27;
	private JPanel panel_28;
	private JPanel panel_29;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaUsuario frame = new VentanaUsuario();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	} 

	/**
	 * Create the frame.
	 */
	public VentanaUsuario(CinePlusController controller, ResourceBundle resourceBundle) {
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
		
		label_2 = new JLabel("NomUser");
		label_2.setFont(new Font("Segoe UI", Font.ITALIC, 18));
		panel_16.add(label_2);
		
		panel_17 = new JPanel();
		panel_7.add(panel_17);
		panel_17.setLayout(new GridLayout(3, 1, 0, 0));
		
		lblpeliculas = new JLabel(resourceBundle.getString("number_films_msg"));
		panel_17.add(lblpeliculas);
		
		separator = new JSeparator();
		panel_17.add(separator);
		
		lblnumpelis = new JLabel("8 peliculas");
		lblnumpelis.setFont(new Font("Segoe UI", Font.ITALIC, 18));
		panel_17.add(lblnumpelis);
		
		
		panel_19 = new JPanel();
		panel_7.add(panel_19);
		panel_19.setLayout(new GridLayout(3, 1, 0, 0));
		
		label_3 = new JLabel(resourceBundle.getString("balance_msg"));
		panel_19.add(label_3);
		
		separator_3 = new JSeparator();
		panel_19.add(separator_3);
		
		lblSaldo = new JLabel("Saldo");
		lblSaldo.setFont(new Font("Segoe UI", Font.ITALIC, 18));
		panel_19.add(lblSaldo);
		
		panel_18 = new JPanel();
		panel_7.add(panel_18);
		panel_18.setLayout(new GridLayout(3, 1, 0, 0));
		
		panel_28 = new JPanel();
		panel_18.add(panel_28);
		
		panel_27 = new JPanel();
		panel_18.add(panel_27);
		
		btnCerrarSesion = new JButton(resourceBundle.getString("logout_msg"));
		panel_27.add(btnCerrarSesion);
		
		panel_29 = new JPanel();
		panel_18.add(panel_29);
		
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
		textFieldNombrePeli.setColumns(10);
		
		panel_22 = new JPanel();
		panel_12.add(panel_22);
		
		lblAnio = new JLabel(resourceBundle.getString("year_msg"));
		panel_22.add(lblAnio);
		
		panel_21 = new JPanel();
		panel_12.add(panel_21);
		
		comboBoxAnio = new JComboBox();
		panel_21.add(comboBoxAnio);
		
		panel_23 = new JPanel();
		panel_12.add(panel_23);
		
		lblGnero = new JLabel(resourceBundle.getString("kind_msg"));
		panel_23.add(lblGnero);
		
		panel_20 = new JPanel();
		panel_12.add(panel_20);
		
		comboBox = new JComboBox();
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
