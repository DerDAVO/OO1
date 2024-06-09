package serviciosDeParquizacionYContratos;

public class Parquizacion extends Servicio {
	private double costoMantenimiente;
	private int cantMaquinas;
	
	public Parquizacion(double precioPorHora,int cantHoras,int cantMaquinas,double costoMantenimiento) {
		// TODO Auto-generated constructor stub
		
		super(precioPorHora, cantHoras);
		this.cantMaquinas=cantMaquinas;
		this.costoMantenimiente=costoMantenimiento;
	}
	
	
	//Testear metodo? Bastaria con testear calcularCostos?
	@Override
	public double montoAabonar() {
		// TODO Auto-generated method stub
		return calcularCostos()+this.cantMaquinas*this.costoMantenimiente;
	}
	public double getCostoMantenimiente() {
		return costoMantenimiente;
	}
	public void setCostoMantenimiente(double costoMantenimiente) {
		this.costoMantenimiente = costoMantenimiente;
	}
	public int getCantMaquinas() {
		return cantMaquinas;
	}

	public void setCantMaquinas(int cantMaquinas) {
		this.cantMaquinas = cantMaquinas;
	}
	
}
