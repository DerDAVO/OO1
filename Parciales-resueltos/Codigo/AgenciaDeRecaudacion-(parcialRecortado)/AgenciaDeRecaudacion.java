package agenciaDeRecaudacion;

import java.util.ArrayList;
import java.util.List;

public class AgenciaDeRecaudacion {
	private List<Contribuyente> contribuyentes;
	
	public AgenciaDeRecaudacion() {
		// TODO Auto-generated constructor stub
		this.contribuyentes=new ArrayList<Contribuyente>();
	}
	
	
	public Contribuyente darDeAltaUnContribuyente(String nombre,String email,String localidad ,int dni) {
		Contribuyente contribuyente = new Contribuyente(nombre, email, localidad, dni);
		this.contribuyentes.add(contribuyente);
		return contribuyente;
	}
}
