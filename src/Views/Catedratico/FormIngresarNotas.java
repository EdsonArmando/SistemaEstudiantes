package Views.Catedratico;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Lists.ListaAsignacionCurso;

import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormIngresarNotas extends JDialog {
	private JTextField idZona;
	private JTextField idExamen;
	private JTextField idTotal;
	ListaAsignacionCurso ingresarNota = new ListaAsignacionCurso();
	public FormIngresarNotas(int carne) {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JLabel lblIngresoDeNotas = new JLabel("Ingreso de Notas");
		lblIngresoDeNotas.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblIngresoDeNotas.setForeground(SystemColor.activeCaptionBorder);
		lblIngresoDeNotas.setBounds(144, 11, 126, 14);
		getContentPane().add(lblIngresoDeNotas);
		
		JLabel lblZona = new JLabel("Zona:");
		lblZona.setBounds(10, 79, 46, 14);
		getContentPane().add(lblZona);
		
		idZona = new JTextField();
		idZona.setBounds(66, 76, 86, 20);
		getContentPane().add(idZona);
		idZona.setColumns(10);
		
		JLabel lblExamen = new JLabel("Examen:");
		lblExamen.setBounds(10, 140, 46, 14);
		getContentPane().add(lblExamen);
		
		idExamen = new JTextField();
		idExamen.setBounds(66, 137, 86, 20);
		getContentPane().add(idExamen);
		idExamen.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(10, 201, 46, 14);
		getContentPane().add(lblTotal);
		
		//int total = Integer.parseInt(idZona.getText())+Integer.parseInt(idExamen.getText());
		idTotal = new JTextField();
		idTotal.setText("Hola");
		idTotal.setEnabled(false);
		idTotal.setBounds(66, 198, 86, 20);
		getContentPane().add(idTotal);
		idTotal.setColumns(10);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int zona=Integer.parseInt(idZona.getText());
				int examen = Integer.parseInt(idExamen.getText());
				int total = zona+examen;
				ListaAsignacionCurso.ingresarNota(carne, zona, examen, total);
			}
		});
		btnAceptar.setBounds(204, 197, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(303, 197, 89, 23);
		getContentPane().add(btnCancelar);
		
	}
}
