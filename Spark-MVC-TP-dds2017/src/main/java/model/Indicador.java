package model;

import java.io.Serializable;
import java.util.List;

public class Indicador implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre ;
	private String usuario ;
	private String formula ;
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

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

	public String getFormula() {
		return formula;
	}

	public void setFormula(String expresion) {
		this.formula = expresion;
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
