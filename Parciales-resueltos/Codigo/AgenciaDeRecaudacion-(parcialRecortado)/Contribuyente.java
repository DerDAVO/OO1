package agenciaDeRecaudacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Contribuyente {
		private List<Bien> bienes;
		private String nombre,localidad,email;
		private int dni;
		
		public Contribuyente(String nombre,String email,String localidad,int dni) {
			// TODO Auto-generated constructor stub
			this.bienes = new ArrayList<>();
			this.nombre=nombre;
			this.dni=dni;
			this.email=email;
			this.localidad=localidad;
		}
		
		
		
		public Inmueble darDeAltaUnInmueble(double valor, int numeroDePartida,double valorDeEdificacion) {
			Inmueble inmueble = new Inmueble(valor, numeroDePartida, valorDeEdificacion);
			this.bienes.add(inmueble);
			return inmueble;
		}
		
		public Automotor darDeAltaUnAutomotor(double valor,String patente ,String marca,String modelo,LocalDate fechaDeFabricacion){
			Automotor automotor = new Automotor(valor, patente, marca, modelo, fechaDeFabricacion);
			this.bienes.add(automotor);
			return automotor;
		}
		
		public double calcularImpuestosApagar() {
			return this.bienes.stream().mapToDouble(bien -> bien.calcularImpuestoApagar()).sum();
		}
		
		public List<Bien> getBienes() {
			return bienes;
		}
		
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getLocalidad() {
			return localidad;
		}
		public void setLocalidad(String localidad) {
			this.localidad = localidad;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public int getDni() {
			return dni;
		}
		public void setDni(int dni) {
			this.dni = dni;
		}
		
		
}
