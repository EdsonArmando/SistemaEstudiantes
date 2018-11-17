package Lists;

import javax.swing.JOptionPane;

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
	public static void ingresarNota(int carne,int zona,int examen,int total,String curso){
		NodoAsignacion puntero=primero;
		while(puntero != null){
			if(puntero.getAsignacion().getCarne()==carne&&puntero.getAsignacion().getCurso().equals(curso)){
				puntero.getAsignacion().setExamen(examen);
				puntero.getAsignacion().setZona(zona);
				puntero.getAsignacion().setNotaTotal(total);
				if(total<61){
					puntero.getAsignacion().setAprobado(false);
				}else{
					puntero.getAsignacion().setAprobado(true);
				}
				JOptionPane.showMessageDialog(null, "Nota Ingresada correctamente");
			}
			puntero = puntero.siguiente;
		}
	}
	
}
