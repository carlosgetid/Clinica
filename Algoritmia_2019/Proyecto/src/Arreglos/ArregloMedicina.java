package Arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Clases.Medicina;
import Clases.Paciente;

public class ArregloMedicina extends AbstractTableModel{
	private ArrayList<Medicina>amed;
	public ArregloMedicina(){
		amed=new ArrayList<Medicina>();
		cargarMedicinas();
	}
	public int tamaño(){
		return amed.size();
	}
	public Medicina obtener(int pos){
		return amed.get(pos);
	}
	public Medicina buscar(int cod){
		for(Medicina m:amed)
			if(m.getCodigoMedicina()==cod)
				return m;
		return null;
	}
	public Medicina buscarCoxNom(String nom){
		for(Medicina m:amed){
			if(m.getNombre().equals(nom)){
				return m;
			}
		}
		return null;
	}
	public void eliminar(Medicina m){
		amed.remove(m);
	}
	public void adicionar(Medicina x){
		amed.add(x);
	}
	private void cargarMedicinas(){
		try {
			BufferedReader br;
			String linea;
			int cod,stock;
			String nom,lab;
			double pre;
			String[] s;
			br = new BufferedReader(new FileReader("medicina.txt"));
			while((linea = br.readLine()) !=null){
				s = linea.split(";");
				cod = Integer.parseInt(s[0].trim());
				nom = s[1].trim();
				lab = s[2].trim();
				stock = Integer.parseInt(s[3].trim());
				pre = Double.parseDouble(s[4].trim());
				adicionar(new Medicina(cod, nom, lab, stock, pre));
			}
			br.close();
		}
		catch (Exception e) {
			
		}
	}
	public void grabarMedicinas(){
		try {
			PrintWriter pw;
			String linea;
			pw = new PrintWriter(new FileWriter("medicina.txt"));
			for(Medicina m:amed){
				linea = m.getCodigoMedicina() + ";" +
						m.getNombre()	+ ";" +
						m.getLaboratorio() + ";" +
						m.getStock() + ";" +
						m.getPrecioUnitario();
				pw.println(linea);
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	public int CodigoCorrelativoM(){
		if(tamaño()==0)
			return 300001;
		else
			return CodigoMayorM()+1;
	}
	private int CodigoMayorM(){
		int mayor= obtener(0).getCodigoMedicina();
		for(Medicina m:amed){
			if(m.getCodigoMedicina()>mayor)
				mayor= m.getCodigoMedicina();
		}
		return mayor;
	}
	private String nomColumnasM[] = {"Codigo","Nombre","Laboratorio","Stock","Precio Unitario"};
	@Override
	public int getColumnCount() {
		return nomColumnasM.length;
	}
	@Override
	public int getRowCount() {
		return tamaño();
	}
	public String getColumnName(int col){
		return nomColumnasM[col];
	}
	@Override
	public Object getValueAt(int fil, int col) {
		Medicina m = obtener(fil);
		switch(col){
		case 0:
			return m.getCodigoMedicina();
		case 1:
			return m.getNombre();
		case 2:
			return m.getLaboratorio();
		case 3:
			return m.getStock();
		default:
			return m.getPrecioUnitario();
		}
	}
}
