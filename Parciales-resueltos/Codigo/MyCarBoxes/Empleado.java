public class Empleado {
	private String nombre;
	private double valorPorHora;
	
	public Empleado(String nombre, double valorPorHora) {
		this.nombre = nombre;
		this.valorPorHora = valorPorHora;
	}
	
	
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getValorPorHora() {
		return valorPorHora;
	}
	public void setValorPorHora(double valorPorHora) {
		this.valorPorHora = valorPorHora;
	}
	
	
}
