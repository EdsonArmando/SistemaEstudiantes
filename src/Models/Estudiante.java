package Models;

public class Estudiante {
	private int carne;
	private String cui;
	private String nombre;
	private String correo;
	private int noCreditos;
	private int contrasenia;
	public int getCarne() {
		return carne;
	}
	public void setCarne(int carne) {
		this.carne = carne;
	}
	public String getCui() {
		return cui;
	}
	public void setCui(String cui) {
		this.cui = cui;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public int getNoCreditos() {
		return noCreditos;
	}
	public void setNoCreditos(int noCreditos) {
		this.noCreditos = noCreditos;
	}
	public int getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(int contrasenia) {
		this.contrasenia = contrasenia;
	}
	public Estudiante(int carne, String cui, String nombre, String correo, int noCreditos, int contrasenia) {
		super();
		this.carne = carne;
		this.cui = cui;
		this.nombre = nombre;
		this.correo = correo;
		this.noCreditos = noCreditos;
		this.contrasenia = contrasenia;
	}
	public Estudiante(){
		
	}
	
}
