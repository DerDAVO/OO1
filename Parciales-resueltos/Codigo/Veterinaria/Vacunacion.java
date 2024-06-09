package primerRecuperatorio;

public class Vacunacion extends Atencion{
	private String vacuna;
	private double costo;
	
	public Vacunacion(String vacuna,double costo,Mascota mascota,Veterinario veterinario,double precioDescartables) {
		super(veterinario, mascota,precioDescartables);
		this.costo = costo;
		this.vacuna = vacuna;
	}
	

	public String getVacuna() {
		return vacuna;
	}

	public void setVacuna(String vacuna) {
		this.vacuna = vacuna;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	@Override
	public double calcularCostos() {
		// TODO Auto-generated method stub
		return this.otrosCostos() + this.getCosto();
	}


	
	
}
