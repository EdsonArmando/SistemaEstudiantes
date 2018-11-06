package Nodes;

import Models.Semestre;

public class NodoSemestre {
	Semestre semestre;
	public NodoSemestre siguiente;
	public NodoSemestre anterior;
	
	public Semestre getSemestre() {
		return semestre;
	}
	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}
	public NodoSemestre(Semestre semestre){
		this.semestre=semestre;
	}
	public NodoSemestre(){
		
	}
}
