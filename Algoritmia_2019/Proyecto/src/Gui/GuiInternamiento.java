package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableColumnModel;

import Clases.Cama;
import Clases.Internamiento;
import Clases.Paciente;
import librerias.Libreria;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Desktop.Action;
import java.awt.Label;
import java.awt.ScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class GuiInternamiento extends JFrame implements ActionListener, ItemListener {

	private JPanel contentPane;
	private JLabel lblCodigoInternamiento;
	private JLabel lblCodigoPaciente;
	private JLabel lblNumeroCama;
	private JLabel lblFechaIngreso;
	private JLabel lblTotalPagar;
	private JLabel lblEstado;
	private JTextField txtCodigoInter;
	private JLabel lblHoraIngreso;
	private JLabel lblFechaSalida;
	private JLabel lblHoraSalida;
	private JTextField txtTotalPago;
	private JComboBox cboEstadoPaciente;
	private JButton btnCerrar;
	private JTable tbIntern;
	private JComboBox cboMesIng;
	private JComboBox<String> cboA�oIng;
	private JComboBox<String> cboHoraIng;
	private JComboBox<String> cboMinIng;
	private JComboBox<String> cboDiaSal;
	private JComboBox cboMesSal;
	private JComboBox<String> cboA�oSal;
	private JComboBox<String> cboHoraSal;
	private JComboBox<String> cboMinSal;
	private JButton btnEliminar;
	private JButton btnListar;
	private JButton btnAdicionar;
	private JComboBox cboCama;
	private JComboBox cboPaciente;
	private JComboBox<String> cboDiaIng;
	private JScrollPane scrollPane;
	private JButton btnModificar;
	private JButton btnConsultar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiInternamiento frame = new GuiInternamiento();
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
	public GuiInternamiento() {
		setTitle("Registro | Internamiento");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we){
				CerrarI();
			}
		});
		setBounds(100, 100, 874, 582);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigoInternamiento = new JLabel("Codigo Internamiento");
		lblCodigoInternamiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodigoInternamiento.setBounds(77, 16, 125, 14);
		contentPane.add(lblCodigoInternamiento);
		
		lblCodigoPaciente = new JLabel("Codigo Paciente");
		lblCodigoPaciente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodigoPaciente.setBounds(77, 44, 98, 14);
		contentPane.add(lblCodigoPaciente);
		
		lblNumeroCama = new JLabel("Numero cama");
		lblNumeroCama.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumeroCama.setBounds(77, 74, 86, 14);
		contentPane.add(lblNumeroCama);
		
		lblFechaIngreso = new JLabel("Fecha ingreso");
		lblFechaIngreso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaIngreso.setBounds(77, 104, 86, 14);
		contentPane.add(lblFechaIngreso);
		
		lblTotalPagar = new JLabel("Total pagar");
		lblTotalPagar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTotalPagar.setBounds(456, 74, 67, 14);
		contentPane.add(lblTotalPagar);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado.setBounds(456, 104, 52, 14);
		contentPane.add(lblEstado);
		
		txtCodigoInter = new JTextField();
		txtCodigoInter.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCodigoInter.setBounds(217, 14, 86, 20);
		contentPane.add(txtCodigoInter);
		txtCodigoInter.setColumns(10);
		
		lblHoraIngreso = new JLabel("Hora ingreso");
		lblHoraIngreso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHoraIngreso.setBounds(77, 134, 80, 14);
		contentPane.add(lblHoraIngreso);
		
		lblFechaSalida = new JLabel("Fecha salida");
		lblFechaSalida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaSalida.setBounds(456, 17, 86, 14);
		contentPane.add(lblFechaSalida);
		
		lblHoraSalida = new JLabel("Hora salida");
		lblHoraSalida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHoraSalida.setBounds(456, 45, 106, 14);
		contentPane.add(lblHoraSalida);
		
		txtTotalPago = new JTextField();
		txtTotalPago.setBounds(544, 72, 86, 20);
		contentPane.add(txtTotalPago);
		txtTotalPago.setColumns(10);
		
		cboEstadoPaciente = new JComboBox();
		cboEstadoPaciente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboEstadoPaciente.setModel(new DefaultComboBoxModel(new String[] {"Internado", "Pagado"}));
		cboEstadoPaciente.setBounds(544, 102, 86, 20);
		contentPane.add(cboEstadoPaciente);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(668, 198, 106, 27);
		contentPane.add(btnCerrar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(9, 236, 838, 298);
		contentPane.add(scrollPane);
		
		tbIntern = new JTable();
		tbIntern.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbIntern.setModel(GuiPrincipal.ai);
		tbIntern.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbIntern);
		tbIntern.getSelectionModel().setSelectionInterval(0, 0);
		
		cboDiaIng = new JComboBox<String>();
		cboDiaIng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboDiaIng.setBounds(217, 102, 52, 20);
		contentPane.add(cboDiaIng);
		
		cboMesIng = new JComboBox();
		cboMesIng.addItemListener(this);
		cboMesIng.setMaximumRowCount(6);
		cboMesIng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboMesIng.setBounds(273, 102, 94, 20);
		contentPane.add(cboMesIng);
		
		cboA�oIng = new JComboBox<String>();
		cboA�oIng.setMaximumRowCount(6);
		cboA�oIng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboA�oIng.setBounds(371, 102, 56, 20);
		contentPane.add(cboA�oIng);
		
		cboHoraIng = new JComboBox<String>();
		cboHoraIng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboHoraIng.setBounds(217, 131, 46, 20);
		contentPane.add(cboHoraIng);
		
		cboMinIng = new JComboBox<String>();
		cboMinIng.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboMinIng.setBounds(269, 131, 46, 20);
		contentPane.add(cboMinIng);
		
		cboDiaSal = new JComboBox<String>();
		cboDiaSal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboDiaSal.setBounds(544, 14, 52, 20);
		contentPane.add(cboDiaSal);
		
		cboMesSal = new JComboBox();
		cboMesSal.addItemListener(this);
		cboMesSal.setMaximumRowCount(6);
		cboMesSal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboMesSal.setBounds(602, 14, 94, 20);
		contentPane.add(cboMesSal);
		
		cboA�oSal = new JComboBox<String>();
		cboA�oSal.setMaximumRowCount(6);
		cboA�oSal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboA�oSal.setBounds(701, 14, 56, 20);
		contentPane.add(cboA�oSal);
		
		cboHoraSal = new JComboBox<String>();
		cboHoraSal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboHoraSal.setBounds(544, 43, 46, 20);
		contentPane.add(cboHoraSal);
		
		cboMinSal = new JComboBox<String>();
		cboMinSal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboMinSal.setBounds(597, 43, 46, 20);
		contentPane.add(cboMinSal);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(96, 198, 106, 27);
		contentPane.add(btnAdicionar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(436, 198, 106, 27);
		contentPane.add(btnEliminar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(552, 198, 106, 27);
		contentPane.add(btnListar);
		
		cboCama = new JComboBox();
		cboCama.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboCama.setBounds(217, 72, 86, 20);
		contentPane.add(cboCama);
		
		cboPaciente = new JComboBox();
		cboPaciente.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboPaciente.setBounds(217, 44, 86, 20);
		contentPane.add(cboPaciente);
		
		
		UIManager.put( "ComboBox.disabledForeground", Color.BLACK );
		CodigoCorrelativo();
		cargarPacientes();
		cargarCamas();
		Libreria.GenerarMeses(cboMesIng);
		Libreria.GenerarMeses(cboMesSal);
		Libreria.GenerarA�os(cboA�oIng);
		Libreria.GenerarA�os(cboA�oSal);
		Libreria.GenerarHoras(cboHoraIng);
		Libreria.GenerarHoras(cboHoraSal);
		Libreria.GenerarMinutos(cboMinIng);
		Libreria.GenerarMinutos(cboMinSal);
		Libreria.GenerarDias(cboDiaIng, cboMesIng.getSelectedIndex());
		Libreria.GenerarDias(cboDiaSal, cboMesSal.getSelectedIndex());
		txtTotalPago.setText("200.00");
		InterKeyLimit();
		tbTableInClicked();
		Libreria.colocarA�oActual(cboA�oIng);
		Libreria.colocarA�oActual(cboA�oSal);
		Libreria.colocarMesActual(cboMesIng);
		Libreria.colocarMesActual(cboMesSal);
		Libreria.colocarHoraActual(cboHoraIng);
		Libreria.colocarHoraActual(cboHoraSal);
		Libreria.colocarMinutosAprox(cboMinIng);
		Libreria.colocarMinutosAprox(cboMinSal);
		Libreria.colocarDiaActual(cboDiaIng);
		Libreria.colocarDiaActual(cboDiaSal);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(321, 198, 106, 27);
		contentPane.add(btnModificar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(209, 198, 106, 27);
		contentPane.add(btnConsultar);
		AjustarAnchoCol();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if(e.getSource() == btnAdicionar){
			APbtnAdicionar(e);
		}
		if(e.getSource() == btnEliminar){
			APbtnEliminar(e);
		}
		if(e.getSource() == btnListar){
			APbtnListar(e);
		}
		if(e.getSource() == btnModificar){
			APbtnModificar(e);
		}
		if(e.getSource() == btnConsultar){
			APbtnConsultar(e);
		}
	}
	protected void APbtnModificar(ActionEvent e){
		int tci= txtCodigoInter.getText().length();
		if(tci!=6){
			Libreria.Mensaje(this,null,"Ingrese un Codigo valido", "Error", -1, "images/no ts.png");
		}
		else{
			if((GuiPrincipal.ai.buscar(LeerCodInternam()))!=null){
				Internamiento into= GuiPrincipal.ai.buscar(LeerCodInternam());
				cboPaciente.setSelectedItem(""+into.getCodigoPaciente());
				Cama c= GuiPrincipal.ac.buscar(into.getNumeroCama());
				c.setEstado(0);
				into.setFechaIngreso(LeerFechaIngreso());
				into.setHoraIngreso(LeerHoraIngreso());
				into.setFechaSalida(LeerFechaSalida());
				into.setHoraSalida(LeerHoraSalida());
				into.setTotalPagar(LeerTotalPagar());
				into.setEstado(cboEstadoPaciente.getSelectedIndex());
				into.setNumeroCama(LeerNumCama());
				Cama c2= GuiPrincipal.ac.buscar(LeerNumCama());
				c2.setEstado(1);
				Libreria.Mensaje(this,null, "Datos Modificados Correctamente", "Adicionar", -1, "images/ok t.png");
				GuiPrincipal.ai.grabarInternamientos();
				GuiPrincipal.ac.grabarCama();
				cargarCamas();
				cargarPacientes();
				limpiar();
				CodigoCorrelativo();
				listar();
			}
			else
				Libreria.Mensaje(this,null, "El Codigo no Existe", "Error", -1, "images/no ts.png");
		}
		
	}
	protected void APbtnConsultar(ActionEvent e){
		int tci= txtCodigoInter.getText().length();
		if(tci!=6){
			Libreria.Mensaje(this,null,"Ingrese un Codigo valido", "Error", -1, "images/no ts.png");
		}
		else{
			if((GuiPrincipal.ai.buscar(LeerCodInternam()))!=null){
				Internamiento into= GuiPrincipal.ai.buscar(LeerCodInternam());
				cboPaciente.setSelectedItem(""+into.getCodigoPaciente());
				cboCama.setSelectedItem(""+into.getNumeroCama());
				Libreria.ConFechaMod(into.getFechaIngreso(), cboDiaIng, cboMesIng, cboA�oIng);
				Libreria.ConHoraMod(into.getHoraIngreso(), cboHoraIng, cboMinSal);
				Libreria.ConFechaMod(into.getFechaSalida(), cboDiaSal, cboMesSal, cboA�oSal);
				Libreria.ConHoraMod(into.getHoraSalida(), cboHoraSal, cboMinSal);
				txtTotalPago.setText(""+into.getTotalPagar());
				cboEstadoPaciente.setSelectedIndex(into.getEstado());
			}
			else
				Libreria.Mensaje(this,null, "El Codigo no Existe", "Error", -1, "images/no ts.png");
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		CerrarI();
	}
	protected void APbtnAdicionar(ActionEvent e){
		int tci= txtCodigoInter.getText().length();
		double ttp= Double.parseDouble(txtTotalPago.getText());
		if((tci!=6)||(ttp<200)){
			Libreria.Mensaje(this,null,"Ingrese Datos Validos", "Error", -1, "images/no ts.png");
		}
		else{
			if(LeerEstadoPaciente()==0){
				if((GuiPrincipal.ai.buscar(LeerCodInternam()))==null){
					Internamiento i=new Internamiento(LeerCodInternam(), LeerCodPaciente(), LeerNumCama(), LeerFechaIngreso(), LeerHoraIngreso(),
							LeerFechaSalida(), LeerHoraSalida(), LeerTotalPagar(), LeerEstadoPaciente());
					GuiPrincipal.ai.adicionarIn(i);
					listar();
					Cama c= GuiPrincipal.ac.buscar(LeerNumCama());
					c.setEstado(1);
					Libreria.Mensaje(this,null, "Datos Ingresados Correctamente", "Adicionar", -1, "images/ok t.png");
					GuiPrincipal.ai.grabarInternamientos();
					GuiPrincipal.ac.grabarCama();
					cargarCamas();
					cargarPacientes();
					limpiar();
					CodigoCorrelativo();
				}
				else
					Libreria.Mensaje(this,null,"El Codigo Ya Existe", "Error", -1, "images/no ts.png");
				}
			else
				Libreria.Mensaje(this,null,"Fije el estado en 'Internado' para poder Adicionar", "Error", -1, "images/no ts.png");
		}
		
	}
	protected void APbtnEliminar(ActionEvent e){
		if((txtCodigoInter.getText().length())!=0){
			Internamiento in= GuiPrincipal.ai.buscar(LeerCodInternam());
			if(in!=null){
				int ok= Libreria.confirmacion(this,null, "�Realemte desea Eliminar este elemento?", "Eliminar", "images/erase t.png");
				if(ok==0){
					int cod= in.getNumeroCama();
					GuiPrincipal.ai.eliminacion(in);
					listar();
					Cama c= GuiPrincipal.ac.buscar(cod);
					c.setEstado(0);
					Libreria.Mensaje(this,null, "Datos Eliminados Correctamente", "Modificar", -1, "images/ok t.png");
					GuiPrincipal.ai.grabarInternamientos();
					GuiPrincipal.ac.grabarCama();
					cargarCamas();
					cargarPacientes();
					limpiar();
					CodigoCorrelativo();
					listar();
				}
			}
			else
				Libreria.Mensaje(this,null, "El Codigo no Existe", "Error", -1, "images/no ts.png");
		}
		else
			Libreria.Mensaje(this,null, "Ingrese un Codigo valido", "Error", -1, "images/no ts.png");
	}
	protected void APbtnListar(ActionEvent e){
		listar();
	}
	private void listar(){
		CodigoCorrelativo();
		limpiar();
		GuiPrincipal.ai.grabarInternamientos();
		GuiPrincipal.ac.grabarCama();
		tbIntern.repaint();
	}
	private void CerrarI(){
		GuiPrincipal.ai.grabarInternamientos();
		GuiPrincipal.ac.grabarCama();
		dispose();
	}
	private void CodigoCorrelativo(){
		txtCodigoInter.setText(""+GuiPrincipal.ai.CodigoCorrelativo());
	}
	private void cargarPacientes(){
		cboPaciente.removeAllItems();
		for (int i = 0; i < GuiPrincipal.ap.tama�o(); i++) {
			Paciente p = GuiPrincipal.ap.obtener(i);
			Internamiento inter= GuiPrincipal.ai.buscarPaciente(p.getCodigoPaciente());
			if(inter==null){
				cboPaciente.addItem(""+p.getCodigoPaciente());
			}
			else if(inter.getEstado()==1){
				cboPaciente.addItem(""+p.getCodigoPaciente());
			}
		}
	}
	private void cargarCamas(){
		cboCama.removeAllItems();
		for (int i = 0; i < GuiPrincipal.ac.tama�o(); i++) {
			Cama c = GuiPrincipal.ac.obtener(i);
			if(c.getEstado()==0){
				cboCama.addItem(""+c.getNumeroCama());
			}
		}
	}
	private int LeerCodInternam(){
		return Integer.parseInt(txtCodigoInter.getText().trim());
	}
	private Integer LeerCodPaciente(){
		return Integer.parseInt((String)cboPaciente.getSelectedItem());
	}
	private Integer LeerNumCama(){
		return Integer.parseInt((String)cboCama.getSelectedItem());
	}
	private String LeerFechaIngreso(){
		return Libreria.obtenerFecha(cboDiaIng, cboMesIng, cboA�oIng);
	}
	private String LeerHoraIngreso(){
		return Libreria.obtenerHora(cboHoraIng, cboMinIng);
	}
	private String LeerFechaSalida(){
		return Libreria.obtenerFecha(cboDiaSal, cboMesSal, cboA�oSal);
	}
	private String LeerHoraSalida(){
		return Libreria.obtenerHora(cboHoraSal, cboMinSal);
	}
	private double LeerTotalPagar(){
		return Double.parseDouble(txtTotalPago.getText());
	}
	private int LeerEstadoPaciente(){
		return cboEstadoPaciente.getSelectedIndex();
	}
	private void InterKeyLimit(){
		txtCodigoInter.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				Libreria.SoloNumeros(e, txtCodigoInter, 6);
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		txtTotalPago.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				Libreria.SoloNumerosYDeciMales(e, txtTotalPago, 8);
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
	}
	private void tbTableInClicked(){
		tbIntern.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				limpiar();
				int rw= tbIntern.getSelectedRow();
				txtCodigoInter.setText(""+GuiPrincipal.ai.obtener(rw).getCodigoInternamiento());
				limpiar();
			}
		});
	}
	private void limpiar(){
		txtTotalPago.setText("200.00");
		Libreria.colocarA�oActual(cboA�oIng);
		Libreria.colocarA�oActual(cboA�oSal);
		Libreria.colocarMesActual(cboMesIng);
		Libreria.colocarMesActual(cboMesSal);
		Libreria.colocarHoraActual(cboHoraIng);
		Libreria.colocarHoraActual(cboHoraSal);
		Libreria.colocarMinutosAprox(cboMinIng);
		Libreria.colocarMinutosAprox(cboMinSal);
		Libreria.colocarDiaActual(cboDiaIng);
		Libreria.colocarDiaActual(cboDiaSal);
	}
	private int anchoColumna(int p){
		return p*scrollPane.getWidth()/100;
	}
	private void AjustarAnchoCol(){
		TableColumnModel t= tbIntern.getColumnModel();
		t.getColumn(0).setPreferredWidth(anchoColumna(16));
		t.getColumn(1).setPreferredWidth(anchoColumna(13));
		t.getColumn(2).setPreferredWidth(anchoColumna(11));
		t.getColumn(3).setPreferredWidth(anchoColumna(11));
		t.getColumn(4).setPreferredWidth(anchoColumna(10));
		t.getColumn(5).setPreferredWidth(anchoColumna(10));
		t.getColumn(6).setPreferredWidth(anchoColumna(10));
		t.getColumn(7).setPreferredWidth(anchoColumna(10));
		t.getColumn(8).setPreferredWidth(anchoColumna(9));
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource()==cboMesIng){
			CboGenerarDias(cboDiaIng, cboMesIng);
		}
		if(e.getSource()==cboMesSal){
			CboGenerarDias(cboDiaSal, cboMesSal);
		}
	}
	private void CboGenerarDias(JComboBox cbodia, JComboBox cbomes){
		Libreria.GenerarDias(cbodia, cbomes.getSelectedIndex());
		Libreria.colocarDiaActual(cbodia);
	}
}
