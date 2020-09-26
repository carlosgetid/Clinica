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
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class GuiConsulta extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnCerrar;
	private JButton btnListar;
	private JTable tbtableC;
	private JButton btnEliminar;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiConsulta frame = new GuiConsulta();
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
	public GuiConsulta() {
		setTitle("Registro | Consulta");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent wc){
					Cerrar();
				}
		});
		setBounds(100, 100, 852, 467);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(682, 11, 104, 36);
		contentPane.add(btnCerrar);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(52, 11, 104, 36);
		contentPane.add(btnAdicionar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(428, 11, 104, 36);
		contentPane.add(btnEliminar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 816, 348);
		contentPane.add(scrollPane);
		
		tbtableC = new JTable();
		tbtableC.setFillsViewportHeight(true);
		tbtableC.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tbtableC.setModel(GuiPrincipal.acon);
		scrollPane.setViewportView(tbtableC);
		tbtableC.getSelectionModel().setSelectionInterval(0, 0);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(553, 11, 104, 36);
		contentPane.add(btnListar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(304, 11, 104, 36);
		btnModificar.addActionListener(this);
		contentPane.add(btnModificar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(176, 11, 104, 36);
		btnConsultar.addActionListener(this);
		contentPane.add(btnConsultar);
		listar();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
		if(arg0.getSource() == btnAdicionar){
			APbtnAdicionar(arg0);
		}
		if(arg0.getSource() == btnEliminar){
			APbtnEliminar(arg0);
	
		}
		if(arg0.getSource() == btnListar){
			APbtnListar(arg0);
		}
		if(arg0.getSource() == btnConsultar){
			APbtnConsultar(arg0);
		}
		if(arg0.getSource() == btnModificar){
			APbtnModificar(arg0);;
		}
	};
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		Cerrar();
	}
	protected void APbtnAdicionar(ActionEvent arg0){
		GUIConsultaACT act= new GUIConsultaACT(tbtableC);
		act.setVisible(true);
	}
	protected void APbtnConsultar(ActionEvent arg0){
		Consulta ct= GuiPrincipal.acon.obtenerCon(tbtableC.getSelectedRow());
		GUIConsultaCON con=new GUIConsultaCON(ct);
		con.setVisible(true);
	}
	protected void APbtnModificar(ActionEvent arg0){
		Consulta ct= GuiPrincipal.acon.obtenerCon(tbtableC.getSelectedRow());
		GUIConsultaMOD mod=new GUIConsultaMOD(tbtableC, ct);
		mod.setVisible(true);
	}
	protected void APbtnEliminar(ActionEvent arg0){
		int ok= Libreria.confirmacion(this, null, "¿Seguro que desea Eliminar esta Consulta, junto a todas sus Recetas?", "Eliminar", "images/erase t.png");
		if(ok==0){
			int row= tbtableC.getSelectedRow();
			Consulta c= GuiPrincipal.acon.obtenerCon(row);
			int cod= c.getCodigoConsulta();
			GuiPrincipal.acon.eliminarCon(c);
			for (int i = 0; i < GuiPrincipal.ar.tamaño()-1; i++) {
				Receta re= GuiPrincipal.ar.obtener(i);
				int cr= re.getcodigoConsulta();
				if(cod==cr){
					GuiPrincipal.ar.eliminar(re);
				}
			}
			listar();
			Libreria.Mensaje(this,null, "Datos Eliminados Correctamente", "Modificar", -1, "images/ok t.png");
		}
	}
	protected void APbtnListar(ActionEvent arg0){
		listar();
	}
	void listar(){
		tbtableC.repaint();
		GuiPrincipal.acon.grabarConsultaCon();
		GuiPrincipal.ar.grabarReceta();
	}
	private void Cerrar(){
		GuiPrincipal.acon.grabarConsultaCon();
		GuiPrincipal.ar.grabarReceta();
		dispose();
	}
}
