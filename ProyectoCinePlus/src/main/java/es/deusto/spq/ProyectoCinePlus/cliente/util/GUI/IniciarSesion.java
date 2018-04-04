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

public class IniciarSesion {

	private JFrame frmIniciarSesion;
	private JTextField textFieldUsuario;
	private JTextField textFieldContrasenia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IniciarSesion window = new IniciarSesion();
					window.frmIniciarSesion.setVisible(true);
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
		
		JPanel panel_1 = new JPanel();
		frmIniciarSesion.getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_3 = new JPanel();
		frmIniciarSesion.getContentPane().add(panel_3, BorderLayout.SOUTH);
		
		JPanel panel_2 = new JPanel();
		frmIniciarSesion.getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_2.add(panel_6, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		panel_6.add(panel);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(btnIniciarSesion);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.add(btnAtras);
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7, BorderLayout.WEST);
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_11 = new JPanel();
		panel_4.add(panel_11);
		panel_11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_9 = new JPanel();
		panel_11.add(panel_9);
		panel_9.setLayout(new GridLayout(4, 1, 5, 5));
		
		JPanel panel_12 = new JPanel();
		panel_9.add(panel_12);
		
		JLabel lblusuario = new JLabel("Usuario:");
		panel_9.add(lblusuario);
		
		JLabel lblcontrasenia = new JLabel("Contraseña:");
		panel_9.add(lblcontrasenia);
		
		JPanel panel_10 = new JPanel();
		panel_11.add(panel_10);
		panel_10.setLayout(new GridLayout(4, 1, 5, 5));
		
		JPanel panel_13 = new JPanel();
		panel_10.add(panel_13);
		
		textFieldUsuario = new JTextField();
		panel_10.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		textFieldContrasenia = new JTextField();
		panel_10.add(textFieldContrasenia);
		textFieldContrasenia.setColumns(10);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.NORTH);
		
		JLabel lblIniciaSesion = new JLabel("Inicia sesion");
		panel_5.add(lblIniciaSesion);
	}
 
}
