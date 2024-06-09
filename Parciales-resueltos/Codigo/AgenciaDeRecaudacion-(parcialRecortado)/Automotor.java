package agenciaDeRecaudacion;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Automotor extends Bien {
	private String patente;
	private String marca;
	private String modelo;
	private LocalDate fechaDeFabricacion;
	public Automotor(double valor,String patente, String marca, String modelo, LocalDate fechaDeFabricacion) {
		super(valor);
		this.patente = patente;
		this.marca = marca;
		this.modelo = modelo;
		this.fechaDeFabricacion = fechaDeFabricacion;
	}
	
	private int antiguedad() {
		return (int) ChronoUnit.YEARS.between(this.fechaDeFabricacion, LocalDate.now());
	}
	@Override
	public double calcularImpuestoApagar() {
		// TODO Auto-generated method stub
		if(this.antiguedad() > 10) {
			return 0;
		}else {
			return this.getValor()*0.05;
		}
	}
	
	
}
