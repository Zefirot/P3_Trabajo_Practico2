package codigoBusiness;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AGM {

	private static Set<Integer> vertices = new HashSet<Integer>(); //Conjunto de donde "marco" los vertices
	
	private static ArrayList<Point> aristas = new ArrayList<Point>(); //Conjunto en donde "marco" las aristas
	
	private static Grafo nuevoGrafo;  //Grafo a devolver
	
	
	public static Grafo getAGM(Grafo grafo) {
		
		vertices.add(0); //Agarro el primer vertice para empezar
		
		nuevoGrafo = new Grafo(grafo.cantidadVertices());
		
		int i=1;
		
		while( i<=grafo.cantidadVertices()-1 ) {
			
			Point arista = buscarArista(grafo); //Busco la arista con menor peso de mi grafo actual
			
			nuevoGrafo.agregarArista((int)arista.getX(),(int) arista.getY(), grafo.getPeso((int)arista.getX(), (int)arista.getY()));
			
			vertices.add((int)arista.getY()); //Agrego el vertice que conecta las aristas.
			
			i++;
		}
		
		return nuevoGrafo;
		
	}
	
	
	// Se busca la arista con menor peso posible, dentro de los vecinos de los vertices que se van agregando
	private static Point buscarArista(Grafo grafo) {
		ArrayList<Point> aristasMenores = new ArrayList<Point>();
		
		Iterator<Integer> vertice = vertices.iterator();
		int verticeActual=0;
		
		while(vertice.hasNext()) {
			verticeActual = vertice.next();
			
			Set<Integer> vecinos = grafo.vecinos(verticeActual);
			
			Point aristaEncontrada=aristaMenor(verticeActual, vecinos, grafo);
			
			if(aristaEncontrada!=null) { //si la aristaEncontrada es null significa que no existen mas aristas para el vertice pasado.
				aristasMenores.add(aristaEncontrada);
			}
			
		}

		return aristaMenorPosible(aristasMenores, grafo); //Le pido que devuelva la menor arista de todas las posibles
		
	}

		
	//Toma un vertice y busca el vecino con menor peso
	private static Point aristaMenor(int i,Set<Integer> vecinos, Grafo grafo) {
		Point arista = null;
		
		Iterator<Integer> vecino = vecinos.iterator(); 
		
		int pesoMenor = Integer.MAX_VALUE;
		
		
		while(vecino.hasNext()) {
			
			int verticeActual=vecino.next();
			
			int pesoActual = grafo.getPeso(i,verticeActual);
			
			Point posibleArista = new Point(i,verticeActual);
	
			/*Las condicines son que la arista no pueda ser (0,0) por ejemplo y que la arista que se encontro no esta agrega
			 * anteriormente, con eso ultimo se consigue que no haya bucles.
			*/
			if(i!=verticeActual  &&
					!aristas.contains(posibleArista) &&
						pesoMenor>pesoActual) {
				
				aristas.add(posibleArista);
				aristas.add(posibleArista);
				pesoMenor=pesoActual;
				arista = new Point(i,verticeActual);
			}
			
		}
		
		return arista;
	}
	
	//Recorre la lista de aristas y calcula cual arista es la de menos peso
	private static Point aristaMenorPosible(ArrayList<Point> aristas, Grafo grafo) {
		
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
	
		
}
