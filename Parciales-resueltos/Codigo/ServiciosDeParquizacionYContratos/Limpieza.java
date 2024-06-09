package serviciosDeParquizacionYContratos;

public class Limpieza extends Servicio{

	private double tarifaMinima;
	
	public Limpieza(double precioPorHora,int cantHoras,double tarifaMinima) {	
		// TODO Auto-generated constructor stub
		super(precioPorHora,cantHoras);
		this.tarifaMinima=tarifaMinima;
		
	}
	
	@Override
	public double montoAabonar() {
		// TODO Auto-generated method stub
		if(calcularCostos() < this.tarifaMinima) {
			return this.tarifaMinima;
		}
		return calcularCostos();
	}
	
}
