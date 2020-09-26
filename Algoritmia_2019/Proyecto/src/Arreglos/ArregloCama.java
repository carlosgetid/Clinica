package Arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.Buffer;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import Clases.Cama;

public class ArregloCama extends AbstractTableModel{
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Cama>acam;
	
	public ArregloCama(){
		acam=new ArrayList<Cama>();
		cargarCamas();
	}
	public int tamaño(){
		return acam.size();
	}
	public Cama obtener(int pos){
		return acam.get(pos);
	}
	public void adicionar(Cama x){
		acam.add(x);
	}
	public Cama buscar(int num){
		for(Cama c:acam)
			if(c.getNumeroCama()==num)
				return c;
		return null;
	}
	public void eliminar(Cama c){
		acam.remove(c);
	}
	private void cargarCamas(){
		try {
			BufferedReader br;
			String linea;
			int num,cat,estado;
			double precio;
			String[] s;
			br = new BufferedReader(new FileReader("camas.txt"));
			while((linea = br.readLine()) !=null){
				s = linea.split(";");
				num = Integer.parseInt(s[0].trim());
				cat = Integer.parseInt(s[1].trim());
				precio = Double.parseDouble(s[2].trim());
				estado = Integer.parseInt(s[3].trim());
				adicionar(new Cama(num, cat, precio, estado));
			}
			br.close();
		}
		catch (Exception e) {	
		}
	}
	public void grabarCama(){
		try {
			PrintWriter pw;
			pw = new PrintWriter(new FileWriter("camas.txt"));
			for(Cama c:acam){
				pw.println(c.getNumeroCama()+";"+c.getCategoria()+";"+c.getPrecioDia()+";"+c.getEstado());
			}
			pw.close();
		}
		catch (Exception e) {
		}
	}
	public int generarCodigoC(){
		if(tamaño()==0)	
			return 100001;
		else
			return codigoMayorC()+1;

	}
	private int codigoMayorC(){
		int mayor= obtener(0).getNumeroCama();
		for(Cama c:acam){
			if(c.getNumeroCama()>mayor)
				mayor=c.getNumeroCama();
		}
		return mayor;
	}
	private String nombreColumnasC[]= {"N° Cama","Categoria","Precio Diario","Estado"};
	public String TiposEstadoC[]= {"Libre","Ocupado"};
	public String TiposCategoriaC[]= {"Básica","Estándar","Premium"};
	
	public String getColumnName(int col){
		return nombreColumnasC[col];
	}
	@Override
	public int getColumnCount() {
		return nombreColumnasC.length;
	}
	@Override
	public int getRowCount() {
		return tamaño();
	}
	@Override
	public Object getValueAt(int fil, int col) {
		Cama c= obtener(fil);
		switch(col){
		case 0:
			return c.getNumeroCama();
		case 1:
			return TiposCategoriaC[c.getCategoria()];
		case 2:
			return c.getPrecioDia();
		default:
			return TiposEstadoC[c.getEstado()];
		}
	}
}


	
