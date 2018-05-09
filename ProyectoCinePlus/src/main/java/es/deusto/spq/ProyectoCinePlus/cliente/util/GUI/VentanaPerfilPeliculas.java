package es.deusto.spq.ProyectoCinePlus.cliente.util.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.CinePlusController;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Pelicula;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;
import javax.swing.BoxLayout;

public class VentanaPerfilPeliculas extends JFrame {

	private static final long serialVersionUID = 1L;

	private CinePlusController controller;
	
	private JPanel contentPane;
 
	//private int anchuraPanel = 1080;
	//private int alturaPanel = 720;
	 
	private JLabel lblLogo;
	private JLabel label_3;
	private JLabel lblSaldo;
	private JLabel label;
	private JLabel label_2;
	
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
	private JPanel panel_18;
	private JPanel panel_19;
	private JPanel panel_9;
	private JPanel panel_5; 
	private JPanel panel_12; 
	private JPanel panel_24;
	private JPanel panel_8; 
	private JPanel panel_25; 
	private JPanel panel_26;
	private JPanel panel_30;
	
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JScrollPane scrollPane;
	private JLabel lblpeliculas;
	private JSeparator separator;
	private JLabel lblnumpelis;
	
	protected ResourceBundle resourceBundle;
	private JButton btnCerrarSesion;
	private JPanel panel_27;
	private JPanel panel_28;
	private JPanel panel_29;
	private List<Pelicula> prueba=new ArrayList<Pelicula>();
	static Logger logger = Logger.getLogger(VentanaPerfilPeliculas.class.getName());
	private JPanel panel_SUP;
	private JLabel lblnumPelis;
	private JPanel panel_13;
	private JLabel label_1;
	private JSeparator separator_1;
	private JLabel label_4;
	

	/**
	 * Create the frame.
	 */

	public VentanaPerfilPeliculas(CinePlusController controller, ResourceBundle resourceBundle, Usuario userLogeado) {
		logger.info("VentanaPerfilPeliculas");
		this.controller =controller;
		this.resourceBundle=resourceBundle;
		setTitle(resourceBundle.getString("user_panel_msg"));
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(VentanaPrincipal.pathn+"logocuadrado50.png"));
		} catch (IOException e) {
		}
		setIconImage(img);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
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
		panel_7.setLayout(new GridLayout(0, 3, 0, 0));
		
		panel_16 = new JPanel();
		panel_7.add(panel_16);
		panel_16.setLayout(new GridLayout(3, 1, 0, 0));
		
		panel_18 = new JPanel();
		panel_7.add(panel_18);
		panel_18.setLayout(new GridLayout(3, 1, 0, 0));
		
		panel_28 = new JPanel();
		panel_18.add(panel_28);
		
		panel_29 = new JPanel();
		panel_18.add(panel_29);
		
		btnCerrarSesion = new JButton(resourceBundle.getString("back_msg"));
		panel_29.add(btnCerrarSesion);
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logger.info("Boton Atras");
				VentanaUsuario ventanaUsuario = new VentanaUsuario(controller, resourceBundle, userLogeado);
				ventanaUsuario.setVisible(true);
				dispose();
			}
		});
		
		panel_27 = new JPanel();
		panel_18.add(panel_27);
		
		panel_19 = new JPanel();
		panel_7.add(panel_19);
		panel_19.setLayout(new GridLayout(3, 1, 0, 0));
		
		panel_9 = new JPanel();
		panel_4.add(panel_9, BorderLayout.EAST);
		panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new GridLayout(2,3));
		panel_12 = new JPanel();
		panel_5.add(panel_12, BorderLayout.NORTH);
		panel_12.setLayout(new GridLayout(0, 1, 0, 0));
		List<String> lo = null;
		try {
			lo = controller.ObtenerAnyo();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		List<String> ls = null;
		try {
			ls = controller.ObtenerGenero();
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		
		panel_SUP = new JPanel();
		panel_12.add(panel_SUP);
		panel_SUP.setLayout(new GridLayout(0, 4, 0, 0));
		
		panel_24 = new JPanel();
		panel_SUP.add(panel_24);
		panel_24.setLayout(new GridLayout(3, 1, 0, 0));
		
		label = new JLabel(resourceBundle.getString("welcome_msg"));
		panel_24.add(label);
		
		separator_2 = new JSeparator();
		panel_24.add(separator_2);
		
		label_2 = new JLabel(userLogeado.getUsuario());
		panel_24.add(label_2);
		label_2.setFont(new Font("Segoe UI", Font.ITALIC, 18));
		
		panel_25 = new JPanel();
		panel_SUP.add(panel_25);
		panel_25.setLayout(new GridLayout(3, 0, 0, 0));
		
		label_1 = new JLabel(resourceBundle.getString("email_msg"));
		panel_25.add(label_1);
		
		separator_1 = new JSeparator();
		panel_25.add(separator_1);
		
		label_4 = new JLabel(userLogeado.getEmail());
		label_4.setFont(new Font("Segoe UI", Font.ITALIC, 18));
		panel_25.add(label_4);

		panel_30= new JPanel();
		panel_SUP.add(panel_30);
		panel_30.setLayout(new GridLayout(3, 0, 0, 0));
		
		lblpeliculas = new JLabel(resourceBundle.getString("number_films_msg"));
		panel_30.add(lblpeliculas);
		
		separator = new JSeparator();
		panel_30.add(separator);
		
		lblnumPelis = new JLabel("0");
		panel_30.add(lblnumPelis);
		lblnumPelis.setFont(new Font("Segoe UI", Font.ITALIC, 18));
		
		panel_13 = new JPanel();
		panel_SUP.add(panel_13);
		panel_13.setLayout(new GridLayout(3, 3, 0, 0));
		
		label_3 = new JLabel(resourceBundle.getString("balance_msg"));
		panel_13.add(label_3);
		
		separator_3 = new JSeparator();
		panel_13.add(separator_3);
		
		lblSaldo = new JLabel(String.valueOf(userLogeado.getSaldo()) + " €");
		panel_13.add(lblSaldo);
		lblSaldo.setFont(new Font("Segoe UI", Font.ITALIC, 18));
		
		scrollPane = new JScrollPane();
		panel_5.add(scrollPane, BorderLayout.CENTER);
		
		panel_26 = new JPanel();
		
		//Pelis
		prueba = userLogeado.getPeliculasList();
		List<String> Pelis = new ArrayList<String>();
	    for (int index = 0; index < prueba.size(); index++) {
	    	Pelis.add("Pelicula: " + prueba.get(index).getNombre());
	    }
	    String[] projectNames = Pelis.toArray(new String[0]);

	    JButton[] buttons = new JButton[Pelis.size()];
	    try {
	    	panel_26.removeAll();
	    	panel_26.revalidate();
	    	panel_26.repaint();
	        for (int i = 0; i < projectNames.length; i++) {	
	            buttons[i] = new JButton(projectNames[i]);
	            Image imgCartel = ImageIO.read(new File(VentanaPrincipal.pathn+"films\\"+prueba.get(i).getPortada()+".jpg"));
	            buttons[i].setIcon(new ImageIcon(imgCartel));
	            panel_26.add(buttons[i]);
	        }
	    }catch(Exception e) {}
	    
	
		logger.info("Busqueda completada");
		scrollPane.setViewportView(panel_26);
		
		panel_8 = new JPanel();
		panel_4.add(panel_8, BorderLayout.WEST);
	}

	
}
