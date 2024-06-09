
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Propiedad {
	private double precioPorNoche;
	private String nombre;
	private String ubicacion;
	private List<Reserva> reservas;
	private List<Regla> reglas;
	
	public Propiedad(double precioPorNoche, String nombre, String ubicacion) {
		this.precioPorNoche = precioPorNoche;
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.reservas = new ArrayList<Reserva>();
		this.reglas = new ArrayList<Regla>();
	}

	public Reserva crearReserva(Usuario inquilino, LocalDate inicio, LocalDate fin) {
		DateLapse posibleFechaReserva = new DateLapse(inicio, fin);
		if (this.estaDisponible(posibleFechaReserva)) {
			Double precioReserva = this.calcularPrecioBase(posibleFechaReserva);
			
			// me parece que me complique mucho por querer todo polimorfico
			// y por querer mantener el que se apliquen reglas segun prioridad
			// y dejando la posibilidad de crear nuevas reglas que respeten
			// el protocolo
			// tambien por respetar el calculo tal cual dice el ejercicio
			this.reglas.sort((r1,r2) -> r1.prioridad() - r2.prioridad());
			for (Regla regla: this.reglas) {
				precioReserva = regla.aplicarRegla(posibleFechaReserva, precioReserva);
			}
			
			Reserva reserva = new Reserva(inicio, fin, precioReserva, inquilino);
			this.reservas.add(reserva);
			return reserva;
		}
		return null;
	}

	private double calcularPrecioBase(DateLapse fecha) {
		return (fecha.sizeInDays() * this.precioPorNoche);
	}

	private boolean estaDisponible(DateLapse fecha) {
		return this.reservas.stream().noneMatch(reserva -> reserva.estaOcupada(fecha));
	}
	
	public ReglaEstanciaProlongada agregarRegla(int porcentaje, int cantidadMinimaDias) {
		// Tengo que asegurarme que haya solo una.
		// Lo que no me gusta de esta solucion es que
		// es basicamente preguntar por clase, pero me 
		// deja mantener el polimorfismo y usar una 
		// sola coleccion.
		ReglaEstanciaProlongada nuevaRegla = null;
		if (this.reglas.stream().noneMatch(regla -> regla.esUnica())) {
			nuevaRegla = new ReglaEstanciaProlongada(porcentaje, cantidadMinimaDias);
			this.reglas.add(nuevaRegla);
		}
		return nuevaRegla;
	}
	
	public ReglaRangoFechas agregarRegla(DateLapse rango, boolean esAumento, int porcentaje) {
		// asumo que el sistema no deja que se overlapeen
		// ya que lo dice el enunciado
		ReglaRangoFechas nuevaRegla = null;
		nuevaRegla = new ReglaRangoFechas(rango, esAumento, porcentaje);
		this.reglas.add(nuevaRegla);
		return nuevaRegla;
	}
}
