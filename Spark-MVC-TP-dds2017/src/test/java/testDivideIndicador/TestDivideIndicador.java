package testDivideIndicador;

import controllers.CuentaController;
import parser.Calculator;
import parser.ParseException;
import parser.TokenMgrError;
import java.util.ArrayList;
import java.util.List;

public class TestDivideIndicador {
	
	String nombre ;
	String formula ;
	List<String> cuentas;
	CuentaController cuentasHandler;
	
	public TestDivideIndicador ()
	{
		this.cuentasHandler = new CuentaController();
		this.cuentas = new ArrayList<>();
	}
	
	public static void main ( String[] args) throws ParseException, TokenMgrError
	{
		TestDivideIndicador test = new TestDivideIndicador();
		String indicador = " Indicatore = ROE + EBITDA+ EBIT / FDS " ;
		System.out.println(test.normalizarNombresDeCuentasAndIndicadores(indicador) );
		test.setNombreIndicadorAndFormula(indicador);
		test.imprimirIdAndformula();
	}
	
	private String normalizarNombresDeCuentasAndIndicadores(String expr)
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
	    			if ( cuentasHandler.existeLaCuenta(variableName) )
	    			{
	    				System.out.println("Existe la cuenta que está bien a la izquierda y es "+variableName);
	    				expresionFinal = "cuenta{" + variableName + "}" + strAux;
	    				this.cuentas.add(variableName);
	    			}
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
	    			if ( cuentasHandler.existeLaCuenta(variableName) )
	    			{
	    				System.out.println("existe la cuenta "+variableName);
	    				expresionFinal = expr.charAt(i) + "cuenta{" + variableName + "}" + strAux;
	    				this.cuentas.add(variableName);
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
	
	public void imprimirIdAndformula() throws ParseException, TokenMgrError
	{
		System.out.println("Nombre de indicador: "+this.formula);
		System.out.println("Expresión: "+this.nombre);
		try
		{
			double[] res = new double[1] ;
			new Calculator ( this.nombre , res) ;
			double resultado = res[0] ;
			System.out.println("Resultado del indicatore : " + resultado );
		}
		catch (NumberFormatException e)
		{
			System.out.println("Hubo un error de sintaxis");
		}
	}
	public String getNombreIndicador() {
		return nombre;
	}

	public void setNombreIndicador(String NombreIndicador) {
		this.nombre = NombreIndicador;
	}

	
	
	
	private void setNombreIndicadorAndFormula(String myFormula)
	{
		int i = myFormula.length()-1 ;
		while ( i > 0 )
		{
			if ( myFormula.charAt(i)=='=')
			{
				this.formula=myFormula.substring(0,i);
				this.nombre=myFormula.substring(i+1,myFormula.length());
				i = -1 ;
			}
			i -= 1 ;
		}
	}
	
	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public List<String> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<String> cuentas) {
		this.cuentas = cuentas;
	}


}
