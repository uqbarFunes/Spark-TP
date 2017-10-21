package model;

import java.io.Serializable;
import java.util.HashSet;

public class Indicador implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre ;
	private String usuario ;
	private String formula ;

	private HashSet<String> cuentas ;
	private HashSet<String> indicadores ;
	
	public Indicador ( String nombreIndicador, String formula, String usuario ) 
	{
		this.cuentas = new HashSet<String>() ;
		this.indicadores= new HashSet<String> () ;
		this.setNombreIndicadorAndFormula(formula);
		this.setNombreDeUsuario(usuario);
	}
	public String getNombreDeUsuario() {
		return usuario;
	}
	
	public void setNombreDeUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	private void setNombreIndicadorAndFormula(String rawFormula)
	{
		int i = rawFormula.length()-1 ;
		while ( i > 0 )
		{
			if ( rawFormula.charAt(i)=='=')
			{
				this.formula=rawFormula.substring(i+1,rawFormula.length());
				this.nombre=rawFormula.substring(0,i);
				i = -1 ;
			}
			i -= 1 ;
		}
	}
	
	public static String getUserE ()
	{
		return "Everyone" ;
	}
	
	public String getNombreDeIndicador() {
		return nombre;
	}

	public void setNombreDeIndicador(String nombreIndicador) {
		this.nombre = nombreIndicador;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String expresion) {
		this.formula = expresion;
	}

	public HashSet<String> getCuentas() {
		return cuentas;
	}

	public void setCuentas(HashSet<String> cuentas) {
		this.cuentas = cuentas;
	}

	public HashSet<String> getIndicadores() {
		return indicadores;
	}

	public void setIndicadores(HashSet<String> indicadores) {
		this.indicadores = indicadores;
	}

	public void addCuenta(String cuenta)
	{
		this.cuentas.add(cuenta) ;
	}
	
	public double aplicar (Empresa empresa, Periodo periodo)
	{
		//TODO aplicar indicador...
		return 1 ;
	}
	
	public boolean sePuedeAplicarA(Empresa empresa, Periodo periodo)
	{
		//TODO se puede aplicar indicador...
		return false ;
	}
	
}
