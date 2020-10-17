package codigoBusiness;

public class Persona {

	private String nombre;
	private int deporte,musica,espectaculo,ciencia;
	
	public Persona(String nombre, int deporte,int musica, int espectaculo, int ciencia) {

		this.nombre=nombre;
		this.deporte=deporte;
		this.musica=musica;
		this.espectaculo=espectaculo;
		this.ciencia=ciencia;

	}
	
	//Seters y Getters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getDeporte() {
		return deporte;
	}

	public void setDeporte(int deporte) {
		this.deporte = deporte;
	}

	public int getMusica() {
		return musica;
	}

	public void setMusica(int musica) {
		this.musica = musica;
	}

	public int getEspectaculo() {
		return espectaculo;
	}

	public void setEspectaculo(int espectaculo) {
		this.espectaculo = espectaculo;
	}

	public int getCiencia() {
		return ciencia;
	}

	public void setCiencia(int ciencia) {
		this.ciencia = ciencia;
	}

	
	
	
	
	
	
}
