package com.alvaro.models;

import static org.junit.Assert.*;

import org.junit.Test;

public class OperadorTest {

	@Test
	public void testCeros() {
		int a = 0, b = 0;
		Operador op = new Operador();

		assertTrue(op.suma(a, b) == 0);
	}

	@Test
	
	public void testBSIempreCero() {
		int[] listaA = new int[5];
		listaA[0] = 2;
		listaA[1] = 32;
		listaA[2] = 356;
		listaA[3] = 3457;
		listaA[4] = 8743679;
		int b = 0;
		Operador op = new Operador();
		for (int a : listaA) {
			assertTrue(op.suma(a, b) == a);
		}
	}
	
	@Test
	
	public void testAbs() {
		
		int a = -7, b = 5;
		
		
		Operador op = new Operador();

		assertTrue(op.sumaAbs(a,b) == a+b);
	}
	
	
	

}
