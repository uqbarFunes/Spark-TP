package controllers;
import model.Indicador;

public class IndicadorController {

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
	
	public Indicador crearIndicador(String rawFormula, String indUser)
	{
		return new Indicador(rawFormula, indUser) ;
	}
	
	public IndicadorController( )
	{
		
		
		
		//TODO Solucionar para que los controllers puedan tener cualquier tipo de persistencia
		
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
	
	public String getNombreDeIndicador ( Indicador indicador )
	{
		return indicador.getNombreDeIndicador() ;
	}
	
	
	
	private void imprimirIndicador( Indicador indicador )
	{
		System.out.println("________________________________________________");
		System.out.println("Nombre de indicador: " + indicador.getNombreDeIndicador() );
		System.out.println("Nombre de usuario que cargó el indicador: " + 
										indicador.getNombreDeUsuario() );
		System.out.println("Fórmula del indicador: " + indicador.getFormula() );
		System.out.println("________________________________________________");
	}
	
	public static void main(String[] args) {
		
		IndicadorController indicadorController = IndicadorController.getInstance() ;
		
		Indicador indicador = indicadorController
					.crearIndicador("EbitdaMasEbit =FDS + EBIT", "Gastón");
		/////////////////////////////////////////////////////////////////////////////////
		System.out.println("Nombres de cuentas sin repetir...");
		indicadorController.imprimirIndicador( indicador );
		
	}
	
	
}
