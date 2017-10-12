package entities;

import java.io.Serializable;

import entities.Cuenta;
import java.util.List;

public class Indicador implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre ;
	private String expresion ;
	private List<Cuenta> cuentas ;
	private List<Indicador> indicadores ;
	
	public Indicador ( String formula ) 
	{
		
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getExpresion() {
		return expresion;
	}

	public void setExpresion(String expresion) {
		this.expresion = expresion;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<Cuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public List<Indicador> getIndicadores() {
		return indicadores;
	}

	public void setIndicadores(List<Indicador> indicadores) {
		this.indicadores = indicadores;
	}

	
	public int aplicar (Empresa empresa, Periodo periodo)
	{
		//TODO implementar método!
		return 1 ;
	}
	
	public boolean sePuedeAplicarA(Empresa empresa, Periodo periodo)
	{
		//TODO implementar método!
		return false ;
	}
	
}
