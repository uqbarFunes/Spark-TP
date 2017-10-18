package controllers;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import model.Cuenta;
import model.Indicador;
import view.IndicadorView;

public class IndicadorController {

	String formula ;
	String nombre ;
	String usuario ;
	CuentaController cuentasController ;
	
	List<String> cuentas ;
	List<String> indicadores ;
	
	HashSet<String> nombresDeCuentasSinRepetir ;
	HashSet<String> nombresDeIndicadresSinRepetir ;
	RepositorioDeIndicadores repo ;
	
	/**
	 * Example of a list of accounts that stores the accounts
	 * EBITDA, EBIT, Free Cash Flow...
	 * [ account{EBITDA} , account{EBIT} ,  account{Free Cash Flow} ]
	 */
	
	/**
	 * myFormula example:
	 * "Free Cash Flow+EBITDA /4*  EBIT"
	 * @param rawFormula
	 */
	
	/*
	 * La clase IndicadorController, no va a ser la encargada de la creación de 
	 * un indicador, por el contrario va a ser la encargada de la persistencia 
	 * de un indicador si éste es válido, de normalizar la fórmula que ha sido
	 * cargada, y de devolver la información referente al mismo, independientemente
	 * del método que se haya utilizado para persistir a los mismos.
	 * También va a ser el encargado de determinar si un indicador es tal, by simply
	 * checking the HashSet to see if it contains the indicator's name.
	 */
	
	public IndicadorController( Indicador myIndicador )
	{
		
		DAOIndicador dao = new DAOJsonIndicador() ;
		repo = RepositorioDeIndicadores.getInstance(dao) ;
		try {
			this.setUnrepeatedCuentas
						( repo.getAllIndicadores () );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		 * si normalizo la fórmula de un indicador dado, 
		 * tengo que ver que el mismo sea 
		 */
		this.formula = normalizarNombresDeCuentasAndIndicadores( myIndicador.getFormula ( ) ) ;
		
	}
	
	private boolean existeElIndicador ( String myNombreIndicador, String myUsuario )
	{
		return this.getUnrepeatedNombresDeIndicadores().contains(myNombreIndicador);
	}
	
	private HashSet<String> getUnrepeatedNombresDeIndicadores ()
	{
		return this.nombresDeIndicadresSinRepetir ;
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
	    			if ( cuentasController.existeLaCuenta(variableName) )
	    			{
	    				System.out.println("Existe la cuenta que está bien a la izquierda y es "+variableName);
	    				expresionFinal = "cuenta{" + variableName + "}" + strAux;
	    				this.cuentas.add(variableName);
	    			}
	    			else if ( this.existeElIndicador (variableName, this.usuario ) )
	    			{
	    				
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
	    			if ( cuentasController.existeLaCuenta(variableName) )
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
	
	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<String> getCuentas() {
		return cuentas;
	}

	public void setCuentas(List<String> cuentas) {
		this.cuentas = cuentas;
	}

	public List<String> getIndicadores() {
		return indicadores;
	}

	public void setIndicadores(List<String> indicadores) {
		this.indicadores = indicadores;
	}
	
	public void setUnrepeatedCuentas( List <Indicador> empresas )
	{
		this.nombresDeCuentasSinRepetir = new HashSet<>(); 
		Stream <Cuenta>cuentas = empresas.stream()
				.map(e -> e.getCuentas())
				.flatMap(x -> x.stream());
		List<String> nombresDeCuentas = cuentas
				.map(e -> e.getNombre())
				.collect(Collectors.toList());
		nombresDeCuentas.forEach(e -> nombresDeCuentasSinRepetir.add(e));
	}
	
	public boolean existeLaCuenta(String nombreDeCuenta)
	{
		return this.getNombresDeCuentasSinRepetir().contains(nombreDeCuenta);
	}
	
	public HashSet<String> getNombresDeCuentasSinRepetir() {
		return this.nombresDeCuentasSinRepetir;
	}
	
	public List<String> getNombresDeCuentasSinRepetirAsList() {
		return this.getNombresDeCuentasSinRepetir()
				.stream().collect(Collectors.toList());
	}
	
	public void setNombresDeCuentasSinRepetir(HashSet<String> myNombresDeCuentasSinRepetir) {
		this.nombresDeCuentasSinRepetir = myNombresDeCuentasSinRepetir;
	}
}

