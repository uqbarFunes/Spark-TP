package junitTests;

import static org.junit.Assert.*;
import controllers.FilePath;
import model.Indicador; 
import java.util.List;
import java.util.LinkedList;	
import org.junit.Before;
import org.junit.Test;

public class TestDaoJsonIndicadores {
	
	String path ;
	
	@Before
	public void init ()
	{
		FilePath filePath = FilePath.getInstance() ;
		this.path = filePath.getIndicadoresJsonPath() ;
		
		
	}
	
	/*
	*
	private void getIndicadoresPublicosValidos()
	{
		List <Indicador> indicadoresPublicos = new LinkedList() ;
		//Solo se debe persistir every_1 y every_3, eso es lo que voy a corroborar en el @test
		//TODO arreglar TestDaoJsonIndicadores
		Indicador every_1 = new Indicador ( "Ingreso Neto"
				+ "= Ingreso Neto en Operaciones Continuas + Ingreso "
				+ "Neto en Operaciones Discontinuadas", Indicador.getUserE() ) ;
		Indicador every_2 = new Indicador ( "No tiene que andar= Hola - CHAU" , Indicador.getUserE() ) ;
		Indicador every_3 = new Indicador ( "ROE= "
				+ "( Ingreso Neto - Dividendos ) / Capital Total", Indicador.getUserE() ) ;
		//TODO le digo al parser que pruebe el indicador, si no da infinito siempre para todas las cuentas y todos los períodos, entonces está todo legal
		indicadoresPublicos.add(every_1) ;
		
	}
	
	
	//TODO cambiar void para que devuelva una linked list
	private void getIndicadoresGastonValidos()
	{
		
		//Solo se debe persistir de_gaston_1 y de_gaston_3, lo corroboro en @test 
		Indicador de_gaston_1 = new Indicador ( "IndiCatori= EBITDA+EBIT/2", "Gastón" ) ;
		Indicador de_gaston_2 = new Indicador ( "Self=ROE+X/4", "Gastón") ;
		Indicador de_gaston_3 = new Indicador ( "Fruta=(ROE+EBITDA*4)/7", "Gastón") ;
		
	}
	
	private void getIndicadoresTitoValidos()
	{
		//Solo se debe persistir de_tito_3 y de_tito_5
		Indicador de_tito_1 = new Indicador ( "IndiCatori= s+X ", "Tito" ) ;
		Indicador de_tito_2 = new Indicador ( "Self=ROE+X/4", "Tito") ;
		Indicador de_tito_3 = new Indicador ( "ÑanFrimFrufi=EBITDA+-EBIT/Ingreso Neto", "Tito") ;
		Indicador de_tito_4 = new Indicador ( "RandomInd= EBIT-/EBITDA", "Tito") ;
		Indicador de_tito_5 = new Indicador ( "JustDoIt=FDS*Free Cash Flow/8.5", "Tito") ;
		
	}
	*/
	
	@Test
	public void testCargasEveryone() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCargasGaston() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCargasTito() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCadaUsuarioRecibeSusIndicadoresAndLosDeEveryone()
	{
		fail("Not yet implemented");
	}
	
	@Test
	public void siEsInfinitoSiempreNoSeCargaAndSeMuestraError()
	{
		//Lazy evaluation
		fail("Not ye...") ;
	}

}
