
import java.util.List;
import java.time.LocalDate;
import java.util.ArrayList;

public class Sistema {
	private List<Usuario> usuarios;
	
	public Sistema() {
		this.usuarios = new ArrayList<Usuario>();
	}
	
	public Usuario crearUsuario(String dni) {
		// ¿Se chequea si existe?
		// No lo hice para no complejizar el ejercicio de examen.
		// Ademas agrego el dni para que tenga algun
		// tipo de informacion aunque no se pida.
		Usuario usuario = new Usuario(dni);
		usuarios.add(usuario);
		return usuario;
	}
	
	public Propiedad registrarPropiedad(Usuario usuario, Double precioPorNoche, String nombre, String ubicacion) {
		// Agregue nombre y ubicacion a las propiedades
		// para que tenga algun tipo de informacion
		// aunque no se pida.
		return usuario.registrarPropiedad(precioPorNoche, nombre, ubicacion);
	}
	
	public Reserva crearReserva(Usuario inquilino, Propiedad propiedad, LocalDate inicio, LocalDate fin) {
		return propiedad.crearReserva(inquilino, inicio, fin);
	}
	
	public ReglaRangoFechas crearReglaPorRangoFechas(Propiedad propiedad, DateLapse rango, boolean esAumento, int porcentaje) {
		return propiedad.agregarRegla(rango, esAumento, porcentaje);
	}
	
	public ReglaEstanciaProlongada crearReglaPorEstanciaProlongada(Propiedad propiedad, int porcentaje, int cantidadMinimaDias) {
		return propiedad.agregarRegla(porcentaje, cantidadMinimaDias);
	}
}
