package primerRecuperatorio;

import java.time.DayOfWeek;

public abstract class Atencion extends Servicio{
	protected Veterinario veterinario;
	private double precioDescartables;
	public Atencion(Veterinario veterinario,Mascota mascota,double precioDescartables) {
		super(mascota);
		this.precioDescartables = precioDescartables;
		this.veterinario=veterinario;
	}

	
	public Veterinario getVeterinario() {
		return veterinario;
	}


	public void setVeterinario(Veterinario veterinario) {
		this.veterinario = veterinario;
	}


	public double getPrecioDescartables() {
		return precioDescartables;
	}


	public void setPrecioDescartables(double precioDescartables) {
		this.precioDescartables = precioDescartables;
	}


	public double otrosCostos() {
		
		double costo = this.veterinario.getHonorarios()+this.getPrecioDescartables();
		if(this.getFecha().getDayOfWeek().equals(DayOfWeek.SUNDAY)) {
			costo += 200;
		}
		return costo ;
	}

}
