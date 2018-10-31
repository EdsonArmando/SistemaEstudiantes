package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class FormularioCatedratico extends JDialog {
	private JTextField IdCui;
	private JTextField idNombre;
	private JTextField idCorreo;
	private JTextField idContraenia;
	private String nombre,correo;
	private int cui,contrasenia;
	public FormularioCatedratico() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		JLabel lblNewLabel = new JLabel("Ingreso de Catedráticos");
		lblNewLabel.setForeground(SystemColor.activeCaptionBorder);
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		lblNewLabel.setBounds(145, 11, 166, 20);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("CUi:");
		lblNewLabel_1.setBounds(45, 55, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre:");
		lblNewLabel_2.setBounds(45, 90, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Correo:");
		lblNewLabel_3.setBounds(45, 125, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Contraseña");
		lblNewLabel_4.setBounds(45, 160, 56, 14);
		getContentPane().add(lblNewLabel_4);
		
		IdCui = new JTextField();
		IdCui.setBounds(135, 52, 86, 20);
		getContentPane().add(IdCui);
		IdCui.setColumns(10);
		
		idNombre = new JTextField();
		idNombre.setBounds(135, 87, 86, 20);
		getContentPane().add(idNombre);
		idNombre.setColumns(10);
		
		idCorreo = new JTextField();
		idCorreo.setBounds(135, 122, 86, 20);
		getContentPane().add(idCorreo);
		idCorreo.setColumns(10);
		
		idContraenia = new JTextField();
		idContraenia.setEditable(false);
		idContraenia.setBounds(135, 157, 86, 20);
		getContentPane().add(idContraenia);
		idContraenia.setColumns(10);
		JButton btnAceptar = new JButton("Cancelar");
		btnAceptar.setBounds(145, 198, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnAceptar_1 = new JButton("Aceptar");
		btnAceptar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAceptar_1.setBounds(45, 198, 89, 23);
		getContentPane().add(btnAceptar_1);
	}
}

