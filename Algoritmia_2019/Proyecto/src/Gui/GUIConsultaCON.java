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


public class GUIConsultaCON extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JTextField txtConsulta;
	/**
	 * @wbp.nonvisual location=-38,279
	 */
	private final JTextField textField_3 = new JTextField();
	private JTextField txtTotalPagar;
	private JComboBox <String> cboEstado;
	private JComboBox <String>cboHoraAtencion;
	private JComboBox <String>cboMinAtencionH;
	private JComboBox <String>cboDiaAtencion;
	private JComboBox <String>cboMesAtencion;
	private JComboBox <String>cboA�oAtencion;
	private JComboBox <String> cboPaciente;
	private JButton btnCreceta;
	private JTextArea txtS;
	private JTable tbMedicinas;
	private DefaultTableModel Tmodel;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_Medi;
	private Consulta con;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			GUIConsultaCON dialog = new GUIConsultaCON(null);
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public GUIConsultaCON(Consulta cta){
		con=cta;
		setTitle("Registro | Consulta | Modificar Consulta");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent wc){
				CerrarCR();
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
		setBounds(100, 100, 534, 663);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		cboMesAtencion = new JComboBox();
		cboMesAtencion.setEnabled(false);
		cboMesAtencion.setMaximumRowCount(6);
		cboMesAtencion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboMesAtencion.setBounds(295, 97, 94, 20);
		contentPanel.add(cboMesAtencion);
		
		cboPaciente = new JComboBox <String>();
		cboPaciente.setEnabled(false);
		cboPaciente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboPaciente.setBounds(233, 66, 86, 20);
		contentPanel.add(cboPaciente);
		
		txtConsulta = new JTextField();
		txtConsulta.setEditable(false);
		txtConsulta.setBounds(233, 35, 86, 20);
		contentPanel.add(txtConsulta);
		txtConsulta.setColumns(10);
		
		cboDiaAtencion = new JComboBox<String>();
		cboDiaAtencion.setEnabled(false);
		cboDiaAtencion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboDiaAtencion.setBounds(233, 97, 52, 20);
		contentPanel.add(cboDiaAtencion);
		
		cboA�oAtencion = new JComboBox<String>();
		cboA�oAtencion.setEnabled(false);
		cboA�oAtencion.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboA�oAtencion.setMaximumRowCount(6);
		cboA�oAtencion.setBounds(399, 97, 56, 20);
		contentPanel.add(cboA�oAtencion);
		
		cboHoraAtencion = new JComboBox<String>();
		cboHoraAtencion.setEnabled(false);
		cboHoraAtencion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboHoraAtencion.setBounds(233, 128, 46, 20);
		contentPanel.add(cboHoraAtencion);
		
		cboMinAtencionH = new JComboBox<String>();
		cboMinAtencionH.setEnabled(false);
		cboMinAtencionH.setFont(new Font("Tahoma", Font.PLAIN, 13));
		cboMinAtencionH.setBounds(295, 128, 46, 20);
		contentPanel.add(cboMinAtencionH);
		
		txtTotalPagar = new JTextField();
		txtTotalPagar.setEditable(false);
		txtTotalPagar.setEnabled(false);
		txtTotalPagar.setBounds(233, 161, 86, 20);
		contentPanel.add(txtTotalPagar);
		txtTotalPagar.setColumns(10);
		
		cboEstado = new JComboBox <String>();
		cboEstado.setEnabled(false);
		cboEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Pendiente", "Pagado"}));
		cboEstado.setBounds(233, 192, 86, 20);
		contentPanel.add(cboEstado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 493, 498, 121);
		contentPanel.add(scrollPane);
		
		tbMedicinas = new JTable();
		tbMedicinas.setEnabled(false);
		Tmodel = new DefaultTableModel();
		tbMedicinas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbMedicinas.setBorder(null);
		tbMedicinas.setModel(Tmodel);
		tbMedicinas.setFillsViewportHeight(true);
		scrollPane.setViewportView(tbMedicinas);
		
		btnCreceta = new JButton("Listar Datos");
		btnCreceta.addActionListener(this);
		btnCreceta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCreceta.setBounds(199, 244, 125, 31);
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
		
		Label label_8 = new Label(":");
		label_8.setFont(new Font("Arial", Font.BOLD, 16));
		label_8.setAlignment(Label.CENTER);
		label_8.setBounds(285, 126, 9, 22);
		contentPanel.add(label_8);
		
		scrollPane_Medi = new JScrollPane();
		scrollPane_Medi.setBounds(10, 285, 498, 141);
		contentPanel.add(scrollPane_Medi);
		
		txtS = new JTextArea();
		txtS.setEditable(false);
		scrollPane_Medi.setViewportView(txtS);
		
		Label label_6 = new Label("Medicinas Recetadas:");
		label_6.setFont(new Font("Arial", Font.BOLD, 14));
		label_6.setBounds(178, 444, 202, 48);
		contentPanel.add(label_6);
		
	
		UIManager.put( "ComboBox.disabledForeground", Color.BLACK );
		cargarPacientes();
		Libreria.GenerarA�os(cboA�oAtencion);
		Libreria.GenerarMeses(cboMesAtencion);
		Libreria.GenerarHoras(cboHoraAtencion);
		Libreria.GenerarMinutos(cboMinAtencionH);
		Libreria.GenerarDias(cboDiaAtencion, cboMesAtencion.getSelectedIndex());
		txtConsulta.setDisabledTextColor(Color.black);
		txtTotalPagar.setDisabledTextColor(Color.black);
		Tmodel.setColumnCount(0);
		Tmodel.addColumn("Codigo Medicina");
		Tmodel.addColumn("Nombre Medicina");
		Tmodel.addColumn("Precio Unitario");
		Tmodel.addColumn("Cantidad");
		Tmodel.addColumn("Precio de Venta");
		AjustarAnchoCol();
		txtConsulta.setText(""+con.getCodigoConsulta());
		cboPaciente.setSelectedItem(""+con.getCodigoPaciente());
		txtTotalPagar.setText(""+con.getTotalPagar());
		cboEstado.setSelectedIndex(con.getEstado());
		Libreria.ConFechaMod(con.getFechaAtencion(), cboDiaAtencion, cboMesAtencion, cboA�oAtencion);
		Libreria.ConHoraMod(con.getHoraAtencion(), cboHoraAtencion, cboMinAtencionH);
		ConTablaMedicinaMod();
	}
	private void ConTablaMedicinaMod(){
		for (int i = 0; i < GuiPrincipal.ar.tama�o(); i++) {
			Receta r= GuiPrincipal.ar.obtener(i);
			if(r.getcodigoConsulta()==con.getCodigoConsulta()){
				Object row[]={r.getCodigoMedicina(),
						GuiPrincipal.am.buscar(r.getCodigoMedicina()).getNombre(),
						r.getPrecioUnitario(),
						r.getCantidad(),
						(r.getPrecioUnitario())*r.getcodigoConsulta()};
				Tmodel.addRow(row);
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnCreceta){
			APbtnCreceta(e);
		}
	}
	protected void APbtnCreceta(ActionEvent g0){
		Listar();
	}
	private void Listar(){
		txtS.setText("\tDATOS LISTADOS\n\n"+
				"\tCodigo de Consulta:\t"+LeerConsulta()+
				"\n\tCodigo de Paciente:\t"+LeerPaciente()+
				"\n\tFecha de Atencion:\t"+LeerFechaAtencion()+
				"\n\tHora de Atencion:\t"+LeerHoraAtencion()+
				"\n\tTotal a Pagar:\t\t"+LeerTotalPagar()+
				"\n\tEstado:\t\t"+LeerEstado());
	}
	int cR;
	private void cargarPacientes(){
		cboPaciente.removeAllItems();
		for (int i = 0; i < GuiPrincipal.ap.tama�o(); i++) {
			Paciente p= GuiPrincipal.ap.obtener(i);
			cboPaciente.addItem(""+p.getCodigoPaciente());
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
		return Libreria.obtenerFecha(cboDiaAtencion, cboMesAtencion, cboA�oAtencion);
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
	private void CerrarCR(){
		this.dispose();
	}
}
