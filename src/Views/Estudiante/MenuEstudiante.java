package Views.Estudiante;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuEstudiante extends JDialog {
	public void  MenuEstudiante() {
		JDialog uno = new JDialog();
		uno.setSize(450,400);
		uno.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu Estudiantes");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblNewLabel.setForeground(SystemColor.activeCaptionBorder);
		lblNewLabel.setBounds(164, 25, 134, 14);
		uno.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ver Cursos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 120, 89, 23);
		uno.add(btnNewButton);
		
		JButton btnAsignar = new JButton("Asignar");
		btnAsignar.setBounds(10, 181, 89, 23);
		uno.add(btnAsignar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MenuEstudiante.class.getResource("/Image/Estudiante2.jpg")));
		lblNewLabel_1.setBounds(153, 76, 259, 230);
		uno.add(lblNewLabel_1);
		uno.setVisible(true);
		uno.setLocationRelativeTo(null);
		uno.setResizable(false);
	}
}
