package primerRecuperatorio;

public class ConsultaMedica extends Atencion {
	public ConsultaMedica(Veterinario veterinario , Mascota mascota, double precioDescartables) {
		super(veterinario, mascota,precioDescartables);
	}
	
	public double calcularCostos() {
		return this.otrosCostos()+this.getVeterinario().antiguedad()*100;
	}
}
