package Views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Lists.ListaEstudiante;
import Nodes.NodoEstudiante;

import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ListadoEstudiantes extends JDialog {
	ListaEstudiante lista = new ListaEstudiante();
	private NodoEstudiante primero = lista.getPrimero();
	private final JPanel contentPanel = new JPanel();
	private JTable tabla;
	public ListadoEstudiantes() {
		DefaultTableModel modelo = new DefaultTableModel();
		 modelo.addColumn("Carne");
		 modelo.addColumn("CUI");
		 modelo.addColumn("Nombre");
		 modelo.addColumn("Correo");
		 modelo.addColumn("No.Créditos");
		 NodoEstudiante actual = new NodoEstudiante();
		 actual = primero;
			 do{
				 try{
					 Object[] fila=new Object[5];
					 fila[0] = actual.getEstudiante().getCarne();
					 fila[1] = actual.getEstudiante().getCui();
					 fila[2] = actual.getEstudiante().getNombre();
					 fila[3] = actual.getEstudiante().getCorreo();
					 fila[4] = actual.getEstudiante().getNoCreditos();
					 System.out.println(actual.getEstudiante().getNombre());
					 modelo.addRow(fila);
					 actual = actual.siguiente;
				 }catch( java.lang.NullPointerException ex){
					 JOptionPane.showMessageDialog(null, "No hay ningun Estudiante Ingresado");
				 }
			 }while(actual!=primero);
			 tabla = new JTable(modelo);
			 tabla.setPreferredScrollableViewportSize(new Dimension(200,200));
			 JScrollPane scroll = new JScrollPane(tabla);
			 scroll.setSize(414, 100);
			 scroll.setLocation(10, 96);
			 
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		
		tabla.setBounds(10, 125, 414, 100);
		getContentPane().add(scroll);
		
		JLabel lblListadoDeUsuaros = new JLabel("Listado de Estudiantes");
		lblListadoDeUsuaros.setForeground(SystemColor.activeCaptionBorder);
		lblListadoDeUsuaros.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblListadoDeUsuaros.setBounds(144, 26, 172, 23);
		getContentPane().add(lblListadoDeUsuaros);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(335, 207, 89, 23);
		getContentPane().add(btnSalir);
	}
}
