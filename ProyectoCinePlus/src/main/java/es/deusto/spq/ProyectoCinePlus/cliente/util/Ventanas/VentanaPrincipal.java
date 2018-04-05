package es.deusto.spq.ProyectoCinePlus.cliente.util.Ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LookAndFeel;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import org.jvnet.substance.skin.SubstanceRavenLookAndFeel;//FIXME

import es.deusto.spq.ProyectoCinePlus.servidor.BaseDeDatos;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.CinePlusController;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Conectividad.RMIServiceLocator;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Datos.Cliente;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Paneles.PanelAdministrador;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Paneles.PanelIniciarSesion;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Paneles.PanelRegistro;
import es.deusto.spq.ProyectoCinePlus.cliente.util.Paneles.PanelUsuario;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JScrollPane contenedorDePaneles;
	private int anchura;
	private int altura;
	private PanelIniciarSesion panelIniciarSesion = new PanelIniciarSesion(this);
	private PanelUsuario panelUsuario;
	private PanelAdministrador panelAdministrador;
	private PanelRegistro panelRegistro = new PanelRegistro();
	private BaseDeDatos bd;
	private RMIServiceLocator rmi;
	private CinePlusController cpc;
	/**
	 * Launch the application.
	 */
	public static void main(final String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					RMIServiceLocator rmi=new RMIServiceLocator();
					rmi.setService(args);
					CinePlusController cpc=new CinePlusController(rmi);
					UIManager.setLookAndFeel((LookAndFeel) new SubstanceRavenLookAndFeel());
					VentanaPrincipal frame = new VentanaPrincipal(500,300,rmi,cpc);
					frame.setVisible(true);
					frame.cargarPanelIniciarSesion();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(int anchura, int altura, RMIServiceLocator rmi,CinePlusController cpc) {
		
		//Antes de llamar a los metodos debemos asignar la anchura y altura al JFrame:
		this.anchura = anchura;
		this.altura = altura;
		this.setRmi(rmi);
		this.setCpc(cpc);
		setBd(new BaseDeDatos());
		
		inicializar();
		componentes();
		anyadirComponentes();
		eventos();				
	}
	
	private void inicializar()
	{
		contentPane = new JPanel();
		contenedorDePaneles = new JScrollPane();
	}
	
	private void componentes()
	{
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new LineBorder(Color.ORANGE, 2));
		
		//El contenedor se ajustar� autom�ticamente a la anchura y altura pasadas por par�metro:
		contenedorDePaneles.setBounds(0, 0, anchura - 6, altura - 35);
	}
	
	private void anyadirComponentes()
	{
		setBackground(Color.DARK_GRAY);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setSize(anchura, altura);
		setLocationRelativeTo(null);
		setContentPane(contentPane);	
		
		contentPane.setLayout(null);
		contentPane.add(contenedorDePaneles);

	}
	
	private void eventos()
	{
		//Accedemos al evento del bot�n de volver del panel registro desde el JFrame VentanaPrincipal:
		panelRegistro.btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPanelIniciarSesion();
			}
		});
		//Accedemos al evento del bot�n de registrarse del panel iniciar sesi�n desde el JFrame VentanaPrincipal:
		panelIniciarSesion.BotonRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargarPanelRegistro();
			}
		});
	}
	
	//Metodo para cargar el panel de iniciar sesion en el scrollPane del JFrame VentanaPrincipal:
	public void cargarPanelIniciarSesion()
	{
		//Cargamos el panel en el scrollPane: contenedorDePaneles
		contenedorDePaneles.setViewportView(panelIniciarSesion);
	}
	
	//Metodo para cargar el panel del usuario:
	public void cargarPanelUsuario(Cliente cliente)
	{
		//Inicializamos el panel:
		panelUsuario = new PanelUsuario(cliente);
		//Cargamos el panel en el scrollPane: contenedorDePaneles
		contenedorDePaneles.setViewportView(panelUsuario);
	}
	
	//Metodo para cargar el panel del administrador:
	public void cargarPanelAdministrador()
	{
		//Inicializamos el panel:
		panelAdministrador = new PanelAdministrador();
		//Cargamos el panel en el scrollPane: contenedorDePaneles
		contenedorDePaneles.setViewportView(panelAdministrador);
	}
	
	//Metodo para cargar el panel registro:
	public void cargarPanelRegistro()
	{
		//Cargamos el panel en el scrollPane: contenedorDePaneles
		contenedorDePaneles.setViewportView(panelRegistro);
	}

	public BaseDeDatos getBd() {
		return bd;
	}

	public void setBd(BaseDeDatos bd) {
		this.bd = bd;
	}

	public RMIServiceLocator getRmi() {
		return rmi;
	}

	public void setRmi(RMIServiceLocator rmi) {
		this.rmi = rmi;
	}

	public CinePlusController getCpc() {
		return cpc;
	}

	public void setCpc(CinePlusController cpc) {
		this.cpc = cpc;
	}
}
