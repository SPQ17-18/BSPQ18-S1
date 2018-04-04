package es.deusto.spq.ProyectoCinePlus.cliente.util.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;

public class IniciarSesion extends JFrame {

	private IniciarSesion frame;
	private JFrame frmIniciarSesion;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasenia;
	
	private JPanel panel_1;
	private JPanel panel_3;
	private JPanel panel_2;
	private JPanel panel_6;
	private JPanel panel;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_4;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_5;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_13;
	
	private JButton btnIniciarSesion;
	private JButton btnAtras;
	private JLabel lblcontrasenia;
	private JLabel lblusuario;
	private JLabel lblIniciaSesion;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IniciarSesion frame = new IniciarSesion();
					frame.frmIniciarSesion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IniciarSesion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIniciarSesion = new JFrame();
		frmIniciarSesion.setTitle("Iniciar sesion");
		frmIniciarSesion.setBounds(100, 100, 450, 300);
		frmIniciarSesion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIniciarSesion.getContentPane().setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		frmIniciarSesion.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		panel_3 = new JPanel();
		frmIniciarSesion.getContentPane().add(panel_3, BorderLayout.SOUTH);
		
		panel_2 = new JPanel();
		frmIniciarSesion.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		panel_6 = new JPanel();
		panel_2.add(panel_6, BorderLayout.SOUTH);
		
		panel = new JPanel();
		panel_6.add(panel);
		
		btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnIniciarSesion);
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnAtras);
		
		panel_7 = new JPanel();
		panel_2.add(panel_7, BorderLayout.WEST);
		
		panel_8 = new JPanel();
		panel_2.add(panel_8, BorderLayout.EAST);
		
		panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_11 = new JPanel();
		panel_4.add(panel_11);
		panel_11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_9 = new JPanel();
		panel_11.add(panel_9);
		panel_9.setLayout(new GridLayout(4, 1, 5, 5));
		
		panel_12 = new JPanel();
		panel_9.add(panel_12);
		
		lblusuario = new JLabel("Usuario:");
		panel_9.add(lblusuario);
		
		lblcontrasenia = new JLabel("Contraseña:");
		panel_9.add(lblcontrasenia);
		
		panel_10 = new JPanel();
		panel_11.add(panel_10);
		panel_10.setLayout(new GridLayout(4, 1, 5, 5));
		
		panel_13 = new JPanel();
		panel_10.add(panel_13);
		
		textFieldUsuario = new JTextField();
		panel_10.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldContrasenia = new JTextField();
		panel_10.add(textFieldContrasenia);
		textFieldContrasenia.setColumns(10);
		
		panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.NORTH);
		
		lblIniciaSesion = new JLabel("Inicia sesion");
		panel_5.add(lblIniciaSesion);
	}
 
}
