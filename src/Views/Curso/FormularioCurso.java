package Views.Curso;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Lists.ListaCurso;
import Models.Curso;

import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioCurso extends JDialog {
	private JTextField idCodigo;
	private JTextField idNombre;
	private JTextField idCui;
	private JTextField idCreditos;
	private JTextField idSeccion;
	private JTextField idPre;
	private JTextField idPost;
	ListaCurso lista = new ListaCurso();
	public FormularioCurso() {
		setBounds(100, 100, 455, 350);
		getContentPane().setLayout(null);
		
		JLabel lblIngresarCursos = new JLabel("Ingresar Cursos");
		lblIngresarCursos.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblIngresarCursos.setForeground(SystemColor.activeCaptionBorder);
		lblIngresarCursos.setBounds(166, 11, 114, 14);
		getContentPane().add(lblIngresarCursos);
		
		JLabel lbCodigo = new JLabel("Código:");
		lbCodigo.setBounds(10, 59, 46, 14);
		getContentPane().add(lbCodigo);
		
		idCodigo = new JTextField();
		idCodigo.setBounds(110, 56, 86, 20);
		getContentPane().add(idCodigo);
		idCodigo.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 102, 46, 14);
		getContentPane().add(lblNombre);
		
		idNombre = new JTextField();
		idNombre.setBounds(110, 99, 86, 20);
		getContentPane().add(idNombre);
		idNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CUI Catedratico");
		lblNewLabel.setBounds(10, 145, 66, 14);
		getContentPane().add(lblNewLabel);
		
		idCui = new JTextField();
		idCui.setBounds(110, 142, 86, 20);
		getContentPane().add(idCui);
		idCui.setColumns(10);
		
		JLabel lblCrditos = new JLabel("Créditos:");
		lblCrditos.setBounds(10, 188, 46, 14);
		getContentPane().add(lblCrditos);
		
		idCreditos = new JTextField();
		idCreditos.setBounds(110, 185, 86, 20);
		getContentPane().add(idCreditos);
		idCreditos.setColumns(10);
		
		JLabel lblSeccin = new JLabel("Sección");
		lblSeccin.setBounds(10, 231, 46, 14);
		getContentPane().add(lblSeccin);
		
		idSeccion = new JTextField();
		idSeccion.setBounds(110, 228, 86, 20);
		getContentPane().add(idSeccion);
		idSeccion.setColumns(10);
		
		JLabel lblPre = new JLabel("PRE:");
		lblPre.setBounds(10, 274, 46, 14);
		getContentPane().add(lblPre);
		
		idPre = new JTextField();
		idPre.setText("");
		idPre.setBounds(110, 271, 86, 20);
		getContentPane().add(idPre);
		idPre.setColumns(10);
		
		JLabel lblPost = new JLabel("POST:");
		lblPost.setBounds(234, 59, 46, 14);
		getContentPane().add(lblPost);
		
		idPost = new JTextField();
		idPost.setBounds(290, 56, 86, 20);
		getContentPane().add(idPost);
		idPost.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo=Integer.parseInt(idCodigo.getText()),creditos=Integer.parseInt(idCreditos.getText());
				String nombre=idNombre.getText(),cuiCate=idCui.getText(),seccion=idSeccion.getText(),pre=idPre.getText(),post=idPost.getText();
				Curso curso = new Curso(codigo,nombre,cuiCate,creditos,seccion,pre,post);
				ListaCurso.insertarCurso(curso);
			}
		});
		btnAceptar.setBounds(234, 116, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(234, 179, 89, 23);
		getContentPane().add(btnCancelar);
	}
}
