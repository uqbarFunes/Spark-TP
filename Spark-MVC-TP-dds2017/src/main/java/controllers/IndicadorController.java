package controllers;
import java.util.HashSet;
import java.util.List;
import model.Indicador;

public class IndicadorController {

	CuentaController cuentasController ;
	
	Indicador indicador ;
	
	HashSet<String> nombresDeCuentasSinRepetir ;
	HashSet<String> nombresDeIndicadresSinRepetir ;
	private static IndicadorController instance = null ; 
	
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
	
	//TODO reemplazar los espacios a izquierda y derecha del ultimo caracter signirficativo de un string encontrado en formula
	public static IndicadorController getInstance()
	{
		if ( instance == null )
		{
			return new IndicadorController () ;
		}
		return instance ;
	}
	
	private void crearIndicador(String rawFormula, String indUser)
	{
		int i = rawFormula.length()-1 ;
		while ( i > 0 )
		{
			if ( rawFormula.charAt(i)=='=')
			{
				String formula=this.normalizarNombresDeCuentasAndIndicadores
						(rawFormula.substring(i+1,rawFormula.length()));
				String nombreIndicador=rawFormula.substring(0,i);
				i = -1 ;
				this.indicador = new Indicador ( nombreIndicador, formula, indUser ) ;
			}
			i -= 1 ;
		}
		this.indicador = null ;
	}
	
	public void setIndicador ( Indicador myIndicador)
	{
		this.indicador = myIndicador ;
	}
	
	public Indicador getIndicador ()
	{
		return this.indicador ;
	}
	
	public IndicadorController( )
	{
		//TODO Solucionar para que los controllers puedan tener cualquier tipo de persistencia
		cuentasController = new CuentaController () ;
		this.setNombresDeCuentasSinRepetir( );
		this.nombresDeIndicadresSinRepetir = new HashSet<String> () ;
		//TODO obtener nombres de indicadores sin repetir
//		this.nombresDeIndicadresSinRepetir = this.getnombresDeIndicadoresSinRepetir () ;
		
	}
	
	//TODO existe el indicador NullPointer...
//	private boolean existeElIndicador ( String myNombreIndicador, String myUsuario )
//	{
//		return this.getNombresDeIndicadoresSinRepeticiones().contains( myNombreIndicador );
//	}
	
	//TODO getNomresDeIndicadores NullPointer...
//	private HashSet<String> getNombresDeIndicadoresSinRepeticiones ()
//	{
//		return this.nombresDeIndicadresSinRepetir ;
//	}
	
	
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
	    				this.indicador.addCuenta(variableName);
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
	    				this.indicador.addCuenta(variableName);
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
	
	
	
	
	public boolean reemplazarCuentaOrIndicadorPorValorDelMismo
		(String indicadorOrCuenta, String cotizacionDeIndicadorOrCuenta)
	{
		String indicadorFormulaAux = this.indicador.getFormula() ;
		if ( indicadorFormulaAux.contains(indicadorOrCuenta) )
		{
			String auxString = indicadorFormulaAux.replace
					( indicadorOrCuenta , cotizacionDeIndicadorOrCuenta ) ;
			indicador.setFormula( auxString ) ;
			//TODO de acá va a sali lo que el parser debe recibir para detemriar si el indicador debe o no ser guardado
			System.out.println( "Luego de reemplazar cuentas e indiacdor : " + indicador.getFormula() );
			return true ;
		}
		return false ;
	}
	
	public String getNombreDeIndicador ()
	{
		return this.indicador.getNombreDeIndicador() ;
	}
	
	
	
	private void imprimirIndicador()
	{
		System.out.println("________________________________________________");
		System.out.println("Nombre de indicador: " + this.getNombreDeIndicador() );
		System.out.println("Nombre de usuario que cargó el indicador: " + 
										this.getNombreDeUsuario() );
		System.out.println("Fórmula del indicador: " + this.getFormula() );
		System.out.println("________________________________________________");
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
	public String normalizarNombreDeIndicadorHalladoEnFormula( String myIndicador )
	{
		StringBuilder indicadorDescubierto = new StringBuilder() ;
		indicadorDescubierto.append("indicador") ;
		indicadorDescubierto.append("{") ;
		indicadorDescubierto.append(myIndicador) ;
		indicadorDescubierto.append("}") ;
		return indicadorDescubierto.toString() ;
	}
	
	public String getFormula() {
		return this.indicador.getFormula();
	}

	public void setFormula(String formula) {
		this.indicador.setFormula(formula);
	}

	public void setNombreIndicador(String myNombreIndicador) {
		this.indicador.setNombreDeIndicador(myNombreIndicador);
	}

	public String getNombreDeUsuario() {
		return this.indicador.getNombreDeUsuario();
	}

	public void setUsuario(String usuario) {
		this.indicador.setNombreDeUsuario(usuario);
	}

	public boolean existeLaCuenta(String nombreDeCuenta)
	{
		return this.cuentasController.existeLaCuenta(nombreDeCuenta);
	}
	
	public HashSet<String> getNombresDeCuentasSinRepetir() {
		return this.cuentasController.getNombresDeCuentasSinRepetir() ;
	}
	
	public static void main(String[] args) {
		IndicadorController indicadorController = IndicadorController.getInstance() ;
		indicadorController.crearIndicador("EbitdaMasEbit=EBITDA+EBIT", "Gastón");
		System.out.println("Nombres de cuentas sin repetir...");
		indicadorController.getNombresDeCuentasSinRepetir().forEach(System.out::println);
		indicadorController.imprimirIndicador();
		
	}
	
	public List<String> getNombresDeCuentasSinRepetirAsList() {
		return this.cuentasController.getNombresDeCuentasSinRepetirAsList() ;
	}
	
	public void setNombresDeCuentasSinRepetir() {
		this.cuentasController.getNombresDeCuentasSinRepetir() ;
	}
}
