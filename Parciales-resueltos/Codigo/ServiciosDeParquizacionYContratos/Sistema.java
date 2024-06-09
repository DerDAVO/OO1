package serviciosDeParquizacionYContratos;

import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Servicio> servicios;
	private List<Cliente> clientes;
	
	public Sistema() {
		this.clientes = new ArrayList<Cliente>();
		this.servicios = new ArrayList<Servicio>();
	}
	
	public Cliente registrarCliente(String nombre,String direccion){
		Cliente cli = new Cliente(nombre, direccion);
		this.clientes.add(cli);
		return cli;
	}
	public Limpieza registrarLimpieza(double precioPorHora,int cantHoras,double tarifaMinima) {
		Limpieza l = new Limpieza(precioPorHora, cantHoras, cantHoras);
		this.servicios.add(l);
		return l;
	}
	public Parquizacion registrarParquizacion(double precioPorHora,int cantHoras,double tarifaMinima,int cantMaquinas,double costoMantenimiento) {
		Parquizacion p = new Parquizacion(precioPorHora, cantHoras, cantMaquinas, costoMantenimiento);
		this.servicios.add(p);
		return p;
	}
	
	//pasar por los clientes
	public double serviciosMayoresAUnValor(double valor) {
		return (double) this.clientes.stream().mapToInt(cliente->cliente.serviciosMayorA(valor)).sum();
	}
	
}
