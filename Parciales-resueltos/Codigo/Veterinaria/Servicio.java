package primerRecuperatorio;

import java.time.LocalDate;

public abstract class Servicio {
	protected Mascota mascota;
	protected LocalDate fecha;
	
	public Servicio(Mascota mascota) {
		this.fecha = LocalDate.now();
		this.mascota = mascota;
	}
	
	
	public Mascota getMascota() {
		return mascota;
	}


	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}


	public LocalDate getFecha() {
		return fecha;
	}

	public boolean esAnterior(LocalDate fecha) {
		return this.getFecha().isBefore(fecha);
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public boolean esFecha(LocalDate unaFecha) {
		return unaFecha.equals(this.getFecha());
	}
	public abstract double calcularCostos();
}
