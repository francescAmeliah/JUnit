package it.unical.ingsw.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import it.unical.ingsw.ContoCorrente;

public class ContoCorrenteTestAdvance {

	private static ContoCorrente contoCorrente;
	
	@BeforeClass
	public static void init(){
		contoCorrente = new ContoCorrente();
		System.out.println("Prima dei depositi e/o prelievi il saldo è: "+ contoCorrente.getSaldo());
	}
	
	@AfterClass
	public static void end(){
		System.out.println("Alla fine dei depositi e/o prelievi il saldo è: "+contoCorrente.getSaldo());
	}
	
	@Before
	public void saldoCorrente(){
		System.out.println("Il saldo attualmente è: "+ contoCorrente.getSaldo());
	}
	
	@After
	public void endTest(){
		System.out.println("Fine Test");
	}
	
	@Test
	public void depositaSoldi(){
		int saldo = contoCorrente.getSaldo();
		contoCorrente.deposita(5000);
		Assert.assertEquals(saldo+5000, contoCorrente.getSaldo());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void depositaImbrogliando(){
		contoCorrente.deposita(0);
	}
	
	@Test
	public void prelevaInModoOnesto(){
		int saldo = contoCorrente.getSaldo();
		contoCorrente.preleva(500);
		Assert.assertEquals(saldo-500, contoCorrente.getSaldo());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void prelevaImbrogliando(){
		contoCorrente.preleva(contoCorrente.getSaldo()+10);
	}
}
