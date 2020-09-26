package Clases;

public class Consulta {
	
	private int codigoConsulta,codigoPaciente;
	private String fechaAtencion,horaAtencion;
	private double totalPagar;
	private int estado;
	public Consulta(int codigoConsulta, int codigoPaciente, String fechaAtencion, String horaAtencion,
			double totalPagar, int estado) {
		this.codigoConsulta = codigoConsulta;
		this.codigoPaciente = codigoPaciente;
		this.fechaAtencion = fechaAtencion;
		this.horaAtencion = horaAtencion;
		this.totalPagar = totalPagar;
		this.estado = estado;
	}
	public int getCodigoConsulta() {
		return codigoConsulta;
	}
	public void setCodigoConsulta(int codigoConsulta) {
		this.codigoConsulta = codigoConsulta;
	}
	public int getCodigoPaciente() {
		return codigoPaciente;
	}
	public void setCodigoPaciente(int codigoPaciente) {
		this.codigoPaciente = codigoPaciente;
	}
	public String getFechaAtencion() {
		return fechaAtencion;
	}
	public void setFechaAtencion(String fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}
	public String getHoraAtencion() {
		return horaAtencion;
	}
	public void setHoraAtencion(String horaAtencion) {
		this.horaAtencion = horaAtencion;
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
