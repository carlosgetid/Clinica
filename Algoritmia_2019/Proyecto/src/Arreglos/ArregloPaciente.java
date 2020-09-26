package Arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Clases.Cama;
import Clases.Paciente;

public class ArregloPaciente extends AbstractTableModel {
	private ArrayList<Paciente>apac;
	
	public ArregloPaciente(){
		apac=new ArrayList<Paciente>();
		cargarPacientes();
	}
	public int tamaño(){
		return apac.size();
	}
	public Paciente obtener(int pos){
		return apac.get(pos);
	}
	public Paciente buscar(int num){
		for(Paciente p:apac)
			if(p.getCodigoPaciente()==num)
				return p;
		return null;
	}
	public void eliminar(Paciente p){
		apac.remove(p);
	}
	public void adicionar(Paciente x){
		apac.add(x);
	}
	private void cargarPacientes(){
		try {
			BufferedReader br;
			String linea;
			int cod;
			String nom,ape;
			int telf,dni;
			String[] s;
			br = new BufferedReader(new FileReader("pacientes.txt"));
			while((linea = br.readLine()) !=null){
				s = linea.split(";");
				cod = Integer.parseInt(s[0].trim());
				nom = s[1].trim();
				ape = s[2].trim();
				telf = Integer.parseInt(s[3].trim());
				dni = Integer.parseInt(s[4].trim());
				adicionar(new Paciente(cod, nom, ape, telf, dni));
			}
			br.close();
		}
		catch (Exception e) {
			
		}
	}
	public void grabarPacientes(){
		try {
			PrintWriter pw;
			String linea;
			pw = new PrintWriter(new FileWriter("pacientes.txt"));
			for(Paciente p:apac){
				linea = p.getCodigoPaciente() + ";" +
						p.getNombre() + ";" +
						p.getApellidos() + ";" +
						p.getTelefono() + ";" +
						p.getDni();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	public int generarCodigoP(){
		if(tamaño()==0)
			return 200001;
		else
			return CodigoMayorP()+1;
	}
	private int CodigoMayorP(){
		int mayor= obtener(0).getCodigoPaciente();
		for(Paciente p:apac){
			if(p.getCodigoPaciente()>mayor)
				mayor=p.getCodigoPaciente();
		}
		return mayor;
	}
	private String nomColumnasP[]= {"Codigo Paciente","Nombres","Apellidos","Telefono","DNI"};
	@Override
	public int getColumnCount() {
		return nomColumnasP.length;
	}
	public String getColumnName(int col){
		return nomColumnasP[col];
	}
	@Override
	public int getRowCount() {
		return tamaño();
	}
	@Override
	public Object getValueAt(int fil, int col) {
		Paciente p= obtener(fil);
		switch(col){
		case 0:
			return p.getCodigoPaciente();
		case 1:
			return p.getNombre();
		case 2:
			return p.getApellidos();
		case 3:
			return p.getTelefono();
		default:
			return p.getDni();
		}
	}
	

}
