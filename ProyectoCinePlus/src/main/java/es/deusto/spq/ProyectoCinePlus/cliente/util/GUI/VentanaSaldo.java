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

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
 
/**
 * Ventana Saldo. Es la ventana de Saldo, la cual permite anyadir saldo a un usuario.
 * @author Fercol
 * @since 2.0.0
 *
 */
public class VentanaSaldo extends JFrame {

	private static final long serialVersionUID = 1L;
	private CinePlusController controller;
	private JPanel contentPane;

	private JPanel panel_1;
	private JPanel panel_3;
	private JPanel panel_2;
	private JPanel panel_6;
	private JPanel panel;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_4;
	private JPanel panel_11;
	private JPanel panel_5;
	private JPanel panel_10;
	private JPanel panel_13;

	private JButton btnRecargarSaldo;
	private JButton btnAtras;
	private JLabel lblIniciaSesion;
	protected ResourceBundle resourceBundle;
	private JComboBox comboBox;
	private JPanel panel_9;
	private JTextField textFieldNombre;
	private JPanel panel_17;
	private JTextField textFieldNumero;
	private JPanel panel_12;
	private JPanel panel_14;
	private JPanel panel_15;
	private JPanel panel_16;
	private JPanel panel_18;
	private JLabel lblNombreCompleto;
	private JLabel lblNewLabel;
	private JPanel panel_19;
	private JPanel panel_20;
	private JLabel lblCvc;
	private JTextField textFieldCVC;

	static Logger logger = Logger.getLogger(VentanaSaldo.class.getName());
	
	/**
	 * Constructor de la ventana Saldo. 
	 * @param controller CinePlusController
	 * @param resourceBundle ResourceBundle
	 * @param userLogeado Usuario
	 */
	public VentanaSaldo(CinePlusController controller, final ResourceBundle resourceBundle, Usuario userLogeado) {
		logger.info("VentanaSaldo");
		this.setController(controller);
		this.resourceBundle = resourceBundle;

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(VentanaPrincipal.pathn + "logocuadrado50.png"));
		} catch (IOException e) {
		}
		setIconImage(img);

		setTitle(resourceBundle.getString("title_balance_msg"));
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

		btnRecargarSaldo = new JButton(resourceBundle.getString("confirm_msg"));
		btnRecargarSaldo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comprobarcampos()) {
					String saldoS = (String) comboBox.getSelectedItem();
					float saldoF = Float.parseFloat(saldoS);
					logger.info(saldoF);
					//obtenemos saldo que tiene y le anyadimos más.
					float saldoViejo = userLogeado.getSaldo();
					saldoViejo += saldoF;
					userLogeado.setSaldo(saldoViejo);
					logger.info(userLogeado);
					try {
						controller.eliminarUsuario(userLogeado);
						controller.RegistrarUsuario(userLogeado.getUsuario(), userLogeado.getEmail(), userLogeado.getNombre(), userLogeado.getApellido(), userLogeado.getPassword(), userLogeado.getPais(), userLogeado.getSaldo(), userLogeado.isAdmin());
					} catch (RemoteException e) {
						e.printStackTrace();
					}
					VentanaUsuario ventanaUsuario = new VentanaUsuario(controller, resourceBundle, userLogeado);
					ventanaUsuario.setVisible(true);
					dispose();
				}else {
					limpiarCampos();
				}
				
			}
		});
		panel.add(btnRecargarSaldo);

		btnAtras = new JButton(resourceBundle.getString("back_msg"));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				logger.info("Boton Atras (Ventana Saldo)");
				VentanaUsuario ventanaUsuario = new VentanaUsuario(controller, resourceBundle, userLogeado);
				ventanaUsuario.setVisible(true);
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

		panel_12 = new JPanel();
		panel_4.add(panel_12);
		panel_12.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panel_14 = new JPanel();
		panel_12.add(panel_14);
		panel_14.setLayout(new GridLayout(3, 1, 5, 5));

		panel_15 = new JPanel();
		panel_14.add(panel_15);

		lblNombreCompleto = new JLabel(resourceBundle.getString("full_name_msg"));
		panel_15.add(lblNombreCompleto);

		panel_16 = new JPanel();
		panel_14.add(panel_16);

		lblNewLabel = new JLabel(resourceBundle.getString("credit_card_msg"));
		panel_16.add(lblNewLabel);

		panel_18 = new JPanel();
		panel_14.add(panel_18);
		panel_18.setLayout(new GridLayout(0, 2, 0, 0));

		panel_20 = new JPanel();
		panel_18.add(panel_20);

		lblCvc = new JLabel("CVC:");
		panel_20.add(lblCvc);

		panel_19 = new JPanel();
		panel_18.add(panel_19);

		textFieldCVC = new JTextField();
		panel_19.add(textFieldCVC);
		textFieldCVC.setColumns(3);

		panel_11 = new JPanel();
		panel_4.add(panel_11);
		panel_11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panel_10 = new JPanel();
		panel_11.add(panel_10);
		panel_10.setLayout(new GridLayout(3, 1, 5, 5));

		panel_9 = new JPanel();
		panel_10.add(panel_9);

		textFieldNombre = new JTextField();
		panel_9.add(textFieldNombre);
		textFieldNombre.setColumns(10);

		panel_17 = new JPanel();
		panel_10.add(panel_17);

		textFieldNumero = new JTextField();
		panel_17.add(textFieldNumero);
		textFieldNumero.setColumns(10);

		panel_13 = new JPanel();
		panel_10.add(panel_13);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "5", "10", "25", "50" }));
		panel_13.add(comboBox);

		panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.NORTH);

		lblIniciaSesion = new JLabel(resourceBundle.getString("add_balance_msg"));
		panel_5.add(lblIniciaSesion);

	}
	
	/**
	 * Metodo get del controller
	 * @return controller CinePlusController
	 */
	public CinePlusController getController() {
		return controller;
	}

	/**
	 * Metodo set del controller
	 * @param controller CinePlusController
	 */
	public void setController(CinePlusController controller) {
		this.controller = controller;
	}
	
	/**
	 * Metodo que comprueba los datos de los campos esten llenos. 
	 * En caso de error, lo mostrara en una ventana de error. 
	 * @return comprobar boolean
	 */
	public boolean comprobarcampos() {
		logger.info("Funci�n comprobar campos");
		boolean comprobar = true;
		String error ="";
		if(textFieldNombre.getText().trim().equals("")) {
			error = resourceBundle.getString("full_name2_msg");
		}
		if(textFieldNumero.getText().trim().equals("")) {
			if(!error.isEmpty()){
				error+=" - "+resourceBundle.getString("credit_card2_msg");
			}else{
				error+=resourceBundle.getString("credit_card2_msg");
			}
		}
		if(textFieldCVC.getText().trim().equals("")) {
			if(!error.isEmpty()){
				error+=" - CVC";
			}else{
				error+="CVC";
			}
		}
		if(!error.isEmpty()) {
			JOptionPane.showMessageDialog(null, resourceBundle.getString("error_data_msg") + error, "ERROR!", JOptionPane.ERROR_MESSAGE);
			comprobar=false;
		}
		return comprobar;
	}
	
	/**
	 * Metodo que limpia los campos de la ventana.
	 */
	private void limpiarCampos() {
		textFieldNombre.setText("");
		textFieldNumero.setText("");
		textFieldCVC.setText("");
	}
}
