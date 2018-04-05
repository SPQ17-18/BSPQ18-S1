package es.deusto.spq.ProyectoCinePlus.cliente.util.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.JLabel;
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

public class VentanaUsuario extends JFrame {

	private JPanel contentPane;
 
	private int anchuraPanel = 1080;
	private int alturaPanel = 720;
	private JTextField textFieldNombrePeli;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaUsuario frame = new VentanaUsuario();
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
	public VentanaUsuario() {
		setTitle("Panel de usuario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaUsuario.class.getResource("/es/deusto/spq/ProyectoCinePlus/cliente/util/Resources/Imagenes/logocuadrado50.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, anchuraPanel, alturaPanel);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 3, 0, 0));
		
		JPanel panel_10 = new JPanel();
		panel.add(panel_10);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(VentanaUsuario.class.getResource("/es/deusto/spq/ProyectoCinePlus/cliente/util/Resources/Imagenes/logo300.png")));
		panel.add(lblLogo);
		
		JPanel panel_11 = new JPanel();
		panel.add(panel_11);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_1.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_1.add(panel_15);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.WEST);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.EAST);
		
		JPanel panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_6 = new JPanel();
		panel_4.add(panel_6, BorderLayout.NORTH);
		
		JPanel panel_7 = new JPanel();
		panel_4.add(panel_7, BorderLayout.SOUTH);
		panel_7.setLayout(new GridLayout(0, 4, 0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_7.add(panel_16);
		panel_16.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel label = new JLabel("Bienvenido");
		panel_16.add(label);
		
		JSeparator separator_2 = new JSeparator();
		panel_16.add(separator_2);
		
		JLabel label_2 = new JLabel("NomUser");
		label_2.setFont(new Font("Segoe UI", Font.ITALIC, 18));
		panel_16.add(label_2);
		
		JPanel panel_17 = new JPanel();
		panel_7.add(panel_17);
		
		JPanel panel_18 = new JPanel();
		panel_7.add(panel_18);
		
		JPanel panel_19 = new JPanel();
		panel_7.add(panel_19);
		panel_19.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel label_3 = new JLabel("Saldo");
		panel_19.add(label_3);
		
		JSeparator separator_3 = new JSeparator();
		panel_19.add(separator_3);
		
		JLabel lblSaldo = new JLabel("saldo");
		lblSaldo.setFont(new Font("Segoe UI", Font.ITALIC, 18));
		panel_19.add(lblSaldo);
		
		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9, BorderLayout.EAST);
		
		JPanel panel_5 = new JPanel();
		panel_4.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_5.add(panel_12, BorderLayout.NORTH);
		panel_12.setLayout(new GridLayout(0, 6, 0, 0));
		
		JPanel panel_24 = new JPanel();
		panel_12.add(panel_24);
		
		JLabel lblNombre = new JLabel("Nombre:");
		panel_24.add(lblNombre);
		
		JPanel panel_25 = new JPanel();
		panel_12.add(panel_25);
		
		textFieldNombrePeli = new JTextField();
		panel_25.add(textFieldNombrePeli);
		textFieldNombrePeli.setColumns(10);
		
		JPanel panel_22 = new JPanel();
		panel_12.add(panel_22);
		
		JLabel lblAnio = new JLabel("Año:");
		panel_22.add(lblAnio);
		
		JPanel panel_21 = new JPanel();
		panel_12.add(panel_21);
		
		JComboBox comboBoxAnio = new JComboBox();
		panel_21.add(comboBoxAnio);
		
		JPanel panel_23 = new JPanel();
		panel_12.add(panel_23);
		
		JLabel lblGnero = new JLabel("Género:");
		panel_23.add(lblGnero);
		
		JPanel panel_20 = new JPanel();
		panel_12.add(panel_20);
		
		JComboBox comboBox = new JComboBox();
		panel_20.add(comboBox);
		
		JPanel panel_13 = new JPanel();
		panel_5.add(panel_13, BorderLayout.SOUTH);
		
		JPanel panel_8 = new JPanel();
		panel_4.add(panel_8, BorderLayout.WEST);
	}

	
}
