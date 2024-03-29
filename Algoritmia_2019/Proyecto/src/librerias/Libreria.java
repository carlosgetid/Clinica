package librerias;

import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Libreria {
	public static int confirmacion(JFrame jf,JDialog jd,String con, String ttl,String ico){
		if(jf==null){
			return JOptionPane.showConfirmDialog(jd, con, ttl, 0, -1, new ImageIcon(ico));
		}
		return JOptionPane.showConfirmDialog(jf, con, ttl, 0, -1, new ImageIcon(ico));
	}
	public static int randomInt(int max,int min){
		return (int)Math.random()*(max-min)+min;
	}
	public static double randomDouble(double max,double min){
		return Math.random()*(max-min)+min;
	}
	public static void SoloLetras(KeyEvent e,JTextField j, int mx){
		char kl=e.getKeyChar();
		if(Character.isDigit(kl) && kl != '\b')
			e.consume();
		if(j.getText().length() == mx)
			e.consume();
	}
	public static void SoloNumeros(KeyEvent e,JTextField j, int mx){
		char kl=e.getKeyChar();
		if((!Character.isDigit(kl)) && kl != '\b')
			e.consume();
		if(j.getText().length() == mx)
			e.consume();
	}
	public static void SoloNumerosYDeciMales(KeyEvent e,JTextField j, int mx){
		char kl=e.getKeyChar();
		if(!Character.isDigit(kl)&&e.getKeyChar()!='.')
		   e.consume();
		if(kl=='.'&&j.getText().contains("."))
		   e.consume();
		if(j.getText().length() == mx)
			e.consume();
	}
	public static void Mensaje(JFrame jf,JDialog jd,String msj,String ttl,int ty, String ico){
		if(jf==null){
			JOptionPane.showMessageDialog(jd, msj, ttl, ty, new ImageIcon(ico));
		}
		if(jd==null){
			JOptionPane.showMessageDialog(jf, msj, ttl, ty, new ImageIcon(ico));
		}
	}
	public static void GenerarHoras(JComboBox<String> cbo){
		for (int i = 1; i < 25; i++) {
			if(i<10)
				cbo.addItem("0"+i);
			else
				cbo.addItem(""+i);
		}
	}
	public static void GenerarMinutos(JComboBox<String>cbo){
		for (int i = 1; i < 61; i++) {
			if(i<10)
				cbo.addItem("0"+i);
			else
				cbo.addItem(""+i);
		}
	}
	public static void GenerarMeses(JComboBox<String>cbo){
		cbo.addItem("Enero");
		cbo.addItem("Febrero");
		cbo.addItem("Marzo");
		cbo.addItem("Abril");
		cbo.addItem("Mayo");
		cbo.addItem("Junio");
		cbo.addItem("Julio");
		cbo.addItem("Agosto");
		cbo.addItem("Septiembre");
		cbo.addItem("Octubre");
		cbo.addItem("Noviembre");
		cbo.addItem("Diciembre");
	}
	public static void GenerarA�os(JComboBox<String>cbo){
		for (int i = A�oActual()-3; i < A�oActual()+6; i++) {
			cbo.addItem(""+i);
		}
	}
	public static void GenerarDias(JComboBox<String>cbo, int op){
		cbo.removeAllItems();
		if(op==1){
			for (int i = 1; i < 30; i++) {
				cbo.addItem(""+i);
				}
		}
		else if(op==3||op==5||op==8||op==10){
			for (int i = 1; i < 31; i++) {
				cbo.addItem(""+i);
			}
		}
		else{
			for (int i = 1; i < 32; i++) {
				cbo.addItem(""+i);
			}
		}	
	}
	public static int A�oActual(){
		Calendar c= new GregorianCalendar();
		return c.get(Calendar.YEAR);
	}
	public static void colocarDiaActual(JComboBox<String> cbo){
		Calendar calendario= new GregorianCalendar();
		cbo.setSelectedIndex(calendario.get(Calendar.DAY_OF_MONTH)-1);
	}
	public static void colocarMesActual(JComboBox<String> cbo){
		Calendar calendario= new GregorianCalendar();
		cbo.setSelectedIndex(calendario.get(Calendar.MONTH));
	}
	public static void colocarA�oActual(JComboBox<String>cbo){
		String a�o= ""+A�oActual();
		cbo.setSelectedItem(a�o);
	}
	public static void colocarHoraActual(JComboBox<String>cbo){
		Calendar c=new GregorianCalendar();
		int hour= c.get(Calendar.HOUR_OF_DAY)-1;
		if(hour<0)
			cbo.setSelectedIndex(23);
		else
			cbo.setSelectedIndex(hour);
	}
	public static void colocarMinutosAprox(JComboBox<String>cbo){
		Calendar c=new GregorianCalendar();
		int min= c.get(Calendar.MINUTE)-1;
		cbo.setSelectedIndex(min);
	}
	public static String obtenerFecha(JComboBox<String> dd,JComboBox<String> mm,JComboBox<String> aa){
		int dia= dd.getSelectedIndex()+1,
			mes= mm.getSelectedIndex()+1,
			a�o= Integer.parseInt(aa.getSelectedItem().toString());
		String fe= ""+((a�o*100+mes)*100+dia);
		return ""+fe.charAt(6)+fe.charAt(7)+"/"+fe.charAt(4)+fe.charAt(5)+"/"+fe.charAt(0)+fe.charAt(1)+fe.charAt(2)+fe.charAt(3);
	}
	public static String obtenerHora(JComboBox<String>hh, JComboBox<String>mn){
		int hora= hh.getSelectedIndex()+1,
			min= Integer.parseInt(mn.getSelectedItem().toString());
		String h1;
		if(hora<10){
			h1= "0"+(hora*100+min);
		}
		else{
			h1= ""+(hora*100+min);
		}	
		return ""+h1.charAt(0)+h1.charAt(1)+":"+h1.charAt(2)+h1.charAt(3);
	}
	public static String obtenerFechaActual(){
		Calendar c=new GregorianCalendar();
		int dia= c.get(Calendar.DAY_OF_MONTH),
			mes= c.get(Calendar.MONTH)+1,
			a�o= c.get(Calendar.YEAR);
		String fe= ""+((a�o*100+mes)*100+dia);
		return ""+fe.charAt(6)+fe.charAt(7)+"/"+fe.charAt(4)+fe.charAt(5)+"/"+fe.charAt(0)+fe.charAt(1)+fe.charAt(2)+fe.charAt(3);
	}
	public static String obtenerHoraActual(){
		Calendar c=new GregorianCalendar();
		int hora= c.get(Calendar.HOUR_OF_DAY),
			min= c.get(Calendar.MINUTE);
		String h1;
		if(hora<10){
			h1= "0"+(hora*100+min);
		}
		else{
			h1= ""+(hora*100+min);
		}	
		return ""+h1.charAt(0)+h1.charAt(1)+":"+h1.charAt(2)+h1.charAt(3);
	}
	public static void ConFechaMod(String fecha, JComboBox<String> dd, JComboBox<String> mm, JComboBox<String> aa){
		String f[]= fecha.split("/");
		int dia= Integer.parseInt(f[0])-1;
		int mes= Integer.parseInt(f[1])-1;
		String a�o= f[2];
		mm.setSelectedIndex(mes);
		aa.setSelectedItem(a�o);
		dd.setSelectedIndex(dia);
	}
	public static void ConHoraMod(String hour,JComboBox<String> hh, JComboBox<String> min){
		String h[]= hour.split(":");
		int hora= Integer.parseInt(h[0])-1;
		int minute= Integer.parseInt(h[1])-1;
		hh.setSelectedIndex(hora);
		min.setSelectedIndex(minute);
	}
}

