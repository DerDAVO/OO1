
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConsultaMedicaTest {
	private ConsultaMedica consultaMedica;
	private Veterinario veterinario;
	private Mascota mascota;
	
	private ConsultaMedica consultaMedica2;
	private Veterinario veterinario2;
	private Mascota mascota2;
	@BeforeEach
	void setUp() throws Exception {
		veterinario = new Veterinario("David", 100);
		mascota =  new Mascota("Ona", "Canino", LocalDate.now());
		consultaMedica =new ConsultaMedica(veterinario, mascota, 300);
		

		veterinario2 = new Veterinario("David", 0);
		mascota2 =  new Mascota("Ona", "Canino", LocalDate.now());
		consultaMedica2 =new ConsultaMedica(veterinario2, mascota2, 0);
		
	}

	@Test
	void calcularCostosTest() {
		
		assertEquals(400, consultaMedica.calcularCostos());

		
		veterinario.setIngreso(LocalDate.now().minusYears(5));
		assertEquals(900,consultaMedica.calcularCostos());
		
		
		assertEquals(0, consultaMedica2.calcularCostos());
		
		
		veterinario2.setHonorarios(100);
		veterinario2.setIngreso(LocalDate.now().minusYears(5));
		assertEquals(600, consultaMedica2.calcularCostos());
	}
	@Test
	void otrosCostosTest() {
		
		assertEquals(400,consultaMedica.otrosCostos());
		consultaMedica.setFecha(LocalDate.now().plusDays(4));
		assertEquals(600,consultaMedica.otrosCostos());
		
		assertEquals(0,consultaMedica2.otrosCostos());
		consultaMedica2.setFecha(LocalDate.now().plusDays(4));
		assertEquals(200, consultaMedica2.otrosCostos());
	}
}
