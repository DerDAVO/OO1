
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VeterinarioTest {

	private Veterinario veterinario;
	@BeforeEach
	void setUp() throws Exception {
		veterinario = new Veterinario("David", 200);
	}

	
	// Crear en cada test los escenarios si voya repetir codigo debe ir en el setup
	@Test
	void antiguedadtest() {
		veterinario.setIngreso(LocalDate.now().minusYears(1));
		assertEquals(1,veterinario.antiguedad());
		
		veterinario.setIngreso(LocalDate.now());
		assertEquals(0,veterinario.antiguedad());
		
		veterinario.setIngreso(LocalDate.now().minusYears(5));
		assertEquals(5,veterinario.antiguedad());
		//Hace falta testear con antiguedad 5 si ya los probe con 1 ?
	}

}
