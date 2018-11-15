package Views.Catedratico;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Views.Estudiante.MenuEstudiante;

public class MenuCatedratico extends JDialog {
	public void menuCatedraticos(String cui) {
		JDialog uno = new JDialog();
		uno.setSize(450,400);
		uno.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menú Catedráticos");
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblNewLabel.setForeground(SystemColor.activeCaptionBorder);
		lblNewLabel.setBounds(164, 25, 154, 14);
		uno.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Ingresar Notas");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IngresarNotas notas = new IngresarNotas(cui);
				notas.setVisible(true);
				notas.setResizable(false);
				notas.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setBounds(10, 120, 89, 25);
		uno.add(btnNewButton);
		
		JButton btnAsignar = new JButton("Salir");
		btnAsignar.setBounds(10, 181, 89, 25);
		uno.add(btnAsignar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MenuEstudiante.class.getResource("/Image/catedratico.jpg")));
		lblNewLabel_1.setBounds(153, 76, 259, 230);
		uno.add(lblNewLabel_1);
		uno.setVisible(true);
		uno.setLocationRelativeTo(null);
		uno.setResizable(false);
	}

}
