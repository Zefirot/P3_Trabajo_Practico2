package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Set;

import codigoBusiness.Persona;

public class Assert {

	public static void sonIguales(int[] esperado, Set<Integer> alcanzables){
		assertEquals(esperado.length, alcanzables.size());
		
		for (int elem: esperado) {
			assertTrue(alcanzables.contains(elem));
		}

	}
	
	
	public static void sonIguales(ArrayList<Persona> esperado, ArrayList<Persona> actual) {
		
		assertEquals(esperado.size(), actual.size());
		
		for(int i=0 ; i<esperado.size() ; i++ ) {
			assertTrue( esperado.get(i).getNombre().equals((actual.get(i).getNombre())) );
		}
	}
	
	
	
}
