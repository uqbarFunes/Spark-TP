package testDivideIndicador;

import controllers.CuentasHandler;
import parser.Calculator;
import parser.ParseException;
import parser.TokenMgrError;
import java.util.ArrayList;
import java.util.List;

public class TestDivideIndicador {
	
	String expresion ;
	String formulaString ;
	List<String> cuentas;
	CuentasHandler cuentasHandler;
	
	public TestDivideIndicador ()
	{
		this.cuentasHandler = new CuentasHandler();
		this.cuentas = new ArrayList<>();
	}
	
	public static void main ( String[] args) throws ParseException, TokenMgrError
	{
		TestDivideIndicador test = new TestDivideIndicador();
		String indicador = " Indicatore = ROE + EBITDA+ EBIT / FDS " ;
		System.out.println(test.nombresCuentasOrIndicadoresToNormalizado(indicador) ); 
		test.guardarIndicadorSiEsPosible(indicador);
		test.imprimirIdAndformula();
	}
	
	public String getExpresion() {
		return expresion;
	}

	public void setExpresion(String expresion) {
		this.expresion = expresion;
	}

	public String getFormulaString() {
		return formulaString;
	}

	public void setFormulaString(String formulaString) {
		this.formulaString = formulaString;
	}

	public List<String> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<String> cuentas) {
		this.cuentas = cuentas;
	}


	public void imprimirIdAndformula() throws ParseException, TokenMgrError
	{
		System.out.println("Fórmula: "+this.formulaString);
		System.out.println("Expresión: "+this.expresion);
		try
		{
			
			double[] res = new double[1] ;
			new Calculator ( this.expresion , res) ;
			double parserResult = res[0] ;
			System.out.println("Resultado del indicatore : " + parserResult );

		}
		
		catch (NumberFormatException e)
		{
			System.out.println("Hubo un error de sintaxis");
		}
	}
	
	private String nombresCuentasOrIndicadoresToNormalizado(String expr)
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
	
	private void guardarIndicadorSiEsPosible(String myFormulaString)
	  {
	    int i = myFormulaString.length()-1 ;
	    while ( i > 0 )
	    {
	      if ( myFormulaString.charAt(i)=='=')
	      {
	    	  this.formulaString=myFormulaString.substring(0,i);
	    	  this.expresion=myFormulaString.substring(i+1,myFormulaString.length());
	    	  i = -1 ;
	      }
	      	i -= 1 ;
	    }
	  }
}
