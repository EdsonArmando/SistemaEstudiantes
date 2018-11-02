package Nodes;

import Models.Estudiante;

public class NodoEstudiante {
	Estudiante estudiante;
	public NodoEstudiante siguiente;
	public NodoEstudiante Anterior;
	public Estudiante getEstudiante() {
		return estudiante;
	}
	public NodoEstudiante(Estudiante estudiante) {
		super();
		this.estudiante = estudiante;
	}
	public NodoEstudiante(){
		
	}
}
