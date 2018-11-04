package Models;

public class Catedratico {
	private String cui;
	private String nombre;
	private String correo;
	private int contrasenia;
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
	public int getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(int contrasenia) {
		this.contrasenia = contrasenia;
	}
	public Catedratico(String cui, String nombre, String correo, int contrasenia) {
		super();
		this.cui = cui;
		this.nombre = nombre;
		this.correo = correo;
		this.contrasenia = contrasenia;
	}
	public Catedratico(){
		
	}
}
