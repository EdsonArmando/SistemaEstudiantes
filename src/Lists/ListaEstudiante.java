package Lists;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Models.Estudiante;
import Nodes.Nodo;
import Nodes.NodoEstudiante;

public class ListaEstudiante {
	static NodoEstudiante primero;
	static NodoEstudiante ultimo;
	static int tamanio=0;
	public NodoEstudiante getPrimero(){
		return primero;
	}
	public void Lista(){
		this.primero=null;
		this.ultimo=null;
	}
	public static void insertarEstudiante(Estudiante estudiante){
		NodoEstudiante nuevo = new NodoEstudiante(estudiante);
		if(primero==null){
			primero = nuevo;
			primero.siguiente=primero;
			nuevo.Anterior=ultimo;
			ultimo = nuevo;
			tamanio++;
		}else{
			ultimo.siguiente=nuevo;
			nuevo.siguiente=primero;
			nuevo.Anterior=ultimo;
			ultimo = nuevo;
			primero.Anterior=ultimo;
			tamanio++;
		}
		
	}
	public void eliminarEstudiante(int carne){
		NodoEstudiante actual = new NodoEstudiante();
		NodoEstudiante anterior = new NodoEstudiante();
		actual = primero;
		anterior=ultimo;
		do{
			if(actual.getEstudiante().getCarne()==carne){
				if(actual == primero){
					primero=primero.siguiente;
					ultimo.siguiente=primero;
					primero.Anterior=ultimo;
				}else if(actual==ultimo){
					ultimo=anterior;
					primero.Anterior=ultimo;
					ultimo.siguiente=primero;
				}else{
					anterior.siguiente=actual.siguiente;
					actual.siguiente.Anterior=anterior;
				}
			}
			anterior=actual;
			actual = actual.siguiente;
		}while(actual!=primero);
	}
	 public boolean vacia (){
	    if(primero == null)
	        return true;
	    else
	        return false;
	}
	 public static void agregarTabla(){
		 JFrame uno = new JFrame();
		 DefaultTableModel modelo = new DefaultTableModel();
		 modelo.addColumn("Carne");
		 modelo.addColumn("CUI");
		 modelo.addColumn("Nombre");
		 modelo.addColumn("Correo");
		 modelo.addColumn("No.Créditos");
		 NodoEstudiante actual = new NodoEstudiante();
		 actual = primero;
			 do{
				 Object[] fila=new Object[5];
				 fila[0] = actual.getEstudiante().getCarne();
				 fila[1] = actual.getEstudiante().getCui();
				 fila[2] = actual.getEstudiante().getNombre();
				 fila[3] = actual.getEstudiante().getCorreo();
				 fila[4] = actual.getEstudiante().getNoCreditos();
				 System.out.println(actual.getEstudiante().getNombre());
				 modelo.addRow(fila);
				 actual = actual.siguiente;
			 }while(actual!=primero);
			 JTable tabla = new JTable(modelo);
			 tabla.setPreferredScrollableViewportSize(new Dimension(200,200));
			 JScrollPane scroll = new JScrollPane(tabla);
			 uno.add(scroll);
			 uno.setSize(500, 500);
			 uno.setVisible(true);
			 uno.setLocationRelativeTo(null);
			 }
}
