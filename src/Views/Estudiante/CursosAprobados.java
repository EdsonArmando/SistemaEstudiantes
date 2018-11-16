package Views.Estudiante;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Lists.ListaAsignacionCurso;
import Nodes.NodoAsignacion;
import Nodes.NodoEstudiante;

public class CursosAprobados extends JDialog {
	ListaAsignacionCurso lista = new ListaAsignacionCurso();
	private NodoAsignacion primero=ListaAsignacionCurso.getPrimero() ;
	JTable tabla;
	public CursosAprobados(int carne) {
		DefaultTableModel modelo = new DefaultTableModel();
		 modelo.addColumn("Nombre Curso");
		 modelo.addColumn("Sección");
		 modelo.addColumn("Zona");
		 modelo.addColumn("Examen");
		 NodoAsignacion actual = new NodoAsignacion();
		 actual = primero;
			 do{
				 try{
					 if(actual.getAsignacion().getCarne()==carne && actual.getAsignacion().isAprobado()==true){
						 Object[] fila=new Object[4];
						 fila[0] = actual.getAsignacion().getCurso();
						 fila[1] = actual.getAsignacion().getSeccion();
						 fila[2] = actual.getAsignacion().getZona();
						 fila[3] = actual.getAsignacion().getExamen();
						 modelo.addRow(fila);
					 }
					 actual = actual.siguiente;
				 }catch( java.lang.NullPointerException ex){
					 JOptionPane.showMessageDialog(null, "No hay ningun curso Aprobado");
				 }
			 }while(actual!=null);
			 tabla = new JTable(modelo);
			 tabla.setPreferredScrollableViewportSize(new Dimension(200,200));
			 JScrollPane scroll = new JScrollPane(tabla);
			 scroll.setSize(414, 100);
			 scroll.setLocation(10, 96);
			 
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		
		tabla.setBounds(10, 125, 414, 100);
		getContentPane().add(scroll);
		
		JLabel lblListadoDeUsuaros = new JLabel("Listado de Cursos Aprobados");
		lblListadoDeUsuaros.setForeground(SystemColor.activeCaptionBorder);
		lblListadoDeUsuaros.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblListadoDeUsuaros.setBounds(117, 26, 212, 23);
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
