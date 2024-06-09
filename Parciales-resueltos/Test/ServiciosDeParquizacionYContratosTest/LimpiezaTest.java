package serviciosDeParquizacionYContratos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LimpiezaTest {

	private Limpieza limpiezaConTarifaMinimaMayor;
	private Limpieza limpiezaConTarifaMinimaMenor;
	private Limpieza limpiezaConTarifaMinimaIgual;	
	@BeforeEach
	void setUp() throws Exception {
		limpiezaConTarifaMinimaMayor = new Limpieza(2000, 4, 4000);
		limpiezaConTarifaMinimaMenor = new Limpieza(900, 4, 4000);
		limpiezaConTarifaMinimaIgual = new Limpieza(1000, 4, 4000);
	}

	@Test
	void testMontoAabonarConTarifaMinimaMayor() {
		assertEquals(limpiezaConTarifaMinimaMayor.montoAabonar(), 8000);
	}
	@Test
	void testMontoAabonarConTarifaMinimaMenor() {
		assertEquals(limpiezaConTarifaMinimaMenor.montoAabonar(), 4000);
	}
	@Test
	void testMontoAabonarConTarifaMinimaIgual() {
		assertEquals(limpiezaConTarifaMinimaIgual.montoAabonar(), 4000);
	}
	@Test
	void testServicioMayorA() {
		assertTrue(limpiezaConTarifaMinimaIgual.servicioMayorA(1000));
		assertFalse(limpiezaConTarifaMinimaIgual.servicioMayorA(100000));
	}

	

}
