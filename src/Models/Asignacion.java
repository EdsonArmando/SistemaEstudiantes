package Models;

public class Asignacion {
	private String semestre;
	private String curso;
	private String carne;
	private String cuiCatedratico;
	private String seccion;
	private int creditos;
	private int zona;
	private int examen;
	private int notaTotal;
	private boolean aprobado;
	public String getSemestre() {
		return semestre;
	}
	public void setSemestre(String semestre) {
		this.semestre = semestre;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getCarne() {
		return carne;
	}
	public void setCarne(String carne) {
		this.carne = carne;
	}
	public String getCuiCatedratico() {
		return cuiCatedratico;
	}
	public void setCuiCatedratico(String cuiCatedratico) {
		this.cuiCatedratico = cuiCatedratico;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public int getCreditos() {
		return creditos;
	}
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	public int getZona() {
		return zona;
	}
	public void setZona(int zona) {
		this.zona = zona;
	}
	public int getExamen() {
		return examen;
	}
	public void setExamen(int examen) {
		this.examen = examen;
	}
	public int getNotaTotal() {
		return notaTotal;
	}
	public void setNotaTotal(int notaTotal) {
		this.notaTotal = notaTotal;
	}
	public boolean isAprobado() {
		return aprobado;
	}
	public void setAprobado(boolean aprobado) {
		this.aprobado = aprobado;
	}
	public Asignacion(String semestre, String curso, String carne, String cuiCatedratico, String seccion, int creditos,
			int zona, int examen, int notaTotal, boolean aprobado) {
		super();
		this.semestre = semestre;
		this.curso = curso;
		this.carne = carne;
		this.cuiCatedratico = cuiCatedratico;
		this.seccion = seccion;
		this.creditos = creditos;
		this.zona = zona;
		this.examen = examen;
		this.notaTotal = notaTotal;
		this.aprobado = aprobado;
	}
	public Asignacion() {
		super();
	}
	
}
