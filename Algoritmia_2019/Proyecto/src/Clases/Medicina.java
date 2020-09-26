package Clases;

public class Medicina {
	
	 private int codigoMedicina;
	 private String nombre,laboratorio;
	 private int stock;
	 private double precioUnitario;
	 
	public Medicina(int codigoMedicina, String nombre, String laboratorio, int stock, double precioUnitario) {
		this.codigoMedicina = codigoMedicina;
		this.nombre = nombre;
		this.laboratorio = laboratorio;
		this.stock = stock;
		this.precioUnitario = precioUnitario;
	}
	public int getCodigoMedicina() {
		return codigoMedicina;
	}
	public void setCodigoMedicina(int codigoMedicina) {
		this.codigoMedicina = codigoMedicina;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	 
}
