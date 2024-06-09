package primerRecuperatorio;


public class Guarderia extends Servicio {
	
	private int dias;
	private double costoDiario;
	
	public Guarderia(Mascota mascota,int dias,double costoDiario) {
		super(mascota);
		this.dias = dias;
		this.costoDiario = costoDiario;
	}
	
	
	
	
	public double getCostoDiario() {
		return costoDiario;
	}

	public void setCostoDiario(double costoDiario) {
		this.costoDiario = costoDiario;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	

	//Aquiuso fecha para saber los servicios previos a la fecha del srevicio actual
	// ya que en el sistema se querria calcular los costos de un servicio cualquiera ,
	// hacerlo con size() estaria desaprobable 
	@Override
	public double calcularCostos() {
		// TODO Auto-generated method stub
		double costo = this.getCostoDiario()*this.getDias();
		if(this.mascota.serviciosPrevios(fecha) > 5) {
			costo *=0.9;
		}
		return costo;
	}
	
}
