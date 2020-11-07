package codigoBusiness;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Set;

public class ProcesarDatos {

	
	private Grafo grafo;
	private ArrayList<Persona> todasLasPersonas;
	private int indiceGrupo1;
	private int indiceGrupo2;
	
	public ProcesarDatos(ArrayList<Persona> datos) {
		
		comprobarDatos(datos);
		
		this.grafo = new Grafo(datos.size());
		this.todasLasPersonas=datos;
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
		
		if(aristas.size()==0) { //Cuando el grafo no tiene aristas, no existe arista alguna para quitar.
			return;
		}
	
		Point aristaMayor = buscarAristaMayor(aristas);
		
		grafo.eliminarArista((int)aristaMayor.getX(), (int)aristaMayor.getY());
		
		this.indiceGrupo2=(int)aristaMayor.getY();
		
	}
	
	private Point buscarAristaMayor(Set<Point> aristas) {
		
		Point aristaMenor = null;
		
		int peso = Integer.MIN_VALUE;
		
		for(Point arista : aristas) {
			
			int pesoActual=grafo.getPeso((int)arista.getX(), (int)arista.getY());
			
			if( peso<pesoActual ) { 
				peso = pesoActual;
				aristaMenor = arista;
			}
			
		}
		
		return aristaMenor;
		
	}
	
	public ArrayList<Persona> getGrupo1(){
		Set<Integer> posiciones = BFS.alcanzables(grafo, indiceGrupo1);
		
		return armarGrupo(posiciones);
	}
	
	public ArrayList<Persona> getGrupo2(){ //Si no existe el grupo2 entonces retorno null
		
		if(indiceGrupo2!=indiceGrupo1) { //Compara los indice para no devolver el mismo grupo.
			Set<Integer> posiciones = BFS.alcanzables(grafo, indiceGrupo2);
			
			return armarGrupo(posiciones);
		}
		return null;
		
	}
	
	private ArrayList<Persona> armarGrupo(Set<Integer> posiciones){
		ArrayList<Persona> grupo = new ArrayList<Persona>();
		
		for(Integer i : posiciones) {
			
			grupo.add(todasLasPersonas.get(i));
			
		}
		
		return grupo;
		
	}
	
	private void comprobarDatos( ArrayList<Persona> datos ) {
		
		if(datos==null) {
			throw new IllegalArgumentException("Los datos ingresados no pueden ser null");
		}
		if(datos.size()==0) {
			throw new IllegalArgumentException("Los datos ingresados no pueden estar vacios");
		}
		
	}
	
	
	
	
	public static ArrayList<Integer> getPromedio(ArrayList<Persona> subGrupo) {
		
		if(subGrupo==null)
			return null;
		
		ArrayList<Integer> promedios = new ArrayList<Integer>();
		
		int promedioDeporte = 0;
		int promedioMusica = 0;
		int promedioEspectaculo = 0;
		int promedioCiencia = 0;
		
		for(Persona persona : subGrupo) {
			
			promedioDeporte += persona.getDeporte();
			
			promedioMusica += persona.getMusica();
			
			promedioEspectaculo += persona.getEspectaculo();
			
			promedioCiencia += persona.getCiencia();
			
		}
		
		promedios.add(promedioDeporte/subGrupo.size());
		promedios.add(promedioMusica/subGrupo.size());
		promedios.add(promedioEspectaculo/subGrupo.size());
		promedios.add(promedioCiencia/subGrupo.size());
		
		
		return promedios;
	}
	
	
	
	
	
	
	
}
