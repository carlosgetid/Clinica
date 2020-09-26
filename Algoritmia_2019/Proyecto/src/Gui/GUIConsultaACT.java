package Gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import javax.swing.plaf.basic.BasicComboBoxUI;

import Clases.Consulta;
import Clases.Medicina;
import Clases.Paciente;
import Clases.Receta;
import librerias.Libreria;

import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import java.awt.Label;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

import javax.imageio.ImageTranscoder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop.Action;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.ItemEvent;
import java.awt.List;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.DropMode;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Array;


public class GUIConsultaACT extends JDialog implements ItemListener,ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtConsulta;
	/**
	 * @wbp.nonvisual location=-38,279
	 */
	private final JTextField textField_3 = new JTextField();
	private JTextField txtTotalPagar;
	private JTextField txtCantidadMed;
	private JComboBox <String> cboMedicina;
	private JComboBox <String> cboEstado;
	private JComboBox <String>cboHoraAtencion;
	private JComboBox <String>cboMinAtencionH;
	private JComboBox <String>cboDiaAtencion;
	private JComboBox <String>cboMesAtencion;
	private JComboBox <String>cboAñoAtencion;
	private JComboBox <String> cboPaciente;
	private JButton btnCreceta;
	private JTextArea txtS;
	private JButton btnAgregarMedicina;
	private JButton btnEliminarMedicina;
	private JButton btnAdicionarConsulta;
	private JTable tbMedicinas;
	private DefaultTableModel Tmodel;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_Medi;
	private JTable Tbconsul;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GUIConsultaACT dialog = new GUIConsultaACT(null);
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GUIConsultaACT(JTable TbCon){
		Tbconsul=TbCon;
		setTitle("Registro | Consulta | Adicionar Consulta");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent wc){
				ConfirmarCR();
			}
			@Override
			public void windowActivated(WindowEvent e){
				}
			@Override
			public void windowOpened(WindowEvent e){
				}
			}
		);
		textField_3.setColumns(10);
		setBounds(100, 100, 534, 704);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		cboMesAtencion = new JComboBox();
		cboMesAtencion.addItemListener(this);
		cboMesAtencion.setMaximumRowCount(6);
		cboMesAtencion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboMesAtencion.setBounds(295, 97, 94, 20);
		contentPanel.add(cboMesAtencion);
		
		cboPaciente = new JComboBox <String>();
		cboPaciente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboPaciente.setBounds(233, 66, 86, 20);
		contentPanel.add(cboPaciente);
		
		txtConsulta = new JTextField();
		txtConsulta.setBounds(233, 35, 86, 20);
		contentPanel.add(txtConsulta);
		txtConsulta.setColumns(10);
		
		cboDiaAtencion = new JComboBox<String>();
		cboDiaAtencion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboDiaAtencion.setBounds(233, 97, 52, 20);
		contentPanel.add(cboDiaAtencion);
		
		cboAñoAtencion = new JComboBox<String>();
		cboAñoAtencion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboAñoAtencion.setMaximumRowCount(6);
		cboAñoAtencion.setBounds(399, 97, 56, 20);
		contentPanel.add(cboAñoAtencion);
		
		cboHoraAtencion = new JComboBox<String>();
		cboHoraAtencion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboHoraAtencion.setBounds(233, 128, 46, 20);
		contentPanel.add(cboHoraAtencion);
		
		cboMinAtencionH = new JComboBox<String>();
		cboMinAtencionH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboMinAtencionH.setBounds(295, 128, 46, 20);
		contentPanel.add(cboMinAtencionH);
		
		txtTotalPagar = new JTextField();
		txtTotalPagar.setBounds(233, 161, 86, 20);
		contentPanel.add(txtTotalPagar);
		txtTotalPagar.setColumns(10);
		
		cboEstado = new JComboBox <String>();
		cboEstado.setEnabled(false);
		cboEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Pendiente", "Pagado"}));
		cboEstado.setBounds(233, 192, 86, 20);
		contentPanel.add(cboEstado);
		
		cboMedicina = new JComboBox <String>();
		cboMedicina.setEnabled(false);
		cboMedicina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboMedicina.setBounds(177, 446, 120, 20);
		contentPanel.add(cboMedicina);
		
		txtCantidadMed = new JTextField();
		txtCantidadMed.setEnabled(false);
		txtCantidadMed.setBounds(399, 446, 43, 20);
		contentPanel.add(txtCantidadMed);
		txtCantidadMed.setColumns(10);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 533, 498, 121);
		contentPanel.add(scrollPane);
		
		tbMedicinas = new JTable(){
			 private static final long serialVersionUID = 1L;
		     public boolean isCellEditable(int row, int column) {                
		    	 return false;               
		     };
		};
		Tmodel = new DefaultTableModel();
		tbMedicinas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbMedicinas.setBorder(null);
		tbMedicinas.setModel(Tmodel);
		tbMedicinas.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbMedicinas);
		
		btnCreceta = new JButton("Listar Datos");
		btnCreceta.addActionListener(this);
		btnCreceta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCreceta.setBounds(115, 243, 125, 31);
		contentPanel.add(btnCreceta);;
		
		Label label_1 = new Label("Codigo de Paciente");
		label_1.setBounds(99, 64, 119, 22);
		contentPanel.add(label_1);
		
		
		Label label = new Label("Codigo de Consulta");
		label.setBounds(99, 35, 119, 22);
		contentPanel.add(label);
		
		Label label_2 = new Label("Fecha de Atenci\u00F3n");
		label_2.setBounds(101, 95, 107, 22);
		contentPanel.add(label_2);
		
		Label label_3 = new Label("Hora de Atenci\u00F3n");
		label_3.setBounds(101, 128, 98, 22);
		contentPanel.add(label_3);
		
		Label label_4 = new Label("Total a Pagar");
		label_4.setBounds(115, 161, 79, 22);
		contentPanel.add(label_4);
		
		Label label_5 = new Label("Estado");
		label_5.setBounds(125, 192, 52, 22);
		contentPanel.add(label_5);
		
		Label label_7 = new Label("Cantidad");
		label_7.setBounds(331, 446, 56, 22);
		contentPanel.add(label_7);
		
		Label label_8 = new Label(":");
		label_8.setFont(new Font("Arial", Font.BOLD, 16));
		label_8.setAlignment(Label.CENTER);
		label_8.setBounds(285, 126, 9, 22);
		contentPanel.add(label_8);
		
		Label label_6 = new Label("Medicinas a Recetar");
		label_6.setBounds(52, 446, 119, 22);
		contentPanel.add(label_6);
		
		scrollPane_Medi = new JScrollPane();
		scrollPane_Medi.setBounds(10, 285, 498, 141);
		contentPanel.add(scrollPane_Medi);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane_Medi.setViewportView(txtS);
		
		btnAgregarMedicina = new JButton("Agregar Medicina");
		btnAgregarMedicina.setEnabled(false);
		btnAgregarMedicina.addActionListener(this);
		btnAgregarMedicina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAgregarMedicina.setBounds(115, 491, 131, 31);
		contentPanel.add(btnAgregarMedicina);
		
		btnEliminarMedicina = new JButton("Eliminar Medicina");
		btnEliminarMedicina.setEnabled(false);
		btnEliminarMedicina.addActionListener(this);
		btnEliminarMedicina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEliminarMedicina.setBounds(281, 491, 131, 31);
		contentPanel.add(btnEliminarMedicina);
		
		btnAdicionarConsulta = new JButton("Adicionar Consulta");
		btnAdicionarConsulta.setEnabled(false);
		btnAdicionarConsulta.addActionListener(this);
		btnAdicionarConsulta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAdicionarConsulta.setBounds(270, 243, 142, 31);
		contentPanel.add(btnAdicionarConsulta);
		
		UIManager.put( "ComboBox.disabledForeground", Color.BLACK );
		codigoCorrelativoCON();
		cargarPacientes();
		Libreria.GenerarAños(cboAñoAtencion);
		Libreria.GenerarMeses(cboMesAtencion);
		Libreria.GenerarHoras(cboHoraAtencion);
		Libreria.GenerarMinutos(cboMinAtencionH);
		Libreria.GenerarDias(cboDiaAtencion, cboMesAtencion.getSelectedIndex());
		cargarMedicinas();
		txtTotalPagar.setText("100.00");
		txtConsulta.setDisabledTextColor(Color.black);
		txtTotalPagar.setDisabledTextColor(Color.black);
		txtCantidadMed.setDisabledTextColor(Color.black);
		Tmodel.setColumnCount(0);
		Tmodel.addColumn("Codigo Medicina");
		Tmodel.addColumn("Nombre Medicina");
		Tmodel.addColumn("Precio Unitario");
		Tmodel.addColumn("Cantidad");
		Tmodel.addColumn("Precio de Venta"
				+ "");
		AjustarAnchoCol();
		ConsultaKeyLimitStart();
		Libreria.colocarAñoActual(cboAñoAtencion);
		Libreria.colocarHoraActual(cboHoraAtencion);
		Libreria.colocarMinutosAprox(cboMinAtencionH);
		Libreria.colocarMesActual(cboMesAtencion);
		Libreria.colocarDiaActual(cboDiaAtencion);
	}
	private void AccionesReInicio(){
		txtS.setText("");
		codigoCorrelativoCON();
		txtTotalPagar.setText("100.00");
		Libreria.colocarAñoActual(cboAñoAtencion);
		Libreria.colocarHoraActual(cboHoraAtencion);
		Libreria.colocarMinutosAprox(cboMinAtencionH);
		Libreria.colocarMesActual(cboMesAtencion);
		Libreria.colocarDiaActual(cboDiaAtencion);
		cboMedicina.setSelectedIndex(0);
		txtCantidadMed.setText("");
		Tmodel.setRowCount(0);
		txtConsulta.setEnabled(true);
		cboPaciente.setEnabled(true);
		cboDiaAtencion.setEnabled(true);
		cboMesAtencion.setEnabled(true);
		cboAñoAtencion.setEnabled(true);
		cboHoraAtencion.setEnabled(true);
		cboMinAtencionH.setEnabled(true);
		txtTotalPagar.setEnabled(true);
		cboMedicina.setEnabled(false);
		txtCantidadMed.setEnabled(false);
		btnAgregarMedicina.setEnabled(false);
		btnEliminarMedicina.setEnabled(false);
		btnAdicionarConsulta.setEnabled(false);
		btnCreceta.setEnabled(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCreceta){
			APbtnCreceta(e);
		}
		if(e.getSource()==btnAgregarMedicina){
			APbtnAgregarMedicina(e);
		}
		if(e.getSource()==btnEliminarMedicina){
			APbtnEliminarMedicina(e);
		}
		if(e.getSource()==btnAdicionarConsulta){
			APbtnAdicionarConsulta(e);
		}
	}
	protected void APbtnCreceta(ActionEvent g0){
		int tc= txtConsulta.getText().length();
		int ttp= txtTotalPagar.getText().length();
		if((tc != 6)||(ttp==0)){
			Libreria.Mensaje(null,this,"Ingrese Datos Validos", "Error", -1, "images/no ts.png");
		}
		else{
			if(GuiPrincipal.acon.buscar(LeerConsulta())==null){
				Listar();
				txtConsulta.setEnabled(false);
				cboPaciente.setEnabled(false);
				cboDiaAtencion.setEnabled(false);
				cboMesAtencion.setEnabled(false);
				cboAñoAtencion.setEnabled(false);
				cboHoraAtencion.setEnabled(false);
				cboMinAtencionH.setEnabled(false);
				txtTotalPagar.setEnabled(false);
				cboMedicina.setEnabled(true);
				txtCantidadMed.setEnabled(true);
				btnAgregarMedicina.setEnabled(true);
				btnEliminarMedicina.setEnabled(true);
				btnAdicionarConsulta.setEnabled(true);
				btnCreceta.setEnabled(false);
				ConsultaKeyLimitMed();
			}
			else
				Libreria.Mensaje(null,this,"El Codigo Ya Existe", "Error", -1, "images/no ts.png");
		}	
	}
	private void Listar(){
		txtS.setText("\tDATOS INGRESADOS\n\n"+
				"\tCodigo de Consulta:\t"+LeerConsulta()+
				"\n\tCodigo de Paciente:\t"+LeerPaciente()+
				"\n\tFecha de Atencion:\t"+LeerFechaAtencion()+
				"\n\tHora de Atencion:\t"+LeerHoraAtencion()+
				"\n\tTotal a Pagar:\t\t"+LeerTotalPagar()+
				"\n\tEstado:\t\t"+LeerEstado());
	}
	int cR;
	protected void APbtnAgregarMedicina(ActionEvent g1){
		if(txtCantidadMed.getText().length()!=0){
			Tmodel.setRowCount(cR);
			Medicina med= GuiPrincipal.am.buscarCoxNom(LeerMedicina());
			double preAct= LeerTotalPagar();
			double preTot= LeerCantidadMedicina()*med.getPrecioUnitario();
			Object fila[]={med.getCodigoMedicina(),med.getNombre(),med.getPrecioUnitario(),
							LeerCantidadMedicina(),preTot};
			Tmodel.addRow(fila);
			cR++;
			txtTotalPagar.setText(""+(preAct+preTot));
			Listar();
		}
		else
			Libreria.Mensaje(null,this,"Ingrese la Cantidad", "Error", -1, "images/no ts.png");
	}
	protected void APbtnEliminarMedicina(ActionEvent g2){
		int row= tbMedicinas.getSelectedRow();
		if(row!=-1){
			int ok= Libreria.confirmacion(null, this, "¿Esta seguro de eliminar este elemento?", "Eliminar", "images/erase t.png");
			if(ok==0){
				double val= (Double)Tmodel.getValueAt(row, 4);
				double tp= LeerTotalPagar();
				txtTotalPagar.setText(""+(tp-val));
				Tmodel.removeRow(row);
				cR--;
				Listar();
			}
		}
		else
			Libreria.Mensaje(null,this,"Seleccione un elemento", "Error", -1, "images/no ts.png");
	}
	protected void APbtnAdicionarConsulta(ActionEvent g3){
		int rc= tbMedicinas.getRowCount();
		if(rc>0){
			Consulta c=new Consulta(LeerConsulta(), LeerPaciente(), LeerFechaAtencion(), LeerHoraAtencion(), LeerTotalPagar(), cboEstado.getSelectedIndex());
			GuiPrincipal.acon.adicionarCon(c);
			for (int i = 0; i < rc; i++) {
				Integer cm= Integer.parseInt(tbMedicinas.getValueAt(i, 0).toString());
				Integer can= Integer.parseInt(tbMedicinas.getValueAt(i, 3).toString());
				double pu= Double.parseDouble(tbMedicinas.getValueAt(i, 2).toString());
				Receta r=new Receta(LeerConsulta(), cm, can, pu);
				GuiPrincipal.ar.adicionar(r);
			}
			Libreria.Mensaje(null,this, "Datos Ingresados Correctamente", "Adicionar", -1, "images/ok t.png");
			grabarConsultatxt();
			CerrarCR();
		}
		else{
			int ok= Libreria.confirmacion(null, this, "!No ha agregado ninguna Receta¡\n¿Desea Adicionar la consulta de todos modos?", "No Recetas", "images/exclamation t.png");
			if(ok==0){
				Consulta c=new Consulta(LeerConsulta(), LeerPaciente(), LeerFechaAtencion(), LeerHoraAtencion(), LeerTotalPagar(), cboEstado.getSelectedIndex());
				GuiPrincipal.acon.adicionarCon(c);
				Libreria.Mensaje(null,this, "Datos Ingresados Correctamente", "Adicionar", -1, "images/ok t.png");
				grabarConsultatxt();
				CerrarCR();
			}
		}
	}
	private void ISCcboGenerarDias(ItemEvent isc){
		Libreria.GenerarDias(cboDiaAtencion, cboMesAtencion.getSelectedIndex());
		Libreria.colocarDiaActual(cboDiaAtencion);
	}
	private void cargarPacientes(){
		cboPaciente.removeAllItems();
		for (int i = 0; i < GuiPrincipal.ap.tamaño(); i++) {
			Paciente p= GuiPrincipal.ap.obtener(i);
			cboPaciente.addItem(""+p.getCodigoPaciente());
		}
	}
	private void cargarMedicinas(){
		cboMedicina.removeAllItems();
		for (int i = 0; i < GuiPrincipal.am.tamaño() ; i++) {
			cboMedicina.addItem(""+GuiPrincipal.am.obtener(i).getNombre());
		}
	}
	private void codigoCorrelativoCON(){
		txtConsulta.setText(""+GuiPrincipal.acon.CodigoCOrrelativo());
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == cboMesAtencion){
			ISCcboGenerarDias(e);
		}
	}
	private int LeerConsulta(){
		return Integer.parseInt(txtConsulta.getText());
	}
	private Integer LeerPaciente(){
		String cpa= (String)cboPaciente.getSelectedItem();
		return Integer.parseInt(cpa);
	}
	private String LeerFechaAtencion(){
		return Libreria.obtenerFecha(cboDiaAtencion, cboMesAtencion, cboAñoAtencion);
	}
	private String LeerHoraAtencion(){
		return Libreria.obtenerHora(cboHoraAtencion, cboMinAtencionH);
	}
	private double LeerTotalPagar(){
		return Double.parseDouble(txtTotalPagar.getText());
	}
	private String LeerEstado(){
		return (String)cboEstado.getSelectedItem();
	}
	private String LeerMedicina(){
		return (String)cboMedicina.getSelectedItem();
	}
	private int LeerCantidadMedicina(){
		return Integer.parseInt(txtCantidadMed.getText());
	}
	private int anchoColumna(int p){
		return p*scrollPane.getWidth()/100;
	}
	private void AjustarAnchoCol(){
		TableColumnModel t= tbMedicinas.getColumnModel();
		t.getColumn(0).setPreferredWidth(anchoColumna(22));
		t.getColumn(1).setPreferredWidth(anchoColumna(24));
		t.getColumn(2).setPreferredWidth(anchoColumna(19));
		t.getColumn(3).setPreferredWidth(anchoColumna(13));
		t.getColumn(4).setPreferredWidth(anchoColumna(21));
	}
	private void ConsultaKeyLimitStart(){
		txtConsulta.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				Libreria.SoloNumeros(e, txtConsulta, 6);
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
		txtTotalPagar.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				Libreria.SoloNumerosYDeciMales(e, txtTotalPagar, 7);
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
	}
	private void ConsultaKeyLimitMed(){
		txtCantidadMed.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				Libreria.SoloNumeros(e, txtCantidadMed, 3);
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
	}
	private void ConfirmarCR(){
		int ok= Libreria.confirmacion(null, this , "¿Realmente desea cancelar el proceso?", "Salir", "images/shutdown t.png");
		if(ok==0){
			CerrarCR();
		}
	}
	private void CerrarCR(){
		GuiPrincipal.acon.grabarConsultaCon();
		GuiPrincipal.ar.grabarReceta();
		this.dispose();
		AccionesReInicio();
		Tbconsul.repaint();
	}
	private void grabarConsultatxt(){
		try {
			String consulta;
			String receta;
			PrintWriter pw= new PrintWriter(new FileWriter(LeerConsulta()+".txt"));
			consulta= "Codigo de Consulta:\t"+LeerConsulta()+
					"\nCodigo de Paciente:\t"+LeerPaciente()+
					"\nFecha de Atención:\t"+LeerFechaAtencion()+
					"\nHora de Atención:\t"+LeerHoraAtencion()+
					"\nTotal a Pagar:\t\t"+LeerTotalPagar()+
					"\nEstado:\t\t\t"+LeerEstado()+"\n\n\nRECETA\n";
			pw.println(consulta);
			for (int i = 0; i < tbMedicinas.getRowCount(); i++) {
				Integer cm= Integer.parseInt(tbMedicinas.getValueAt(i, 0).toString());
				String nm= tbMedicinas.getValueAt(i, 1).toString();
				Integer can= Integer.parseInt(tbMedicinas.getValueAt(i, 3).toString());
				double pu= Double.parseDouble(tbMedicinas.getValueAt(i, 2).toString());
				receta= "Codigo de la Medicina:\t"+cm+
						"\nNombre de la Medicina:\t"+nm+
						"\nPrecio Unitario:\t"+pu+
						"\nCantidad:\t\t"+can+
						"\nPrecio Total:\t\t"+(pu*can)+"\n\n";
				pw.println(receta);
			}
			pw.close();
		} catch (Exception e) {
		}
	}
}
