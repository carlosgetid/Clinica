package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Clases.Consulta;
import librerias.Libreria;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuiConsultasPagadas extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JScrollPane scrollPane;
	private JTextArea txtS;
	private JButton btnListar;
	private JButton btnCerrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiConsultasPagadas frame = new GuiConsultasPagadas();
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
	public GuiConsultasPagadas() {
		setTitle("Reporte | Consultas pagadas ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 469, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 56, 433, 498);
		contentPane.add(scrollPane);
		
		txtS = new JTextArea();
		scrollPane.setViewportView(txtS);
		
		btnListar = new JButton("Listar");
		btnListar.setBounds(102, 11, 89, 23);
		btnListar.addActionListener(this);
		contentPane.add(btnListar);
		
		btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(245, 11, 89, 23);
		contentPane.add(btnCerrar);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnCerrar) {
			actionPerformedBtnCerrar(e);
		}
		if(e.getSource() ==btnListar){
			actionPerformedBtnListar(e);
		}
	}
	protected void actionPerformedBtnCerrar(ActionEvent e) {
		dispose();
	}
	protected void actionPerformedBtnListar(ActionEvent e) {
		int k=0;
		imprimir("\n\tCONSULTAS PAGADAS\n");
		for (int i = 0; i < GuiPrincipal.acon.tama�oCon(); i++) {
			Consulta co= GuiPrincipal.acon.obtenerCon(i);
			if(co.getEstado()==1){
				k++;
				imprimir("\tCodigo de Consulta:\t"+co.getCodigoConsulta()+
					"\n\tCodigo del Paciente:\t"+co.getCodigoPaciente()+
					"\n\tFecha de Atencion:\t"+co.getFechaAtencion()+
					"\n\tHora de Atencion:\t"+co.getHoraAtencion()+
					"\n\tTotal a Pagar:\t\t"+co.getTotalPagar()+
					"\n\tEstado:\t\t"+GuiPrincipal.acon.EstadosConsul[co.getEstado()]+"\n\n");
			}
		}
		if(k==0){
			txtS.setText("");
			Libreria.Mensaje(this,null, "No Hay Consultas Pagadas", "Error", -1, "images/no ts.png");
		}
	}
	private void imprimir(String imp){
		txtS.append(imp+"\n");
	}
}
