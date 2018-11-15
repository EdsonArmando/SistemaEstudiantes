package Lists;

import Models.Asignacion;
import Nodes.NodoAsignacion;

public class ListaAsignacionCurso {
	static NodoAsignacion primero;
	
	public static NodoAsignacion getPrimero() {
		return primero;
	}
	public static void setPrimero(NodoAsignacion primero) {
		ListaAsignacionCurso.primero = primero;
	}
	public static void ingresarAsignacion(Asignacion asignacion){
		NodoAsignacion nuevo = new NodoAsignacion(asignacion);
		if (primero == null) {
			nuevo.siguiente = null;
			primero = nuevo;
		} else {
			nuevo.siguiente = primero;
			primero = nuevo;
		}
		buscar();
	}
	public static void buscar(){
		NodoAsignacion puntero=primero;
		while(puntero != null){
			System.out.println(puntero.getAsignacion().getCarne());
			puntero = puntero.siguiente;
		}
	}
}
