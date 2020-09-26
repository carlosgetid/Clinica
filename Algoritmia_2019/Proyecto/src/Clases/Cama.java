package Clases;

public class Cama {
	
	private int numeroCama,categoria;
	private double precioDia;	
	private int estado;
	public Cama(int numeroCama, int categoria, double precioDia, int estado) {
		this.numeroCama = numeroCama;
		this.categoria = categoria;
		this.precioDia = precioDia;
		this.estado = estado;
	}
	public int getNumeroCama() {
		return numeroCama;
	}
	public void setNumeroCama(int numeroCama) {
		this.numeroCama = numeroCama;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public double getPrecioDia() {
		return precioDia;
	}
	public void setPrecioDia(double precioDia) {
		this.precioDia = precioDia;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
}
