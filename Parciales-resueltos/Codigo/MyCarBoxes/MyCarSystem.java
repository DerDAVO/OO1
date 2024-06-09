

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class MyCarSystem {
	
	List<Empleado> empleados;
	List<Orden> ordenes;
	List<Repuesto> repuestos;
	//dada una lista de Orenes
	public List<Factura> facturar(List<Orden> ordenesAFacturar){

		return (List<Factura>) ordenesAFacturar.stream().map(orden -> this.generarFactura(orden)).collect(Collectors.toList());
	}
	
	private Factura generarFactura(Orden orden) {
		return new Factura(orden.getPatente(), orden.calcularCosto(), this.descuento(orden.getPatente()));
	}
	
	private double descuento(String patente) {
		return tieneFacturaHace12Meses(patente)? 0.05 : 0;
	}
	
	public boolean tieneFacturaHace12Meses(String patente) { 
		return ordenes.stream().filter(orden -> orden.getPatente().equals(patente)).anyMatch(orden -> orden.fechaMayorA());
	}
}
