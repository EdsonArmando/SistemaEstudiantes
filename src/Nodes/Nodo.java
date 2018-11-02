package Nodes;

import Models.Administrador;
import Models.Estudiante;

public class Nodo {
	 Administrador administrador;
	 Nodo siguiente;
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
	public Nodo(){
		
	}
}
