package Nodes;

import Models.Administrador;

public class Nodo {
	private Administrador administrador;
	private Nodo siguiente;
	
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
	
}
