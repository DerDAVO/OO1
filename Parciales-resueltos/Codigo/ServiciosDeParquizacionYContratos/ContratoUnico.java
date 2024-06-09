package serviciosDeParquizacionYContratos;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class ContratoUnico extends Contrato{
	
	public ContratoUnico(LocalDate fecha ,Servicio servicio) {
		// TODO Auto-generated constructor stub
		super(fecha, servicio);
	}
	//consultar el constructor
	
	
	@Override
	double MontoApagar() {
		// TODO Auto-generated method stub
		DayOfWeek dia = DayOfWeek.from(fecha);
		if(dia.equals(DayOfWeek.SATURDAY)|| dia.equals(DayOfWeek.SUNDAY)) {
			return this.getServicio().montoAabonar()*1.15;
		}
		return this.getServicio().montoAabonar();
	}
	
}
