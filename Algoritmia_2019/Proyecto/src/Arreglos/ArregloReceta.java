package Arreglos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import Clases.Consulta;
import Clases.Receta;

public class ArregloReceta {
	ArrayList<Receta>ar;
	public ArregloReceta() {
		ar= new ArrayList<Receta>();
		cargarRecata();
	}
	public int tamaño(){
		return ar.size();
	}
	public Receta obtener(int i){
		return ar.get(i)
;	}
	public Receta buscar(int cod){
		for(Receta d:ar){
			if(d.getcodigoConsulta()==cod)
				return d;
		}
		return null;
	}
	public void adicionar(Receta a){
		ar.add(a);
	}
	public void eliminar(Receta r){
		ar.remove(r);
	}
	public void cargarRecata(){
		try {
			BufferedReader bf;
			String linea;
			int cod,med, can;;
			double pre;
			String c[];
			bf= new BufferedReader(new FileReader("receta.txt"));
			while((linea = bf.readLine())!=null){
				c= linea.split(";");
				cod= Integer.parseInt(c[0]);
				med= Integer.parseInt(c[1]);
				can= Integer.parseInt(c[2]);
				pre= Double.parseDouble(c[3]);
				adicionar(new Receta(cod, med, can, pre));
			}
			bf.close();
		} 
		catch (Exception e) {
		}
	}
	public void grabarReceta(){
		try {
			PrintWriter pw;
			String linea;
			pw= new PrintWriter(new FileWriter("receta.txt"));
			for(Receta r:ar){
				linea= r.getcodigoConsulta()+";"+
						r.getCodigoMedicina()+";"+
						r.getCantidad()+";"+
						r.getPrecioUnitario();
				pw.println(linea);
			}
			pw.close();
		} 
		catch (Exception e) {
		}
	}
}
