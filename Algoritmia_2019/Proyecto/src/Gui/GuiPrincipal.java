package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Arreglos.ArregloCama;
import Arreglos.ArregloConsulta;
import Arreglos.ArregloInternamiento;
import Arreglos.ArregloMedicina;
import Arreglos.ArregloPaciente;
import Arreglos.ArregloReceta;
import librerias.Libreria;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class GuiPrincipal extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMantenimiento;
	private JMenu mnRegistro;
	private JMenu mnPago;
	private JMenu mnReporte;
	private JMenuItem mntmCama;
	private JMenuItem mntmPaciente;
	private JMenuItem mntmMedicina;
	private JMenuItem mntmConsulta;
	private JMenuItem mntmInternamiento;
	private JMenuItem mntmConsultas;
	private JMenuItem mntmInternamientos;
	private JMenuItem mntmConsultasPendientes;
	private JMenuItem mntmConsultasPagadas;
	private JMenuItem mntmInternamientosPendientes;
	private JMenuItem mntmInternamientosPagados;
	private JMenu mnArchivo;
	private JMenuItem mntmSalir;

	public static ArregloCama ac=new ArregloCama();
	public static ArregloPaciente ap=new ArregloPaciente();
	public static ArregloMedicina am= new ArregloMedicina();
	public static ArregloConsulta acon= new ArregloConsulta();
	public static ArregloReceta ar= new ArregloReceta();
	public static ArregloInternamiento ai=new ArregloInternamiento();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiPrincipal frame = new GuiPrincipal();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GuiPrincipal() {
		setResizable(false);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent wc){
				confirmar();
			}
		});
		setBounds(100, 100, 543, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 538, 27);
		contentPane.add(menuBar);
		
		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);
		
		mntmCama = new JMenuItem("Cama");
		mntmCama.addActionListener(this);
		mnMantenimiento.add(mntmCama);
		
		mntmPaciente = new JMenuItem("Paciente");
		mntmPaciente.addActionListener(this);
		mnMantenimiento.add(mntmPaciente);
		
		mntmMedicina = new JMenuItem("Medicina");
		mntmMedicina.addActionListener(this);
		mnMantenimiento.add(mntmMedicina);
		
		mnRegistro = new JMenu("Registro");
		menuBar.add(mnRegistro);
		
		mntmConsulta = new JMenuItem("Consulta");
		mntmConsulta.addActionListener(this);
		mnRegistro.add(mntmConsulta);
		
		mntmInternamiento = new JMenuItem("Internamiento");
		mntmInternamiento.addActionListener(this);
		mnRegistro.add(mntmInternamiento);
		
		mnPago = new JMenu("Pago");
		menuBar.add(mnPago);
		
		mntmConsultas = new JMenuItem("Consultas");
		mntmConsultas.addActionListener(this);
		mnPago.add(mntmConsultas);
		
		mntmInternamientos = new JMenuItem("Internamientos");
		mntmInternamientos.addActionListener(this);
		mnPago.add(mntmInternamientos);
		
		mnReporte = new JMenu("Reporte");
		menuBar.add(mnReporte);
		
		mntmConsultasPendientes = new JMenuItem("Consultas pendientes");
		mntmConsultasPendientes.addActionListener(this);
		mnReporte.add(mntmConsultasPendientes);
		
		mntmConsultasPagadas = new JMenuItem("Consultas pagadas");
		mntmConsultasPagadas.addActionListener(this);
		mnReporte.add(mntmConsultasPagadas);
		
		mntmInternamientosPendientes = new JMenuItem("Internamientos pendientes");
		mntmInternamientosPendientes.addActionListener(this);
		mnReporte.add(mntmInternamientosPendientes);
		
		mntmInternamientosPagados = new JMenuItem("Internamientos pagados");
		mntmInternamientosPagados.addActionListener(this);
		mnReporte.add(mntmInternamientosPagados);
		
		mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(this);
		mnArchivo.add(mntmSalir);
		
		JLabel lblFondo = new JLabel(new ImageIcon("images/clinica.jpg"));
		lblFondo.setBounds(0, 0, 538, 324);
		contentPane.add(lblFondo);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == mntmInternamientosPagados) {
			actionPerformedMntmInternamientosPagados(arg0);
		}
		if (arg0.getSource() == mntmInternamientosPendientes) {
			actionPerformedMntmInternamientosPendientes(arg0);
		}
		if (arg0.getSource() == mntmConsultasPagadas) {
			actionPerformedMntmConsultasPagadas(arg0);
		}
		if (arg0.getSource() == mntmConsultasPendientes) {
			actionPerformedMntmConsultasPendientes(arg0);
		}
		if (arg0.getSource() == mntmInternamientos) {
			actionPerformedMntmInternamientos(arg0);
		}
		if (arg0.getSource() == mntmConsultas) {
			actionPerformedMntmConsultas(arg0);
		}
		if (arg0.getSource() == mntmInternamiento) {
			actionPerformedMntmInternamiento(arg0);
		}
		if (arg0.getSource() == mntmConsulta) {
			actionPerformedMntmConsulta(arg0);
		}
		if (arg0.getSource() == mntmMedicina) {
			actionPerformedMntmMedicina(arg0);
		}
		if (arg0.getSource() == mntmPaciente) {
			actionPerformedMntmPaciente(arg0);
		}
		if (arg0.getSource() == mntmCama) {
			actionPerformedMntmCama(arg0);
		}
		if (arg0.getSource() == mntmSalir) {
			actionPerformedMntmSalir(arg0);
		}
	}
	private void confirmar(){
		int ok= Libreria.confirmacion(this,null,"�Realmente desea Salir?","Salir","images/shutdown t.png");
		if(ok == 0)
			System.exit(0);
	}
	protected void actionPerformedMntmSalir(ActionEvent arg0) {
		confirmar();
	}
	protected void actionPerformedMntmCama(ActionEvent arg0) {
		GuiCama gc = new GuiCama();
		gc.setVisible(true);
	}
	protected void actionPerformedMntmPaciente(ActionEvent arg0) {
		GuiPaciente gp = new GuiPaciente();
		gp.setVisible(true);
	}
	protected void actionPerformedMntmMedicina(ActionEvent arg0) {
		GuiMedicina gm = new GuiMedicina();
		gm.setVisible(true);
	}
	protected void actionPerformedMntmConsulta(ActionEvent arg0) {
		GuiConsulta gc = new GuiConsulta();
		gc.setVisible(true);
	}
	protected void actionPerformedMntmInternamiento(ActionEvent arg0) {
		GuiInternamiento gi = new GuiInternamiento();
		gi.setVisible(true);
	}
	protected void actionPerformedMntmConsultas(ActionEvent arg0) {
		GuiPGConsultas gcon = new GuiPGConsultas();
		gcon.setVisible(true);
	}
	protected void actionPerformedMntmInternamientos(ActionEvent arg0) {
		GuiPGInternamientos gin = new GuiPGInternamientos();
		gin.setVisible(true);
	}
	protected void actionPerformedMntmConsultasPendientes(ActionEvent arg0) {
		GuiConsultasPendientes gcp = new GuiConsultasPendientes();
		gcp.setVisible(true);
	}
	protected void actionPerformedMntmConsultasPagadas(ActionEvent arg0) {
		GuiConsultasPagadas gpa = new GuiConsultasPagadas();
		gpa.setVisible(true);
	}
	protected void actionPerformedMntmInternamientosPendientes(ActionEvent arg0) {
		GuiInternamientosPendientes gip = new GuiInternamientosPendientes();
		gip.setVisible(true);
	}
	protected void actionPerformedMntmInternamientosPagados(ActionEvent arg0) {
		GuiInternamientosPagados gipa = new GuiInternamientosPagados();
		gipa.setVisible(true);
	}
}
