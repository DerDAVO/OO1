
public class ReglaRangoFechas extends Regla {
	DateLapse rango;
	boolean esAumento;
	
	public ReglaRangoFechas(DateLapse rango, boolean esAumento, int porcentaje) {
		super(porcentaje);
		this.rango = rango;
		this.esAumento = esAumento;
	}
	
	public int prioridad() {
		return 1;
	}

	public double aplicarRegla(DateLapse fecha, double precioTotal) {
		// El único problema con este algoritmo es que si se llegasen
		// a aplicar dos descuentos por este tipo de regla, de dias disjuntos
		// se va a tomar que cada dia vale por lo descontado previamente.
		
		// Ejemplo donde puede pasar: 
		
		// precioTotal = 1000
		// esAumento = false
		// diasTotales = 10
		// precioPorNoche = 100
		// dias que aplicar = 4
		// dias normales = 6
		// porcentaje = 10%
		// (6 * 100) + (4 * (100 * 0.90)) = 960
		
		// precioTotal = 960
		// esAumento = false
		// diasTotales = 10
		// precioPorNoche = 96
		// dias que aplicar = 6
		// dias normales = 4
		// porcentaje = 10%
		// (4 * 96) + (6 * (96 * 0.90)) = 960 = 902,4
		
		// cuando la cuenta real tendría que ser:
		// (4 * (100 * 0.90)) + (6 * (100 * 0.90)) = 900
		// que es el descuento aplicado por día especifico
		
		// No se me ocurre una forma fácil de realizarlo para mantener
		// el polimorfismo sin romper encapsulamiento y/o cometer
		// envidia de atributos.
		
		// La única forma que veo de hacerlo correcto es llevar un 
		// arreglo con valor por día especifico de la posible reserva
		// e ir haciendo los descuentos pertinentes a cada uno, y después 
		// totalizar el resultado. Pero añade una dificultad algoritmica
		// mayor y creo que se va de la practica que quiere plantear
		// el enunciado.
		
		Double precioPorNoche = precioTotal/fecha.sizeInDays();
		int diasQueAplicar = rango.daysThatOverlaps(fecha);
		int diasNormales = rango.sizeInDays() - diasQueAplicar;
		
		double porcentaje = this.porcentaje/100; 
		if (this.esAumento) {
			porcentaje = 1 + porcentaje;
		} else {
			porcentaje = 1 - porcentaje;
		}
		
		return (diasNormales * precioPorNoche) + (diasQueAplicar * (precioPorNoche * porcentaje));
	}
}
