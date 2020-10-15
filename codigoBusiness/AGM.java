package codigoBusiness;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AGM {

	
	private Grafo grafo;
	private Set<Integer> vertices= new HashSet<Integer>();
	
	public Grafo getAGM(Grafo graf) {
		
		this.grafo = new Grafo(graf.cantidadVertices());
		vertices.add(0);
		
		int i = 0;
		
		while(i<=graf.cantidadVertices()-1) {
			
			Point aristaNueva = agregarAristaMenor(graf);
			//System.out.println(aristaNueva);
			int pesoArista = graf.getPeso(aristaNueva.getX(), aristaNueva.getY());
			grafo.agregarArista((int)aristaNueva.getX(), (int)aristaNueva.getY(), pesoArista);
			
			vertices.add((int)aristaNueva.getX());
			
			i++;
		}
		
		return grafo;
		
	}
	
	
	public Point agregarAristaMenor(Grafo graf) {
		
		ArrayList<Point> conjuntoAristasMenores = new ArrayList<Point>();
		int aristaActual=0;
		
		Iterator<Integer> it = vertices.iterator();
	
		while(it.hasNext()) {
			
			conjuntoAristasMenores.add(new Point(aristaActual,getVecinoConMenorPeso(graf,aristaActual)));
			System.out.println(aristaActual);
			aristaActual = it.next();
			
		}
		
		return getAristaMenorPeso(conjuntoAristasMenores,graf);
		
	}
	
	public Point getAristaMenorPeso(ArrayList<Point> conjunto, Grafo graf) {
		Point actual = conjunto.get(0);
		
		int menor = graf.getPeso(actual.getX(), actual.getY());
		
		for(Point punto : conjunto) {
			//System.out.println(punto);
			int pesoActual = graf.getPeso(punto.getX(), punto.getY());
			
			if(menor>pesoActual) {
				actual = punto;
				menor = pesoActual;
			}
			
		}
		
		return actual;
		
		
	}
	
	//Esto te va a dar la arista menor que no este marcada anteriormente.
	public int getVecinoConMenorPeso(Grafo graf,int i) {
		
		Set<Integer> aristas = graf.vecinos(i);
		
		Iterator<Integer> it = aristas.iterator();
		
		int arista = it.next();
		
		int pesoMinimo = graf.getPeso(i, arista); //Se toma la primer arista
		
		while(it.hasNext()) {
			int aristaActual = it.next();
			int pesoAristaActual = graf.getPeso(i, aristaActual);
			
			if(vertices.contains(aristaActual)==false&&pesoMinimo>pesoAristaActual) {
				arista = aristaActual;
				pesoMinimo = pesoAristaActual;
			}
			
		}
		return arista;
		
	}

	
	
	public static void main(String[] args) {
		
		Grafo viejo = new Grafo(9);
		viejo.agregarArista(0, 1, 4); //AB
		viejo.agregarArista(0, 2, 8); //AH
		viejo.agregarArista(1, 2, 12); //BH
		viejo.agregarArista(1, 3, 8); //BC
		viejo.agregarArista(2, 5, 1);  //HG
		viejo.agregarArista(2, 4, 6); //HI
		viejo.agregarArista(3, 4, 3); //CI
		viejo.agregarArista(3, 6, 6); //CD
		viejo.agregarArista(3, 7, 4); //CF
		viejo.agregarArista(4, 5, 5); //IG
		viejo.agregarArista(5, 7, 3); //GF
		viejo.agregarArista(6, 8, 9); //DE
		viejo.agregarArista(6, 7, 13); //DF
		viejo.agregarArista(7, 8, 10); //FE
		
		AGM it = new AGM();
		
		Grafo nuevo = it.getAGM(viejo);
		
		System.out.println(viejo.getAristas());
		System.out.println(nuevo.getAristas());

	}
	
	
	
}
