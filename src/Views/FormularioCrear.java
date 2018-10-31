package Views;

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
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class FormularioCrear extends JDialog {
	private JTextField idCarne;
	private JTextField IdCui;
	private JTextField idNombre;
	private JTextField idCorreo;
	private JTextField idCreditos;
	private JTextField idContraenia;
	private String nombre,correo;
	private int carne,cui,noCreditos,contrasenia;
	Nodo nodo = new Nodo();
	ListaEstudiante listaEstudiante = new ListaEstudiante();
	Estudiante estudiante;
	public FormularioCrear() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ingreso de Usuarios");
		lblNewLabel.setForeground(SystemColor.activeCaptionBorder);
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		lblNewLabel.setBounds(164, 11, 128, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Carne:");
		lblNewLabel_1.setBounds(45, 55, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CUI:");
		lblNewLabel_2.setBounds(45, 90, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		lblNewLabel_3.setBounds(45, 125, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Correo:");
		lblNewLabel_4.setBounds(45, 160, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNoCrditos = new JLabel("No. Créditos:");
		lblNoCrditos.setBounds(45, 195, 64, 14);
		getContentPane().add(lblNoCrditos);
		
		JLabel lblNewLabel_5 = new JLabel("Contraseña:");
		lblNewLabel_5.setBounds(45, 230, 64, 14);
		getContentPane().add(lblNewLabel_5);
		
		idCarne = new JTextField();
		idCarne.setBounds(135, 52, 86, 20);
		getContentPane().add(idCarne);
		idCarne.setColumns(10);
		
		IdCui = new JTextField();
		IdCui.setBounds(135, 87, 86, 20);
		getContentPane().add(IdCui);
		IdCui.setColumns(10);
		
		idNombre = new JTextField();
		idNombre.setBounds(135, 118, 86, 20);
		getContentPane().add(idNombre);
		idNombre.setColumns(10);
		
		idCorreo = new JTextField();
		idCorreo.setBounds(135, 154, 86, 20);
		getContentPane().add(idCorreo);
		idCorreo.setColumns(10);
		
		idCreditos = new JTextField();
		idCreditos.setText("");
		idCreditos.setBounds(135, 189, 86, 20);
		getContentPane().add(idCreditos);
		idCreditos.setColumns(10);
		
		idContraenia = new JTextField();
		idContraenia.setEditable(false);
		idContraenia.setBounds(135, 224, 86, 20);
		getContentPane().add(idContraenia);
		idContraenia.setColumns(10);
		idContraenia.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				idContraenia.setText("123456789");
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
		btnAceptar.setBounds(250, 221, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnAceptar_1 = new JButton("Aceptar");
		btnAceptar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				carne = Integer.parseInt(idCarne.getText());
				cui = Integer.parseInt(IdCui.getText());
				nombre = idNombre.getText();
				correo = idCorreo.getText();
				noCreditos = Integer.parseInt(idCreditos.getText());
				contrasenia = Integer.parseInt(idContraenia.getText());
				estudiante = new Estudiante(carne,cui,nombre,correo,noCreditos,contrasenia);
				listaEstudiante.insertarEstudiante(estudiante);
				listaEstudiante.imprimir();
			}
		});
		btnAceptar_1.setBounds(250, 177, 89, 23);
		getContentPane().add(btnAceptar_1);
	}
}
