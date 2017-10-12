package junitTests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import parser.Calculator;
import parser.ParseException;
import parser.TokenMgrError;

public class TestParser {
	
	private double parserResult ;

	@Before
	public void init()
	{
		try {
			double[] res = new double[1] ;
			new Calculator ("( 4   + 2 + 22 ) * 4 ", res) ;
			parserResult = res[0] ;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TokenMgrError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void elParserDevuelveLoMismoQueJDK()
	{
		try {
			double[] resInf = new double[1] ;
			new Calculator ("( 4   + 2 + 22 ) * 4 / 0", resInf) ;
			if (Double.isInfinite(resInf[0]))
			{
				System.out.println("Infinito!");
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TokenMgrError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		double nro = ( 4 + 2 + 22 ) * 4 ;
		Assert.assertTrue(nro == parserResult);
	}
	
}
