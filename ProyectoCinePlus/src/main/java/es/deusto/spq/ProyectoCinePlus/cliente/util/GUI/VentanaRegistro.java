package es.deusto.spq.ProyectoCinePlus.cliente.util.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.CinePlusController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.DefaultComboBoxModel;

public class VentanaRegistro extends JFrame {

	private CinePlusController controller;
	
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
	private final JLabel lblNombre ;
	private JTextField textFieldNombre;
	private JPanel panel_12;
	private JPanel panel_13;
	private JLabel lblApellidos;
	private JTextField textFieldApellidos;
	private JPanel panel_14;
	private JPanel panel_15;
	private JLabel lblFechaNacimiento;
	private JLabel lblCalle;
	private JPanel panel_16;
	private JPanel panel_17;
	private JLabel lblPoblacin;
	private JLabel lblPais;
	private JTextField textFieldPais;
	private JTextField textFieldPoblacion;
	private JTextField textFieldCalle;
	private JPanel panel_18;
	private JPanel panel_19;
	private JPanel panel_20;
	private JPanel panel_21;
	private JPanel panel_22;
	private JPanel panel_23;
	private JTextField textFieldFecha;
	private JPanel panel_24;
	private JPanel panel_25;
	private JLabel label;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					VentanaRegistro frame = new VentanaRegistro();
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
	public VentanaRegistro(CinePlusController controller,ResourceBundle resourceBundle) {
		this.controller = controller;
		final ResourceBundle resourceBundleNew = resourceBundle;
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaRegistro.class.getResource("/es/deusto/spq/ProyectoCinePlus/cliente/util/Resources/Imagenes/logocuadrado50.png")));
		setTitle(resourceBundle.getString("title_register_users_msg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 351);
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
		panel_8.setLayout(new GridLayout(7, 2, 0, 0));
		
		panel_12 = new JPanel();
		panel_8.add(panel_12);
		panel_12.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		panel_18 = new JPanel();
		panel_12.add(panel_18);
		panel_18.setLayout(new GridLayout(1, 2, 0, 0));
		lblNombre = new JLabel(resourceBundle.getString("name_msg"));
		panel_18.add(lblNombre);
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		
		textFieldNombre = new JTextField();
		panel_18.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		panel_13 = new JPanel();
		panel_8.add(panel_13);
		
		panel_19 = new JPanel();
		panel_13.add(panel_19);
		panel_19.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblApellidos = new JLabel(resourceBundle.getString("surnames_msg"));
		panel_19.add(lblApellidos);
		
		textFieldApellidos = new JTextField();
		panel_19.add(textFieldApellidos);
		textFieldApellidos.setColumns(10);
		
		panel_24 = new JPanel();
		panel_8.add(panel_24);
		
		panel_25 = new JPanel();
		panel_24.add(panel_25);
		panel_25.setLayout(new GridLayout(1, 0, 0, 0));
		
		label = new JLabel(resourceBundle.getString("pass_msg"));
		panel_25.add(label);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		panel_25.add(passwordField);
		
		panel_15 = new JPanel();
		panel_8.add(panel_15);
		
		panel_20 = new JPanel();
		panel_15.add(panel_20);
		panel_20.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblFechaNacimiento = new JLabel(resourceBundle.getString("birthdate_msg"));
		panel_20.add(lblFechaNacimiento);
		
		textFieldFecha = new JTextField();
		panel_20.add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		panel_17 = new JPanel();
		panel_8.add(panel_17);
		
		panel_21 = new JPanel();
		panel_17.add(panel_21);
		panel_21.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblPoblacin = new JLabel(resourceBundle.getString("town_msg"));
		panel_21.add(lblPoblacin);
		
		textFieldPoblacion = new JTextField();
		panel_21.add(textFieldPoblacion);
		textFieldPoblacion.setColumns(10);
		
		panel_14 = new JPanel();
		panel_8.add(panel_14);
		
		panel_22 = new JPanel();
		panel_14.add(panel_22);
		panel_22.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblCalle = new JLabel(resourceBundle.getString("street_msg"));
		panel_22.add(lblCalle);
		
		textFieldCalle = new JTextField();
		panel_22.add(textFieldCalle);
		textFieldCalle.setColumns(10);
		
		panel_16 = new JPanel();
		panel_8.add(panel_16);
		
		panel_23 = new JPanel();
		panel_16.add(panel_23);
		panel_23.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblPais = new JLabel(resourceBundle.getString("country_msg"));
		panel_23.add(lblPais);
		
		textFieldPais = new JTextField();
		panel_23.add(textFieldPais);
		textFieldPais.setColumns(10);
		
		panel_11 = new JPanel();
		panel_4.add(panel_11, BorderLayout.SOUTH);
		
		panel_9 = new JPanel();
		panel_11.add(panel_9);
		
		btnRegistrarse = new JButton(resourceBundle.getString("register_msg"));
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comprobarcampos(resourceBundleNew)) {
					VentanaUsuario ventanaUsuario = new VentanaUsuario(VentanaRegistro.this.controller);
					ventanaUsuario.setVisible(true);
					dispose();
				}
			}
		});
		panel_9.add(btnRegistrarse);
		
		btnAtras = new JButton(resourceBundle.getString("back_msg"));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaPrincipal.frame.setVisible(true);
				dispose();
			}
		});
		panel_9.add(btnAtras);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));
	}
 
	private boolean comprobarcampos(ResourceBundle resourceBundle) {
		String error ="";
		boolean comprobar = true;
		if(textFieldNombre.getText().trim().equals("")) {
			error = resourceBundle.getString("name2_msg");
		}
		if(textFieldApellidos.getText().trim().equals("")) {
			if(!error.isEmpty()){
				error += " - " + resourceBundle.getString("surnames2_msg");
			}else{
				error+=resourceBundle.getString("surnames2_msg");
			}
		}
		if(textFieldFecha.getText().trim().equals("")) {
			if(!error.isEmpty()){
				error+=" - "+resourceBundle.getString("birthdate2_msg");
			}else{
				error+=resourceBundle.getString("birthdate2_msg");
			}
		}
		if(textFieldPais.getText().trim().equals("")) {
			if(!error.isEmpty()){
				error+=" - "+resourceBundle.getString("birthdate2_msg");
			}else{
				error+=resourceBundle.getString("birthdate2_msg");
			}
		}
		if(textFieldPoblacion.getText().trim().equals("")) {
			if(!error.isEmpty()){
				error+=" - "+resourceBundle.getString("town2_msg");
			}else{
				error+=resourceBundle.getString("town2_msg");
			}
		}
		if(textFieldCalle.getText().trim().equals("")) {
			if(!error.isEmpty()){
				error+=" - "+resourceBundle.getString("street2_msg");
			}else{
				error+=resourceBundle.getString("street2_msg");
			}
		}
		if(textFieldFecha.getText().trim().equals("")) {
			if(!error.isEmpty()){
				error+=" - "+resourceBundle.getString("pass2_msg");
			}else{
				error+=resourceBundle.getString("pass2_msg");
			}
		}
		if(!error.isEmpty()) {
			JOptionPane.showMessageDialog(null, resourceBundle.getString("error_data_msg") + error, "ERROR!", JOptionPane.ERROR_MESSAGE);
			limpiarCampos();
			comprobar= false;
		}
		
		return comprobar;
	}
	
	private void limpiarCampos() {
		textFieldNombre.setText("");
		textFieldApellidos.setText("");
		textFieldFecha.setText("");
		textFieldPais.setText("");
		textFieldPoblacion.setText("");
		textFieldCalle.setText("");
		textFieldFecha.setText("");
	}
}
