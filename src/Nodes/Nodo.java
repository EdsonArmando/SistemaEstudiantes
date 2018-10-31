package Nodes;

import Models.Administrador;
import Models.Estudiante;

public class Nodo {
	private Administrador administrador;
	private Estudiante estudiante;
	private Nodo siguiente;
	private Nodo Anterior;
	
	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Nodo getAnterior() {
		return Anterior;
	}

	public void setAnterior(Nodo anterior) {
		Anterior = anterior;
	}

	public Administrador getAdministrador() {
		return administrador;
	}

	public void setAdministrador(Administrador administrador) {
		this.administrador = administrador;
	}

	public Nodo getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(Nodo siguiente) {
		this.siguiente = siguiente;
	}

	public Nodo(Administrador admin){
		this.administrador = admin;
		this.siguiente = null;
	}
	public Nodo(Estudiante estudiante){
		this.estudiante = estudiante;
	}
	public Nodo(){
		
	}
}
