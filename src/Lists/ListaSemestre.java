package Lists;

import Models.Semestre;
import Nodes.NodoSemestre;

public class ListaSemestre {
	static NodoSemestre inicio=null;
	static NodoSemestre anterior=null;
	
	public static void insertarSemestre(Semestre semestre){
		NodoSemestre nuevo = new NodoSemestre(semestre);
		if(inicio==null){
			inicio = nuevo;
			inicio.siguiente=null;
			inicio.anterior=null;
			anterior=inicio;
		}else{
			anterior.siguiente=nuevo;
			nuevo.anterior=anterior;
			nuevo.siguiente=null;
			anterior=nuevo;
		}
		buscar();
	}
	public static  void eliminarSemestre(String nombre, int anio){
		NodoSemestre actual = new NodoSemestre();
		NodoSemestre anterior = new NodoSemestre();
		actual = inicio;
		anterior = null;
		while(actual !=null){
			if(actual.getSemestre().getNombre().equals(nombre) && actual.getSemestre().getAnio()==anio){
				if(actual == inicio){
				inicio = inicio.siguiente;
				inicio.anterior = null;
			}else{
				anterior.siguiente=actual.siguiente;
				actual.siguiente.anterior = actual.anterior;
			}	
		}
		anterior = actual;
		actual = actual.siguiente;
		}
		buscar();
	}
	public static void buscar(){
		NodoSemestre aux = new NodoSemestre();
		aux = anterior;
		while(aux!=null){
			System.out.println(aux.getSemestre().getNombre()+" : "+aux.getSemestre().getAnio());
			aux = aux.anterior;
		}
	}
}
