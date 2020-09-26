package Arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Clases.Consulta;

public class ArregloConsulta extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Consulta>ac;
	public ArregloConsulta() {
		ac= new ArrayList<Consulta>();
		cargarConsultaCon();
	}
	public int tama�oCon(){
		return ac.size();
	}
	public Consulta obtenerCon(int c){
		return ac.get(c);
	}
	public void adicionarCon(Consulta ad){
		ac.add(ad);
	}
	public Consulta buscar(int cod){
		for(Consulta c:ac){
			if(c.getCodigoConsulta()==cod)
				return c;
		}
		return null;
	}
	public void eliminarCon(Consulta ad){
		ac.remove(ad);
	}
	public int CodigoCOrrelativo(){
		if(tama�oCon()==0)
			return 400001;
		else
			return CodigoMayor()+1;
	}
	private int CodigoMayor(){
		int mayor= obtenerCon(0).getCodigoConsulta();
		for(Consulta c:ac){
			if(c.getCodigoConsulta()>mayor)
				mayor=c.getCodigoConsulta();
		}
		return mayor;
	}
	public void cargarConsultaCon(){
		try {
			BufferedReader bf;
			String linea;
			int con, pac,es;
			String fec,hora;
			double pag;
			String c[];
			bf= new BufferedReader(new FileReader("Consulta.txt"));
			while((linea = bf.readLine())!=null){
				c= linea.split(";");
				con= Integer.parseInt(c[0]);
				pac= Integer.parseInt(c[1]);
				fec= c[2];
				hora= c[3];
				pag= Double.parseDouble(c[4]);
				es= Integer.parseInt(c[5]);
				adicionarCon(new Consulta(con, pac, fec, hora, pag, es));
			}
			bf.close();
		} 
		catch (Exception e) {
		}
	}
	public void grabarConsultaCon(){
		try {
			PrintWriter pw;
			String linea;
			pw= new PrintWriter(new FileWriter("Consulta.txt"));
			for(Consulta c:ac){
				linea= c.getCodigoConsulta()+";"+
						c.getCodigoPaciente()+";"+
						c.getFechaAtencion()+";"+
						c.getHoraAtencion()+";"+
						c.getTotalPagar()+";"+
						c.getEstado();
				pw.println(linea);
			}
			pw.close();
		} 
		catch (Exception e) {
		}
	}
	private String ConsulColumns[]= {"Cod. Consulta","Cod. Paciente","Fecha de Atencion","Hora de Atencion","Total a Pagar","Estado"};
	public static String EstadosConsul[]= {"Pendiente","Pagada"};
	@Override
	public int getColumnCount() {
		return ConsulColumns.length;
	}
	public String getColumnName(int col){
		return ConsulColumns[col];
	}
	@Override
	public int getRowCount() {
		return tama�oCon();
	}
	@Override
	public Object getValueAt(int row, int col) {
		Consulta ce= obtenerCon(row);
		switch(col){
		case 0:
			return ce.getCodigoConsulta();
		case 1:
			return ce.getCodigoPaciente();
		case 2:
			return ce.getFechaAtencion();
		case 3:
			return ce.getHoraAtencion();
		case 4:
			return ce.getTotalPagar();
		default:
			return EstadosConsul[ce.getEstado()];
		}
	}
}
