package primerRecuperatorio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Veterinario {
	private String nombre;
	private LocalDate ingreso;
	private double honorarios;
	
	
	public Veterinario(String nombre,double honorarios) {
		this.nombre = nombre;
		this.honorarios = honorarios;
		this.ingreso = LocalDate.now();
	}
	
	public int antiguedad() {
		long antiguedad = ChronoUnit.YEARS.between(ingreso, LocalDate.now());
		return (int)antiguedad;
	}
	public LocalDate getIngreso() {
		return ingreso;
	}
	public void setIngreso(LocalDate ingreso) {
		this.ingreso = ingreso;
	}
	public double getHonorarios() {
		return honorarios;
	}
	public void setHonorarios(double honorarios) {
		this.honorarios = honorarios;
	}
	c
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
