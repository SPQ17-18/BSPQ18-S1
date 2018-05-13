package es.deusto.spq.ProyectoCinePlus.cliente.util.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.CinePlusController;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSeparator;

public class VentanaPelicula extends JFrame {

	private JPanel contentPane;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_2;
	private JPanel panel_12;
	private JPanel panel;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_1; 
	private JPanel panel_14;
	private JPanel panel_16;
	private JPanel panel_20;
	private JPanel panel_19;
	private JPanel panel_17;	
	private JPanel panel_15;
	private JPanel panel_13;
	private JPanel panel_18;
	private JPanel panel_7;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_22;
	private JPanel panel_23;
	private JPanel panel_24;
	private JPanel panel_25;
	private JPanel panel_21;
	private JPanel panel_26;
	private JPanel panel_27;
	private JPanel panel_28;
	private JPanel panel_29;
	private JPanel panel_30;
	
	private JLabel lblCartel;
	private JLabel lblDescripcion;
	private JLabel lblTitulo;
	private JLabel lblDuracion;
	private JLabel lblAo;
	private JLabel lblCategoria;
	
	private JButton btnAlquilar;
	
	private Usuario user;
	private Pelicula peli;
	
	private CinePlusController controller;
	private ResourceBundle resourceBundle;
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(VentanaPrincipal.class.getName());
	private JPanel panel_31;
	private JLabel lblPrecio;
	private JPanel panel_32;
	private JPanel panel_33;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_2;
	private JPanel panel_34;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPelicula frame = new VentanaPelicula();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	
	/**
	 * Create the frame.
	 */
	public VentanaPelicula(CinePlusController controller, ResourceBundle resourceBundle, Usuario userLogeado, Pelicula peliSelect ) {
		
		logger.info("VentanaPelicula");
		this.controller = controller;
		this.resourceBundle = resourceBundle;
		this.user = userLogeado;
		this.peli = peliSelect;
		setTitle(resourceBundle.getString("film_panel_msg"));
		
		/*
		 * O pasamos la peli o la buscamos desde aqui.
		 */
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(VentanaPrincipal.pathn+"films\\"+peli.getPortada()+".jpg"));
		    //img = ImageIO.read(new File(VentanaPrincipal.pathn+"logocuadrado50.png"));
		} catch (IOException e) {
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.WEST);
		
		panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.EAST);
		
		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 4, 0, 0));
		
		panel_12 = new JPanel();
		panel_2.add(panel_12);
		
		panel_10 = new JPanel();
		panel_2.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		panel_22 = new JPanel();
		panel_10.add(panel_22, BorderLayout.SOUTH);
		
		panel_23 = new JPanel();
		panel_10.add(panel_23, BorderLayout.WEST);
		
		panel_25 = new JPanel();
		panel_10.add(panel_25, BorderLayout.CENTER);
		
		btnAlquilar = new JButton(resourceBundle.getString("rent_msg"));
		btnAlquilar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.info("Boton Alquilar (Ventana Pelicula)");
				logger.debug("Recuperamos el saldo antiguo");
				float saldoViejo = userLogeado.getSaldo();
				
				if(saldoViejo >= peli.getPrecio()) {
					
				}else {
					
				}
				
				//Cambiar saldo.
				try {
					logger.info("Actualizamos el saldo del usuario");
					controller.eliminarUsuario(userLogeado);
					logger.info("Actualizamos el saldo del usuario (Saldo Viejo - Precio pelicula)");
					
					saldoViejo -= peli.getPrecio();
					userLogeado.setSaldo(saldoViejo);
					controller.RegistrarUsuario(userLogeado.getUsuario(), userLogeado.getEmail(), userLogeado.getNombre(), userLogeado.getApellido(), userLogeado.getPassword(), userLogeado.getPais(), userLogeado.getSaldo(), userLogeado.isAdmin());
					
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
				
				VentanaUsuario ventanaUsuario = new VentanaUsuario(controller, resourceBundle, userLogeado);
				ventanaUsuario.setVisible(true);
				dispose();
			}
		});
		panel_25.add(btnAlquilar);
		
		panel_24 = new JPanel();
		panel_10.add(panel_24, BorderLayout.EAST);
		
		panel_21 = new JPanel();
		panel_10.add(panel_21, BorderLayout.NORTH);
		
		panel_11 = new JPanel();
		panel_2.add(panel_11);
		panel_11.setLayout(new BorderLayout(0, 0));
		
		panel_26 = new JPanel();
		panel_11.add(panel_26, BorderLayout.NORTH);
		
		panel_30 = new JPanel();
		panel_11.add(panel_30, BorderLayout.CENTER);
		
		JButton btnAtras = new JButton(resourceBundle.getString("back_msg"));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.info("Boton Atras (Ventana Pelicula)");
				VentanaUsuario ventanaUsuario = new VentanaUsuario(controller, resourceBundle, userLogeado);
				ventanaUsuario.setVisible(true);
				dispose();
			}
		});
		panel_30.add(btnAtras);
		
		panel_27 = new JPanel();
		panel_11.add(panel_27, BorderLayout.SOUTH);
		
		panel_29 = new JPanel();
		panel_11.add(panel_29, BorderLayout.EAST);
		
		panel_28 = new JPanel();
		panel_11.add(panel_28, BorderLayout.WEST);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.NORTH);
		
		panel_6 = new JPanel();
		panel.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		
		panel_9 = new JPanel();
		panel.add(panel_9, BorderLayout.EAST);
		panel_9.setLayout(new GridLayout(0, 3, 0, 0));
		
		panel_8 = new JPanel();
		panel.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		panel_14 = new JPanel();
		panel_8.add(panel_14);
		panel_14.setLayout(new GridLayout(3, 0, 0, 0));
		
		panel_16 = new JPanel();
		panel_8.add(panel_16, BorderLayout.SOUTH);
		panel_16.setLayout(new GridLayout(1, 3, 0, 0));
		
		panel_20 = new JPanel();
		panel_16.add(panel_20);
		panel_20.setLayout(new GridLayout(3, 1, 0, 0));
		
		lblCategoria = new JLabel(resourceBundle.getString("kind2_msg"));
		panel_20.add(lblCategoria);
		
		separator = new JSeparator();
		panel_20.add(separator);
		
		lblNewLabel_2 = new JLabel(peli.getCategoria());
		panel_20.add(lblNewLabel_2);
		
		panel_19 = new JPanel();
		panel_16.add(panel_19);
		panel_19.setLayout(new GridLayout(3, 1, 0, 0));
		lblAo = new JLabel(resourceBundle.getString("year2_msg"));
		panel_19.add(lblAo);
		
		separator_1 = new JSeparator();
		panel_19.add(separator_1);
		
		lblNewLabel_1 = new JLabel(String.valueOf(peli.getAnyo()));
		panel_19.add(lblNewLabel_1);
		
		panel_17 = new JPanel();
		panel_16.add(panel_17);
		panel_17.setLayout(new GridLayout(3, 1, 0, 0));
		
		lblDuracion = new JLabel(resourceBundle.getString("duration2_msg"));
		panel_17.add(lblDuracion);
		
		separator_2 = new JSeparator();
		panel_17.add(separator_2);
		
		String duracion = String.valueOf(peli.getDuracion()) + " min.";
		
		lblNewLabel_3 = new JLabel(duracion);
		panel_17.add(lblNewLabel_3);
			
		panel_15 = new JPanel();
		panel_8.add(panel_15, BorderLayout.NORTH);
		
		lblTitulo = new JLabel(peli.getNombre());
		lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		panel_15.add(lblTitulo);
		
		panel_13 = new JPanel();
		panel_8.add(panel_13);
		panel_13.setLayout(new GridLayout(2, 0, 0, 0));
		
		panel_18 = new JPanel();
		panel_13.add(panel_18);
		
		lblDescripcion = new JLabel(peli.getDescripcion());
		lblDescripcion.setFont(new Font("Segoe UI", Font.ITALIC, 17));
		panel_18.add(lblDescripcion);
		
		panel_31 = new JPanel();
		panel_13.add(panel_31);
		panel_31.setLayout(new GridLayout(0, 4, 0, 0));
		
		panel_34 = new JPanel();
		panel_31.add(panel_34);
		
		panel_32 = new JPanel();
		panel_31.add(panel_32);
		
		lblPrecio = new JLabel(resourceBundle.getString("price_msg"));
		panel_32.add(lblPrecio);
		
		panel_33 = new JPanel();
		panel_31.add(panel_33);
		String precioPeli = Float.toString(peli.getPrecio());
		precioPeli = precioPeli +" €";
		lblNewLabel = new JLabel(precioPeli);
		panel_33.add(lblNewLabel);
		
		panel_7 = new JPanel();
		panel.add(panel_7, BorderLayout.WEST);
		
		lblCartel = new JLabel("");
		try {
			Image imgPortada = ImageIO.read(new File(VentanaPrincipal.pathn+"films\\"+peli.getPortada()+".jpg"));
			lblCartel.setIcon(new ImageIcon(imgPortada));
		} catch (IOException e1) {
			
			e1.printStackTrace();
		}
		panel_7.add(lblCartel);
	}

}
