package primerRecuperatorio;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Mascota {
	private String nombre;
	private LocalDate fechaDeNacimieto;
	private String especie;
	private List<Servicio> servicios;
	
	public Mascota (String nombre,String especie,LocalDate fechaDeNacimiento) {
		this.especie = especie;
		this.nombre = nombre;
		this.fechaDeNacimieto = fechaDeNacimiento;
		this.servicios = new ArrayList<Servicio>();
	}
	
	
	public double gastosEn(LocalDate fecha) {
		return this.servicios.stream().filter(servicio -> servicio.esFecha(fecha)).mapToDouble(s -> s.calcularCostos()).sum();
	} 
	public int edad() {
		return (int) ChronoUnit.YEARS.between(fechaDeNacimieto, LocalDate.now());
	}
	
	
	public ConsultaMedica registrarConsultaMedica(Veterinario veterinario){
		ConsultaMedica consultaMedica = new ConsultaMedica(veterinario, this, 300);
		this.getServicios().add(consultaMedica);
		return consultaMedica;
	}
	
	public Vacunacion registrarVacunacion(Veterinario veterinario,String vacuna ,double costo,double precioDescartables) {
		Vacunacion vacunacion = new Vacunacion(vacuna, costo,this, veterinario, precioDescartables);
		this.getServicios().add(vacunacion);
		return vacunacion;
	}
	
	public Guarderia registrarServicioDeGuarderia(int dias,double costoDiario) {
		Guarderia guarderia = new Guarderia(this, dias,costoDiario );
		this.getServicios().add (guarderia);
		return guarderia;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public LocalDate getFechaDeNacimieto() {
		return fechaDeNacimieto;
	}
	public void setFechaDeNacimieto(LocalDate fechaDeNacimieto) {
		this.fechaDeNacimieto = fechaDeNacimieto;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public List<Servicio> getServicios() {
		return servicios;
	}
	
	public int serviciosPrevios(LocalDate fecha) {
		return (int)this.servicios.stream().filter(servicio -> servicio.esAnterior(fecha)).count();
	}
}
