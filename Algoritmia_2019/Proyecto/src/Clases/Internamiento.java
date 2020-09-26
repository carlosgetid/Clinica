package Clases;

public class Internamiento {
	
	private int CodigoInternamiento,codigoPaciente,numeroCama;
	private String fechaIngreso,horaIngreso,fechaSalida,horaSalida;
	private double totalPagar;
	private int estado;
	public Internamiento(int codigoInternamiento, int codigoPaciente, int numeroCama, String fechaIngreso,
			String horaIngreso, String fechaSalida, String horaSalida, double totalPagar, int estado) {
		CodigoInternamiento = codigoInternamiento;
		this.codigoPaciente = codigoPaciente;
		this.numeroCama = numeroCama;
		this.fechaIngreso = fechaIngreso;
		this.horaIngreso = horaIngreso;
		this.fechaSalida = fechaSalida;
		this.horaSalida = horaSalida;
		this.totalPagar = totalPagar;
		this.estado = estado;
	}
	public int getCodigoInternamiento() {
		return CodigoInternamiento;
	}
	public void setCodigoInternamiento(int codigoInternamiento) {
		CodigoInternamiento = codigoInternamiento;
	}
	public int getCodigoPaciente() {
		return codigoPaciente;
	}
	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}
	public int getNumeroCama() {
		return numeroCama;
	}
	public void setNumeroCama(int numeroCama) {
		this.numeroCama = numeroCama;
	}
	public String getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(String fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public String getHoraIngreso() {
		return horaIngreso;
	}
	public void setHoraIngreso(String horaIngreso) {
		this.horaIngreso = horaIngreso;
	}
	public String getFechaSalida() {
		return fechaSalida;
	}
	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}
	public String getHoraSalida() {
		return horaSalida;
	}
	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}
	public double getTotalPagar() {
		return totalPagar;
	}
	public void setTotalPagar(double totalPagar) {
		this.totalPagar = totalPagar;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
}
