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
import javax.swing.table.DefaultTableModel;

import Lists.ListaCurso;
import Nodes.NodoCurso;

public class ListaCursos extends JDialog{
	ListaCurso curso = new ListaCurso();
	private NodoCurso primero = ListaCurso.getPrimero();
	private JTable tabla;
	public ListaCursos(){
		DefaultTableModel modelo = new DefaultTableModel();
		 modelo.addColumn("Código");
		 modelo.addColumn("Nombre");
		 modelo.addColumn("CUI Catedrático");
		 modelo.addColumn("Créditos");
		 modelo.addColumn("Pre");
		 modelo.addColumn("Post");
		 NodoCurso actual = new NodoCurso();
		 actual = primero;
		 while(actual !=null){
				 try{
					 Object[] fila=new Object[6];
					 fila[0] = actual.getCurso().getCodigo();
					 fila[1] = actual.getCurso().getNombre();
					 fila[2] = actual.getCurso().getCuiCatedratico();
					 fila[3] = actual.getCurso().getCreditos();
					 fila[4] = actual.getCurso().getPre();
					 fila[5] = actual.getCurso().getPost();
					 modelo.addRow(fila);
					 actual = actual.Siguiente;
				 }catch( java.lang.NullPointerException ex){
					 JOptionPane.showMessageDialog(null, "No hay ningun curso Ingresado");
				 }
			 }
			 tabla = new JTable(modelo);
			 tabla.setPreferredScrollableViewportSize(new Dimension(200,200));
			 JScrollPane scroll = new JScrollPane(tabla);
			 scroll.setSize(414, 100);
			 scroll.setLocation(10, 96);
			 
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		
		tabla.setBounds(10, 125, 414, 100);
		getContentPane().add(scroll);
		
		JLabel lblListadoDeUsuaros = new JLabel("Listado de Cursos");
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
