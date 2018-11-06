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
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Lists.ListaCatedratico;
import Nodes.NodoCatedratico;

public class EliminacionCatedratico extends JDialog {
	ListaCatedratico lista = new ListaCatedratico();
	private NodoCatedratico primero = lista.getPrimero();
	private JTable tabla;
	private String cui;
	public EliminacionCatedratico() {
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
			 tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

					@Override
					public void valueChanged(ListSelectionEvent e) {
						int fila = tabla.getSelectedRowCount();
						if(fila==1){
							int row = tabla.getSelectedRow();
							Object cuis = tabla.getValueAt(row, 0);
							 cui = (String)cuis;
						}
					}
					
				});;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		tabla.setBounds(10, 125, 414, 100);
		getContentPane().add(scroll);
		
		JLabel lblListadoDeUsuaros = new JLabel("Listado de Catedraticos");
		lblListadoDeUsuaros.setForeground(SystemColor.activeCaptionBorder);
		lblListadoDeUsuaros.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblListadoDeUsuaros.setBounds(144, 26, 172, 23);
		getContentPane().add(lblListadoDeUsuaros);
		
		JButton btnSalir = new JButton("Eliminar");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.removeRow(tabla.getSelectedRow());
				lista.eliminar(cui);
				JOptionPane.showMessageDialog(null, "El catedratico fue eliminado exitosamente");
			}
		});
		btnSalir.setBounds(335, 207, 89, 23);
		getContentPane().add(btnSalir);
	}

}
