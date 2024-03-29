package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Consulta;
import Clases.Receta;
import librerias.Libreria;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class GuiPGConsultas extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JLabel lblConsultas;
	private JComboBox cboConsulta;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JLabel lblEstado;
	private JComboBox cboEstado;
	private JButton btnConsultar;
	private JButton btnActualizar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiPGConsultas frame = new GuiPGConsultas();
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
	public GuiPGConsultas() {
		setTitle("Pago | Consultas");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent wc){
				GuiPrincipal.acon.grabarConsultaCon();
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		setBounds(100, 100, 450, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblConsultas = new JLabel("Cod. Consulta");
		lblConsultas.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblConsultas.setBounds(22, 11, 83, 14);
		contentPane.add(lblConsultas);
		
		cboConsulta = new JComboBox();
		cboConsulta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboConsulta.setBounds(111, 8, 93, 20);
		contentPane.add(cboConsulta);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 83, 414, 288);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstado.setBounds(39, 42, 62, 14);
		contentPane.add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Pendiente", "Pagada"}));
		cboEstado.setBounds(111, 39, 93, 20);
		contentPane.add(cboEstado);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(322, 8, 102, 23);
		contentPane.add(btnConsultar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(322, 41, 102, 23);
		contentPane.add(btnActualizar);
		
		cargarConsultas();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnAct(e);
		}
		if(e.getSource() ==btnConsultar){
			APbtnConsultar(e);
		}
	}
	private void listar(){
		int c=0;
		txtS.setText("");
		Consulta co= GuiPrincipal.acon.buscar(LeerConsulta());
		imprimir("\n\tLISTAR DATOS\n\n"
				+"\tCodigo de Consulta:\t"+co.getCodigoConsulta()+
				"\n\tCodigo del Paciente:\t"+co.getCodigoPaciente()+
				"\n\tFecha de Atencion:\t"+co.getFechaAtencion()+
				"\n\tHora de Atencion:\t"+co.getHoraAtencion()+
				"\n\tTotal a Pagar:\t\t"+co.getTotalPagar()+
				"\n\tEstado:\t\t"+GuiPrincipal.acon.EstadosConsul[co.getEstado()]);
		for (int i = 0; i < GuiPrincipal.ar.tama�o(); i++) {
			Receta re= GuiPrincipal.ar.obtener(i);
			if((co.getCodigoConsulta())==(re.getcodigoConsulta())){
				c++;
				if(c==1){
					imprimir("\n\n\n\tRECETAS\n");
				}
				String noM= GuiPrincipal.am.buscar(re.getCodigoMedicina()).getNombre();
				imprimir(
						"\tCodigo de Medicina:\t"+re.getCodigoMedicina()+
						"\n\tNombre de la Medicina:\t"+noM+
						"\n\tPrecio Unitario:\t\t"+re.getPrecioUnitario()+
						"\n\tCantidad:\t\t"+re.getCantidad()+
						"\n\tPrecio de Venta:\t"+(re.getPrecioUnitario()*re.getCantidad())+"\n\n");
			}
		}
	}
	protected void actionPerformedBtnAct(ActionEvent e) {
		Consulta co= GuiPrincipal.acon.buscar(LeerConsulta());
		co.setEstado(LeerEstado());
		Libreria.Mensaje(this,null, "Datos Actualizados Correctamente", "Actualizar", -1, "images/ok t.png");
		limpiar();
		GuiPrincipal.acon.grabarConsultaCon();
		cargarConsultas();
	}
	protected void APbtnConsultar(ActionEvent e){
		listar();
		cboEstado.setSelectedIndex(0);
	}
	private void cargarConsultas(){
		cboConsulta.removeAllItems();
		for (int i = 0; i < GuiPrincipal.acon.tama�oCon(); i++) {
			Consulta c= GuiPrincipal.acon.obtenerCon(i);
			if(c.getEstado()==0){
				cboConsulta.addItem(""+c.getCodigoConsulta());
			}
		}
	}
	private Integer LeerConsulta(){
		return Integer.parseInt((String)cboConsulta.getSelectedItem());
	}
	private int LeerEstado(){
		return cboEstado.getSelectedIndex();
	}
	private void imprimir(String imp){
		txtS.append(imp+"\n");
	}
	private void limpiar(){
		cboConsulta.setSelectedIndex(0);
		cboEstado.setSelectedIndex(0);
	}
}
