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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Lists.ListaEstudiante;

public class ReporteCatedratico extends JDialog {
	JTable tabla;
	JTextField idCui;
	public ReporteCatedratico() {
		DefaultTableModel modelo = new DefaultTableModel();
		 modelo.addColumn("Curso");
		 modelo.addColumn("Semestre");
		 modelo.addColumn("Estudiantes que Ganaron");
		 modelo.addColumn("Estudiantes que % Ganaron");
		 modelo.addColumn("Estudiantes que Perdieron");
		 modelo.addColumn("Estudiantes que % Perdieron");
		 modelo.addColumn("No llegaron a zona minima");
		 modelo.addColumn("Nota máxima");
		 modelo.addColumn("Nota mínima");
		 modelo.addColumn("Promedio de Notas");
		 modelo.addColumn("Total Asignados");
					 Object[] fila=new Object[3];
					
			 tabla = new JTable(modelo);
			 tabla.setPreferredScrollableViewportSize(new Dimension(200,200));
			 JScrollPane scroll = new JScrollPane(tabla);
			 scroll.setSize(1264, 100);
			 scroll.setLocation(10, 96);
			 
		setBounds(100, 100, 1300, 300);
		getContentPane().setLayout(null);
		
		
		tabla.setBounds(10, 125, 414, 100);
		getContentPane().add(scroll);

		JLabel lblListadoDeUsuaros = new JLabel("Reporte de Catedráticos");
		lblListadoDeUsuaros.setForeground(SystemColor.activeCaptionBorder);
		lblListadoDeUsuaros.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblListadoDeUsuaros.setBounds(10, 21, 191, 23);
		getContentPane().add(lblListadoDeUsuaros);
		
		JLabel lblCurso = new JLabel("CUI:");
		lblCurso.setBounds(10, 71, 46, 14);
		getContentPane().add(lblCurso);
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 /*fila[0] = 
				 fila[1] = 
				 fila[2] = 
				 modelo.addRow(fila);*/
			}
		});
		btnMostrar.setBounds(1185, 207, 89, 23);
		getContentPane().add(btnMostrar);
		
		idCui = new JTextField();
		idCui.setText("");
		idCui.setBounds(66, 65, 86, 20);
		getContentPane().add(idCui);
		idCui.setColumns(10);
	}
}
