package Models;

public class Curso {
	private int codigo;
	private String nombre;
	private String cuiCatedratico;
	private int creditos;
	private String seccion;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCuiCatedratico() {
		return cuiCatedratico;
	}
	public void setCuiCatedratico(String cuiCatedratico) {
		this.cuiCatedratico = cuiCatedratico;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public Curso(int codigo, String nombre, String cuiCatedratico, int creditos, String seccion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.cuiCatedratico = cuiCatedratico;
		this.creditos = creditos;
		this.seccion = seccion;
	}
	public Curso() {
		super();
	}
	
}
