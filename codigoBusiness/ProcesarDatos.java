package codigoBusiness;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Set;

public class ProcesarDatos {

	
	private Grafo grafo;
	private int indiceGrupo1;
	private int indiceGrupo2;
	
	
	public ProcesarDatos(ArrayList<Persona> datos) {
		this.grafo = new Grafo(datos.size());
		this.indiceGrupo1=0;
		
		armarGrafo(grafo,datos);
		
		AGM agm = new AGM();
		
		grafo = agm.getAGM(grafo);
		
		quitarAristaMayorPeso(grafo);
		
		
	}
	
	private void armarGrafo(Grafo grafo, ArrayList<Persona> datos) {
		
		for(int i=0 ; i<datos.size() ; i++) {		
			for(int j=0 ; j<datos.size() ; j++) {
				
				if(i!=j) { //i!=j para que no se creen loops
					int pesoArista = calcularSimilaridad( datos.get(i), datos.get(j));
					grafo.agregarArista(i, j, pesoArista);
				}
				
			}	
		}
	}
	
	
	
	private int calcularSimilaridad(Persona persona1, Persona persona2) {
		
		int deporte = Math.abs(persona1.getDeporte()-persona2.getDeporte());
		int musica = Math.abs(persona1.getMusica()-persona2.getMusica()) ;
		int espectaculo = Math.abs(persona1.getEspectaculo()-persona2.getEspectaculo());
		int ciencia = Math.abs(persona1.getCiencia()-persona2.getCiencia());

		return deporte+musica+espectaculo+ciencia;		
	}
	
	
	private void quitarAristaMayorPeso(Grafo grafo) {
		
		Set<Point> aristas = grafo.getAristas();
		
		Point aristaMayor = buscarAristaMayor(aristas);
		
		grafo.eliminarArista((int)aristaMayor.getX(), (int)aristaMayor.getY());
		
		this.indiceGrupo2=(int)aristaMayor.getY();
		
	}
	
	private Point buscarAristaMayor(Set<Point> aristas) {
		Point aristaMenor = null;
		
		int peso = Integer.MIN_VALUE;
		
		for(Point arista : aristas) {
			
			int pesoActual=grafo.getPeso((int)arista.getX(), (int)arista.getY());
			
			if( peso>pesoActual ) {
				peso = pesoActual;
				aristaMenor = arista;
			}
			
		}
		
		return aristaMenor;
		
	}
	
	public Set<Integer> getGrupo1(){
		return BFS.alcanzables(grafo, indiceGrupo1);
	}
	public Set<Integer> getGrupo2(){
		return BFS.alcanzables(grafo, indiceGrupo2);
	}
	
	
}
