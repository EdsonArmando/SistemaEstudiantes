package Views.Curso;

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
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Lists.ListaCurso;
import Lists.ListaSemestre;
import Nodes.NodoCurso;
import Nodes.NodoSemestre;

import javax.swing.JComboBox;

public class AsignacionCurso extends JDialog {
	ListaCurso curso = new ListaCurso();
	ListaSemestre semestre = new ListaSemestre();
	private NodoCurso primero = ListaCurso.getPrimero();
	private NodoSemestre anterior = ListaSemestre.getAnterior();
	private JTable tabla;
	int cont =1;
	String codigos;
	public AsignacionCurso(){
		DefaultTableModel modelo = new DefaultTableModel();
		 modelo.addColumn("No");
		 modelo.addColumn("Curso");
		 modelo.addColumn("CUI Catedrático");
		 modelo.addColumn("Seccion");
		 modelo.addColumn("Creditos");
		 modelo.addColumn("Semestre");
		
					 Object[] fila=new Object[6];				
			 tabla = new JTable(modelo);
			 tabla.setPreferredScrollableViewportSize(new Dimension(200,200));
			 JScrollPane scroll = new JScrollPane(tabla);
			 scroll.setSize(414, 100);
			 scroll.setLocation(10, 128);
			 
		setBounds(100, 100, 450, 312);
		getContentPane().setLayout(null);
		
		
		tabla.setBounds(10, 125, 414, 100);
		getContentPane().add(scroll);
		
		JLabel lblListadoDeUsuaros = new JLabel("Asignacion de Cursos");
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
		btnSalir.setBounds(335, 239, 89, 23);
		getContentPane().add(btnSalir);
		
		JComboBox idSemestre = new JComboBox();
		idSemestre.setBounds(10, 97, 70, 20);
		NodoSemestre aux = new NodoSemestre();
		aux = anterior;
		while(aux!=null){
			idSemestre.addItem(aux.getSemestre().getNombre()+ " "+ aux.getSemestre().getAnio());
			aux = aux.anterior;
		}
		getContentPane().add(idSemestre);
		
		
		JComboBox idCurso = new JComboBox();
		NodoCurso puntero = primero;
		while (puntero != null) {
			idCurso.addItem(puntero.getCurso().getNombre());
			puntero = puntero.Siguiente;
		}
		idCurso.setBounds(185, 97, 70, 20);
		getContentPane().add(idCurso);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			int creditos=0;
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < tabla.getRowCount(); i++) {
					creditos += (int) tabla.getValueAt(i, 4);
			}
				if(creditos<35){
					NodoCurso puntero = primero;
					fila[0] = cont;
					fila[1] = idCurso.getSelectedItem();
					while (puntero != null) {
						if(idCurso.getSelectedItem().equals(puntero.getCurso().getNombre())){	
							fila[2] = puntero.getCurso().getCuiCatedratico();
							fila[3] = puntero.getCurso().getSeccion();
							fila[4] = puntero.getCurso().getCreditos();
						}
						fila[5] = idSemestre.getSelectedItem();
						puntero = puntero.Siguiente;
					}
					modelo.addRow(fila);
					cont++;
				}
			}
		});
		
		btnAgregar.setBounds(335, 94, 89, 23);
		JButton btnAsignar = new JButton("Asignar");
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < tabla.getRowCount(); i++) {
						String nombre,cate;
						nombre = (String) tabla.getValueAt(i, 1);
						System.out.println(nombre);
						cate = (String) tabla.getValueAt(i, 2);
						System.out.println(cate);
				}
			}
		});
		btnAsignar.setBounds(227, 239, 89, 23);
		getContentPane().add(btnAsignar);
		
		getContentPane().add(btnAgregar);
	}
}
