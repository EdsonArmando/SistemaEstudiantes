package Views.Catedratico;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
import Lists.ListaEstudiante;
import Lists.ListaSemestre;
import Nodes.NodoAsignacion;
import Nodes.NodoCurso;
import Nodes.NodoSemestre;

import javax.swing.JComboBox;

public class IngresarNotas extends JDialog {
		ListaCurso curso = new ListaCurso();
		private NodoAsignacion prim = ListaAsignacionCurso.getPrimero();
		private NodoCurso primero = ListaCurso.getPrimero();
		private NodoSemestre anterior = ListaSemestre.getAnterior();
		private JTable tabla;
		int carne;
		public IngresarNotas(String cuiCatedratico){
			setBounds(100, 100, 512, 300);
			getContentPane().setLayout(null);
			DefaultTableModel modelo = new DefaultTableModel();
			 modelo.addColumn("Carne");
			 modelo.addColumn("Nombre");
			 modelo.addColumn("Nota");
			 Object[] fila=new Object[3];
				 tabla = new JTable(modelo);
				 tabla.setPreferredScrollableViewportSize(new Dimension(200,200));
				 JScrollPane scroll = new JScrollPane(tabla);
				 scroll.setSize(414, 100);
				 scroll.setLocation(10, 96);
				 
			setBounds(100, 100, 450, 300);
			getContentPane().setLayout(null);
			tabla.setBounds(10, 125, 414, 100);
			getContentPane().add(scroll);
	
			JLabel lblListadoDeUsuaros = new JLabel("Ingresar Notas");
			lblListadoDeUsuaros.setForeground(SystemColor.activeCaptionBorder);
			lblListadoDeUsuaros.setFont(new Font("Calibri Light", Font.PLAIN, 18));
			lblListadoDeUsuaros.setBounds(174, 26, 107, 23);
			getContentPane().add(lblListadoDeUsuaros);
			
			JButton btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnSalir.setBounds(335, 207, 89, 23);
			getContentPane().add(btnSalir);
			JComboBox idAnio = new JComboBox();
			idAnio.setBounds(115, 65, 59, 20);
			getContentPane().add(idAnio);
			JComboBox idSemestre = new JComboBox();
			idSemestre.setBounds(10, 65, 95, 20);
			getContentPane().add(idSemestre);
			idSemestre.addItem("Semestre 1");
			idSemestre.addItem("Semestre 2");
			NodoSemestre aux = new NodoSemestre();
			aux = anterior;
			int anio=0;
			while (aux != null) {
				if (aux.getSemestre().getAnio()==anio) {

				} else {
					idAnio.addItem(aux.getSemestre().getAnio());
					anio = aux.getSemestre().getAnio();
				}
				aux = aux.anterior;
			}
			JComboBox idCurso = new JComboBox();
			idCurso.setBounds(184, 65, 95, 20);
			getContentPane().add(idCurso);
			 NodoCurso actual = new NodoCurso();
			 actual = primero;
			 String nombre =null;
			 while(actual !=null){
				 if(actual.getCurso().getCuiCatedratico().equals(cuiCatedratico)){
					 if (actual.getCurso().getNombre().equals(nombre)) {

						} else {
							 idCurso.addItem(actual.getCurso().getNombre());
							nombre = actual.getCurso().getNombre();
						}
				 }
				 actual = actual.Siguiente;
				 }
			JButton btnMostrar = new JButton("Mostrar ");
			btnMostrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					NodoAsignacion puntero=prim;
					while(puntero != null){
						if(puntero.getAsignacion().getSemestre().equals(idSemestre.getSelectedItem())&& puntero.getAsignacion().getCurso().equals(idCurso.getSelectedItem())
								&& puntero.getAsignacion().getCuiCatedratico().equals(cuiCatedratico)&& puntero.getAsignacion().getAnio()==(int) idAnio.getSelectedItem()){
							 fila[0] = puntero.getAsignacion().getCarne();
							 fila[1] = ListaEstudiante.retornarNombre(puntero.getAsignacion().getCarne());
							 fila[2] = puntero.getAsignacion().getNotaTotal();
							 modelo.addRow(fila);
						}
						puntero = puntero.siguiente;
					}
				}
			});
			btnMostrar.setBounds(335, 62, 89, 23);
			tabla.addMouseListener(new MouseListener() {

				@Override
				public void mouseClicked(MouseEvent e) {
					if (e.getClickCount() == 1) {
						int fila = tabla.getSelectedRowCount();
						if(fila==1){
							int row = tabla.getSelectedRow();
							Object codigo = tabla.getValueAt(row, 0);
							carne = (Integer)codigo;
							System.out.println(carne);
							FormIngresarNotas ingresar = new FormIngresarNotas(carne,(String) idCurso.getSelectedItem());
							ingresar.setVisible(true);
							ingresar.setLocationRelativeTo(null);
							ingresar.setResizable(false);
						}
					}
				}

				@Override
				public void mousePressed(MouseEvent e) {
				}

				@Override
				public void mouseReleased(MouseEvent e) {
				}

				@Override
				public void mouseEntered(MouseEvent e) {
				}

				@Override
				public void mouseExited(MouseEvent e) {
				}

			});
			getContentPane().add(btnMostrar);
		}
	}
