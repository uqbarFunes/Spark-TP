package junitTests;

import java.util.ArrayList;
import java.util.List;
import controllers.CuentaController;
import java.lang.StringBuilder;

public class TestTransformarVariablesANumeros 
{

	private CuentaController cuentasHandler ;
	List <String> cuentas ;
	
	public TestTransformarVariablesANumeros()
	{
		this.cuentasHandler = new CuentaController();
		this.cuentas = new ArrayList<>();
		this.transformarVariablesANumeros("EBITDA+ROE");
	}
	
	public static void main(String[] args) {
		TestTransformarVariablesANumeros id = new TestTransformarVariablesANumeros();
	}
	
	private String transformarVariablesANumeros(String expr)
	  {
	    boolean recognizingVar = false ;
	    String resultado = "";
	    String expresionFinal = "";
	    String variableName = "";
	    int i = expr.length()-1;
	    while ( i >= 0 )
	    {
	      if ( (expr.charAt(i) >='a' && expr.charAt(i)<='z') || (expr.charAt(i)>='A' && expr.charAt(i)<='Z') )
	      {
	        resultado += expr.charAt(i) ;
	        if ( !recognizingVar )  {
	          recognizingVar = true ;
	        }
	        if (i == 0)
	        {
	        	
	          variableName = new StringBuilder(resultado).reverse().toString();
	          
	          String strAux = expresionFinal ;
	          if ( cuentasHandler.existeLaCuenta(variableName) )
	          {
	        	  expresionFinal = String.valueOf(0) + strAux;
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
	          variableName = new StringBuilder(resultado).reverse().toString();
	          String strAux = expresionFinal;
	          
	          if ( cuentasHandler.existeLaCuenta(variableName) )
	          {
	        	  expresionFinal = expr.charAt(i) + String.valueOf(0) + strAux;
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
	
}
