package Views;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;

import Lists.ListaCatedratico;
import Views.Catedratico.FormularioCatedratico;
import Views.Catedratico.ListaCatedraticos;
import Views.Estudiante.AdministrarEstudiantes;
import Views.Estudiante.ListadoEstudiantes;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MenuAdministrador extends JDialog {
	AdministrarEstudiantes adminEstudiantes = new AdministrarEstudiantes();
	FormularioCatedratico formCatedratico = new FormularioCatedratico();
	JDialog dialogMaster;
	public MenuAdministrador() {
		getContentPane().setEnabled(false);
		setSize(450,400);
		setResizable(false);
		JLabel lblMenAdministrador = new JLabel("Menú Administrador");
		getContentPane().setLayout(null);
		getContentPane().add(lblMenAdministrador);
		
		JLabel lblNewLabel = new JLabel("Modulo Administrador");
		lblNewLabel.setForeground(SystemColor.activeCaptionBorder);
		lblNewLabel.setBackground(SystemColor.textInactiveText);
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 19));
		lblNewLabel.setEnabled(false);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(151, 22, 179, 27);
		getContentPane().add(lblNewLabel);
		
		JLabel lblModulos = new JLabel("Modulos");
		lblModulos.setEnabled(false);
		lblModulos.setBackground(SystemColor.activeCaptionBorder);
		lblModulos.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		lblModulos.setBounds(37, 75, 88, 14);
		getContentPane().add(lblModulos);
		
		JButton btnEstudiantes = new JButton("Estudiantes");
		btnEstudiantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminEstudiantes.setVisible(true);
				adminEstudiantes.setLocationRelativeTo(null);
			}
		});
		btnEstudiantes.setBounds(37, 108, 102, 23);
		getContentPane().add(btnEstudiantes);
		
		JButton btnCatdraticos = new JButton("Catedráticos");
		btnCatdraticos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminCatedraticos();
			}
		});
		btnCatdraticos.setBounds(37, 155, 102, 23);
		getContentPane().add(btnCatdraticos);
		
		JButton btnNewButton = new JButton("Cursos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administrarCursos();
			}
		});
		btnNewButton.setBounds(37, 202, 102, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnCargaMasiva = new JButton("Carga Masiva");
		btnCargaMasiva.setBounds(37, 249, 102, 23);
		getContentPane().add(btnCargaMasiva);
		
		JButton btnNewButton_1 = new JButton("Reportes");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(37, 296, 102, 23);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Armando\\Documents\\Edson\\EclipseEE\\SistemaEstudiantes\\src\\Image\\admin.png"));
		lblNewLabel_1.setBounds(208, 75, 206, 207);
		getContentPane().add(lblNewLabel_1);
	}
	public void adminCatedraticos(){
		dialogMaster = new JDialog();
		dialogMaster.getContentPane().setLayout(null);
		
		JLabel lblAdministrarEstudiantes = new JLabel("Administrar Catedráticos");
		lblAdministrarEstudiantes.setForeground(SystemColor.activeCaptionBorder);
		lblAdministrarEstudiantes.setBackground(SystemColor.activeCaptionBorder);
		lblAdministrarEstudiantes.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		lblAdministrarEstudiantes.setBounds(132, 11, 180, 14);
		dialogMaster.getContentPane().add(lblAdministrarEstudiantes);
		
		JButton btnAgregarUsuario = new JButton("Agregar");
		btnAgregarUsuario.setBounds(65, 46, 111, 23);
		dialogMaster.getContentPane().add(btnAgregarUsuario);
		btnAgregarUsuario.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				formCatedratico.formularioCrear();
			}
			
		});
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(65, 97, 111, 23);
		dialogMaster.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Visualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaCatedraticos listaNueva = new ListaCatedraticos();
				listaNueva.setVisible(true);
				listaNueva.setLocationRelativeTo(null);
				listaNueva.setResizable(false);
			}
		});
		btnNewButton_1.setBounds(256, 46, 111, 23);
		dialogMaster.getContentPane().add(btnNewButton_1);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(256, 97, 111, 23);
		dialogMaster.getContentPane().add(btnEliminar);
		dialogMaster.setBounds(100, 100, 453, 203);
		dialogMaster.setLocationRelativeTo(null);
		dialogMaster.setResizable(false);
		dialogMaster.setVisible(true);
	}
	public void administrarCursos(){
		dialogMaster = new JDialog();
		dialogMaster.getContentPane().setLayout(null);
		
		JLabel lblAdministrarEstudiantes = new JLabel("Administrar Cursos");
		lblAdministrarEstudiantes.setForeground(SystemColor.activeCaptionBorder);
		lblAdministrarEstudiantes.setBackground(SystemColor.activeCaptionBorder);
		lblAdministrarEstudiantes.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		lblAdministrarEstudiantes.setBounds(132, 11, 180, 14);
		dialogMaster.getContentPane().add(lblAdministrarEstudiantes);
		
		JButton btnAgregarUsuario = new JButton("Agregar");
		btnAgregarUsuario.setBounds(65, 46, 111, 23);
		dialogMaster.getContentPane().add(btnAgregarUsuario);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(65, 97, 111, 23);
		dialogMaster.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Visualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(256, 46, 111, 23);
		dialogMaster.getContentPane().add(btnNewButton_1);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(256, 97, 111, 23);
		dialogMaster.getContentPane().add(btnEliminar);
		dialogMaster.setBounds(100, 100, 453, 203);
		dialogMaster.setLocationRelativeTo(null);
		dialogMaster.setResizable(false);
		dialogMaster.setVisible(true);
	}
	
}
