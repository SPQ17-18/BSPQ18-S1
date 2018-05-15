/** @package es.deusto.spq.ProyectoCinePlus.cliente.util.GUI
    @brief Ventana de inicio de sesión. May 15, 2018

    Esta es la ventana que te da acceso a la funcionalidad completa de la aplicación. 
    Para eso, tienes que estar registrado en la aplicación y disponer de un usuario y una contraseña valida.
    Introduciendo un email valido y una contraseña valida te permite entrar a tu perfil personal.
*/

package es.deusto.spq.ProyectoCinePlus.cliente.util.GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ResourceBundle;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.CinePlusController;
import es.deusto.spq.ProyectoCinePlus.servidor.DATA.Usuario;

import javax.swing.JPasswordField;

/**
 * Ventana Login. Se trata de la ventana de login, la cual permite acceder a la aplicación.
 * @author Fercol
 *
 */
public class VentanaLogin extends JFrame {


	private static final long serialVersionUID = 1L;
	private CinePlusController controller;
	private JPanel contentPane;
	private JTextField textFieldUsuario;

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
	private JPasswordField passwordField;
	protected ResourceBundle resourceBundle;
	
	protected Usuario userLogeado;

	static Logger logger = Logger.getLogger(VentanaLogin.class.getName());

	/**
	 * Constructor de la ventana Login. 
	 * @param controller - CinePlusController
	 * @param resourceBundle - ResourceBundle 
	 */
	public VentanaLogin(CinePlusController controller, final ResourceBundle resourceBundle) {

		logger.info("VentanaLogin");

		this.setController(controller);
		this.resourceBundle = resourceBundle;

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(VentanaPrincipal.pathn + "logocuadrado50.png"));
		} catch (IOException e) {
		}
		setIconImage(img);

		setTitle(resourceBundle.getString("title_login_msg"));
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);

		panel_3 = new JPanel();
		getContentPane().add(panel_3, BorderLayout.SOUTH);

		panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));

		panel_6 = new JPanel();
		panel_2.add(panel_6, BorderLayout.SOUTH);

		panel = new JPanel();
		panel_6.add(panel);

		btnIniciarSesion = new JButton(resourceBundle.getString("login_msg"));
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logger.info("Boton aceptar login");
				// Comprobacion campos vacios
				if (textFieldUsuario.getText().trim().equals("") || passwordField.getPassword().length > 30) {
					JOptionPane.showMessageDialog(null, resourceBundle.getString("error_login_msg"), "ERROR!",
							JOptionPane.ERROR_MESSAGE);
					limpiarCampos();
				}
				else {
					try {
						String pass = new String(passwordField.getPassword());
						logger.info("PASSWORD= " + pass);
						boolean login = controller.LoginUsuario(textFieldUsuario.getText(), pass);
						if (login) {
							logger.info("Usuario logueado:  " + textFieldUsuario.getText());
							
							//Obtener usuario a partir del email
							String email = textFieldUsuario.getText();
							logger.info("USUARIO: "+ email);
							Usuario userLogeado = controller.DevolverUsuario(email);
							logger.info("***USUARIO LOGEADO: *** "+ userLogeado);

							VentanaLogin.this.setVisible(false);
							VentanaUsuario windowusuario = new VentanaUsuario(controller, resourceBundle, userLogeado);
							windowusuario.setVisible(true);
						} else {
							JOptionPane.showMessageDialog(null, resourceBundle.getString("error_login_msg"), "ERROR!",
									JOptionPane.ERROR_MESSAGE);
							limpiarCampos();
						}

					} catch (RemoteException e) {
						e.printStackTrace();
					}

				}
			}
		});
		panel.add(btnIniciarSesion);

		btnAtras = new JButton(resourceBundle.getString("back_msg"));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				logger.info("Boton Atras (VentanaLogin)");
				VentanaPrincipal.frame.setVisible(true);
				dispose();
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

		lblusuario = new JLabel(resourceBundle.getString("email_msg"));
		panel_9.add(lblusuario);

		lblcontrasenia = new JLabel(resourceBundle.getString("pass_msg"));
		panel_9.add(lblcontrasenia);

		panel_10 = new JPanel();
		panel_11.add(panel_10);
		panel_10.setLayout(new GridLayout(4, 1, 5, 5));

		panel_13 = new JPanel();
		panel_10.add(panel_13);

		textFieldUsuario = new JTextField();
		panel_10.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);

		passwordField = new JPasswordField();
		panel_10.add(passwordField);

		panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.NORTH);

		lblIniciaSesion = new JLabel(resourceBundle.getString("login_msg"));
		panel_5.add(lblIniciaSesion);
	}

	/**
	 * Método que limpia los campos de las ventana login.
	 */
	private void limpiarCampos() {
		textFieldUsuario.setText("");
		passwordField.setText("");
	}

	/**
	 * Método get que devuelve el controlador.
	 * @return controller
	 */
	public CinePlusController getController() {
		return controller;
	}

	/**
	 * Método set que cambia el controlador. 
	 * @param controller
	 */
	public void setController(CinePlusController controller) {
		this.controller = controller;
	}
}
