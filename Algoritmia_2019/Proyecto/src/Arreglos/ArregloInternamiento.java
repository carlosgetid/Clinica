package Arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Clases.Internamiento;

public class ArregloInternamiento extends AbstractTableModel{
	private ArrayList<Internamiento>ai;
	public ArregloInternamiento(){
		ai= new ArrayList<Internamiento>();
		cargarInternamientos();
	}
	public int tama�o(){
		return ai.size();
	}
	public Internamiento obtener(int pos){
		return ai.get(pos);
	}
	public void adicionarIn(Internamiento in){
		ai.add(in);
	}
	public Internamiento buscar(int cod){
		for(Internamiento i:ai){
			if(i.getCodigoInternamiento()==cod){
				return i;
			}
		}
		return null;
	}
	public Internamiento buscarPaciente(int cod){
		for(Internamiento i:ai){
			if(i.getCodigoPaciente()==cod)
				return i;
		}
		return null;
	}
	public void eliminacion(Internamiento i){
		ai.remove(i);
	}
	private int CodigoMayor(){
		int mayor= obtener(0).getCodigoInternamiento();
		for(Internamiento i:ai){
			if(i.getCodigoInternamiento()>mayor){
				mayor= i.getCodigoInternamiento();
			}
		}
		return mayor;
	}
	public int CodigoCorrelativo(){
		if(tama�o()==0)
			return 500001;
		else
			return CodigoMayor()+1;
	}
	public void cargarInternamientos(){
		try {
			BufferedReader bf;
			String linea;
			int ci,cp,nc,es;
			String fi,hi,fs,hs;
			double tp;
			String s[];
			bf= new BufferedReader(new FileReader("Internamiento.txt"));
			while((linea = bf.readLine())!=null){
				s= linea.split(";");
				ci= Integer.parseInt(s[0]);
				cp= Integer.parseInt(s[1]);
				nc= Integer.parseInt(s[2]);
				fi= s[3];
				hi= s[4];
				fs= s[5];
				hs= s[6];
				tp= Double.parseDouble(s[7]);
				es= Integer.parseInt(s[8]);
				adicionarIn(new Internamiento(ci, cp, nc, fi, hi, fs, hs, tp, es));
			}
			bf.close();
		} 
		catch (Exception e) {
		}
	}
	public void grabarInternamientos(){
		try {
			PrintWriter pw;
			String linea;
			pw= new PrintWriter(new FileWriter("Internamiento.txt"));
			for(Internamiento i:ai){
				linea= i.getCodigoInternamiento()+";"+
						i.getCodigoPaciente()+";"+
						i.getNumeroCama()+";"+
						i.getFechaIngreso()+";"+
						i.getHoraIngreso()+";"+
						i.getFechaSalida()+";"+
						i.getHoraSalida()+";"+
						i.getTotalPagar()+";"+
						i.getEstado();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}
	String NombresColIn[]={"Codigo Internamiento","Codigo Paciente","Numero Cama","Fecha Ingreso",
			"Hora Ingreso","Fecha Salida","Hora Salida","Total a Pagar","Estado"};
	public static String EstadosPacIn[]={"Internado","Pagado"};
	@Override
	public int getColumnCount() {
		return NombresColIn.length;
	}
	public String getColumnName(int col){
		return NombresColIn[col];
	}
	@Override
	public int getRowCount() {
		return tama�o();
	}
	@Override
	public Object getValueAt(int row, int col) {
		Internamiento i= obtener(row);
		switch(col){
		case 0:
			return i.getCodigoInternamiento();
		case 1:
			return i.getCodigoPaciente();
		case 2:
			return i.getNumeroCama();
		case 3:
			return i.getFechaIngreso();
		case 4:
			return i.getHoraIngreso();
		case 5:
			return i.getFechaSalida();
		case 6:
			return i.getHoraSalida();
		case 7:
			return i.getTotalPagar();
		default:
			return EstadosPacIn[i.getEstado()];
		}
	}
}
