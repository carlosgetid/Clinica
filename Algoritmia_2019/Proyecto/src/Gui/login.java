package Gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Label;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Panel;


public class login extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JButton btnIngresar;
	private Label label;
	private Label label_1;
	private JPasswordField jpassClave;
	private Label label_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setTitle("Programa Clinica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(117, 88, 158, 20);
		contentPane.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		jpassClave = new JPasswordField();
		jpassClave.setBounds(117, 142, 158, 20);
		contentPane.add(jpassClave);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(153, 173, 89, 23);
		contentPane.add(btnIngresar);
		
		label = new Label("Usuario");
		label.setBounds(164, 60, 62, 22);
		contentPane.add(label);
		
		label_1 = new Label("Contrase\u00F1a");
		label_1.setBounds(164, 114, 78, 22);
		contentPane.add(label_1);
		
		label_2 = new Label("Bienvenido!");
		label_2.setFont(new Font("Elephant", Font.PLAIN, 16));
		label_2.setBounds(153, 25, 109, 22);
		contentPane.add(label_2);
	}
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(arg0);
		}
	}
	
	protected void actionPerformedBtnIngresar(ActionEvent arg0) {
		char clave[]=jpassClave.getPassword();

		String clavedef=new String(clave);


		if (txtUsuario.getText().equals("Administrador") && clavedef.equals("12345")){
			
		                    this.dispose();


		                    JOptionPane.showMessageDialog(null, "Bienvenido\n"
		                    + "Has ingresado satisfactoriamente al sistema",   "Mensaje de bienvenida",
		                    JOptionPane.INFORMATION_MESSAGE);


		                    GuiPrincipal lo1 = new GuiPrincipal();

		                    lo1.setVisible(true);


		            }else {


		                    JOptionPane.showMessageDialog(null, "Acceso denegado:\n"
		                    + "Por favor ingrese un usuario y/o contraseña correctos", "Acceso denegado",
		                    JOptionPane.ERROR_MESSAGE);
		     
		            }


	}
	
}
