package Views.Estudiante;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Lists.ListaEstudiante;
import Models.Estudiante;
import Nodes.Nodo;
import Nodes.NodoEstudiante;

public class FormularioModificar {
	ListaEstudiante listaEstudiante = new ListaEstudiante();
	private String nombre,correo,cui;
	private int carne,noCreditos,contrasenia;
	private NodoEstudiante primero = listaEstudiante.getPrimero();
	private NodoEstudiante ultimo = listaEstudiante.getUltimo();
	JTextField idCarne;
	JTextField IdCui;
	JTextField idNombre;
	JTextField idCorreo;
	JTextField idCreditos;
	JTextField idContraenia;
	Estudiante estudiante;
	public void modificar(int carnet){
		JDialog dialogUsuario = new JDialog();
		JPanel panelUsuario = new JPanel();
		panelUsuario.setLayout(null);
		JLabel lblNewLabel = new JLabel("Modificación de Estudiantes");
		lblNewLabel.setForeground(SystemColor.activeCaptionBorder);
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		lblNewLabel.setBounds(164, 11, 128, 20);
		panelUsuario.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Carne:");
		lblNewLabel_1.setBounds(45, 55, 46, 14);
		panelUsuario.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("CUI:");
		lblNewLabel_2.setBounds(45, 90, 46, 14);
		panelUsuario.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre:");
		lblNewLabel_3.setBounds(45, 125, 46, 14);
		panelUsuario.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Correo:");
		lblNewLabel_4.setBounds(45, 160, 46, 14);
		panelUsuario.add(lblNewLabel_4);
		
		JLabel lblNoCrditos = new JLabel("No. Créditos:");
		lblNoCrditos.setBounds(45, 195, 64, 14);
		panelUsuario.add(lblNoCrditos);
		
		JLabel lblNewLabel_5 = new JLabel("Contraseña:");
		lblNewLabel_5.setBounds(45, 230, 64, 14);
		panelUsuario.add(lblNewLabel_5);
		primero = ultimo;
		do{
			if(primero.getEstudiante().getCarne()==carnet){
		idCarne = new JTextField();
		idCarne.setText(Integer.toString(primero.getEstudiante().getCarne()));
		idCarne.setBounds(135, 52, 86, 20);
		panelUsuario.add(idCarne);
		idCarne.setColumns(10);
		
		IdCui = new JTextField();
		IdCui.setText(primero.getEstudiante().getCui());
		IdCui.setBounds(135, 87, 86, 20);
		panelUsuario.add(IdCui);
		IdCui.setColumns(10);
		
		idNombre = new JTextField();
		idNombre.setText(primero.getEstudiante().getNombre());
		idNombre.setBounds(135, 118, 86, 20);
		panelUsuario.add(idNombre);
		idNombre.setColumns(10);
		
		idCorreo = new JTextField();
		idCorreo.setText(primero.getEstudiante().getCorreo());
		idCorreo.setBounds(135, 154, 86, 20);
		panelUsuario.add(idCorreo);
		idCorreo.setColumns(10);
		
		idCreditos = new JTextField();
		idCreditos.setText(Integer.toString(primero.getEstudiante().getNoCreditos()));
		idCreditos.setBounds(135, 189, 86, 20);
		panelUsuario.add(idCreditos);
		idCreditos.setColumns(10);
		
		idContraenia = new JTextField();
		idContraenia.setText(Integer.toString(primero.getEstudiante().getContrasenia()));
		idContraenia.setEditable(false);
		idContraenia.setBounds(135, 224, 86, 20);
		panelUsuario.add(idContraenia);
		idContraenia.setColumns(10);
		idContraenia.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				idContraenia.setText("123456789");
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
		});
			}
			primero = primero.Anterior;
		}while(primero !=ultimo);
		JButton btnAceptar = new JButton("Cancelar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialogUsuario.dispose();
			}
		});
		btnAceptar.setBounds(250, 221, 89, 23);
		panelUsuario.add(btnAceptar);
		
		JButton btnAceptar_1 = new JButton("Aceptar");
		btnAceptar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cui = IdCui.getText();
				nombre = idNombre.getText();
				correo = idCorreo.getText();
				try{
					carne = Integer.parseInt(idCarne.getText());
					noCreditos = Integer.parseInt(idCreditos.getText());
					contrasenia = Integer.parseInt(idContraenia.getText());
				}catch( java.lang.NumberFormatException es){
					JOptionPane.showMessageDialog(null, "LLene los campos");
				}
				do{
					if(primero.getEstudiante().getCarne()==carne){
						primero.getEstudiante().setNombre(nombre);
						primero.getEstudiante().setCarne(carne);
						primero.getEstudiante().setCui(cui);
						primero.getEstudiante().setNoCreditos(noCreditos);
						primero.getEstudiante().setCorreo(correo);
						primero.getEstudiante().setContrasenia(contrasenia);
					}
					primero = primero.Anterior;
				}while(primero !=ultimo);
			}
		});
		
		btnAceptar_1.setBounds(250, 177, 89, 23);
		panelUsuario.add(btnAceptar_1);
		dialogUsuario.add(panelUsuario);
		dialogUsuario.setLocationRelativeTo(null);
		dialogUsuario.setSize(450, 350);
		dialogUsuario.setVisible(true);
		dialogUsuario.setLocationRelativeTo(null);
	}
}
