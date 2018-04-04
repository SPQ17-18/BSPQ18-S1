package es.deusto.spq.ProyectoCinePlus.cliente.util.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_10;
	private JPanel panel_6;
	private JPanel panel_5;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_11;
	private JPanel panel_9;
	private JPanel panel_1;
	
	private JButton btnRegistrarse;
	private JButton btnAtras;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegistro frame = new VentanaRegistro();
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
	public VentanaRegistro() {
		setTitle("Registrar usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.WEST);
		
		panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		panel_10 = new JPanel();
		panel_4.add(panel_10, BorderLayout.NORTH);
		
		panel_6 = new JPanel();
		panel_4.add(panel_6);
		
		panel_5 = new JPanel();
		panel_4.add(panel_5);
		
		panel_7 = new JPanel();
		panel_4.add(panel_7);
		
		panel_8 = new JPanel();
		panel_4.add(panel_8);
		
		panel_11 = new JPanel();
		panel_4.add(panel_11, BorderLayout.SOUTH);
		
		panel_9 = new JPanel();
		panel_11.add(panel_9);
		
		btnRegistrarse = new JButton("Registrarse");
		panel_9.add(btnRegistrarse);
		
		btnAtras = new JButton("Atras");
		panel_9.add(btnAtras);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));
	}
 
}
