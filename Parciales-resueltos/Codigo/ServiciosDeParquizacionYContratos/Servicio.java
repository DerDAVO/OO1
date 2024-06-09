package serviciosDeParquizacionYContratos;

public abstract class Servicio {
	private double precioPorHora;
	private int cantHoras;
	
	public Servicio(double precioPorHora,int cantHoras) {
		// TODO Auto-generated constructor stub
		this.cantHoras=cantHoras;
		this.precioPorHora=precioPorHora;
	}
	
	public double calcularCostos() {
		return this.precioPorHora*this.cantHoras;
	}
	//Pasar los clientes
	public boolean servicioMayorA(double valor) {
		return this.montoAabonar()>valor;
	}
	public abstract double montoAabonar();

	public int getCantHoras() {
		return cantHoras;
	}

	public void setCantHoras(int cantHoras) {
		this.cantHoras = cantHoras;
	}

	public double getPrecioPorHora() {
		return precioPorHora;
	}

	public void setPrecioPorHora(double precioPorHora) {
		this.precioPorHora = precioPorHora;
	}
	
}
