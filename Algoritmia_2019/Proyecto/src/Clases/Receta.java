package Clases;

public class Receta {
	
	public int codigoConsulta,codigoMedicina,cantidad;
	public double precioUnitario;
	
	public Receta(int codigoConsulta, int codigoMedicina, int cantidad, double precioUnitario) {
		this.codigoConsulta = codigoConsulta;
		this.codigoMedicina = codigoMedicina;
		this.cantidad = cantidad;
		this.precioUnitario = precioUnitario;
	}
	public int getcodigoConsulta(){
		return codigoConsulta;
	}
	public void setcodigoConsulta(int codigoConsulta){
		this.codigoConsulta = codigoConsulta;
	}
	public int getCodigoMedicina() {
		return codigoMedicina;
	}

	public void setCodigoMedicina(int codigoMedicina) {
		this.codigoMedicina = codigoMedicina;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
}
