package es.deusto.spq.ProyectoCinePlus.cliente.util.GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.apache.log4j.Logger;

import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.CinePlusController;

import java.awt.GridLayout;
import java.util.ResourceBundle;

import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class VentanaPelicula extends JFrame {

	private JPanel contentPane;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_2;
	private JPanel panel_12;
	private JPanel panel;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_1; 
	private JPanel panel_14;
	private JPanel panel_16;
	private JPanel panel_20;
	private JPanel panel_19;
	private JPanel panel_17;	
	private JPanel panel_15;
	private JPanel panel_13;
	private JPanel panel_18;
	private JPanel panel_7;
	
	private JLabel lblCartel;
	private JLabel lblDescripcion;
	private JLabel lblTitulo;
	private JLabel lblDuracion;
	private JLabel lblAo;
	private JLabel lblCategoria;
	
	private JButton btnAlquilar;
	private static final long serialVersionUID = 1L;
	static Logger logger = Logger.getLogger(VentanaPrincipal.class.getName());

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPelicula frame = new VentanaPelicula();
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
	public VentanaPelicula(/*CinePlusController controller,ResourceBundle resourceBundle*/) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.WEST);
		
		panel_4 = new JPanel();
		contentPane.add(panel_4, BorderLayout.EAST);
		
		panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
		
		panel_12 = new JPanel();
		panel_2.add(panel_12);
		
		panel_10 = new JPanel();
		panel_2.add(panel_10);
		
		btnAlquilar = new JButton("Alquilar");
		panel_10.add(btnAlquilar);
		
		panel_11 = new JPanel();
		panel_2.add(panel_11);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel.add(panel_5, BorderLayout.NORTH);
		
		JPanel panel_6 = new JPanel();
		panel.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_9 = new JPanel();
		panel.add(panel_9, BorderLayout.EAST);
		panel_9.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_8 = new JPanel();
		panel.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_8.add(panel_14);
		
		JPanel panel_16 = new JPanel();
		panel_8.add(panel_16, BorderLayout.SOUTH);
		panel_16.setLayout(new GridLayout(0, 3, 0, 0));
		
		JPanel panel_20 = new JPanel();
		panel_16.add(panel_20);
		
		JLabel lblCategoria = new JLabel("Categoria");
		panel_20.add(lblCategoria);
		
		JPanel panel_19 = new JPanel();
		panel_16.add(panel_19);
		
		JLabel lblAo = new JLabel("Año");
		panel_19.add(lblAo);
		
		JPanel panel_17 = new JPanel();
		panel_16.add(panel_17);
		
		JLabel lblDuracion = new JLabel("Duracion");
		panel_17.add(lblDuracion);
		
		JPanel panel_15 = new JPanel();
		panel_8.add(panel_15, BorderLayout.NORTH);
		
		JLabel lblTitulo = new JLabel("Titulo");
		panel_15.add(lblTitulo);
		
		JPanel panel_13 = new JPanel();
		panel_8.add(panel_13);
		panel_13.setLayout(new GridLayout(2, 0, 0, 0));
		
		JPanel panel_18 = new JPanel();
		panel_13.add(panel_18);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		panel_18.add(lblDescripcion);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7, BorderLayout.WEST);
		
		JLabel lblCartel = new JLabel("Cartelk");
		panel_7.add(lblCartel);
	}

}
