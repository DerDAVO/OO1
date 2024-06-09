
import java.util.List;

public class OrdenReparacion extends Orden {
	List<Empleado> empleados;
	private int cantHorasNecesarias;
	
	protected double costoManoDeObra() {
		return empleados.stream().mapToDouble(empleado -> empleado.getValorPorHora()*cantHorasNecesarias).sum();
	}
	
	protected double incrementoGanancia() { 
		return 1.10;
	}

}
