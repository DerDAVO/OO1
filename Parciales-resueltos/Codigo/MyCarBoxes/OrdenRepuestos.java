
public class OrdenRepuestos extends Orden{
	
	
	protected double costoManoDeObra() {
		return 0;
	}
	protected double incrementoGanancia() {
		return this.repuestos.stream().anyMatch(repuesto -> repuesto.antiguedadMayorA5()>5) ? 1.08: 1.15;
	}
}
