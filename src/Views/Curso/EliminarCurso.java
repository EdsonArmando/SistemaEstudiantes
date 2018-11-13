package Views.Curso;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Lists.ListaCurso;
import Nodes.NodoCurso;

public class EliminarCurso extends JDialog {
	ListaCurso curso = new ListaCurso();
	private NodoCurso primero = ListaCurso.getPrimero();
	private JTable tabla;
	private int codigos=0;
	public EliminarCurso() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Código");
		modelo.addColumn("Nombre");
		modelo.addColumn("CUI Catedrático");
		modelo.addColumn("Créditos");
		modelo.addColumn("Pre");
		modelo.addColumn("Post");
		NodoCurso actual = new NodoCurso();
		actual = primero;
		while (actual != null) {
			try {
				Object[] fila = new Object[6];
				fila[0] = actual.getCurso().getCodigo();
				fila[1] = actual.getCurso().getNombre();
				fila[2] = actual.getCurso().getCuiCatedratico();
				fila[3] = actual.getCurso().getCreditos();
				fila[4] = actual.getCurso().getPre();
				fila[5] = actual.getCurso().getPost();
				modelo.addRow(fila);
				actual = actual.Siguiente;
			} catch (java.lang.NullPointerException ex) {
				JOptionPane.showMessageDialog(null, "No hay ningun curso Ingresado");
			}
		}
		tabla = new JTable(modelo);
		tabla.setPreferredScrollableViewportSize(new Dimension(200, 200));
		JScrollPane scroll = new JScrollPane(tabla);
		scroll.setSize(414, 100);
		scroll.setLocation(10, 96);
		tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int fila = tabla.getSelectedRowCount();
				if(fila==1){
					int row = tabla.getSelectedRow();
					Object codigo = tabla.getValueAt(row, 0);
					 codigos = (Integer)codigo;
				}
			}
			
		});;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		tabla.setBounds(10, 125, 414, 100);
		getContentPane().add(scroll);

		JLabel lblListadoDeUsuaros = new JLabel("Listado de Cursos");
		lblListadoDeUsuaros.setForeground(SystemColor.activeCaptionBorder);
		lblListadoDeUsuaros.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblListadoDeUsuaros.setBounds(144, 26, 172, 23);
		getContentPane().add(lblListadoDeUsuaros);

		JButton btnSalir = new JButton("Eliminar");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				curso.eliminar(codigos);
				modelo.removeRow(tabla.getSelectedRow());
				JOptionPane.showMessageDialog(null, "El curso fue eliminado exitosamente");
			}
		});
		btnSalir.setBounds(335, 207, 89, 23);
		getContentPane().add(btnSalir);
	}
}
