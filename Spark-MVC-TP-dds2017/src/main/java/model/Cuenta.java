package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cuenta implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre ;
	private List<Periodo> periodos ;
	
	public Cuenta(String myNombre, List<Periodo> myPeriodos )
	{
		this.periodos = new ArrayList<>();
		this.periodos = myPeriodos ;
		this.nombre = myNombre ;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Periodo> getPeriodos() {
		return periodos;
	}

	public void setPeriodos(List<Periodo> periodos) {
		this.periodos = periodos;
	}
}
