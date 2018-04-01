package es.deusto.spq.ProyectoCinePlus.cliente.util.Paneles;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import es.deusto.spq.ProyectoCinePlus.servidor.BaseDeDatos;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Datos.Cliente;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Ventanas.VentanaPrincipal;

public class PanelIniciarSesion extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int anchuraPanel = 500;
	int alturaPanel = 300;
	private JPasswordField passwordField;
	private JTextField textField;
	private JButton BotonAcceder;
	public JButton BotonRegistrarse;
	private JButton BotonContrasenyaOlvidada;

	private BaseDeDatos bd = new BaseDeDatos();

	/**
	 * Create the panel.
	 */
	public PanelIniciarSesion(JFrame frame) {

		inicializar();
		componentes();
		anyadirComponentes();
		eventos(frame);
	}

	private void inicializar() {
		textField = new JTextField();
		passwordField = new JPasswordField();
		BotonAcceder = new JButton("ACCEDER");
		BotonRegistrarse = new JButton("REGISTRARSE ");
		BotonContrasenyaOlvidada = new JButton("CONTRASE\u00D1A OLVIDADA");
	}

	private void componentes() {

		textField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		textField.setColumns(10);
		textField.setBounds(71, 29, 361, 60);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
		passwordField.setBounds(71, 102, 361, 60);
		BotonAcceder.setForeground(SystemColor.textHighlight);
		BotonAcceder.setFont(new Font("Tahoma", Font.BOLD, 20));
		BotonAcceder.setBackground(Color.DARK_GRAY);
		BotonAcceder.setBounds(150, 175, 193, 35);
		BotonRegistrarse.setFont(new Font("Tahoma", Font.BOLD, 12));
		BotonRegistrarse.setBackground(Color.DARK_GRAY);
		BotonRegistrarse.setBounds(50, 223, 193, 35);
		BotonContrasenyaOlvidada.setFont(new Font("Tahoma", Font.BOLD, 12));
		BotonContrasenyaOlvidada.setBackground(Color.DARK_GRAY);
		BotonContrasenyaOlvidada.setBounds(255, 223, 196, 35);	
		textField.setBackground(Color.DARK_GRAY);
		textField.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Introduzca usuario", TitledBorder.CENTER, TitledBorder.TOP, null, SystemColor.textHighlight));
		passwordField.setBackground(Color.DARK_GRAY);
		passwordField.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Introduzca contrase\u00F1a", TitledBorder.CENTER, TitledBorder.TOP, null, SystemColor.textHighlight));
		BotonAcceder.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		BotonRegistrarse.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		BotonContrasenyaOlvidada.setBorder(new LineBorder(SystemColor.textHighlight, 2));
		textField.setForeground(SystemColor.textHighlight);
		passwordField.setForeground(SystemColor.textHighlight);

	}

	private void anyadirComponentes() {
		setSize(anchuraPanel, alturaPanel);
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		setBorder(null);
		add(textField);
		add(passwordField);
		add(BotonAcceder);
		add(BotonRegistrarse);
		add(BotonContrasenyaOlvidada);
	}

	private void eventos(final JFrame frame) {
		
		BotonAcceder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarlizarVentana(comprobarCredenciales(), frame);
			}
		});
		BotonContrasenyaOlvidada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						bd.devuelveContrasenya(JOptionPane.showInputDialog(null, "INTRODUCE TU CORREO ELECTR�NICO")));
			}
		});
		
		
	
	}
	private String comprobarCredenciales() {
		String usuario = textField.getText();
		String contrasenya = String.valueOf(passwordField.getPassword());
		String dev = "TIPO_USUARIO";

		if (usuario.equals("")) {
			JOptionPane.showMessageDialog(null, "NO HAS INTRODUCIDO NINGUN USUARIO.", "�ERROR!",JOptionPane.ERROR_MESSAGE);
		}
		else if (contrasenya.equals("")) {
			JOptionPane.showMessageDialog(null, "NO HAS INTRODUCIDO NINGUNA CONTRASE�A.", "�ERROR!",JOptionPane.ERROR_MESSAGE);
		}
		else {
			//Primero comprobamos si es ADMINISTRADOR:
			int resulAdministrador = bd.adminRegistrado(usuario, contrasenya);
			//Segundo comprobamos a ver si es USUARIO:
			int resulUsuario = bd.UsuarioRegistrado(usuario, contrasenya);

			if (resulAdministrador == 0 && resulUsuario == 0) {
				JOptionPane.showMessageDialog(null,"EL USUARIO NO EXISTE EN LA BD");
			}
			else if (resulAdministrador == 1 || resulUsuario == 1) {
				JOptionPane.showMessageDialog(null, "CONTRASE�A INCORRECTA", "�ERROR!",JOptionPane.ERROR_MESSAGE);
			}
			else {							
				if(resulAdministrador!=0&&resulAdministrador!=1)
				{
					dev = "ADMIN";
				}else{
					dev = "USER";
				}
			}
			
			//ADMIN LOCAL SIN CONECTAR A BD:
			if(textField.getText().equals("ADMIN")&&String.valueOf(passwordField.getPassword()).equals("12345")){
				dev = "ADMIN";
			}
		}				
		
		return dev;
	}
	
	private void iniciarlizarVentana(String tipoUsuario, JFrame frame)
	{
		if(tipoUsuario.equals(("USER")))
		{
			//Primero cerramos la ventana actual de las credenciales:
			frame.dispose();
			//Inicializamos nueva JFrame VentanaPrincipal pero con distintos par�metros de entrada:
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(1080+6,720+35);//800 (anchura del PanelUsuario), 600 (altura del PanelUsuario)
			ventanaPrincipal.setVisible(true);
			ventanaPrincipal.cargarPanelUsuario(buscarClienteEnBD(textField.getText()));
			
			//Mostramos mensaje:
			JOptionPane.showMessageDialog(null, "BIENVENIDO "+textField.getText());
		}else if(tipoUsuario.equals(("ADMIN")))
		{
			//Primero cerramos la ventana actual de las credenciales:
			frame.dispose();
			//Inicializamos nueva JFrame VentanaPrincipal pero con distintos par�metros de entrada:
			VentanaPrincipal ventanaPrincipal = new VentanaPrincipal(1080+6,720+35);//800 (anchura del PanelAdministrador), 600 (altura del PanelAdministrador)
			ventanaPrincipal.setVisible(true);
			ventanaPrincipal.cargarPanelAdministrador();
			
			//Mostramos mensaje:
			JOptionPane.showMessageDialog(null, "BIENVENIDO "+textField.getText());
		}
	}
	
	private Cliente buscarClienteEnBD(String user)
	{
		//Buscamos id cliente:
		BaseDeDatos bd = new BaseDeDatos();
		int id_cliente = bd.obtenerIdCliente(user);
		int id_pos_cliente = 0;
		//Buscamos cliente con el id_cliente:
		List<Cliente> arrayClientes = null;
		try {
			arrayClientes = bd.obtenerClientes();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i<arrayClientes.size(); i++)
		{
			if(arrayClientes.get(i).getId_cliente()==id_cliente)
			{
				id_cliente = arrayClientes.get(i).getId_cliente();
				id_pos_cliente = i;
			}
		}
		
		return arrayClientes.get(id_pos_cliente);
	}
	
}


