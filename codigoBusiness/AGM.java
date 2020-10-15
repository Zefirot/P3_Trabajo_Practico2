package codigoBusiness;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AGM {

	private Set<Integer> vertices = new HashSet<Integer>();
	
	private ArrayList<Point> aristas = new ArrayList<Point>();
	
	private Grafo nuevoGrafo;
	
	
	public Grafo getAGM(Grafo grafo) {
		
		vertices.add(0);
		nuevoGrafo = new Grafo(grafo.cantidadVertices());
		
		int i=1;
		
		while( i<=grafo.cantidadVertices()-1 ) {
			
			Point arista = buscarArista(grafo);
			System.out.println(arista);

			nuevoGrafo.agregarArista((int)arista.getX(),(int) arista.getY(), grafo.getPeso((int)arista.getX(), (int)arista.getY()));
			
			vertices.add((int)arista.getY());
			
			i++;
		}
		
		
		return nuevoGrafo;
		
	}
	
	public Point buscarArista(Grafo grafo) {
		ArrayList<Point> aristasMenores = new ArrayList<Point>();
		
		Iterator<Integer> vertice = vertices.iterator();
		int verticeActual=0;
		
		while(vertice.hasNext()) {
			verticeActual = vertice.next();
			
			Set<Integer> vecinos = grafo.vecinos(verticeActual);
			
			Point aristaEncontrada=aristaMenor(verticeActual, vecinos, grafo);
			
			if(aristaEncontrada!=null) {
				aristasMenores.add(aristaEncontrada);
			}
			
			
			
		}
		

		
		return aristaMenorPosible(aristasMenores, grafo);
		
	}
	
	public Point aristaMenorPosible(ArrayList<Point> aristas, Grafo grafo) {
		
		Point aristaActual = aristas.get(0);
		
		
		int pesoMenor = grafo.getPeso((int) aristaActual.getX(),(int) aristaActual.getY());
		
		
		for(Point arista : aristas) {
			
			if(pesoMenor>grafo.getPeso((int)arista.getX(),(int) arista.getY())) {
				
				aristaActual = arista;
				pesoMenor = grafo.getPeso((int) arista.getX(),(int) arista.getY());
				
			}
		}
		return aristaActual;
		
	}
	
	
	
	
	//Toma un vertice y busca el vecino con menor peso
	public Point aristaMenor(int i,Set<Integer> vecinos, Grafo grafo) {
		Point arista = null;
		
		Iterator<Integer> vecino = vecinos.iterator(); 
		
		int pesoMenor = Integer.MAX_VALUE;
		
		
		while(vecino.hasNext()) {
			
			int verticeActual=vecino.next();
			
			int pesoActual = grafo.getPeso(i,verticeActual);
			
			if(i!=verticeActual  &&
					!aristas.contains(new Point(i,verticeActual)) &&
					pesoMenor>pesoActual) {
				aristas.add(new Point(i,verticeActual));
				aristas.add(new Point(verticeActual,i));
				pesoMenor=pesoActual;
				arista = new Point(i,verticeActual);
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
