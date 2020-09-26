package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Arreglos.ArregloCama;
import Clases.Cama;
import librerias.Libreria;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.security.Principal;
import java.awt.event.ItemEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.xml.transform.SourceLocator;
import javax.swing.ListSelectionModel;
import java.awt.Font;

public class GuiCama extends JFrame implements ActionListener, ItemListener {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel lblNumeroDeCama;
	private JTextField txtNumeroCama;
	private JLabel lblCategoria;
	private JComboBox cboCategoria;
	private JLabel lblPrecioDia;
	private JTextField txtPrecioDia;
	private JLabel lblEstado;
	private JComboBox cboEstado;
	private JButton btnAdicionar;
	private JButton btnConsultar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnListar;
	private JScrollPane scrollPane;
	private JButton btnCerrar;
	
	
	int Operation;
	private JTable tbtable;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiCama frame = new GuiCama();
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
	public GuiCama() {
		setResizable(false);
		setTitle("Mantenimiento | Cama");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent wc){
				cerrarC();
			}
		});
		setBounds(100, 100, 586, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNumeroDeCama = new JLabel("N\u00B0 Cama");
		lblNumeroDeCama.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumeroDeCama.setBounds(97, 67, 62, 14);
		contentPane.add(lblNumeroDeCama);
		
		txtNumeroCama = new JTextField();
		txtNumeroCama.setBounds(169, 64, 86, 20);
		contentPane.add(txtNumeroCama);
		txtNumeroCama.setColumns(10);
		
		lblCategoria = new JLabel("Categoria");
		lblCategoria.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCategoria.setBounds(97, 98, 84, 14);
		contentPane.add(lblCategoria);
		
		cboCategoria = new JComboBox();
		cboCategoria.addItemListener(this);
		cboCategoria.setModel(new DefaultComboBoxModel(new String[] {"Basica", "Estandar", "Premiun"}));
		cboCategoria.setToolTipText("");
		cboCategoria.setBounds(169, 95, 84, 20);
		contentPane.add(cboCategoria);
		
		lblPrecioDia = new JLabel("Precio Diario");
		lblPrecioDia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrecioDia.setBounds(308, 67, 62, 14);
		contentPane.add(lblPrecioDia);
		
		txtPrecioDia = new JTextField();
		txtPrecioDia.setEditable(false);
		txtPrecioDia.setBounds(391, 64, 86, 20);
		contentPane.add(txtPrecioDia);
		txtPrecioDia.setColumns(10);
		
		lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEstado.setBounds(319, 98, 46, 14);
		contentPane.add(lblEstado);
		
		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Libre", "Ocupada"}));
		cboEstado.setBounds(391, 95, 84, 20);
		contentPane.add(cboEstado);
		
		btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(this);
		btnAdicionar.setBounds(10, 11, 89, 23);
		contentPane.add(btnAdicionar);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(105, 11, 89, 23);
		contentPane.add(btnConsultar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(200, 11, 89, 23);
		contentPane.add(btnModificar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(294, 11, 89, 23);
		contentPane.add(btnEliminar);
		
		btnListar = new JButton("Listar");
		btnListar.addActionListener(this);
		btnListar.setBounds(388, 11, 89, 23);
		contentPane.add(btnListar);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 141, 559, 207);
		contentPane.add(scrollPane);
		
		tbtable = new JTable();
		tbtable.setFillsViewportHeight(true);
		tbtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tbtable);
		tbtable.setModel(GuiPrincipal.ac);
		tbtable.getSelectionModel().setSelectionInterval(0, 0);
		
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(480, 11, 89, 23);
		contentPane.add(btnCerrar);
		CodigoAutogenerado();
		NumCamaKeyLimit();
		tbtableClicked();
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(arg0);
		}
		if (arg0.getSource() == btnListar) {
			actionPerformedBtnListar(arg0);
		}
		if (arg0.getSource() == btnModificar) {
			actionPerformedBtnModificar(arg0);
		}
		if (arg0.getSource() == btnConsultar) {
			actionPerformedBtnConsultar(arg0);
		}
		if (arg0.getSource() == btnAdicionar) {
			actionPerformedBtnAdicionar(arg0);
		}
		if (arg0.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(arg0);
		}
	}
	
	/*ArregloCama ac = new ArregloCama();*/
	
	void listar(){
		tbtable.repaint();
		LimpiarC();
		CodigoAutogenerado();
	}
	void imprimir(String x){
	}
	int leerNumero(){
		return Integer.parseInt(txtNumeroCama.getText());
	}
	int leerCategoria(){
		return cboCategoria.getSelectedIndex();
	}
	double leerPrecio(){
		return Double.parseDouble(txtPrecioDia.getText());
	}
	int leerEstado(){
		return cboEstado.getSelectedIndex();
	}
	private void cerrarC(){
		GuiPrincipal.ac.grabarCama();
		dispose();
	}
	protected void actionPerformedBtnCerrar(ActionEvent arg0) {
		cerrarC();
	}
	protected void actionPerformedBtnAdicionar(ActionEvent arg0) {
			if(txtNumeroCama.getText().length() ==6)
				if(GuiPrincipal.ac.buscar(leerNumero())==null){
					Cama c=new Cama(leerNumero(), leerCategoria(), leerPrecio(), leerEstado());
					GuiPrincipal.ac.adicionar(c);
					Libreria.Mensaje(this,null, "Datos Ingresados Correctamente", "Adicionar", -1, "images/ok t.png");
					listar();
					GuiPrincipal.ac.grabarCama();
					LimpiarC();
					CodigoAutogenerado();
				}
				else Libreria.Mensaje(this,null, "El N� Cama ya existe", "Error", -1, "images/no ts.png");
			else
				Libreria.Mensaje(this,null, "Ingrese un Codigo valido", "Error", -1, "images/no ts.png");
	}
	protected void actionPerformedBtnConsultar(ActionEvent arg0) {
		if(txtNumeroCama.getText().length() ==6){
			int num=leerNumero();
			Cama c = GuiPrincipal.ac.buscar(num);
			if(c !=null){
				cboCategoria.setSelectedIndex(c.getCategoria());
				txtPrecioDia.setText(""+c.getPrecioDia());
				cboEstado.setSelectedIndex(c.getEstado());
			}
			else
				Libreria.Mensaje(this,null, "El N�Cama no Existe", "Error", -1, "images/no ts.png");
		}
		else
			Libreria.Mensaje(this,null, "Ingrese un Codigo valido", "Error", -1, "images/no ts.png");
	}
	protected void actionPerformedBtnModificar(ActionEvent arg0) {
		if(txtNumeroCama.getText().length() ==6){
			int num=leerNumero();
			Cama c = GuiPrincipal.ac.buscar(num);
			if(c !=null){
				int cat=leerCategoria();
				double precio=leerPrecio();
				int estado=leerEstado();
				c.setCategoria(cat);
				c.setPrecioDia(precio);
				c.setEstado(estado);
				Libreria.Mensaje(this,null, "Datos Modificados Correctamente", "Modificar", -1, "images/ok t.png");
				listar();
				LimpiarC();
				CodigoAutogenerado();
			}
			else
				Libreria.Mensaje(this,null, "El N� Cama no Existe", "Error", -1, "images/no ts.png");
		}
		else
			Libreria.Mensaje(this,null, "Ingrese un Codigo valido", "Error", -1, "images/no ts.png");
	}
	protected void actionPerformedBtnListar(ActionEvent arg0) {
		listar();
	}
	protected void actionPerformedBtnEliminar(ActionEvent arg0) {
			if(txtNumeroCama.getText().length() ==6){
				if(GuiPrincipal.ac.buscar(leerNumero())!=null){
					Cama c=GuiPrincipal.ac.buscar(leerNumero());
					if(c.getEstado()!=1){
						int ok= Libreria.confirmacion(this,null, "�Realemte desea Eliminar este elemento?", "Eliminar", "images/erase t.png");
						if(ok == 0){
							GuiPrincipal.ac.eliminar(c);
							listar();
							GuiPrincipal.ac.grabarCama();
							Libreria.Mensaje(this,null, "Datos Eliminados Correctamente", "Modificar", -1, "images/ok t.png");
							LimpiarC();
							CodigoAutogenerado();
						}
					}	
					else
						Libreria.Mensaje(this,null, "No se puede eliminar una cama Ocupada", "Error", -1, "images/no ts.png");
				}
				else
					Libreria.Mensaje(this,null, "El N� Cama no Existe", "Error", -1, "images/no ts.png");
			}
			else
				Libreria.Mensaje(this,null, "Ingrese un Codigo valido", "Error", -1, "images/no ts.png");
		}
	public void itemStateChanged(ItemEvent arg0) {
		if (arg0.getSource() == cboCategoria) {
			itemStateChangedCboCategoria(arg0);
		}
	}
	protected void itemStateChangedCboCategoria(ItemEvent arg0) {
		int op=cboCategoria.getSelectedIndex();
		if(op==0)txtPrecioDia.setText(""+70);
		else if(op==1)txtPrecioDia.setText(""+120);
		else 		  txtPrecioDia.setText(""+180);
	}
	private void CodigoAutogenerado(){
		txtNumeroCama.setText(""+GuiPrincipal.ac.generarCodigoC());
	}
	private void NumCamaKeyLimit(){
		txtNumeroCama.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				char t= e.getKeyChar();
				if((!Character.isDigit(t)) && t != '\b')
					e.consume();
				if(txtNumeroCama.getText().length() == 6)
					e.consume();
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
	}
	private void tbtableClicked(){
		tbtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LimpiarC();
				int rw= tbtable.getSelectedRow();
				txtNumeroCama.setText(""+GuiPrincipal.ac.obtener(rw).getNumeroCama());
			}
		});
	}
	private void LimpiarC(){
		txtNumeroCama.setText("");
		cboCategoria.setSelectedIndex(0);
		txtPrecioDia.setText("");
		cboEstado.setSelectedIndex(0);
	}
}
