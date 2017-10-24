package model;

import java.io.Serializable;
import java.util.HashSet;

import controllers.CuentaController;

public class Indicador implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombreDeIndicador ;
	private String usuario ;
	private String formula ;

	CuentaController cuentasController ;
	
	HashSet<String> nombresDeIndicadresSinRepetir ;
	HashSet<String> nombresDeCuentasSinRepetir ;
	
	HashSet<String> cuentasHalldasEnFormula ;
	HashSet<String> indicadoresHalladosEnFormula ; 
	
	
	public Indicador ( String rawFormula, String myUsuario ) 
	{
		
		this.usuario=myUsuario;
		
		cuentasController = new CuentaController () ;
		
		this.setNombresDeCuentasSinRepetir( ) ;
		
		this.cuentasHalldasEnFormula = new HashSet<String> () ;
		
		this.setNombreIndicadorAndFormula(rawFormula);
		
		this.setFormula ( normalizarNombresDeCuentasAndIndicadores ( this.getFormula() ) ) ;
		
	}
	
	public void setNombresDeCuentasSinRepetir() {
		this.nombresDeCuentasSinRepetir = this.cuentasController.getNombresDeCuentasSinRepetir() ;
	}
	
	public boolean existeLaCuenta(String nombreDeCuenta)
	{
		return this.cuentasController.existeLaCuenta(nombreDeCuenta);
	}
	
	public boolean reemplazarCuentaOrIndicadorPorValorDelMismo
		(String indicadorOrCuenta, String cotizacionDeIndicadorOrCuenta)
	{
		String indicadorFormulaAux = this.getFormula() ;
		if ( indicadorFormulaAux.contains(indicadorOrCuenta) )
		{
			String auxString = indicadorFormulaAux.replace
					( indicadorOrCuenta , cotizacionDeIndicadorOrCuenta ) ;
			this.setFormula( auxString ) ;
			//TODO de acá va a sali lo que el parser debe recibir para detemriar si el indicador debe o no ser guardado
			System.out.println( "Luego de reemplazar cuentas e indiacdor : " + this.getFormula() );
			return true ;
		}
		return false ;
	}

	
	public HashSet<String> getNombresDeCuentasSinRepetir() {
		return this.cuentasController.getNombresDeCuentasSinRepetir() ;
	}

	
	private String normalizarNombresDeCuentasAndIndicadores( String expr )
	{
		boolean recognizingVar = false ;
	    String resultado = "";
	    String expresionFinal = "";
	    String variableName = "";
	    int i = expr.length()-1;
	    while ( i >= 0 )
	    {
	    	if ( (expr.charAt(i) >='a' && expr.charAt(i)<='z') || 
	    			(expr.charAt(i)>='A' && expr.charAt(i)<='Z') )
	    	{
	    		resultado += expr.charAt(i) ;
	    		if ( !recognizingVar )  {
	    			recognizingVar = true ;
	    		}
	    		if (i == 0)
	    		{
	    			String strAux = expresionFinal ;
	    			variableName = new StringBuilder( resultado ).reverse().toString() ;
	    			if ( cuentasController.existeLaCuenta(variableName) )
	    			{
	    				System.out.println(
	    						"Existe la cuenta que está totalmente "
	    						+ "a la izquierda y es "+variableName);
	    				expresionFinal = this.normalizarNombreDeCuentaHalladaEnFormula(variableName) + strAux;
	    				this.addCuenta(variableName);
	    			}
	    			//TODO, si el indicador existe: NullPointer...
//	    			else if ( this.existeElIndicador (variableName, this.usuario ) )
//	    			{
//	    				
//	    			}
	    			else
	    			{
	    				expresionFinal = variableName + strAux;
	    			}
	    		}
	    	}
	    	else
	    	{
	    		if ( recognizingVar  )
	    		{
	    			String strAux = expresionFinal;
	    			variableName = new StringBuilder( resultado ).reverse().toString() ;
	    			if ( cuentasController.existeLaCuenta(variableName) )
	    			{
	    				System.out.println("existe la cuenta "+variableName);
	    				expresionFinal = expr.charAt(i) +
	    						this.normalizarNombreDeCuentaHalladaEnFormula(variableName) + strAux;
	    				this.addCuenta(variableName);
	    			}
	    			else
	    			{
	    				expresionFinal = expr.charAt(i) + variableName + strAux ;
	    			}
	    			resultado= "" ;
	    			recognizingVar = false ;
	    		}
	    		else
	    		{
	    			String strAux = ""; 
	    			strAux += expr.charAt(i);
	    			expresionFinal = strAux + expresionFinal ;
	    		}
	    	}
	    	i-=1 ;
	    }
	    return expresionFinal ;
	}
	
	
	
	private String normalizarNombreDeCuentaHalladaEnFormula ( String myAccount)
	{
		StringBuilder cuentasDescubierta = new StringBuilder() ;
		cuentasDescubierta.append("cuenta") ;
		cuentasDescubierta.append("{") ;
		cuentasDescubierta.append(myAccount) ;
		cuentasDescubierta.append("}") ;
		return cuentasDescubierta.toString() ;
	}
	//TODO normalizar indicador debe ser llamado cuando un indicador es encontrado en la fórmula
	private String normalizarNombreDeIndicadorHalladoEnFormula( String myIndicador )
	{
		StringBuilder indicadorDescubierto = new StringBuilder() ;
		indicadorDescubierto.append("indicador") ;
		indicadorDescubierto.append("{") ;
		indicadorDescubierto.append(myIndicador) ;
		indicadorDescubierto.append("}") ;
		return indicadorDescubierto.toString() ;
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
				this.nombreDeIndicador=rawFormula.substring(0,i);
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
		return nombreDeIndicador;
	}

	public void setNombreDeIndicador(String nombreIndicador) {
		this.nombreDeIndicador = nombreIndicador;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String expresion) {
		this.formula = expresion;
	}

	public HashSet<String> getCuentas() {
		return cuentasHalldasEnFormula;
	}

	public void setCuentas(HashSet<String> cuentas) {
		this.cuentasHalldasEnFormula = cuentas;
	}

	public HashSet<String> getIndicadores() {
		return indicadoresHalladosEnFormula;
	}

	public void setIndicadores(HashSet<String> indicadores) {
		this.indicadoresHalladosEnFormula = indicadores;
	}

	public void addCuenta(String cuenta)
	{
		this.cuentasHalldasEnFormula.add(cuenta) ;
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