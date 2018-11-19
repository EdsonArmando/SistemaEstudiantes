package Views.Catedratico;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Lists.ListaAsignacionCurso;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class FormIngresarNotas extends JDialog  {
	private JTextField idZona;
	private JTextField idExamen;
	private JTextField idTotal;
	ListaAsignacionCurso ingresarNota = new ListaAsignacionCurso();
	public FormIngresarNotas(int carne,String curso) {
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
		idExamen.addMouseListener(new MouseAdapter(){

			@Override
			public void mousePressed(MouseEvent  ev) {
				int nota = Integer.parseInt(idZona.getText());
				if(nota <36){
					idExamen.setEnabled(false);
					idExamen.setText("0");
				}else if(nota >=36 && nota<=75){
					idExamen.setEnabled(true);
				}
			}
			
		});
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(10, 201, 46, 14);
		getContentPane().add(lblTotal);
		
		idTotal = new JTextField();
		idTotal.addMouseListener(new MouseListener(){
			@Override
			public void mouseClicked(MouseEvent e) {
				int total = Integer.parseInt(idZona.getText())+Integer.parseInt(idExamen.getText());
				idTotal.setText(String.valueOf(total));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
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
				if(examen>25){
					JOptionPane.showMessageDialog(null, "El examen no debe exeder los 25 pts");
				}else{
					ListaAsignacionCurso.ingresarNota(carne, zona, examen, total,curso);
				}
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
