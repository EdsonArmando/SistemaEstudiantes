package Views.Catedratico;

import java.awt.BorderLayout;
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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Lists.ListaCatedratico;
import Models.Catedratico;
import Nodes.NodoCatedratico;
import Nodes.NodoEstudiante;

public class FormularioModificar extends JDialog {
	private JTextField IdCui;
	private JTextField idNombre;
	private JTextField idCorreo;
	private JTextField idContraenia;
	ListaCatedratico lista = new ListaCatedratico();
	private NodoCatedratico primero = lista.getPrimero();
	private NodoCatedratico ultimo = lista.getUltimo();
	public void formularioModificars(String cui) {
		JDialog uno = new JDialog();
		JLabel lblNewLabel = new JLabel("Ingreso de Catedráticos");
		lblNewLabel.setForeground(SystemColor.activeCaptionBorder);
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		lblNewLabel.setBounds(145, 11, 166, 20);
		uno.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CUi:");
		lblNewLabel_1.setBounds(45, 55, 46, 14);
		uno.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(45, 90, 46, 14);
		uno.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Correo:");
		lblNewLabel_3.setBounds(45, 125, 46, 14);
		uno.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contraseña");
		lblNewLabel_4.setBounds(45, 160, 56, 14);
		uno.add(lblNewLabel_4);
		NodoCatedratico actual = new NodoCatedratico();
		actual=primero;
		do{
			if(actual.getCatedratico().getCui().equals(cui)){
		IdCui = new JTextField();
		IdCui.setBounds(135, 52, 86, 20);
		uno.add(IdCui);
		IdCui.setText(actual.getCatedratico().getCui());
		IdCui.setColumns(10);
		
		idNombre = new JTextField();
		idNombre.setBounds(135, 87, 86, 20);
		uno.add(idNombre);
		idNombre.setText(actual.getCatedratico().getNombre());
		idNombre.setColumns(10);
		
		idCorreo = new JTextField();
		idCorreo.setBounds(135, 122, 86, 20);
		uno.add(idCorreo);
		idCorreo.setText(actual.getCatedratico().getCorreo());
		idCorreo.setColumns(10);
		
		idContraenia = new JTextField();
		idContraenia.setEditable(false);
		idContraenia.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				idContraenia.setText(contrasenia(IdCui.getText(),idNombre.getText()));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		idContraenia.setText(actual.getCatedratico().getContrasenia());
		idContraenia.setBounds(135, 157, 86, 20);
		uno.add(idContraenia);
		idContraenia.setColumns(10);
			}
			actual = actual.siguiente;
		}while(actual!=primero);
		JButton btnAceptar = new JButton("Cancelar");
		btnAceptar.setBounds(145, 198, 89, 23);
		btnAceptar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				uno.dispose();
			}
			
		});
		uno.add(btnAceptar);
		
		JButton btnAceptar_1 = new JButton("Aceptar");
		btnAceptar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String nombre=idNombre.getText(),correo=idCorreo.getText(),cui2=IdCui.getText();
				 String contrasenia=contrasenia(cui,nombre);
				 
				 if(nombre.equals("")||cui.equals("")||correo.equals("")||contrasenia.equals("")){
					 JOptionPane.showMessageDialog(null, "LLene todos los campos");
				 }else if(cui.length()==13){
					 lista.modificarCatedratico(cui, cui2, nombre, correo, contrasenia);
					 JOptionPane.showMessageDialog(null, "Modificacion Correcta");
				 }else{
					 JOptionPane.showMessageDialog(null, "Ingrese correctamen el cui");
				 }
			}
		});
		btnAceptar_1.setBounds(45, 198, 89, 23);
		uno.add(btnAceptar_1);
		
		uno.setBounds(100, 100, 450, 300);
		uno.setLayout(null);
		uno.setVisible(true);
		uno.setResizable(false);
		uno.setLocationRelativeTo(null);
	}
	private static String contrasenia(String cui, String nombre){
		String contra = null;
		try{
			String uno = String.valueOf(cui.charAt(0))+String.valueOf(cui.charAt(1))+
					String.valueOf(cui.charAt(2))+String.valueOf(cui.charAt(3));
					String dos = String.valueOf(nombre.charAt(0))+String.valueOf(nombre.charAt(1)
							+String.valueOf(nombre.charAt(2)));
					contra=uno+dos;
		}catch(java.lang.StringIndexOutOfBoundsException e){
			JOptionPane.showMessageDialog(null, "LLene correctamente los campos");
		}
		return contra;
	}
}
