package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Internamiento;
import librerias.Libreria;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiInternamientosPagados extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnCerrar;
	private JButton btnMostrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiInternamientosPagados frame = new GuiInternamientosPagados();
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
	public GuiInternamientosPagados() {
		setTitle("Reporte | Internamientos Pagados");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 467, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 431, 524);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		btnMostrar = new JButton("Listar");
		btnMostrar.addActionListener(this);
		btnMostrar.setBounds(110, 11, 89, 23);
		contentPane.add(btnMostrar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(244, 11, 89, 23);
		contentPane.add(btnCerrar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if (e.getSource() == btnMostrar) {
			actionPerformedBtnListar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		int ik=0;
		imprimir("\n\tINTERNAMIENTOS PAGADOS\n");
		for (int i = 0; i < GuiPrincipal.ai.tama�o(); i++) {
			Internamiento in= GuiPrincipal.ai.obtener(i);
			if(in.getEstado()==1){
				ik++;
				imprimir("\tCodigo de Internamiento:\t"+in.getCodigoInternamiento()+
						"\n\tCodigo del Paciente:\t"+in.getCodigoPaciente()+
						"\n\tNumero de la Cama:\t"+in.getNumeroCama()+
						"\n\tFecha de Ingreso:\t"+in.getFechaIngreso()+
						"\n\tHora de Ingreso:\t"+in.getHoraIngreso()+
						"\n\tFecha de Salida:\t"+in.getFechaSalida()+
						"\n\tHora de Salida:\t\t"+in.getHoraSalida()+
						"\n\tTotal a Pagar:\t\t"+in.getTotalPagar()+
						"\n\tEstado:\t\t"+GuiPrincipal.ai.EstadosPacIn[in.getEstado()]+"\n\n");
			}
		}
		if(ik==0){
			txtS.setText("");
			Libreria.Mensaje(this,null, "No Hay Internamientos Pagados", "Error", -1, "images/no ts.png");
		}
	}
	private void imprimir(String imp){
		txtS.append(imp+"\n");
	}
}
