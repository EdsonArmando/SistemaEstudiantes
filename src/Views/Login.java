package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Lists.Lista;
import Lists.ListaCatedratico;
import Lists.ListaEstudiante;
import Models.Administrador;
import Views.Catedratico.MenuCatedratico;
import Views.Estudiante.MenuEstudiante;
public class Login {
	JFrame inicio=new JFrame();
	Lista lista = new Lista();
	ListaEstudiante listaEstudinate = new ListaEstudiante();
	ListaCatedratico lista2 = new ListaCatedratico();
	MenuEstudiante menu = new MenuEstudiante();
	MenuCatedratico menu2 = new MenuCatedratico();
	public void inicio() {
		Administrador admin = new Administrador("admin","admin","admin");
		lista.agregarNodo(admin);
		JButton boton1 = new JButton("About");
		JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel panel2 = new JPanel();
		ImageIcon logo = new ImageIcon("Image.jpg");
		ImageIcon logo2 = new ImageIcon("Image01.jpg");
		JLabel image = new JLabel(logo);
		JLabel image2 = new JLabel(logo2);
		image.setSize(350,350);
		image2.setSize(75,75);
		Icon icono = new ImageIcon(logo.getImage().getScaledInstance(image.getWidth(), image.getHeight(), Image.SCALE_DEFAULT));
		Icon icono2 = new ImageIcon(logo2.getImage().getScaledInstance(image2.getWidth(), image2.getHeight(), Image.SCALE_DEFAULT));
		image.setIcon(icono);
		image2.setIcon(icono2);
		JButton login;
		JPanel panel1;
		JLabel titulo;
		panel2.add(image);
		panel2.setBackground(Color.WHITE);
		panel2.setLayout(new GridBagLayout());
		panel2.add(image);
		panel2.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		panel2.setPreferredSize(new Dimension(350,200));
		panel1 = new JPanel();
		titulo = new JLabel("Sistema Estudiantes");
		titulo.setFont(new Font("Tahoma",0,35));
		panel1.setBackground(Color.WHITE);
		inicio = new JFrame("Sistema Gestión");
		login = new JButton("Login");
		panel1.setPreferredSize(new Dimension(0,100));
		panel1.setLayout(new FlowLayout());
		titulo.setHorizontalAlignment(JLabel.CENTER);
		titulo.setVerticalAlignment(JLabel.CENTER);
		inicio.setLayout(new BorderLayout());
		panel1.add(titulo);
		panel1.add(login);
		panel1.add(image2);
		login.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				formularioLogin();
			}
			
		});
		panel4.add(boton1);
		panel4.setBackground(Color.black);
		inicio.add(panel4, BorderLayout.SOUTH);
		inicio.add(panel2, BorderLayout.CENTER);
		inicio.add(panel1, BorderLayout.NORTH);
		inicio.setVisible(true);
		inicio.setSize(550, 600);
		inicio.setLocationRelativeTo(null);
	}
	public void formularioLogin(){
		JPanel login;
		JDialog ventanaLogin;
		JLabel usuario, contraseña;
		JTextField user;
		JPasswordField contra;
		JButton aceptar, cancelar;
		login = new JPanel();
		ventanaLogin = new JDialog();
		login.setLayout(null);
		usuario = new JLabel("Usuario");
		usuario.setBounds(10, 20, 80, 20);
		contraseña = new JLabel("Password");
		contraseña.setBounds(10, 50, 80, 20);
		user = new JTextField();
		user.setBounds(100, 20, 80, 20);
		contra = new JPasswordField();
		contra.setBounds(100, 50, 80, 20);
		cancelar = new JButton("Cancelar");
		cancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaLogin.dispose();
			}
		});
		aceptar = new JButton("Aceptar");
		aceptar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String password;
				String username = user.getText();
				password = contra.getText();
				boolean veri2 = esEntero(password);
				boolean verificar = esEntero(username);
				if(verificar==true && veri2==true){
					boolean log1 = ListaEstudiante.loginEstudiante(username, password);
					if(log1==true){
						menu.MenuEstudiante();
					}else{
						JOptionPane.showMessageDialog(null,"Verifique sus credenciales");
					}
				}else if(verificar==true&& veri2==false){
					boolean login2 = ListaCatedratico.loginCatedratico(username, password);
					if(login2==true){
						JOptionPane.showMessageDialog(null,"Bienvenido al sistema");
						menu2.menuCatedraticos();
					}else{
						JOptionPane.showMessageDialog(null,"Verifique sus credenciales");
					}
				}else{
					lista.login(username, password);
				}
			}
		});
		aceptar.setBounds(200, 20, 80, 20);
		cancelar.setBounds(200, 50, 80, 20);
		aceptar.setBounds(200, 20, 80, 20);
		cancelar.setBounds(200, 50, 80, 20);
		login.add(usuario);
		login.add(cancelar);
		login.add(contra);
		login.add(user);
		login.add(contraseña);
		login.add(aceptar);
		ventanaLogin.add(login);
		ventanaLogin.setVisible(true);
		ventanaLogin.setSize(300, 150);
		ventanaLogin.setLocationRelativeTo(null);
	}
	public static boolean esEntero(String carnet) {
		String uno = String.valueOf(carnet.charAt(0))+String.valueOf(carnet.charAt(1))+
				String.valueOf(carnet.charAt(2))+String.valueOf(carnet.charAt(3)+String.valueOf(carnet.charAt(4)));
		boolean resultado;
		try {
			Integer.parseInt(uno);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}
		return resultado;
	}

}
