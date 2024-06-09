package agenciaDeRecaudacion;

public class Inmueble extends Bien{
	private int nuemeroDePartida;
	private double valorDeEdificacion;
	
	
	public Inmueble(double valor, int nuemeroDePartida, double valorDeEdificacion) {
		super(valor);
		this.nuemeroDePartida = nuemeroDePartida;
		this.valorDeEdificacion = valorDeEdificacion;
	}


	@Override
	public double calcularImpuestoApagar() {
		// TODO Auto-generated method stub
		return (this.getValor()+this.valorDeEdificacion)*0.01;
	}

}
