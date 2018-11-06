package Models;

public class Semestre {
	private String nombre;
	private int anio;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public Semestre(String nombre, int anio) {
		super();
		this.nombre = nombre;
		this.anio = anio;
	}
	public Semestre() {
		super();
	}
	
}
