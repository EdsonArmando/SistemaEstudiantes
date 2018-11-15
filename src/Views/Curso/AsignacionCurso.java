package Views.Curso;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	int cont = 1;
	String codigos;

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
					modelo.removeRow(tabla.getSelectedRow());
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

		JComboBox idSemestre = new JComboBox();
		idSemestre.setBounds(10, 97, 95, 20);
		NodoSemestre aux = new NodoSemestre();
		aux = anterior;
		while (aux != null) {
			idSemestre.addItem(aux.getSemestre().getNombre() + " " + aux.getSemestre().getAnio());
			aux = aux.anterior;
		}
		getContentPane().add(idSemestre);
		NodoCurso puntero = primero;
		JComboBox idCurso = new JComboBox();
		JComboBox idSeccion = new JComboBox();
		while (puntero != null) {
			idCurso.addItem(puntero.getCurso().getNombre());
			if (puntero.getCurso().getNombre().equals(idCurso.getSelectedItem())) {
				idSeccion.addItem(puntero.getCurso().getSeccion());
			}
			puntero = puntero.Siguiente;
		}
		idCurso.setBounds(115, 97, 95, 20);
		getContentPane().add(idCurso);
		idSeccion.setBounds(220, 97, 70, 20);
		getContentPane().add(idSeccion);
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			int creditos = 0;

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
				for (int i = 0; i < tabla.getRowCount(); i++) {
					String nombre, cate;
					nombre = (String) tabla.getValueAt(i, 1);
					System.out.println(nombre);
					cate = (String) tabla.getValueAt(i, 2);
					System.out.println(cate);
					System.out.println(carne);
				}
			}
		});
		btnAsignar.setBounds(307, 239, 89, 23);
		getContentPane().add(btnAsignar);

		getContentPane().add(btnAgregar);

	}
}
