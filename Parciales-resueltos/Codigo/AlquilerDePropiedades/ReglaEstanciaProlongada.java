
public class ReglaEstanciaProlongada extends Regla{
	private int cantidadMinimaDias;
	
	public ReglaEstanciaProlongada(int porcentaje, int cantidadMinimaDias) {
		super(porcentaje);
		this.cantidadMinimaDias = cantidadMinimaDias;
	}

	public int prioridad() {
		return 2;
	}
	
	public boolean esUnica() {
		return true;
	}

	public double aplicarRegla(DateLapse fecha, double precioTotal) {
		return (fecha.sizeInDays() > this.cantidadMinimaDias)? precioTotal * (1 - (this.porcentaje/100)) : precioTotal;
	}
}
