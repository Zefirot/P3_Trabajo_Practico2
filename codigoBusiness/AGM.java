package codigoBusiness;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class AGM {

	private Set<Integer> vertices = new HashSet<Integer>(); //Conjunto en donde "marco" los vertices
	
	private ArrayList<Point> aristas = new ArrayList<Point>(); //Conjunto en donde "marco" las aristas
	
	private Grafo nuevoGrafo;  //Grafo a devolver
	
	
	public Grafo getAGM(Grafo grafo) {
		
		esConexo(grafo); //Verifico que el grafo pasado es conexo
		
		vertices.add(0); //Agarro el primer vertice para empezar
		
		nuevoGrafo = new Grafo(grafo.cantidadVertices()); 
		
		int i=1;
		
		while( i<=grafo.cantidadVertices()-1 ) { 
			
			Point arista = buscarArista(grafo); //Busco la arista con menor peso de mi grafo actual
			
			nuevoGrafo.agregarArista((int)arista.getX(),(int) arista.getY(), grafo.getPeso((int)arista.getX(), (int)arista.getY()));
			
			vertices.add((int)arista.getY()); //Agrego el vertice que conecta las aristas.
			
			aristas.add(new Point((int)arista.getX(),(int)arista.getY())); //Agrego la arista agregada al conjunto
			aristas.add(new Point((int)arista.getY(),(int)arista.getX()));
			
			i++;
		}
		
		return nuevoGrafo;
		
	}
	
	
	public void esConexo(Grafo grafo) {
		if( !BFS.esConexo(grafo) ) {
			throw new RuntimeException("El grafo ingresado no es conexo, por ende no se puede crear un AGM");
		}
	}
	
	
	// Se busca la arista con menor peso posible, dentro de los vertices que se van agregando
	private Point buscarArista(Grafo grafo) {
		ArrayList<Point> aristasMenores = new ArrayList<Point>();	
		
		for( Integer vertice : vertices) {
			
			Set<Integer> vecinos = grafo.vecinos(vertice);
			
			Point aristaEncontrada = aristaMenor(vertice, vecinos, grafo);
			
			if(aristaEncontrada!=null) {  //si la aristaEncontrada es null significa que no existen mas aristas para ese vertice.
				aristasMenores.add(aristaEncontrada);
			}
			
		}
		
		return aristaMenorPosible(aristasMenores, grafo); //Le pido que devuelva la menor arista de todas las posibles
		
	}

		
	//Toma un vertice y busca el vecino con menor peso
	private Point aristaMenor(int i,Set<Integer> vecinos, Grafo grafo) {
		Point arista = null;
		
		int pesoMenor = Integer.MAX_VALUE; //Se intenta buscar al menos una arista que sea menor, asi que para comparar tomo el mayor valor posible.

		for(Integer verticeActual : vecinos) {
			
			int pesoActual = grafo.getPeso(i, verticeActual);
			
			/*Las condicines son que la arista no pueda ser (0,0) y que la arista que se encontro no este agrega
			 * anteriormente, con eso ultimo se consigue que no haya bucles.
			*/
			if(i!=verticeActual  &&
					!aristas.contains(new Point(i,verticeActual)) &&
						!vertices.contains(verticeActual) &&
							pesoMenor>pesoActual) {
				
				pesoMenor=pesoActual;
				arista = new Point(i,verticeActual);
				
			}
			
		}
		
		
		return arista;
	}
	
	//Recorre la lista de aristas y calcula cual arista es la de menos peso
	private Point aristaMenorPosible(ArrayList<Point> aristas, Grafo grafo) {
		
		Point aristaEncontrada = aristas.get(0);
		
		int pesoMenor = grafo.getPeso((int) aristaEncontrada.getX(),(int) aristaEncontrada.getY()); //Se toma como comparacion la primer arista
		
		for(Point aristaActual : aristas) {
			
			int pesoActual = grafo.getPeso((int)aristaActual.getX(),(int) aristaActual.getY());
			
			if(pesoMenor>pesoActual) { //Cuando el peso de la arista 0 sea mayor que el de alguna arista entonces esa arista es menor.
				
				aristaEncontrada = aristaActual;
				pesoMenor = pesoActual;
				
			}
		}
		return aristaEncontrada;
		
	}
	
		
}
