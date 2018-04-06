package es.deusto.spq.ProyectoCinePlus.cliente.util.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.CinePlusController;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class VentanaPrincipal extends JFrame {

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

	String copy;
	ResourceBundle resourceBundle;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(CinePlusController controller) {
		
		resourceBundle = ResourceBundle.getBundle("SystemMessages", Locale.getDefault());
		resourceBundle = ResourceBundle.getBundle("SystemMessages",	Locale.forLanguageTag("en"));
		
		this.controlador = controller;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/es/deusto/spq/ProyectoCinePlus/cliente/util/Resources/Imagenes/logocuadrado50.png")));
		setTitle("CinePlus");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/es/deusto/spq/ProyectoCinePlus/cliente/util/Resources/Imagenes/logo300.png")));
		panel_2.add(label);
		
		panel_1 = new JPanel();
		panel.add(panel_1, BorderLayout.CENTER);
		
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
				VentanaPrincipal.this.setVisible(false);
				VentanaLogin iniciarsesion = new VentanaLogin(frame.controlador,resourceBundle);
				iniciarsesion.setVisible(true);
				
			}
		});
		panel_8.add(btnIniciarSesion);
		
		btnRegistarse = new JButton(resourceBundle.getString("register_msg"));
		btnRegistarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				
				JOptionPane.showMessageDialog(null,copy,"CopyRight CinePlus:", JOptionPane.DEFAULT_OPTION);
			}
		});
		panel_8.add(btnCopyright);
		
		btnSalir = new JButton(resourceBundle.getString("get_out_msg"));
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel_8.add(btnSalir);
	}

}
