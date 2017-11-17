package it.unical.ingsw.test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.ingsw.ContoCorrente;

public class ContoCorrenteTest {

	private static ContoCorrente contoCorrente;
	
	@BeforeClass
	public static void init(){
		contoCorrente = new ContoCorrente();
	}
	
	@Test
	public void contoIniziale(){
		Assert.assertEquals(0, contoCorrente.getSaldo());
	}
	
	@Test
	public void testDeposita(){
		int saldo = contoCorrente.getSaldo();
		contoCorrente.deposita(250);
		Assert.assertEquals(saldo+250, contoCorrente.getSaldo());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testDepositaFailed(){
		contoCorrente.deposita(-10);
	}
	
	@AfterClass
	public static void testPreleva(){
		int saldo = contoCorrente.getSaldo();
		contoCorrente.preleva(10);
		Assert.assertEquals(saldo-10, contoCorrente.getSaldo());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPrelevaFailed(){
		contoCorrente.preleva(-10);
	}
}
