package Views;

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

public class Reportes extends JDialog {
	public Reportes() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblReportes = new JLabel("Reportes");
		lblReportes.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblReportes.setForeground(SystemColor.activeCaptionBorder);
		lblReportes.setBounds(186, 11, 74, 14);
		getContentPane().add(lblReportes);
		
		JLabel lblReporteEstudiantes = new JLabel("Reporte Estudiantes:");
		lblReporteEstudiantes.setBounds(10, 85, 108, 14);
		getContentPane().add(lblReporteEstudiantes);
		
		JButton button = new JButton("");
		button.setForeground(SystemColor.controlHighlight);
		button.setBounds(128, 81, 89, 23);
		getContentPane().add(button);
		
		JLabel lblNewLabel = new JLabel("Resumen Estudiante:");
		lblNewLabel.setBounds(10, 134, 108, 14);
		getContentPane().add(lblNewLabel);
		
		JButton button_1 = new JButton("");
		button_1.setBounds(128, 134, 89, 23);
		getContentPane().add(button_1);
		
		JLabel lblNewLabel_1 = new JLabel("Reporte Catedrático:");
		lblNewLabel_1.setBounds(10, 183, 108, 14);
		getContentPane().add(lblNewLabel_1);
		
		JButton button_2 = new JButton("");
		button_2.setBounds(128, 179, 89, 23);
		getContentPane().add(button_2);
		
		JLabel lblD = new JLabel("");
		lblD.setIcon(new ImageIcon(Reportes.class.getResource("/Image/reportes.png")));
		lblD.setBounds(227, 36, 197, 214);
		getContentPane().add(lblD);
		
	}
}
