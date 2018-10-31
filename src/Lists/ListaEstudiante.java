package Lists;

import Models.Estudiante;
import Nodes.Nodo;

public class ListaEstudiante {
	private Nodo raiz;
	private int tamanio;
	public void Lista(){
		this.tamanio=0;
		this.raiz=null;
	}
	public void insertarEstudiante(Estudiante estudiante){
		Nodo nuevo = new Nodo(estudiante);
		if(raiz==null){
			nuevo.setSiguiente(nuevo);
			nuevo.setAnterior(nuevo);
			raiz=nuevo;
		}else{
			Nodo ultimo = raiz.getAnterior();
			nuevo.setSiguiente(raiz);
			nuevo.setAnterior(ultimo);
			raiz.setAnterior(nuevo);
			ultimo.setSiguiente(nuevo);
			raiz=nuevo;
		}
		tamanio++;
	}
	 public boolean vacia (){
	    if(raiz == null)
	        return true;
	    else
	        return false;
	}
	 public void imprimir(){
		 if(!vacia()){
			 Nodo reco=raiz;
			  do {
	                System.out.print (reco.getEstudiante().getNombre()+ "-");
	                reco.setSiguiente(reco);             
	            } while (reco!=raiz);
	            System.out.println();
		 }
	 }
}
