
import java.time.LocalDate;

public class Reserva {
	private DateLapse dateLapse;
	private double precioFinal;
	private Usuario inquilino;
	
	public Reserva(LocalDate fechaInicio, LocalDate fechaFin, double precioFinal, Usuario inquilino) {
		this.dateLapse = new DateLapse(fechaInicio, fechaFin);
		this.precioFinal = precioFinal;
		this.inquilino = inquilino;
	}

	public boolean estaOcupada(DateLapse dateLapse) {
		return this.dateLapse.overlaps(dateLapse);
	}
}
