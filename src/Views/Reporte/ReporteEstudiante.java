package Views.Reporte;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Lists.ListaAsignacionCurso;
import Lists.ListaCurso;
import Lists.ListaEstudiante;
import Nodes.NodoAsignacion;
import Nodes.NodoCurso;
import Nodes.NodoEstudiante;
import Nodes.NodoSemestre;
import javax.swing.JTextField;

public class ReporteEstudiante extends JDialog {
	private NodoAsignacion primero = ListaAsignacionCurso.getPrimero();
	private NodoCurso primeros = ListaCurso.getPrimero();
	private ListaEstudiante lista = new ListaEstudiante();
	JTable tabla;
	private JTextField idCarne;
	public ReporteEstudiante() {
		DefaultTableModel modelo = new DefaultTableModel();
		 modelo.addColumn("Nombre");
		 modelo.addColumn("Promedio");
		 modelo.addColumn("Créditos");
					 Object[] fila=new Object[3];
					
			 tabla = new JTable(modelo);
			 tabla.setPreferredScrollableViewportSize(new Dimension(200,200));
			 JScrollPane scroll = new JScrollPane(tabla);
			 scroll.setSize(512, 100);
			 scroll.setLocation(10, 96);
			 
		setBounds(100, 100, 548, 300);
		getContentPane().setLayout(null);
		
		
		tabla.setBounds(10, 125, 414, 100);
		getContentPane().add(scroll);

		JLabel lblListadoDeUsuaros = new JLabel("Reporte de Estudiantes");
		lblListadoDeUsuaros.setForeground(SystemColor.activeCaptionBorder);
		lblListadoDeUsuaros.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblListadoDeUsuaros.setBounds(144, 26, 172, 23);
		getContentPane().add(lblListadoDeUsuaros);
		
		JLabel lblCurso = new JLabel("Carne:");
		lblCurso.setBounds(10, 71, 46, 14);
		getContentPane().add(lblCurso);
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double cursos = cursosAsignados(Integer.parseInt(idCarne.getText()));
				String nombre = ListaEstudiante.retornarNombre(Integer.parseInt(idCarne.getText()));
				double notas = total(Integer.parseInt(idCarne.getText()));
				double promedio = notas/cursos;
				 fila[0] = nombre;
				 fila[1] = promedio;
				 fila[2] = creditos(Integer.parseInt(idCarne.getText()));
				 modelo.addRow(fila);
			}
		});
		btnMostrar.setBounds(433, 207, 89, 23);
		getContentPane().add(btnMostrar);
		
		idCarne = new JTextField();
		idCarne.setText("");
		idCarne.setBounds(66, 65, 86, 20);
		getContentPane().add(idCarne);
		idCarne.setColumns(10);
	}
	public int total(int carne){
		NodoAsignacion puntero=primero;
		int cont =0;
		while(puntero != null){
			if(puntero.getAsignacion().getCarne()==carne && puntero.getAsignacion().isAprobado()==true){
				cont += puntero.getAsignacion().getNotaTotal();
			}
			puntero=puntero.siguiente;
		}
		
		return cont;
	}
	public int cursosAsignados(int carne){
		NodoAsignacion puntero=primero;
		int cont =0;
		while(puntero != null){
			if(puntero.getAsignacion().getCarne()==carne && puntero.getAsignacion().isAprobado()==true){
				cont++;
			}
			puntero=puntero.siguiente;
		}
		return cont;
	}
	public int creditos(int carne){
		NodoAsignacion puntero=primero;
		int cont =0;
		while(puntero != null){
			if(puntero.getAsignacion().getCarne()==carne && puntero.getAsignacion().isAprobado()==true){
				cont += puntero.getAsignacion().getCreditos();
			}
			puntero=puntero.siguiente;
		}
		return cont;
	}
}
