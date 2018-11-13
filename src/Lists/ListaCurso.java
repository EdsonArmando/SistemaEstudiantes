package Lists;

import Models.Curso;
import Nodes.NodoCurso;

public class ListaCurso {
   static NodoCurso primero;
   
   public static NodoCurso getPrimero() {
	return primero;
}
public static void insertarCurso(Curso curso){
	   NodoCurso nuevo = new NodoCurso(curso);
	   if(primero ==null){
		   nuevo.Siguiente=null;
		   primero = nuevo;
	   }else{
		   nuevo.Siguiente=primero;
		   primero = nuevo;
	   }
	   buscar2();
   }
   public boolean buscar(int referencia){
       // Crea una copia de la lista.
	   NodoCurso aux = primero;
       // Bandera para indicar si el valor existe.
       boolean encontrado = false;
       // Recorre la lista hasta encontrar el elemento o hasta 
       // llegar al final de la lista.
       while(aux != null && encontrado != true){
           // Consulta si el valor del nodo es igual al de referencia.
           if (referencia == aux.getCurso().getCodigo()){
               // Canbia el valor de la bandera.
               encontrado = true;
           }
           else{
               // Avansa al siguiente. nodo.
               aux = aux.getSiguiente();
           }
       }
       // Retorna el resultado de la bandera.
       return encontrado;
   }
   public void eliminar(int referencia){
       // Consulta si el valor de referencia existe en la lista.
       if (buscar(referencia)) {
           // Consulta si el nodo a eliminar es el pirmero
           if (primero.getCurso().getCodigo() == referencia) {
               // El primer nodo apunta al siguiente.
        	   primero = primero.getSiguiente();
           } else{
               // Crea ua copia de la lista.
        	   NodoCurso aux = primero;
               // Recorre la lista hasta llegar al nodo anterior 
               // al de referencia.
               while(aux.getSiguiente().getCurso().getCodigo() != referencia){
                   aux = aux.getSiguiente();
               }
               // Guarda el nodo siguiente del nodo a eliminar.
               NodoCurso siguiente = aux.getSiguiente().getSiguiente();
               // Enlaza el nodo anterior al de eliminar con el 
               // sguiente despues de el.
               aux.setSiguiente(siguiente);  
           }
       }
       buscar2();
   }
   public static void buscar2(){
	   NodoCurso puntero=primero;
		while(puntero !=null){
			System.out.println("El codigo es: "+ puntero.getCurso().getCodigo());
			puntero = puntero.Siguiente;
		}
	}
}
