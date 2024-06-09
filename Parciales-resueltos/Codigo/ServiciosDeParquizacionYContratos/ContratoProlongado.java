package serviciosDeParquizacionYContratos;

import java.time.LocalDate;

public class ContratoProlongado extends Contrato{
	private int cantDias;
	public ContratoProlongado(LocalDate fecha,Servicio servicio,int cantDias) {
		// TODO Auto-generated constructor stub
		super(fecha, servicio);
		this.cantDias=cantDias;
	}
	public int getCantDias() {
		return cantDias;
	}
	public void setCantDias(int cantDias) {
		this.cantDias = cantDias;
	}
	@Override
	double MontoApagar() {
		// TODO Auto-generated method stub
		if(this.cantDias > 5) {
			return this.getServicio().montoAabonar()*0.9;
		}
		return this.getServicio().montoAabonar()*this.cantDias;
	}
	
	
}	
