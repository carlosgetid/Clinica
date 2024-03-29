package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Arreglos.ArregloPaciente;
import Clases.Cama;
import Clases.Paciente;
import librerias.Libreria;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class GuiPaciente extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblCodigoPaciente;
	private JTextField txtPaciente;
	private JLabel lblNombres;
	private JLabel lblApellidos;
	private JLabel lblTelefono;
	private JLabel lblDni;
	private JTextField txtNombres;
	private JTextField txtApellidos;
	private JTextField txtTelefono;
	private JTextField txtDni;
	private JScrollPane scrollPane;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnListar;
	private JButton btnCerrar;
	private JTable tbtableP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiPaciente frame = new GuiPaciente();
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
	public GuiPaciente() {
		setTitle("Mantenimiento | Paciente");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent wc){
				cerrarP();
			}
		});
		setBounds(100, 100, 617, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigoPaciente = new JLabel("Codigo paciente");
		lblCodigoPaciente.setBounds(80, 54, 102, 14);
		contentPane.add(lblCodigoPaciente);
		
		txtPaciente = new JTextField();
		txtPaciente.setBounds(192, 51, 86, 20);
		contentPane.add(txtPaciente);
		txtPaciente.setColumns(10);
		
		lblNombres = new JLabel("Nombres");
		lblNombres.setBounds(90, 87, 77, 14);
		contentPane.add(lblNombres);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setBounds(89, 120, 77, 14);
		contentPane.add(lblApellidos);
		
		lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(322, 68, 61, 14);
		contentPane.add(lblTelefono);
		
		lblDni = new JLabel("DNI");
		lblDni.setBounds(334, 106, 42, 14);
		contentPane.add(lblDni);
		
		txtNombres = new JTextField();
		txtNombres.setBounds(192, 84, 86, 20);
		contentPane.add(txtNombres);
		txtNombres.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(192, 117, 86, 20);
		contentPane.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(385, 65, 86, 20);
		contentPane.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		txtDni = new JTextField();
		txtDni.setBounds(385, 103, 86, 20);
		contentPane.add(txtDni);
		txtDni.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 157, 581, 201);
		contentPane.add(scrollPane);
		
		tbtableP = new JTable();
		tbtableP.setFillsViewportHeight(true);
		tbtableP.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tbtableP);
		tbtableP.setModel(GuiPrincipal.ap);
		tbtableP.getSelectionModel().setSelectionInterval(0, 0);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(10, 7, 89, 23);
		contentPane.add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(109, 7, 89, 23);
		contentPane.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(208, 7, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(307, 7, 89, 23);
		contentPane.add(btnEliminar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(403, 7, 89, 23);
		contentPane.add(btnListar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(502, 7, 89, 23);
		contentPane.add(btnCerrar);
		CodigoAutogeneradoP();
		PacienKeyLimit();
		tbtablePClicked();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(e);
		}
		if (e.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(e);
		}
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
	}
	/*ArregloPaciente ap =new ArregloPaciente();*/
	
	int leerCodigo(){
		return Integer.parseInt(txtPaciente.getText());
	}
	String leerNombre(){
		return txtNombres.getText();
	}
	String leerApellido(){
		return txtApellidos.getText();
	}
	int leerTelefono(){
		return Integer.parseInt(txtTelefono.getText());
	}
	int leerDNI(){
		return Integer.parseInt(txtDni.getText());
	}
	
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		cerrarP();
	}
	private void cerrarP(){
		GuiPrincipal.ap.grabarPacientes();
		dispose();
	}
	void listar(){
		tbtableP.repaint();
		LimpiarP();
		CodigoAutogeneradoP();
	}
	void imprimir(String x){
	}
	protected void actionPerformedBtnAdicionar(ActionEvent e) {
		int tp= txtPaciente.getText().length();
		int tn= txtNombres.getText().length();
		int ta= txtApellidos.getText().length();
		int tl= txtTelefono.getText().length();
		int td= txtDni.getText().length();
		if(tp==6 && tn!=0 && ta!=0 && (tl>4 && tl<10) && td==8){
			if(GuiPrincipal.ap.buscar(leerCodigo())==null){
				Paciente p = new Paciente(leerCodigo(), leerNombre(), leerApellido(), leerTelefono(), leerDNI());
				GuiPrincipal.ap.adicionar(p);
				listar();
				Libreria.Mensaje(this,null, "Datos Ingresados Correctamente", "Adicionar", -1, "images/ok t.png");
				GuiPrincipal.ap.grabarPacientes();
				LimpiarP();
				CodigoAutogeneradoP();
			}
			else
				Libreria.Mensaje(this,null, "el Codigo ya existe", "Error", -1, "images/no ts.png");
		}
		else
			Libreria.Mensaje(this,null, "Ingrese Datos Validos", "Error", -1, "images/no ts.png");
	}
	protected void actionPerformedBtnConsultar(ActionEvent e) {
		if(txtPaciente.getText().length()==6){
			int cod=leerCodigo();
			Paciente p = GuiPrincipal.ap.buscar(cod);
			if(p !=null){
				txtPaciente.setText(""+p.getCodigoPaciente());
				txtNombres.setText(""+p.getNombre());
				txtApellidos.setText(""+p.getApellidos());
				txtTelefono.setText(""+p.getTelefono());
				txtDni.setText(""+p.getDni());
			}
			else
				Libreria.Mensaje(this,null, "el Codigo no existe", "Error", -1, "images/no ts.png");
		}
		else
			Libreria.Mensaje(this, null,"Ingrese un Codigo Valido", "Error", -1, "images/no ts.png");
	}
	protected void actionPerformedBtnModificar(ActionEvent e) {
		if(txtPaciente.getText().length()==6){
			int num=leerCodigo();
			Paciente p = GuiPrincipal.ap.buscar(num);
			if(p !=null){
				String nombre=leerNombre();
				String apellido=leerApellido();
				int telefono=leerTelefono();
				int dni = leerDNI();
				p.setNombre(nombre);
				p.setApellidos(apellido);
				p.setTelefono(telefono);
				p.setDni(dni);	
				Libreria.Mensaje(this,null, "Datos Modificados Correctamente", "Modificar", -1, "images/ok t.png");
				listar();
				LimpiarP();
				CodigoAutogeneradoP();
			}
			else
				Libreria.Mensaje(this,null, "el Codigo no existe", "Error", -1, "images/no ts.png");
		}
		else
			Libreria.Mensaje(this,null, "Ingrese un Codigo Valido", "Error", -1, "images/no ts.png");
	}
	protected void actionPerformedBtnEliminar(ActionEvent e) {
		if(txtPaciente.getText().length()==6){
			if(GuiPrincipal.ap.buscar(leerCodigo())!=null){
				int ok= Libreria.confirmacion(this,null, "�Realemte desea Eliminar este elemento?", "Eliminar", "images/erase t.png");
				if(ok == 0){
					Paciente p=GuiPrincipal.ap.buscar(leerCodigo());
					GuiPrincipal.ap.eliminar(p);
					GuiPrincipal.ap.grabarPacientes();
					Libreria.Mensaje(this,null, "Datos Eliminados Correctamente", "Modificar", -1, "images/ok t.png");
					listar();
					LimpiarP();
					CodigoAutogeneradoP();
				}
			}else
				Libreria.Mensaje(this,null, "el Codigo no existe", "Error", -1, "images/no ts.png");
		}
		else
			Libreria.Mensaje(this,null, "Ingrese un Codigo Valido", "Error", -1, "images/no ts.png");
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		listar();
	}
	private void CodigoAutogeneradoP(){
		txtPaciente.setText(""+GuiPrincipal.ap.generarCodigoP());
	}
	private void PacienKeyLimit(){
		txtPaciente.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e){
				Libreria.SoloNumeros(e, txtPaciente, 6);
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		txtNombres.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent s){
				Libreria.SoloLetras(s, txtNombres, 25);
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		txtApellidos.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent q){
				Libreria.SoloLetras(q, txtApellidos, 30);
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		txtTelefono.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent t){
				Libreria.SoloNumeros(t, txtTelefono, 9);
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		txtDni.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent d){
				Libreria.SoloNumeros(d, txtDni, 8);
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
	}
	private void tbtablePClicked(){
		tbtableP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				LimpiarP();
				int rw= tbtableP.getSelectedRow();
				txtPaciente.setText(""+GuiPrincipal.ap.obtener(rw).getCodigoPaciente());
			}
		});
	}
	private void LimpiarP(){
		txtPaciente.setText("");
		txtNombres.setText("");
		txtApellidos.setText("");
		txtTelefono.setText("");
		txtDni.setText("");
	}
}
