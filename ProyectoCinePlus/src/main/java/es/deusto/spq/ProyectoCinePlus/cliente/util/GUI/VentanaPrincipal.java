/** @package es.deusto.spq.ProyectoCinePlus.cliente.util.GUI
    @brief Ventana de principal. May 15, 2018

    Esta es la ventana principal de la aplicacion. 
    Desde aqui puedes empezar a crear cuentas de usuario, iniciar sesion, 
    ver los creditos de la aplicacion o cerrar el programa. 
*/
package es.deusto.spq.ProyectoCinePlus.cliente.util.GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.log4j.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.CinePlusController;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.RMIServiceLocator;

import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Ventana Prinicipal. Se trata de la ventana de inicio del programa, la cual permite acceder a la aplicaci�n.
 * @author Fercol
 *
 */
public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private CinePlusController controlador;
	public static VentanaPrincipal frame;
	

	private JPanel contentPane;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_1;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_3;
	private JPanel panel_8;
	
	private JButton btnIniciarSesion;
	private JButton btnRegistarse;
	private JButton btnCopyright;
	private JButton btnSalir;
	private JLabel label;

	private String copy;
	protected ResourceBundle resourceBundle;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JLabel lblEs;
	private JLabel lblEn;
	private JLabel lblEu;
	

	private String lang="en";
	public static String pathn;
	
	static Logger logger = Logger.getLogger(VentanaPrincipal.class.getName());

	/**
	 * COntructor de la Ventana Principal. 
	 * @param rmi - RMIServiceLocator
	 * @param controller - CinePlusController
	 */
	public VentanaPrincipal(RMIServiceLocator rmi,CinePlusController controller) {
		
		logger.info("VentanaPrincipal");
		pathn=(System.getProperty("user.dir")+ "\\src\\main\\resources\\images\\");
		
		logger.debug(pathn);
		resourceBundle = ResourceBundle.getBundle("SystemMessages", Locale.getDefault());
		//resourceBundle = ResourceBundle.getBundle("SystemMessages ",	Locale.forLanguageTag(lang));
		
		this.controlador = controller;
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(pathn+"logocuadrado50.png"));
		} catch (IOException e) {
		}
		
		setIconImage(img);
		setTitle("CinePlus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel_6 = new JPanel();
		contentPane.add(panel_6, BorderLayout.NORTH);
		
		panel_7 = new JPanel();
		contentPane.add(panel_7, BorderLayout.SOUTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.NORTH);
		
		BufferedImage img2 = null;
		try {
		    img2 = ImageIO.read(new File(pathn+"logo300.png"));
		} catch (IOException e) {
		}
		ImageIcon a=new ImageIcon(img2);
		
		label = new JLabel("");
		label.setIcon(a);
		panel_2.add(label);
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_9 = new JPanel();
		panel_1.add(panel_9, BorderLayout.EAST);
		panel_9.setLayout(new GridLayout(3, 0, 0, 0));
		
		panel_10 = new JPanel();
		panel_9.add(panel_10);
		
		lblEs = new JLabel("");
		lblEs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lang = "es";
				logger.info("Idioma: es");
			}
		});
		
		BufferedImage img3 = null;
		try {
		    img3 = ImageIO.read(new File(pathn+"es25.png"));
		} catch (IOException e) {
		}
		ImageIcon b=new ImageIcon(img3);
		
		lblEs.setIcon(b);
		panel_10.add(lblEs);
		
		panel_12 = new JPanel();
		panel_9.add(panel_12);
		
		lblEu = new JLabel("");
		lblEu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lang = "eu";
				logger.info("Idioma: eu");
				//resourceBundle = ResourceBundle.getBundle("SystemMessages",	Locale.forLanguageTag(lang));
				//frame.repaint();
				//frame.dispose();
				//frame.setVisible(true);
				
			}
		});
		
		BufferedImage img4 = null;
		try {
		    img4 = ImageIO.read(new File(pathn+"eu25.png"));
		} catch (IOException e) {
		}
		ImageIcon c=new ImageIcon(img4);
		
		lblEu.setIcon(c);
		panel_12.add(lblEu);
		
		panel_11 = new JPanel();
		panel_9.add(panel_11);
		
		lblEn = new JLabel("");
		lblEn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lang = "en";
				logger.info("Idioma: en");
			}
		});
		
		BufferedImage img5 = null;
		try {
		    img5 = ImageIO.read(new File(pathn+"en25.png"));
		} catch (IOException e) {
		}
		ImageIcon d=new ImageIcon(img5);
		
		lblEn.setIcon(d);
		panel_11.add(lblEn);
		
		panel_4 = new JPanel();
		panel.add(panel_4, BorderLayout.WEST);
		
		panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.EAST);
		
		panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.SOUTH);
		
		panel_8 = new JPanel();
		panel_3.add(panel_8);
		panel_8.setLayout(new GridLayout(2, 2, 0, 0));
		
		btnIniciarSesion = new JButton(resourceBundle.getString("login_msg"));
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.info("Boton Login");
				VentanaPrincipal.this.setVisible(false);
				VentanaLogin iniciarsesion = new VentanaLogin(frame.controlador,resourceBundle);
				iniciarsesion.setVisible(true);
			}
		});
		panel_8.add(btnIniciarSesion);
		
		btnRegistarse = new JButton(resourceBundle.getString("register_msg"));
		btnRegistarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.info("Boton Registrar");
				frame.setVisible(false);
				VentanaRegistro registrouser = new VentanaRegistro(frame.controlador,resourceBundle);
				registrouser.setVisible(true);	
			}
		});
		 
		panel_8.add(btnRegistarse);
		copy = resourceBundle.getString("copyright_msg");
		btnCopyright = new JButton("Copyright");
		btnCopyright.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logger.info("Boton Copyright");
				JOptionPane.showMessageDialog(null,copy,"CopyRight CinePlus:", JOptionPane.DEFAULT_OPTION);
			}
		});
		panel_8.add(btnCopyright);
		 
		btnSalir = new JButton(resourceBundle.getString("get_out_msg"));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				logger.info("Saliendo");
			}
		});
		panel_8.add(btnSalir);
	}
	
}
