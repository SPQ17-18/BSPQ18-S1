package es.deusto.spq.ProyectoCinePlus.cliente.util.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.CinePlusController;
import javax.swing.JList;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

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
	private JTextField textField;
	private JPanel panel_17;
	private JTextField textField_1;
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
	private JTextField textField_2;

	static Logger logger = Logger.getLogger(VentanaSaldo.class.getName());
	
	/**
	 * Create the frame.
	 */
	public VentanaSaldo(CinePlusController controller, final ResourceBundle resourceBundle) {
		logger.info("VentanaSaldo");
		// Inicializamos el controlador
		this.setController(controller);
		this.resourceBundle = resourceBundle;

		BufferedImage img = null;
		try {
			img = ImageIO.read(new File(VentanaPrincipal.pathn + "logocuadrado50.png"));
		} catch (IOException e) {
		}
		setIconImage(img);

		// setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaLogin.class.getResource(VentanaPrincipal.pathn+"logocuadrado50.png")));

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
				
			}
		});
		panel.add(btnRecargarSaldo);

		btnAtras = new JButton(resourceBundle.getString("back_msg"));
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

		textField_2 = new JTextField();
		panel_19.add(textField_2);
		textField_2.setColumns(3);

		panel_11 = new JPanel();
		panel_4.add(panel_11);
		panel_11.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panel_10 = new JPanel();
		panel_11.add(panel_10);
		panel_10.setLayout(new GridLayout(3, 1, 5, 5));

		panel_9 = new JPanel();
		panel_10.add(panel_9);

		textField = new JTextField();
		panel_9.add(textField);
		textField.setColumns(10);

		panel_17 = new JPanel();
		panel_10.add(panel_17);

		textField_1 = new JTextField();
		panel_17.add(textField_1);
		textField_1.setColumns(10);

		panel_13 = new JPanel();
		panel_10.add(panel_13);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "5€", "10€", "25€", "50€" }));
		panel_13.add(comboBox);

		panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.NORTH);

		lblIniciaSesion = new JLabel(resourceBundle.getString("add_balance_msg"));
		panel_5.add(lblIniciaSesion);

	}

	public CinePlusController getController() {
		return controller;
	}

	public void setController(CinePlusController controller) {
		this.controller = controller;
	}
}
