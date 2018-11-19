package Lists;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Models.Catedratico;
import Nodes.NodoCatedratico;

public class ListaCatedratico {
	static NodoCatedratico primero;
	static NodoCatedratico ultimo;
	
	public  NodoCatedratico getPrimero() {
		return primero;
	}
	public static void setPrimero(NodoCatedratico primero) {
		ListaCatedratico.primero = primero;
	}
	
	public static NodoCatedratico getUltimo() {
		return ultimo;
	}
	public static void setUltimo(NodoCatedratico ultimo) {
		ListaCatedratico.ultimo = ultimo;
	}
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
	}
	public static void eliminar(String cui){
		NodoCatedratico actual = new NodoCatedratico();
		NodoCatedratico anterior = new NodoCatedratico();
		actual = primero;
		anterior = ultimo;
		do{
			if(actual.getCatedratico().getCui().equals(cui)){
				if(actual==primero){
					primero = primero.siguiente;
					ultimo.siguiente=primero;
				}else if(actual ==ultimo){
					anterior.siguiente=ultimo.siguiente;
					ultimo=anterior;
				}else{
					anterior.siguiente=actual.siguiente;
				}
			}
			anterior = actual;
			actual = actual.siguiente;
		}while(actual!=primero);
	}
	public static void modificarCatedratico(String cui,String cui2,String nombre,String correo,String contra){
		NodoCatedratico actual = new NodoCatedratico();
		actual=primero;
		do{
			if(actual.getCatedratico().getCui().equals(cui)){
				actual.getCatedratico().setCui(cui2);
				actual.getCatedratico().setNombre(nombre);
				actual.getCatedratico().setCorreo(correo);
				actual.getCatedratico().setContrasenia(contra);
			}
			actual = actual.siguiente;
		}while(actual!=primero);
	}
	public static boolean loginCatedratico(String cui, String contra){
		boolean verdadero = false;
		NodoCatedratico actual = new NodoCatedratico();
		actual=primero;
		do{
			if(actual.getCatedratico().getCui().equals(cui)&& actual.getCatedratico().getContrasenia().equals(contra)){
				verdadero = true;
			}
			actual = actual.siguiente;
		}while(actual!=primero);
		return verdadero;
	}
	public static boolean buscarCatedratico(String cui){
		boolean registrado = false;
		NodoCatedratico actual = new NodoCatedratico();
		actual=primero;
		do{
			if(actual.getCatedratico().getCui().equals(cui)){
				registrado = true;
			}
			actual = actual.siguiente;
		}while(actual!=primero);
		return registrado;
	}
	public static String retornarNombre(String cui){
		String registrado = null;
		NodoCatedratico actual = new NodoCatedratico();
		actual=primero;
		do{
			if(actual.getCatedratico().getCui().equals(cui)){
				registrado = actual.getCatedratico().getNombre();
			}
			actual = actual.siguiente;
		}while(actual!=primero);
		return registrado;
	}
}
