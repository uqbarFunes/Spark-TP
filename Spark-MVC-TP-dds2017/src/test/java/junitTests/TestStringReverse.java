package junitTests;

import org.junit.Test;

import org.junit.Assert;

public class TestStringReverse {
	
	@Test
	public void palabrasCapicuasSonIguales ()
	{
		String nqn = "neuquen" ;
		String nqnRev = new StringBuilder(nqn).reverse().toString();
		Assert.assertTrue(nqn.equals(nqnRev));
	}
	
	@Test 
	public void otrasPalabrasYSusInversasSeComportanCorrectamente ()
	{
		String hola = "Hola, que tal!" ;
		String holaRevTest = "!lat euq ,aloH" ;
		String holaActualRev = new StringBuilder(hola).reverse().toString() ;
		Assert.assertTrue(holaRevTest.equals(holaActualRev));
	}

}
