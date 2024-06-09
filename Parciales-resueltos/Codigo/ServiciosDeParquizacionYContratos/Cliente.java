package serviciosDeParquizacionYContratos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
	private String nombre;
	private String direccion;
	private List<Contrato> contratos;
 	public Cliente(String nombre,String direccion) {
		// TODO Auto-generated constructor stub
		this.nombre=nombre;
		this.direccion=direccion;
		this.contratos = new ArrayList<Contrato>();
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void contratarDeFormaProlongada(Servicio servicio,LocalDate fecha,int cantDias) {
		ContratoProlongado unContrato = new ContratoProlongado(fecha, servicio,cantDias);
		this.contratos.add(unContrato);
	}
	public void contratarUnicaVez(LocalDate fecha,Servicio servicio) {
		ContratoUnico cu = new ContratoUnico(fecha,servicio);
		this.contratos.add(cu);
	}
	public double montoAabonar() {
		return this.contratos.stream().mapToDouble(c -> c.MontoApagar()).sum();
	}
	public int serviciosMayoresA(double valor) {
		return (int)this.contratos.stream().filter(contrato->contrato.servicioMayorA(valor)).count();
	}
}
