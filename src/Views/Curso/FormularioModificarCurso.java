package Views.Curso;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import Lists.ListaCurso;
import Models.Curso;
import Nodes.NodoCurso;

public class FormularioModificarCurso {
	private JTextField idCodigo;
	private JTextField idNombre;
	private JTextField idCui;
	private JTextField idCreditos;
	private JTextField idSeccion;
	private JTextField idPre;
	private JTextField idPost;
	private NodoCurso primero = ListaCurso.getPrimero();
	ListaCurso lista = new ListaCurso();
	public void formularioModificarCurso(int codigo2) {
		JDialog uno = new JDialog();
		uno.setBounds(100, 100, 455, 350);
		uno.setLayout(null);
		 
		JLabel lblIngresarCursos = new JLabel("Ingresar Cursos");
		lblIngresarCursos.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblIngresarCursos.setForeground(SystemColor.activeCaptionBorder);
		lblIngresarCursos.setBounds(166, 11, 114, 14);
		uno.add(lblIngresarCursos);
		
		JLabel lbCodigo = new JLabel("Código:");
		lbCodigo.setBounds(10, 59, 46, 14);
		uno.add(lbCodigo);
		NodoCurso actual = new NodoCurso();
		actual = primero;
			while (actual != null) {
				if(actual.getCurso().getCodigo()==codigo2){
					idCodigo = new JTextField();
					idCodigo.setBounds(110, 56, 86, 20);
					idCodigo.setText(String.valueOf(actual.getCurso().getCodigo()));
					uno.add(idCodigo);
					idCodigo.setColumns(10);
					
					JLabel lblNombre = new JLabel("Nombre:");
					lblNombre.setBounds(10, 102, 46, 14);
					uno.add(lblNombre);
					
					idNombre = new JTextField();
					idNombre.setBounds(110, 99, 86, 20);
					idNombre.setText(actual.getCurso().getNombre());
					uno.add(idNombre);
					idNombre.setColumns(10);
					
					JLabel lblNewLabel = new JLabel("CUI Catedratico");
					lblNewLabel.setBounds(10, 145, 66, 14);
					uno.add(lblNewLabel);
					
					idCui = new JTextField();
					idCui.setBounds(110, 142, 86, 20);
					idCui.setText(actual.getCurso().getCuiCatedratico());
					uno.add(idCui);
					idCui.setColumns(10);
					
					JLabel lblCrditos = new JLabel("Créditos:");
					lblCrditos.setBounds(10, 188, 46, 14);
					uno.add(lblCrditos);
					
					idCreditos = new JTextField();
					idCreditos.setBounds(110, 185, 86, 20);
					idCreditos.setText(String.valueOf(actual.getCurso().getCreditos()));
					uno.add(idCreditos);
					idCreditos.setColumns(10);
					
					JLabel lblSeccin = new JLabel("Sección");
					lblSeccin.setBounds(10, 231, 46, 14);
					uno.add(lblSeccin);
					
					idSeccion = new JTextField();
					idSeccion.setText(actual.getCurso().getSeccion());
					idSeccion.setBounds(110, 228, 86, 20);
					uno.add(idSeccion);
					idSeccion.setColumns(10);
					
					JLabel lblPre = new JLabel("PRE:");
					lblPre.setBounds(10, 274, 46, 14);
					uno.add(lblPre);
					
					idPre = new JTextField();
					idPre.setText(actual.getCurso().getPre());
					idPre.setBounds(110, 271, 86, 20);
					uno.add(idPre);
					idPre.setColumns(10);
					
					JLabel lblPost = new JLabel("POST:");
					lblPost.setBounds(234, 59, 46, 14);
					uno.add(lblPost);
					
					idPost = new JTextField();
					idPost.setBounds(290, 56, 86, 20);
					idPost.setText(actual.getCurso().getPost());
					uno.add(idPost);
					idPost.setColumns(10);
				}
			actual = actual.Siguiente;
		}
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int codigo=Integer.parseInt(idCodigo.getText()),creditos=Integer.parseInt(idCreditos.getText());
				String nombre=idNombre.getText(),cuiCate=idCui.getText(),seccion=idSeccion.getText(),pre=idPre.getText(),post=idPost.getText();
				lista.modificar(codigo2, codigo, nombre, cuiCate, creditos, seccion, pre, post);
			}
		});
		btnAceptar.setBounds(234, 116, 89, 23);
		uno.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				uno.dispose();
			}
		});
		btnCancelar.setBounds(234, 179, 89, 23);
		uno.add(btnCancelar);
		uno.setVisible(true);
		uno.setResizable(false);
		uno.setLocationRelativeTo(null);
	}
}
