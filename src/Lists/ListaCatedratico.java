package Lists;

import javax.swing.JOptionPane;

import Models.Catedratico;
import Nodes.NodoCatedratico;

public class ListaCatedratico {
	static NodoCatedratico primero;
	static NodoCatedratico ultimo;
	public static void ingresarCatedratico(Catedratico catedratico){
		NodoCatedratico nuevo = new NodoCatedratico(catedratico);
		if(primero ==null){
			primero=nuevo;
			ultimo=primero;
			primero.siguiente=ultimo;
			JOptionPane.showMessageDialog(null, "Catedrático ingresado exitosamente");
		}else{
			ultimo.siguiente=nuevo;
			nuevo.siguiente=primero;
			ultimo=nuevo;
			JOptionPane.showMessageDialog(null, "Catedrático ingresado exitosamente");
		}
		mostrarLista();
	}
	public static void mostrarLista(){
		NodoCatedratico actual = new NodoCatedratico();
		actual=primero;
		do{
			System.out.println(actual.getCatedratico().getNombre());
			actual = actual.siguiente;
		}while(actual!=primero);
	}
	public void lista(){
		primero =null;
		ultimo=null;
	}
}
