
import java.time.LocalDate;
import java.util.List;

public abstract class Orden {
	String patente;
	protected LocalDate fecha;
	protected List<Repuesto> repuestos;
	
	// OO1: EL TRUCAZO. OO2: Template method
	
	public String getPatente() {
		return this.patente;
	}
	public LocalDate getFecha() {
		return this.fecha;
	}
	public boolean fechaMayorA() {

		return this.getFecha().isBefore(LocalDate.now().minusYears(1));
	}
	
	public double calcularCosto() {
		return ((this.costoRepuestos()+ this.costoManoDeObra())*this.incrementoGanancia());
	}
	
	protected double costoRepuestos() {
		if(this.repuestos.isEmpty()) {
			return 0;
		}else {
			return repuestos.stream().mapToDouble(repuesto -> repuesto.getCosto()).sum();

		}
	}
	
	protected abstract double costoManoDeObra();
	
	protected abstract double incrementoGanancia();
	
}
