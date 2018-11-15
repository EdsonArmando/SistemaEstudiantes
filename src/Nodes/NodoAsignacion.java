package Nodes;

import Models.Asignacion;

public class NodoAsignacion {
	public Asignacion asignacion;
	public NodoAsignacion siguiente;
	public NodoAsignacion(Asignacion asignacion){
		this.asignacion = asignacion;
	}
	public Asignacion getAsignacion() {
		return asignacion;
	}
	public void setAsignacion(Asignacion asignacion) {
		this.asignacion = asignacion;
	}
	public NodoAsignacion getSiguiente() {
		return siguiente;
	}
	public void setSiguiente(NodoAsignacion siguiente) {
		this.siguiente = siguiente;
	}
	public NodoAsignacion(){
		
	}
}
