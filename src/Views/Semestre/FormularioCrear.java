package Views.Semestre;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Lists.ListaSemestre;
import Models.Semestre;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormularioCrear extends JDialog {
	private JTextField textField;
	ListaSemestre lista = new ListaSemestre();
	public FormularioCrear() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblIngresarSemestre = new JLabel("Ingresar Semestre");
		lblIngresarSemestre.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblIngresarSemestre.setForeground(SystemColor.activeCaptionBorder);
		lblIngresarSemestre.setBounds(155, 23, 135, 14);
		getContentPane().add(lblIngresarSemestre);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(10, 82, 46, 14);
		getContentPane().add(lblNombre);
		
		JComboBox idSemestre = new JComboBox();
		idSemestre.addItem("Semestre 1");
		idSemestre.addItem("Semestre 2");
		idSemestre.setBounds(91, 79, 86, 20);
		getContentPane().add(idSemestre);
		
		JLabel lblAo = new JLabel("Año:");
		lblAo.setBounds(10, 131, 46, 14);
		getContentPane().add(lblAo);
		
		textField = new JTextField();
		textField.setBounds(91, 128, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int anio = Integer.parseInt(textField.getText());
				String nombre = String.valueOf(idSemestre.getSelectedItem());
				Semestre semestre = new Semestre(nombre,anio);
				ListaSemestre.insertarSemestre(semestre);
				JOptionPane.showMessageDialog(null, "Semestre registrado Exitosamente");
			}
		});
		btnAceptar.setBounds(10, 202, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(113, 202, 89, 23);
		getContentPane().add(btnCancelar);
		
	}
}
