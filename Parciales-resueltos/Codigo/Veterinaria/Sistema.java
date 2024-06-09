package primerRecuperatorio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Veterinario> veterinarios;
	private List<Mascota> mascotas;
	
	public Sistema() {
		this.mascotas = new ArrayList<Mascota>();
		this.veterinarios = new ArrayList<Veterinario>();
	}
	
	
	public Veterinario registrarVeterinario(String nombre,double honorarios) {
		Veterinario veterinario = new Veterinario(nombre, honorarios);
		this.veterinarios.add(veterinario);
		return veterinario;
	}
	
	public Mascota registrarMascota(String nombre ,LocalDate fechaDeNacimiento,String especie) {
		Mascota mascota = new  Mascota(nombre, especie, fechaDeNacimiento);
		this.mascotas.add(mascota);
		return mascota;
	}
	
	public double recaudadoEn(LocalDate fecha , Mascota mascota) {
		return mascota.gastosEn(fecha);
	}
	public double recaudacionCachorros(LocalDate fecha) {
		return this.mascotas.stream().filter(m -> ChronoUnit.YEARS.between(m.getFechaDeNacimieto(),LocalDate.now())< 2)
				.mapToDouble(mascota -> mascota.gastosEn(fecha)).sum();
	}	
}
