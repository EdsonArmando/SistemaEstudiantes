package Views.Estudiante;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Lists.ListaEstudiante;
import Models.Estudiante;
import Nodes.Nodo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class FormularioCrear{
	private String nombre,correo,cui;
	private int carne,noCreditos,contrasenia;
	ListaEstudiante listaEstudiante = new ListaEstudiante();
	Estudiante estudiante;
	public void formulario2(){
		JDialog dialogUsuario = new JDialog();
		JPanel panelUsuario = new JPanel();
		panelUsuario.setLayout(null);
		JTextField idCarne;
		JTextField IdCui;
		JTextField idNombre;
		JTextField idCorreo;
		JTextField idCreditos;
		JTextField idContraenia;
		JLabel lblNewLabel = new JLabel("Ingreso de Usuarios");
		lblNewLabel.setForeground(SystemColor.activeCaptionBorder);
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		lblNewLabel.setBounds(164, 11, 128, 20);
		panelUsuario.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Carne:");
		lblNewLabel_1.setBounds(45, 55, 46, 14);
		panelUsuario.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CUI:");
		lblNewLabel_2.setBounds(45, 90, 46, 14);
		panelUsuario.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		lblNewLabel_3.setBounds(45, 125, 46, 14);
		panelUsuario.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Correo:");
		lblNewLabel_4.setBounds(45, 160, 46, 14);
		panelUsuario.add(lblNewLabel_4);
		
		JLabel lblNoCrditos = new JLabel("No. Créditos:");
		lblNoCrditos.setBounds(45, 195, 64, 14);
		panelUsuario.add(lblNoCrditos);
		
		JLabel lblNewLabel_5 = new JLabel("Contraseña:");
		lblNewLabel_5.setBounds(45, 230, 64, 14);
		panelUsuario.add(lblNewLabel_5);
		
		idCarne = new JTextField();
		idCarne.setBounds(135, 52, 86, 20);
		panelUsuario.add(idCarne);
		idCarne.setColumns(10);
		
		IdCui = new JTextField();
		IdCui.setBounds(135, 87, 86, 20);
		panelUsuario.add(IdCui);
		IdCui.setColumns(10);
		
		idNombre = new JTextField();
		idNombre.setBounds(135, 118, 86, 20);
		panelUsuario.add(idNombre);
		idNombre.setColumns(10);
		
		idCorreo = new JTextField();
		idCorreo.setBounds(135, 154, 86, 20);
		panelUsuario.add(idCorreo);
		idCorreo.setColumns(10);
		
		idCreditos = new JTextField();
		idCreditos.setText("");
		idCreditos.setBounds(135, 189, 86, 20);
		panelUsuario.add(idCreditos);
		idCreditos.setColumns(10);
		
		idContraenia = new JTextField();
		idContraenia.setEditable(false);
		idContraenia.setBounds(135, 224, 86, 20);
		panelUsuario.add(idContraenia);
		idContraenia.setColumns(10);
		idContraenia.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				idContraenia.setText(contrasenia(idCarne.getText(),IdCui.getText()));
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
		JButton btnAceptar = new JButton("Cancelar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogUsuario.dispose();
			}
		});
		btnAceptar.setBounds(250, 221, 89, 23);
		panelUsuario.add(btnAceptar);
		
		JButton btnAceptar_1 = new JButton("Aceptar");
		btnAceptar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cui = IdCui.getText();
				nombre = idNombre.getText();
				correo = idCorreo.getText();
				try{
					carne = Integer.parseInt(idCarne.getText());
					noCreditos = Integer.parseInt(idCreditos.getText());
					contrasenia = Integer.parseInt(idContraenia.getText());
				}catch( java.lang.NumberFormatException es){
					JOptionPane.showMessageDialog(null, "LLene los campos");
				}
				boolean esEnteros =tamaño(cui);
				boolean esNumerico = esNumerico(cui);
				if(idCreditos.getText().equals("")||idContraenia.getText().equals("")||
						idCarne.getText().equals("")||IdCui.getText().equals("")||idNombre.getText().equals("")||idCorreo.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Llene todos los campos");
					}else if(esEnteros==false){
						JOptionPane.showMessageDialog(null, "Ingrese un cui de 13 digitos");
					}else if(esNumerico==false){
						JOptionPane.showMessageDialog(null, "Ingrese un cui númerico");
					}else if(carne<0||Integer.toString(carne).length()<9){
						JOptionPane.showMessageDialog(null, "Ingrese correctamente el carne");
					}else{
						estudiante = new Estudiante(carne,cui,nombre,correo,noCreditos,contrasenia);
						ListaEstudiante.insertarEstudiante(estudiante);
						JOptionPane.showMessageDialog(null, "Estudiante Ingresado Exitosamente");
					}
			}
		});
		btnAceptar_1.setBounds(250, 177, 89, 23);
		panelUsuario.add(btnAceptar_1);
		dialogUsuario.add(panelUsuario);
		dialogUsuario.setLocationRelativeTo(null);
		dialogUsuario.setSize(450, 350);
		dialogUsuario.setVisible(true);
		dialogUsuario.setLocationRelativeTo(null);
	}
	public static boolean tamaño(String identificador) {
		boolean resultado = false;
			if(identificador.length()==13||identificador.length()==9){
				resultado=true;
			}else{
				JOptionPane.showMessageDialog(null, "Ingrese correctamente el cui o carne " );
			}
		return resultado;
	}
	private static String contrasenia(String carneess, String cui){
		String uno = String.valueOf(carneess.charAt(5))+String.valueOf(carneess.charAt(6))+
		String.valueOf(carneess.charAt(7))+String.valueOf(carneess.charAt(8));
		String dos = String.valueOf(cui.charAt(0))+String.valueOf(cui.charAt(1));
		String contra=uno+dos;
		return contra;
	}
	private static boolean esNumerico(String identificador){
		boolean uno = false;
		try {
			double n =Double.parseDouble(identificador);
			if(n>0){	
			uno= true;}else{
				JOptionPane.showMessageDialog(null, "Ingrese un numero positivo " );
			}
		} catch (NumberFormatException nfe){
			uno= false;
		}
		return uno;
	}
}
