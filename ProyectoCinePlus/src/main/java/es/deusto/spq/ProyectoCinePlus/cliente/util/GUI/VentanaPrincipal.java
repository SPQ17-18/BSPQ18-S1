package es.deusto.spq.ProyectoCinePlus.cliente.util.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VentanaPrincipal extends JFrame {

	private static VentanaPrincipal frame;
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
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
		
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLogin iniciarsesion = new VentanaLogin();
				iniciarsesion.setVisible(true);
				frame.setVisible(false);
			}
		});
		panel_8.add(btnIniciarSesion);
		
		btnRegistarse = new JButton("Registarse");
		btnRegistarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaRegistro registrouser = new VentanaRegistro();
				registrouser.setVisible(true);
				frame.setVisible(false);
			}
		});
		
		panel_8.add(btnRegistarse);
		
		btnCopyright = new JButton("Copyright");
		btnCopyright.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,
						"Bienvenido a CinePlus!\n"
								+ "CinePlus es una aplicación de peliculas donde podrás"
								+ "marcar las peliculas que has visto, así como alquilar "
								+ "las peliculas que quieres ver.\n"
								+ "Está desarrollado por: \n"
								+ "Javier Fernandez\n"
								+ "Mikel Fernandez\n"
								+ "Aritz Rasines\n"
								+ "Xabi Sarrionandia\n",
						"CopyRight CinePlus:", JOptionPane.DEFAULT_OPTION);
			}
		});
		panel_8.add(btnCopyright);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		panel_8.add(btnSalir);
	}

}
