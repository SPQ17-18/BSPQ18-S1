package es.deusto.spq.ProyectoCinePlus.cliente.util.GUI;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.CinePlusController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.imageio.ImageIO;

/**
 * Ventana de Regitro. Se trata de la ventana de registro en la que se pueden
 * registrar usuarios.
 * 
 * @author Fercol
 * @since 1.0.0
 *
 */
public class VentanaRegistro extends JFrame {

	private static final long serialVersionUID = 1L;

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
	private final JLabel lblUser ;
	private JTextField textFielduser;
	private JPanel panel_12;
	private JPanel panel_13;
	private JLabel lblPass;
	private JTextField textFieldemail;
	private JPanel panel_14;
	private JPanel panel_15;
	private JLabel lblNombre;
	private JLabel lblPais;
	private JPanel panel_16;
	private JPanel panel_17;
	private JLabel lblApellido;
	private JLabel lblpass2;
	private JTextField textFieldApellido;
	private JPanel panel_18;
	private JPanel panel_19;
	private JPanel panel_20;
	private JPanel panel_21;
	private JPanel panel_23;
	private JTextField textFieldnombre;
	private JPanel panel_24;
	private JPanel panel_25;
	private JLabel lblEmail;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPanel panel_26;
	private JTextField textFieldPais;
	
	protected ResourceBundle resourceBundle;
	static Logger logger = Logger.getLogger(VentanaRegistro.class.getName());
	
	/**
	 * Constructor de la ventana Registro. 
	 * @param controller CinePlusController
	 * @param resourceBundle ResourceBundle 
	 */
	public VentanaRegistro(CinePlusController controller,ResourceBundle resourceBundle) {
		logger.info("VentanaRegistro");
		this.controller = controller;
		this.resourceBundle=resourceBundle;
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(VentanaPrincipal.pathn+"logocuadrado50.png"));
		} catch (IOException e) {
		}
		setIconImage(img);
		
		setTitle(resourceBundle.getString("title_register_users_msg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 350);
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
		lblUser = new JLabel(resourceBundle.getString("user_msg"));
		panel_18.add(lblUser);
		lblUser.setHorizontalAlignment(SwingConstants.LEFT);
		
		textFielduser = new JTextField();
		panel_18.add(textFielduser);
		textFielduser.setColumns(10);
		
		panel_13 = new JPanel();
		panel_8.add(panel_13);
		
		panel_19 = new JPanel();
		panel_13.add(panel_19);
		panel_19.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblPass = new JLabel(resourceBundle.getString("pass_msg"));
		panel_19.add(lblPass);
		
		passwordField = new JPasswordField();
		panel_19.add(passwordField);
		passwordField.setColumns(10);
		
		panel_16 = new JPanel();
		panel_8.add(panel_16);
		
		panel_23 = new JPanel();
		panel_16.add(panel_23);
		panel_23.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblpass2 = new JLabel(resourceBundle.getString("another_pass_msg"));
		panel_23.add(lblpass2);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setColumns(10);
		panel_23.add(passwordField_1);
		
		panel_24 = new JPanel();
		panel_8.add(panel_24);
		
		panel_25 = new JPanel();
		panel_24.add(panel_25);
		panel_25.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblEmail = new JLabel(resourceBundle.getString("email_msg"));
		panel_25.add(lblEmail);
		
		textFieldemail = new JTextField();
		panel_25.add(textFieldemail);
		textFieldemail.setColumns(10);
		
		panel_15 = new JPanel();
		panel_8.add(panel_15);
		
		panel_20 = new JPanel();
		panel_15.add(panel_20);
		panel_20.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblNombre = new JLabel(resourceBundle.getString("name_msg"));
		panel_20.add(lblNombre);
		
		textFieldnombre = new JTextField();
		panel_20.add(textFieldnombre);
		textFieldnombre.setColumns(10);
		
		panel_17 = new JPanel();
		panel_8.add(panel_17);
		
		panel_21 = new JPanel();
		panel_17.add(panel_21);
		panel_21.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblApellido = new JLabel(resourceBundle.getString("surnames_msg"));
		panel_21.add(lblApellido);
		
		textFieldApellido = new JTextField();
		panel_21.add(textFieldApellido);
		textFieldApellido.setColumns(10);
		
		panel_14 = new JPanel();
		panel_8.add(panel_14);
		
		panel_26 = new JPanel();
		panel_14.add(panel_26);
		panel_26.setLayout(new GridLayout(1, 2, 0, 0));
		
		lblPais = new JLabel(resourceBundle.getString("country_msg"));
		panel_26.add(lblPais);
		
		textFieldPais = new JTextField();
		panel_26.add(textFieldPais);
		textFieldPais.setColumns(10);
		
		panel_11 = new JPanel();
		panel_4.add(panel_11, BorderLayout.SOUTH);
		
		panel_9 = new JPanel();
		panel_11.add(panel_9);
		
		btnRegistrarse = new JButton(resourceBundle.getString("register_msg"));
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comprobarcampos()) {
					logger.info("Boton registar");
					logger.info(textFielduser.getText()+
							textFieldemail.getText()+
							textFieldnombre.getText()+
							textFieldApellido.getText()+
							new String(passwordField.getPassword())+
							textFieldPais.getText());
					
					if(validarEmail()) {
						if (validarPass()) {
					
							try {
								controller.RegistrarUsuario(textFielduser.getText(),
										textFieldemail.getText(),
										textFieldnombre.getText(),
										textFieldApellido.getText(),
										new String(passwordField.getPassword()),
										textFieldPais.getText(),
										false);
							} catch (RemoteException e2) {
								e2.printStackTrace();
							}

							VentanaPrincipal.frame.setVisible(true);
							dispose();
						}
					}
				}else {
					limpiarCampos();
				}
				
			}
		});
		panel_9.add(btnRegistrarse);
		
		btnAtras = new JButton(resourceBundle.getString("back_msg"));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.info("Boton atras (Ventana Registro)");
				VentanaPrincipal.frame.setVisible(true);
				dispose();
			}
		});
		panel_9.add(btnAtras);
		
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new BorderLayout(0, 0));
	}
 
	/**
	 * Funcion que comprueba que todos los datos se han introducido en el formulario. 
	 * Comprueba que no haya campos en blanco, y elimina los espacios del comienzo y del final. 
	 * En caso de fallo, muestra una ventana de error informando del problema.
	 * @return comprobar - boolean
	 */
	public boolean comprobarcampos() {
		logger.info("Funcion comprobar campos");
		String error ="";
		boolean comprobar = true;
		if(textFielduser.getText().trim().equals("")) {
			error = resourceBundle.getString("user2_msg");
		}
		if(textFieldemail.getText().trim().equals("")) {
			if(!error.isEmpty()){
				error += " - " + resourceBundle.getString("email2_msg");
			}else{
				error+=resourceBundle.getString("email2_msg");
			}
		}
		if(textFieldnombre.getText().trim().equals("")) {
			if(!error.isEmpty()){
				error+=" - "+resourceBundle.getString("name2_msg");
			}else{
				error+=resourceBundle.getString("name2_msg");
			}
		}
		if(textFieldApellido.getText().trim().equals("")) {
			if(!error.isEmpty()){
				error+=" - "+resourceBundle.getString("surnames2_msg");
			}else{
				error+=resourceBundle.getString("surnames2_msg");
			}
		}
		if(textFieldPais.getText().trim().equals("")) {
			if(!error.isEmpty()){
				error+=" - "+resourceBundle.getString("country2_msg");
			}else{
				error+=resourceBundle.getString("country2_msg");
			}
		}
		if(!error.isEmpty()) {
			JOptionPane.showMessageDialog(null, resourceBundle.getString("error_data_msg") + error, "ERROR!", JOptionPane.ERROR_MESSAGE);
			comprobar=false;
		} 
		
		return comprobar;
	}
	
	/**
	 * Metodo que comprueba si se trata de un email valido. 
	 * Devuelve TRUE si el email dispone de una "@" y termina por ".com".
	 * Devuelve FALSE si el email no cumple con las condiciones anteriores. 
	 * @return resul - boolean
	 */
	public boolean validarEmail() {
		logger.info("Funcion validarEmail");
		boolean resul=true;
		if(!(textFieldemail.getText().contains("@") && (textFieldemail.getText().contains(".com") || textFieldemail.getText().contains(".es")))) {
			JOptionPane.showMessageDialog(null, resourceBundle.getString("error_email_msg"), "ERROR!", JOptionPane.ERROR_MESSAGE);
			resul=false;
		}
		return resul;
	}
	
	/**
	 * Metodo que comprueba su la contrasenya cumple con las condiciones establecidas. 
	 * Devuelve TRUE si la contrasenya cumple las condiciones de ser mas de 6 caracteres.
	 * Devuelve FALSE si es mas corta.
	 * @return resul - boolean 
	 */
	public boolean validarPass() {
		logger.info("Funcion validarPass");
		boolean resul=true;
		if(passwordField.getPassword().length < 6 ) {
			JOptionPane.showMessageDialog(null, resourceBundle.getString("error_pass_msg"), "ERROR!", JOptionPane.ERROR_MESSAGE);
			resul=false;
		}
		return resul;
	}
	
	/**
	 * Metodo que limpia los campos de las ventana registro.
	 */
	private void limpiarCampos() {
		textFielduser.setText("");
		textFieldemail.setText("");
		passwordField.setText("");
		passwordField_1.setText("");
		textFieldnombre.setText("");
		textFieldApellido.setText("");
		textFieldPais.setText("");
	}
}
