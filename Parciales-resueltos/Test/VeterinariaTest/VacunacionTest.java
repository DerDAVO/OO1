
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VacunacionTest {
	
	private Veterinario veterinario1;
	private Mascota mascota1;
	private Vacunacion vacunacion;
	
	private Vacunacion vacunacion2;
	private Mascota mascota2;
	private Veterinario veterinario2;
	
	@BeforeEach
	void setUp() throws Exception {
		mascota1 = new Mascota("Koda", "Dogo Argentino", LocalDate.now());
		veterinario1 = new Veterinario("David", 300);
		vacunacion = new Vacunacion("Fizer", 200, mascota1, veterinario1, 500);
		
		mascota2 = new Mascota("Koda", "Dogo Argentino", LocalDate.now());
		veterinario2 = new Veterinario("David", 0);
		vacunacion2 = new Vacunacion("Fizer", 0, mascota2, veterinario2, 0);

	}

	
	
	@Test
	void calcularCostos() {
		assertEquals(1000,vacunacion.calcularCostos());
		assertEquals(0, vacunacion2.calcularCostos());
	}
	
	@Test
	void otrosCostosTest() {
		
		assertEquals(800,vacunacion.otrosCostos());
		vacunacion.setFecha(LocalDate.now().plusDays(4));
		assertEquals(1000,vacunacion.otrosCostos());
		assertEquals(0,vacunacion2.otrosCostos());
		vacunacion2.setFecha(LocalDate.now().plusDays(4));
		assertEquals(200, vacunacion2.otrosCostos());
	}

}
