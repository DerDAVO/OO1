package serviciosDeParquizacionYContratos;

import java.time.LocalDate;

public abstract class Contrato {
	private Servicio servicio;
	protected LocalDate fecha;
	public Contrato(LocalDate fecha,Servicio servicio) {
		// TODO Auto-generated constructor stub
		this.fecha=fecha;
		this.servicio=servicio;
	}
	
	public boolean servicioMayorA(double valor) {
		return this.servicio.servicioMayorA(valor);
	}
	abstract double MontoApagar();
	
	
	public Servicio getServicio() {
		return servicio;
	}
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	
}
