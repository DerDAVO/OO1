import java.time.LocalDate;

public class Factura {

	private LocalDate fecha;
	private double monto;
	private double descuento;
	private String patente;
	
	public Factura(String patente, double monto, double descuento) {
		super();
		this.monto = monto;
		this.descuento = descuento;
		this.patente = patente;
	}
	
	
}
