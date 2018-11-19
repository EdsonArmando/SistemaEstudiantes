package Views.Curso;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Collection;
import java.util.HashSet;

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

import Lists.ListaAsignacionCurso;
import Lists.ListaCurso;
import Lists.ListaSemestre;
import Models.Asignacion;
import Nodes.NodoCurso;
import Nodes.NodoSemestre;

import javax.swing.JComboBox;

public class AsignacionCurso extends JDialog {
	ListaCurso curso = new ListaCurso();
	ListaSemestre semestre = new ListaSemestre();
	private NodoCurso primero = ListaCurso.getPrimero();
	private NodoSemestre anterior = ListaSemestre.getAnterior();
	private JTable tabla;
	int cont = 1;
	String codigos;
	JComboBox idCurso = new JComboBox();
	JComboBox idSeccion = new JComboBox();
	int creditos = 0;
	int credito=0;
	public AsignacionCurso(int carne) {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("No");
		modelo.addColumn("Curso");
		modelo.addColumn("CUI Catedrático");
		modelo.addColumn("Seccion");
		modelo.addColumn("Creditos");
		modelo.addColumn("Semestre");

		Object[] fila = new Object[6];
		tabla = new JTable(modelo);
		tabla.setPreferredScrollableViewportSize(new Dimension(200, 200));
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setSize(485, 100);
		scroll.setLocation(10, 128);
		tabla.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 1) {
					int row = tabla.getSelectedRow();
					Object carnes = tabla.getValueAt(row, 4);
					credito = (Integer)carnes;
					modelo.removeRow(tabla.getSelectedRow());
					creditos = creditos -credito;
					cont--;
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
		setBounds(100, 100, 521, 312);
		getContentPane().setLayout(null);

		tabla.setBounds(10, 125, 414, 100);
		getContentPane().add(scroll);

		JLabel lblListadoDeUsuaros = new JLabel("Asignacion de Cursos");
		lblListadoDeUsuaros.setForeground(SystemColor.activeCaptionBorder);
		lblListadoDeUsuaros.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblListadoDeUsuaros.setBounds(188, 26, 172, 23);
		getContentPane().add(lblListadoDeUsuaros);

		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSalir.setBounds(406, 239, 89, 23);
		getContentPane().add(btnSalir);
		JComboBox idAnio = new JComboBox();
		idAnio.setBounds(115, 97, 83, 20);
		getContentPane().add(idAnio);

		JComboBox idSemestre = new JComboBox();
		idSemestre.setBounds(10, 97, 95, 20);
		int anio=0;
		NodoSemestre aux = new NodoSemestre();
		aux = anterior;
		idSemestre.addItem("Semestre 1");
		idSemestre.addItem("Semestre 2");
		while (aux != null) {
			if (aux.getSemestre().getAnio()==anio) {

			} else {
				idAnio.addItem(aux.getSemestre().getAnio());
				anio = aux.getSemestre().getAnio();
			}
			aux = aux.anterior;
		}
		getContentPane().add(idSemestre);
		NodoCurso puntero = primero;
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
		idCurso.setBounds(208, 97, 95, 20);
		getContentPane().add(idCurso);
		idSeccion.setBounds(313, 97, 70, 20);
		getContentPane().add(idSeccion);
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < tabla.getRowCount(); i++) {
					creditos += (int) tabla.getValueAt(i, 4);
				}
				if (creditos < 35) {
					NodoCurso puntero = primero;
					fila[0] = cont;
					fila[1] = idCurso.getSelectedItem();
					fila[3] = idSeccion.getSelectedItem();
					while (puntero != null) {
						if (idCurso.getSelectedItem().equals(puntero.getCurso().getNombre())) {
							fila[2] = puntero.getCurso().getCuiCatedratico();
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

		btnAgregar.setBounds(406, 94, 89, 23);
		JButton btnAsignar = new JButton("Asignar");
		btnAsignar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Asignacion asignacion;
				ListaAsignacionCurso lista = new ListaAsignacionCurso();
				for (int i = 0; i < tabla.getRowCount(); i++) {
					String nombre, cate, seccion, semestre;
					int creditos,anio;
					anio = (int) idAnio.getSelectedItem();
					nombre = (String) tabla.getValueAt(i, 1);
					cate = (String) tabla.getValueAt(i, 2);
					seccion = (String) tabla.getValueAt(i, 3);
					creditos = (int) tabla.getValueAt(i, 4);
					semestre = (String) tabla.getValueAt(i, 5);
					asignacion = new Asignacion(semestre,anio, nombre, carne, cate, seccion, creditos, 0, 0, 0, false);
					ListaAsignacionCurso.ingresarAsignacion(asignacion);
				}
				JOptionPane.showMessageDialog(null, "Asignación Exitosa");
			}
		});
		btnAsignar.setBounds(307, 239, 89, 23);
		getContentPane().add(btnAsignar);

		getContentPane().add(btnAgregar);
	}

	public void mostrarSeccion(String curso) {
		idSeccion.removeAllItems();
		NodoCurso puntero = primero;
		while (puntero != null) {
			if (puntero.getCurso().getNombre().equals(curso)) {
				idSeccion.addItem(puntero.getCurso().getSeccion());
			}
			puntero = puntero.Siguiente;
		}
	}
}
