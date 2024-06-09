package serviciosDeParquizacionYContratos;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ContratoProlongadoTest {
	private ContratoProlongado contratoProlongado1;
	private ContratoProlongado contratoProlongado2;	
	@BeforeEach
	void setUp() throws Exception {
		//Usar fechas especificas,LocalDate,Now() peude variar segun el dia en el que se lo compile
		contratoProlongado1 = new ContratoProlongado(LocalDate.now(), new Limpieza(1000, 4, 4000), 6);
		contratoProlongado2 = new ContratoProlongado( LocalDate.now(), new Parquizacion(1000, 5, 5, 1000), 6);
	
	}
	
	/*El monto a abonar de los servicios de parquización se calcula como el precio por hora multiplicado 
	 * por la cantidad de horas y a este monto se le adiciona el costo de mantenimiento de las máquinas multiplicado 
	 * por la cantidad de máquinas.*/
	@Test
	void testMontoApagarDeUnaParquizacionReservadoPorMenosDeCincoDias() {
		contratoProlongado2.setCantDias(4);
		assertEquals(40000, contratoProlongado2.MontoApagar());
	}
	@Test
	void testMontoApagarDeUnaParquizacionReservadoPorMasDeCincoDias() {
		assertEquals(9000, contratoProlongado2.MontoApagar());
	}
	
	@Test
	void testMontoApagarDeUnaLimpiezaReservadoPorMasDeCincoDias() {
		assertEquals(contratoProlongado1.MontoApagar(), 3600);
	}
	@Test
	void testMontoApagarDeUnaLimpiezaReservadoPorMenosDeCincoDias() {
		contratoProlongado1.setCantDias(4);
		assertEquals(contratoProlongado1.MontoApagar(), 16000);
	}
	

}
