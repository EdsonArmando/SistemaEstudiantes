package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdministrarEstudiantes extends JDialog {
	FormularioCrear formulario = new FormularioCrear();
	public AdministrarEstudiantes() {
		getContentPane().setLayout(null);
		
		JLabel lblAdministrarEstudiantes = new JLabel("Administrar Estudiantes");
		lblAdministrarEstudiantes.setForeground(SystemColor.activeCaptionBorder);
		lblAdministrarEstudiantes.setBackground(SystemColor.activeCaptionBorder);
		lblAdministrarEstudiantes.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		lblAdministrarEstudiantes.setBounds(132, 11, 160, 14);
		getContentPane().add(lblAdministrarEstudiantes);
		
		JButton btnAgregarUsuario = new JButton("Agregar Usuario");
		btnAgregarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formulario.setVisible(true);
				formulario.setLocationRelativeTo(null);
				formulario.setResizable(false);
			}
		});
		btnAgregarUsuario.setBounds(65, 46, 111, 23);
		getContentPane().add(btnAgregarUsuario);
		
		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(65, 97, 111, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Visualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBounds(256, 46, 111, 23);
		getContentPane().add(btnNewButton_1);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(256, 97, 111, 23);
		getContentPane().add(btnEliminar);
		setBounds(100, 100, 453, 203);
		setResizable(false);
	}
	
}
