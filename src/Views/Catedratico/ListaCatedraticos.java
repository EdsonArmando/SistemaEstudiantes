package Views.Catedratico;

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

import Lists.ListaCatedratico;
import Lists.ListaEstudiante;
import Nodes.NodoCatedratico;
import Nodes.NodoEstudiante;

public class ListaCatedraticos extends JDialog {
	ListaCatedratico lista = new ListaCatedratico();
	private NodoCatedratico primero = lista.getPrimero();
	private JTable tabla;
	public ListaCatedraticos() {
		DefaultTableModel modelo = new DefaultTableModel();
		modelo.addColumn("Cui");
		modelo.addColumn("Nombre");
		modelo.addColumn("Correo");
		 NodoCatedratico actual = new NodoCatedratico();
		 actual = primero;
			 do{
				 try{
					 Object[] fila = new Object[3];
						fila[0] = actual.getCatedratico().getCui();
						fila[1] = actual.getCatedratico().getNombre();
						fila[2] = actual.getCatedratico().getCorreo();
						modelo.addRow(fila);
					 actual = actual.siguiente;
				 }catch( java.lang.NullPointerException ex){
					 JOptionPane.showMessageDialog(null, "No hay ningun Catedratico Ingresado");
				 }
			 }while(actual!=primero);
			 tabla = new JTable(modelo);
			 tabla.setPreferredScrollableViewportSize(new Dimension(200,200));
			 JScrollPane scroll = new JScrollPane(tabla);
			 scroll.setSize(414, 100);
			 scroll.setLocation(10, 96);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		tabla.setBounds(10, 125, 414, 100);
		getContentPane().add(scroll);
		
		JLabel lblListadoDeUsuaros = new JLabel("Listado de Estudiantes");
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
