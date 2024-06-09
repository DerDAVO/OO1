
public abstract class Regla {
	protected int porcentaje;
	protected Regla(int porcentaje) {
		this.porcentaje = porcentaje;
	}
	public abstract double aplicarRegla(DateLapse fecha, double precioTotal);
	public abstract int prioridad();
	public boolean esUnica() {
		return false;
	}
}
