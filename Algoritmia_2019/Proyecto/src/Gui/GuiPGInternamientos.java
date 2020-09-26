package Gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Internamiento;
import librerias.Libreria;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class GuiPGInternamientos extends JFrame implements ActionListener, ItemListener {

	private JPanel contentPane;
	private JLabel lblCodigoInternamiento;
	private JComboBox cboInternamiento;
	private JLabel lblFechaDeSalida;
	private JLabel lblHoraDeSalida;
	private JLabel lblEstadoDeIternamiento;
	private JLabel lblEstadoCama;
	private JComboBox cboEstado;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnConsultar;
	private JButton btnActualizar;
	private JTextField txtTotaPagar;
	private JComboBox<String> cboDia;
	private JComboBox cboMes;
	private JComboBox<String> CboA�o;
	private JComboBox<String> cboHora;
	private JComboBox<String> cboMin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiPGInternamientos frame = new GuiPGInternamientos();
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
	public GuiPGInternamientos() {
		setTitle("Pago | Internamientos"); 
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent wc){
				GuiPrincipal.ai.grabarInternamientos();
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}
		});
		setBounds(100, 100, 536, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblCodigoInternamiento = new JLabel("Codigo Internamiento");
		lblCodigoInternamiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCodigoInternamiento.setBounds(10, 11, 123, 14);
		contentPane.add(lblCodigoInternamiento);
		
		cboInternamiento = new JComboBox();
		cboInternamiento.addItemListener(this);
		cboInternamiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboInternamiento.setBounds(135, 8, 120, 20);
		contentPane.add(cboInternamiento);
		
		lblFechaDeSalida = new JLabel("Fecha de salida");
		lblFechaDeSalida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFechaDeSalida.setBounds(10, 36, 89, 14);
		contentPane.add(lblFechaDeSalida);
		
		lblHoraDeSalida = new JLabel("Hora de salida");
		lblHoraDeSalida.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHoraDeSalida.setBounds(10, 61, 82, 14);
		contentPane.add(lblHoraDeSalida);
		
		lblEstadoDeIternamiento = new JLabel("Estado");
		lblEstadoDeIternamiento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstadoDeIternamiento.setBounds(10, 86, 67, 14);
		contentPane.add(lblEstadoDeIternamiento);
		
		lblEstadoCama = new JLabel("Total a pagar");
		lblEstadoCama.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEstadoCama.setBounds(10, 111, 82, 14);
		contentPane.add(lblEstadoCama);
		
		cboEstado = new JComboBox();
		cboEstado.setEnabled(false);
		cboEstado.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Alojado", "Pagado"}));
		cboEstado.setBounds(135, 83, 86, 20);
		contentPane.add(cboEstado);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 153, 500, 210);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(this);
		btnConsultar.setBounds(407, 8, 101, 23);
		contentPane.add(btnConsultar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(this);
		btnActualizar.setBounds(407, 36, 101, 23);
		contentPane.add(btnActualizar);
		
		txtTotaPagar = new JTextField();
		txtTotaPagar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTotaPagar.setColumns(10);
		txtTotaPagar.setBounds(135, 108, 86, 20);
		contentPane.add(txtTotaPagar);
		
		cboDia = new JComboBox<String>();
		cboDia.setEnabled(false);
		cboDia.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboDia.setBounds(135, 33, 52, 20);
		contentPane.add(cboDia);
		
		cboMes = new JComboBox();
		cboMes.setEnabled(false);
		cboMes.setMaximumRowCount(6);
		cboMes.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboMes.setBounds(192, 33, 94, 20);
		contentPane.add(cboMes);
		
		CboA�o = new JComboBox<String>();
		CboA�o.setEnabled(false);
		CboA�o.setMaximumRowCount(6);
		CboA�o.setFont(new Font("Tahoma", Font.PLAIN, 12));
		CboA�o.setBounds(290, 33, 56, 20);
		contentPane.add(CboA�o);
		
		cboHora = new JComboBox<String>();
		cboHora.setEnabled(false);
		cboHora.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboHora.setBounds(135, 58, 46, 20);
		contentPane.add(cboHora);
		
		cboMin = new JComboBox<String>();
		cboMin.setEnabled(false);
		cboMin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboMin.setBounds(186, 58, 46, 20);
		contentPane.add(cboMin);
		
		UIManager.put( "ComboBox.disabledForeground", Color.BLACK );
		Libreria.GenerarMeses(cboMes);
		Libreria.GenerarA�os(CboA�o);
		Libreria.GenerarDias(cboDia, cboMes.getSelectedIndex());
		Libreria.GenerarHoras(cboHora);
		Libreria.GenerarMinutos(cboMin);
		GenerarInterna();
		Libreria.colocarMesActual(cboMes);
		Libreria.colocarA�oActual(CboA�o);
		Libreria.colocarDiaActual(cboDia);
		Libreria.colocarHoraActual(cboHora);
		Libreria.colocarMinutosAprox(cboMin);
		cboEstado.setSelectedIndex(1);
		KeyLimit();
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnActualizar) {
			actionPerformedBtnAct(e);
		}
		if (e.getSource() == btnConsultar){
			APbtnConsultar(e);
		}
	}
	protected void actionPerformedBtnAct(ActionEvent e) {
		if(LeerTotalPagar()>199){
			Internamiento in= GuiPrincipal.ai.buscar(LeerCodIntern());
			in.setFechaSalida(Libreria.obtenerFechaActual());
			in.setHoraSalida(Libreria.obtenerHoraActual());
			in.setEstado(LeerEstado());
			in.setTotalPagar(LeerTotalPagar());
			Libreria.Mensaje(this,null, "Datos Actualizados Correctamente", "Adicionar", -1, "images/ok t.png");
			Limpiar();
			GuiPrincipal.ai.grabarInternamientos();
		}
		else
			Libreria.Mensaje(this,null, "Ingrese un monto minimo de 200.00", "Error", -1, "images/no ts.png");
		
	}
	protected void APbtnConsultar(ActionEvent e){
		txtS.setText("");
		Internamiento in= GuiPrincipal.ai.buscar(LeerCodIntern());
		imprimir("\n\tLISTAR DATOS\n\n"+
				"\tCodigo de Internamiento:\t"+in.getCodigoInternamiento()+
				"\n\tCodigo del Paciente:\t"+in.getCodigoPaciente()+
				"\n\tNumero de la Cama:\t"+in.getNumeroCama()+
				"\n\tFecha de Ingreso:\t"+in.getFechaIngreso()+
				"\n\tHora de Ingreso:\t"+in.getHoraIngreso()+
				"\n\tFecha de Salida:\t"+in.getFechaSalida()+
				"\n\tHora de Salida:\t\t"+in.getHoraSalida()+
				"\n\tTotal a Pagar:\t\t"+in.getTotalPagar()+
				"\n\tEstado:\t\t"+GuiPrincipal.ai.EstadosPacIn[in.getEstado()]);
		Libreria.colocarHoraActual(cboHora);
		Libreria.colocarMinutosAprox(cboMin);
	}
	private void GenerarInterna(){
		cboInternamiento.removeAllItems();
		for (int i = 0; i < GuiPrincipal.ai.tama�o(); i++) {
			Internamiento in= GuiPrincipal.ai.obtener(i);
			if(in.getEstado()==0){
				cboInternamiento.addItem(""+in.getCodigoInternamiento());
			}
		}
	}
	private double LeerTotalPagar(){
		return Double.parseDouble(txtTotaPagar.getText());
	}
	private int LeerEstado(){
		return cboEstado.getSelectedIndex();
	}
	private Integer LeerCodIntern(){
		return Integer.parseInt((String)cboInternamiento.getSelectedItem());
	}
	private void imprimir(String imp){
		txtS.append(imp);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getSource() == cboInternamiento){
			Internamiento in= GuiPrincipal.ai.buscar(LeerCodIntern());
			txtTotaPagar.setText(""+in.getTotalPagar());
		}
	}
	public void KeyLimit(){
		txtTotaPagar.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				Libreria.SoloNumerosYDeciMales(e, txtTotaPagar, 8);
			}
			@Override
			public void keyReleased(KeyEvent e) {	
			}
			@Override
			public void keyPressed(KeyEvent e) {
			}
		});
	}
	public void Limpiar(){
		GenerarInterna();
		cboInternamiento.setSelectedIndex(0);
		Libreria.colocarDiaActual(cboDia);
		Libreria.colocarHoraActual(cboHora);
		Libreria.colocarMinutosAprox(cboMin);
	}
}
