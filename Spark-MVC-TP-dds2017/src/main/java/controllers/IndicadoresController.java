package controllers;
import java.util.ArrayList;
import java.util.List;

public class IndicadoresController {

	String formula ;
	String nombre ;
	List<String> cuentas ;
	List<String> indicadores ;
	
	/**
	 * Example of a list of accounts that stores the accounts
	 * EBITDA, EBIT, Free Cash Flow...
	 * [ account{EBITDA} , account{EBIT} ,  account{Free Cash Flow} ]
	 */
	
	/**
	 * myFormula example:
	 * "Free Cash Flow+EBITDA /4*  EBIT"
	 * @param myFormula
	 */
		
	public IndicadoresController( String myFormula )
	{
		
		this.formula = myFormula ;
//			this.setAccounts( this.getAccountsFromFormula(myFormula) ) ;
	}
	
	public boolean replaceOneStringWithAnother(String searchedText, String someString)
	{
		if ( this.formula.contains(searchedText) )
		{
			String auxString = this.formula.replace(searchedText, someString) ;
			this.formula = auxString ;
			System.out.println(this.formula);
			return true ;
		}
		return false ;
	}
	
	public void divideIndicador( String userInput )
	{
		
	}
	
	private void setAccounts(List<String> myAccounts) 
	{
		
		for ( String acc : myAccounts ) 
		{
			StringBuilder cuentasDescubiertas = new StringBuilder() ;
			cuentasDescubiertas.append("cuenta") ;
			cuentasDescubiertas.append("{") ;
			cuentasDescubiertas.append(acc) ;
			cuentasDescubiertas.append("}") ;
			this.cuentas.add(cuentasDescubiertas.toString()) ;
		}
	}
	/**
	 * This function finds accounts, like
	 * "EBITDA", "EBIT", or "Free Cash Flow", they are added
	 * to the accounts' List
	 * as "account{EBITDA}", etc...
	 * @param formula
	 */
	private List<String> getAccountsFromFormula( String formula )
	{
		List<String> myAccounts = new ArrayList<>();
		//accounts found on String are added to myAccounts' List.
		return myAccounts ;
	}

}
