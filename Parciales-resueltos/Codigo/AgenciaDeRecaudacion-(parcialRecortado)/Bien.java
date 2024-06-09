package agenciaDeRecaudacion;

public abstract class Bien {
	protected double valor;

	public Bien(double valor) {

		this.valor = valor;
	}
	
	public double getValor() {
		return this.valor;
	}
	
	public abstract double calcularImpuestoApagar();
}
