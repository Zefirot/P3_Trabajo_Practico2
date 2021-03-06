package codigoBusiness;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Grafo {
	
	private ArrayList<Map<Integer,Integer>> vecinos;  //Esta es una manera de que se el grafo contenga peso en las aristas
	private Set<Point> aristas;  //Conjunto de aristas
	private int peso; //Auxiliar para saber el peso de todas las aristas
	
	public Grafo(int n) {
	
		this.vecinos = new ArrayList<Map<Integer,Integer>>();
		this.aristas = new HashSet<Point>();
		
		this.peso = 0;
		
		for(int i=0; i<n; i++) {
			vecinos.add(new HashMap<Integer,Integer>());
		}	
	}
	
	
	public void agregarArista(int i, int j, int peso) {
		verificarVertice(i);
		verificarVertice(j);
		verificarLoops(i,j);
		
		aristas.add(new Point(i,j));
		this.peso+=peso;
		vecinos.get(i).put(j, peso);
		vecinos.get(j).put(i, peso);	
	}
	
	public void eliminarArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarLoops(i,j);
		
		aristas.remove(new Point(i,j));
		peso-=getPeso(i,j);
		vecinos.get(i).remove(j);
		vecinos.get(j).remove(i);
	}
	
	public boolean existeArista(int i, int j) {
		verificarVertice(i);
		verificarVertice(j);
		verificarLoops(i,j);
		
		return vecinos.get(i).containsKey(j);
	}
	
	public int cantidadVertices() {
		return vecinos.size();
	}
	
	public Set<Integer> vecinos(int i){
		verificarVertice(i);
		
		return vecinos.get(i).keySet();
	}
	
	//Devuelve el peso de una arista en concreto
	public int getPeso(int i, int j) {
		return vecinos.get(i).get(j);
	}
	
	//Devuelve el peso de todas las aristas
	public int getPesoAristas() {
		return peso;
	}
	
	//Retorna el conjunto de aristas completas
	public Set<Point> getAristas(){																									
		return aristas;
	}
																																																						
	private void verificarVertice(int i) {
		if(i<0) 
			throw new IllegalArgumentException("Un parametro no puede ser negativo: "+i);		
		if(i>=vecinos.size())
			throw new IllegalArgumentException("Un parametro excede el maximo disponible: "+i);
	}

	private void verificarLoops(int i, int j) {
		if(i==j) 
			throw new IllegalArgumentException("No se pueden crear loops en el grafo: "+"("+i+", "+j+")");
	}
	
	
	
}
