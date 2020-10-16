package codigoBusiness;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class BFS {
	
	private static ArrayList<Integer> vertices;
	private static boolean[] marcados;
	
	
	public static boolean esConexo(Grafo g) {
		
		if(g==null)
			throw new IllegalArgumentException("Se intento consultar con un grafo null!" );
		
		if(g.cantidadVertices()==0)
			return true;
		
		return alcanzables(g,0).size()==g.cantidadVertices();
		
		
	}
	
	public static Set<Integer> alcanzables(Grafo g, int pos){
		Set<Integer> ret = new HashSet<Integer>();
		
		inicializar(g,pos);
		
		while(vertices.size()>0) {
			int i = vertices.get(0);
			marcados[i]=true;
			ret.add(i);
			
			agregarVecinosPendientes(g, i);
			vertices.remove(0);
			
		}
		
		return ret;
	}
	
	private static void inicializar(Grafo g, int pos) {
		vertices = new ArrayList<Integer>();
		vertices.add(pos);
		marcados = new boolean[g.cantidadVertices()];
		
	}
	
	private static void agregarVecinosPendientes(Grafo g, int pos) {
		
		for(int vertice : g.vecinos(pos)) {
			
			if (marcados[vertice] == false && vertices.contains(vertice) == false)
				vertices.add(vertice);	
		}
	}
	
	
}
