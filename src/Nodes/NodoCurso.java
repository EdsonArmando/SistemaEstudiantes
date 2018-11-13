package Nodes;

import Models.Curso;

public class NodoCurso {
	 public Curso curso;
	 public NodoCurso Siguiente;
	public  Curso getCurso() {
		return curso;
	}
	public  void setCurso(Curso curso) {
		this.curso = curso;
	}
	public NodoCurso(Curso curso){
		this.curso = curso;
	}
	public NodoCurso(){
		
	}
	public NodoCurso getSiguiente() {
		return Siguiente;
	}
	public void setSiguiente(NodoCurso siguiente) {
		Siguiente = siguiente;
	}
	
}
