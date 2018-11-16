package Views.Reporte;

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
import Lists.ListaCurso;
import Lists.ListaSemestre;
import Nodes.NodoAsignacion;
import Nodes.NodoCurso;
import Nodes.NodoEstudiante;
import Nodes.NodoSemestre;

import javax.swing.JComboBox;

public class ReporteEstudiantes extends JDialog {
	ListaAsignacionCurso listado = new ListaAsignacionCurso();
	private NodoAsignacion primero = ListaAsignacionCurso.getPrimero();
	private NodoCurso primeros = ListaCurso.getPrimero();
	private NodoSemestre anterior = ListaSemestre.getAnterior();
	JTable tabla;
	double porcentaje = 0.0;
	JComboBox idSeccion = new JComboBox();
	public ReporteEstudiantes() {
		DefaultTableModel modelo = new DefaultTableModel();
		 modelo.addColumn("Estudiantes Ganaron");
		 modelo.addColumn("Estudiantes % Ganaron");
		 modelo.addColumn("Estudiantes que perdieron");
		 modelo.addColumn("Estudiantes % Perdieron");
		 modelo.addColumn("Total estudiantes");
		 modelo.addColumn("Catedratico");
					 Object[] fila=new Object[6];
					
			 tabla = new JTable(modelo);
			 tabla.setPreferredScrollableViewportSize(new Dimension(200,200));
			 JScrollPane scroll = new JScrollPane(tabla);
			 scroll.setSize(414, 100);
			 scroll.setLocation(10, 96);
			 
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		
		tabla.setBounds(10, 125, 414, 100);
		getContentPane().add(scroll);

		JLabel lblListadoDeUsuaros = new JLabel("Reporte de Estudiantes");
		lblListadoDeUsuaros.setForeground(SystemColor.activeCaptionBorder);
		lblListadoDeUsuaros.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblListadoDeUsuaros.setBounds(144, 26, 172, 23);
		getContentPane().add(lblListadoDeUsuaros);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(10, 71, 46, 14);
		getContentPane().add(lblCurso);
		
		JComboBox idCurso = new JComboBox();
		NodoCurso puntero = primeros;
		String nombre = null;
		while (puntero != null) {
			if (puntero.getCurso().getNombre().equals(nombre)) {

			} else {
				idCurso.addItem(puntero.getCurso().getNombre());
				nombre = puntero.getCurso().getNombre();
			}
			puntero = puntero.Siguiente;
		}
		idCurso.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				mostrarSeccion((String) idCurso.getSelectedItem());
			}

		});
		idCurso.setBounds(52, 68, 75, 20);
		getContentPane().add(idCurso);
		
		JLabel lblSeccin = new JLabel("Sección:");
		lblSeccin.setBounds(144, 71, 46, 14);
		getContentPane().add(lblSeccin);
		
		idSeccion.setBounds(187, 68, 41, 20);
		getContentPane().add(idSeccion);
		
		JLabel lblSemestre = new JLabel("Semestre:");
		lblSemestre.setBounds(238, 71, 65, 14);
		getContentPane().add(lblSemestre);
		
		JComboBox idSemestre = new JComboBox();
		NodoSemestre aux = new NodoSemestre();
		aux = anterior;
		while (aux != null) {
			idSemestre.addItem(aux.getSemestre().getNombre());
			aux = aux.anterior;
		}
		idSemestre.setBounds(292, 68, 75, 20);
		getContentPane().add(idSemestre);
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String semestre = (String) idSemestre.getSelectedItem();
				String curso = (String) idCurso.getSelectedItem();
				String seccion = (String) idSeccion.getSelectedItem();
				double total = cantidadAsignados(semestre, seccion, curso);
				 fila[0] = cantidadAprobados(semestre,seccion,curso);
				 fila[1] = total/cantidadAprobados(semestre,seccion,curso);
				 fila[2] = cantidadReprobados(semestre,seccion,curso);
				 fila[3] = total/cantidadReprobados(semestre,seccion,curso);
				 fila[4] = cantidadAsignados(semestre,seccion,curso);
				 fila[5] = catedraticoEncargado(semestre,seccion,curso);
				 modelo.addRow(fila);
			}
		});
		btnMostrar.setBounds(335, 207, 89, 23);
		getContentPane().add(btnMostrar);
	}
	public int  cantidadAprobados(String semestre,String seccion,String curso){
		NodoAsignacion puntero=primero;
		int cantidad =0;
		while(puntero != null){
			if(puntero.getAsignacion().isAprobado()==true && puntero.getAsignacion().getCurso().equals(curso) && 
					puntero.getAsignacion().getSemestre().equals(semestre)&& puntero.getAsignacion().getSeccion().equals(seccion)){
				cantidad++;
			}
			puntero=puntero.siguiente;
		}
		return cantidad;
	}
	public int cantidadAsignados(String semestre,String seccion,String curso){
		NodoAsignacion puntero=primero;
		int cantidad =0;
		while(puntero != null){
			if(puntero.getAsignacion().getCurso().equals(curso) &&	puntero.getAsignacion().getSemestre().equals(semestre)&& puntero.getAsignacion().getSeccion().equals(seccion)){
				cantidad++;
			}
			puntero=puntero.siguiente;
		}
		return cantidad;
	}
	public int  cantidadReprobados(String semestre,String seccion,String curso){
		NodoAsignacion puntero=primero;
		int cantidad =0;
		while(puntero != null){
			if(puntero.getAsignacion().isAprobado()==false && puntero.getAsignacion().getCurso().equals(curso) && 
					puntero.getAsignacion().getSemestre().equals(semestre)&& puntero.getAsignacion().getSeccion().equals(seccion)){
				cantidad++;
			}
			puntero=puntero.siguiente;
		}
		return cantidad;
	}
	public String catedraticoEncargado(String semestre,String seccion,String curso){
		String nombre=null;
		NodoAsignacion puntero=primero;
		while(puntero != null){
			if(puntero.getAsignacion().getCurso().equals(curso) &&	puntero.getAsignacion().getSemestre().equals(semestre)
					&& puntero.getAsignacion().getSeccion().equals(seccion)){
				nombre = puntero.getAsignacion().getCuiCatedratico();
			}
			puntero=puntero.siguiente;
		}
		return nombre;
	}
	public void mostrarSeccion(String curso) {
		idSeccion.removeAllItems();
		NodoCurso puntero = primeros;
		while (puntero != null) {
			if (puntero.getCurso().getNombre().equals(curso)) {
				idSeccion.addItem(puntero.getCurso().getSeccion());
			}
			puntero = puntero.Siguiente;
		}
	}
}
