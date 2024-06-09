
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Repuesto {
	private String nombre;
	private LocalDate fechaDeFabricacion;
	private double costo;
	public Repuesto(String nombre, LocalDate fechaDeFabricacion, double costo) {
		this.nombre = nombre;
		this.fechaDeFabricacion = fechaDeFabricacion;
		this.costo = costo;
	}

	public int antiguedadMayorA5() {
		long anios = ChronoUnit.YEARS.between(LocalDate.now(),this.fechaDeFabricacion); 
		return (int) anios;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public LocalDate getFechaDeFabricacion() {
		return fechaDeFabricacion;
	}
	public void setFechaDeFabricacion(LocalDate fechaDeFabricacion) {
		this.fechaDeFabricacion = fechaDeFabricacion;
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
}
