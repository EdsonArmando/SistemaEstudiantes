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
}
