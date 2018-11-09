package Views.Semestre;

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

import Lists.ListaSemestre;
import Nodes.NodoSemestre;

public class ListaSsemestres extends JDialog {
	ListaSemestre lista = new ListaSemestre();
	NodoSemestre anterior = ListaSemestre.getAnterior();
	JTable tabla;
	public ListaSsemestres() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Nombre");
		modelo.addColumn("Año");
		NodoSemestre actual = new NodoSemestre();
		actual = anterior;
		while(actual !=null){
			try {
				Object[] fila = new Object[2];
				fila[0] = actual.getSemestre().getNombre();
				fila[1] = actual.getSemestre().getAnio();
				modelo.addRow(fila);
				actual = actual.anterior;
			} catch (java.lang.NullPointerException ex) {
				JOptionPane.showMessageDialog(null, "No hay ningun Semestre Ingresado");
			}
		}
		tabla = new JTable(modelo);
		tabla.setPreferredScrollableViewportSize(new Dimension(200, 200));
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setSize(414, 100);
		scroll.setLocation(10, 96);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		tabla.setBounds(10, 125, 414, 100);
		getContentPane().add(scroll);

		JLabel lblListadoDeUsuaros = new JLabel("Listado de Semestres");
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
