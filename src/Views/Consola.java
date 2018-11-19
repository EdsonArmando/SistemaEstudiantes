package Views;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Consola extends JDialog {
	public Consola() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		JTextArea idMensajes = new JTextArea();
		idMensajes.setText("Nombre: Edson Guix\r\nCarne: 201701029\r\nIPC1-A");
		idMensajes.setBounds(10, 11, 312, 239);
		getContentPane().add(idMensajes);
		
	}
}
