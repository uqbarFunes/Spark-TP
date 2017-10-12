package entities;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;

public class Periodo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private LocalDate fechaInicial ;
	private LocalDate fechaFinal ;
	private int cotizacion ;
	

	public Periodo( LocalDate fecInic, LocalDate fecFin, int myCot )
	{
		this.fechaFinal = fecFin ;
		this.fechaInicial = fecInic;
		this.cotizacion = myCot ;
	}

	public LocalDate getFechaInicial() {
		return fechaInicial;
	}

	public void setFechaInicial(LocalDate fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	public LocalDate getFechaFinal() {
		return fechaFinal;
	}


	public void setFechaFinal(LocalDate fechaFinal) {
		this.fechaFinal = fechaFinal;
	}


	public int getCotizacion() {
		return cotizacion;
	}


	public void setCotizacion(int cotizacion) {
		this.cotizacion = cotizacion;
	}
	
	public String toString()
	{
		if ( getFechaFinal().getMonth() == Month.JUNE)
		{
			return "Primer semestre " + getFechaFinal().getYear() ; 
		}
		else if (getFechaInicial().getMonth() == Month.JULY )
		{
			return "Segundo semestre " + getFechaFinal().getYear() ;
		}
		else
		{
			return this.getFechaInicial().getYear()
					+ " - " +this.getFechaFinal().plusDays(1).getYear() ;
		}
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
