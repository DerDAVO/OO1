
import java.util.List;
import java.util.ArrayList;

public class Usuario {
	private String dni;
	private List<Propiedad> propiedades;
	
	public Usuario(String dni) {
		this.dni = dni;
		this.propiedades = new ArrayList<Propiedad>();
	}
	
	public Propiedad registrarPropiedad(Double precioPorNoche, String nombre, String ubicacion) {
		// ¿Se chequea si existe?
		// No lo hice para no complejizar el ejercicio de examen.
		Propiedad propiedad = new Propiedad(precioPorNoche, nombre, ubicacion);
		propiedades.add(propiedad);
		return propiedad;
	}
}
