package Views;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import Lists.ListaCatedratico;
import Lists.ListaCurso;
import Lists.ListaEstudiante;
import Lists.ListaSemestre;
import Models.Catedratico;
import Models.Curso;
import Models.Estudiante;
import Models.Semestre;
import Views.Catedratico.EliminacionCatedratico;
import Views.Catedratico.FormularioCatedratico;
import Views.Catedratico.ListaCatedraticos;
import Views.Catedratico.MoificarCatedratico;
import Views.Curso.EliminarCurso;
import Views.Curso.FormularioCurso;
import Views.Curso.ListaCursos;
import Views.Estudiante.AdministrarEstudiantes;
import Views.Estudiante.ListadoEstudiantes;
import Views.Semestre.FormularioCrear;
import Views.Semestre.ListaSsemestres;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class MenuAdministrador extends JDialog {
	AdministrarEstudiantes adminEstudiantes = new AdministrarEstudiantes();
	FormularioCatedratico formCatedratico = new FormularioCatedratico();
	JDialog dialogMaster;

	public MenuAdministrador() {
		getContentPane().setEnabled(false);
		setSize(450, 400);
		setResizable(false);
		JLabel lblMenAdministrador = new JLabel("Menú Administrador");
		getContentPane().setLayout(null);
		getContentPane().add(lblMenAdministrador);

		JLabel lblNewLabel = new JLabel("Modulo Administrador");
		lblNewLabel.setForeground(SystemColor.activeCaptionBorder);
		lblNewLabel.setBackground(SystemColor.textInactiveText);
		lblNewLabel.setFont(new Font("Calibri Light", Font.PLAIN, 19));
		lblNewLabel.setEnabled(false);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(151, 22, 179, 27);
		getContentPane().add(lblNewLabel);

		JLabel lblModulos = new JLabel("Modulos");
		lblModulos.setEnabled(false);
		lblModulos.setBackground(SystemColor.activeCaptionBorder);
		lblModulos.setFont(new Font("Calibri Light", Font.PLAIN, 12));
		lblModulos.setBounds(37, 75, 88, 14);
		getContentPane().add(lblModulos);

		JButton btnEstudiantes = new JButton("Estudiantes");
		btnEstudiantes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminEstudiantes.setVisible(true);
				adminEstudiantes.setLocationRelativeTo(null);
			}
		});
		btnEstudiantes.setBounds(37, 108, 102, 23);
		getContentPane().add(btnEstudiantes);

		JButton btnCatdraticos = new JButton("Catedráticos");
		btnCatdraticos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminCatedraticos();
			}
		});
		btnCatdraticos.setBounds(37, 155, 102, 23);
		getContentPane().add(btnCatdraticos);

		JButton btnNewButton = new JButton("Cursos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administrarCursos();
			}
		});
		btnNewButton.setBounds(37, 202, 102, 23);
		getContentPane().add(btnNewButton);

		JButton btnCargaMasiva = new JButton("Semestres");
		btnCargaMasiva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				administrarSemestres();
			}
		});
		btnCargaMasiva.setBounds(37, 249, 102, 23);
		getContentPane().add(btnCargaMasiva);

		JButton btnNewButton_1 = new JButton("CargaMasiva");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String aux = "";
				String texto = "";
				JFileChooser chooser = new JFileChooser("CargaMasiva");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif", "swag",
						"SWAG");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(getContentPane());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					File abre=chooser.getSelectedFile();
					FileReader archivos = null;
					try {
						archivos = new FileReader(abre);
					} catch (FileNotFoundException e3) {
						e3.printStackTrace();
					}
					BufferedReader lee=new BufferedReader(archivos);
					 try {
						while((aux=lee.readLine())!=null)
						  {
						     texto+= aux+ "\n";
						  }
					} catch (IOException e2) {
						e2.printStackTrace();
					}
				         try {
							lee.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
				         leerLineas(texto);
				}
			}
		});
		btnNewButton_1.setBounds(37, 296, 102, 23);
		getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(
				"C:\\Users\\Armando\\Documents\\Edson\\EclipseEE\\SistemaEstudiantes\\src\\Image\\admin.png"));
		lblNewLabel_1.setBounds(208, 75, 206, 207);
		getContentPane().add(lblNewLabel_1);

		JButton btnReportes = new JButton("Reportes");
		btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reportes repo = new Reportes();
				repo.setVisible(true);
				repo.setResizable(false);
				repo.setLocationRelativeTo(null);
			}
		});
		btnReportes.setBounds(37, 337, 102, 23);
		getContentPane().add(btnReportes);
	}

	public void adminCatedraticos() {
		dialogMaster = new JDialog();
		dialogMaster.getContentPane().setLayout(null);

		JLabel lblAdministrarEstudiantes = new JLabel("Administrar Catedráticos");
		lblAdministrarEstudiantes.setForeground(SystemColor.activeCaptionBorder);
		lblAdministrarEstudiantes.setBackground(SystemColor.activeCaptionBorder);
		lblAdministrarEstudiantes.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		lblAdministrarEstudiantes.setBounds(132, 11, 180, 14);
		dialogMaster.getContentPane().add(lblAdministrarEstudiantes);

		JButton btnAgregarUsuario = new JButton("Agregar");
		btnAgregarUsuario.setBounds(65, 46, 111, 23);
		dialogMaster.getContentPane().add(btnAgregarUsuario);
		btnAgregarUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				formCatedratico.formularioCrear();
			}

		});

		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MoificarCatedratico modificar = new MoificarCatedratico();
				modificar.setVisible(true);
				modificar.setLocationRelativeTo(null);
				modificar.setResizable(false);
			}
		});
		btnNewButton.setBounds(65, 97, 111, 23);
		dialogMaster.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Visualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaCatedraticos listaNueva = new ListaCatedraticos();
				listaNueva.setVisible(true);
				listaNueva.setLocationRelativeTo(null);
				listaNueva.setResizable(false);
			}
		});
		btnNewButton_1.setBounds(256, 46, 111, 23);
		dialogMaster.getContentPane().add(btnNewButton_1);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(256, 97, 111, 23);
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EliminacionCatedratico eliminar = new EliminacionCatedratico();
				eliminar.setVisible(true);
				eliminar.setLocationRelativeTo(null);
				eliminar.setResizable(false);
			}

		});
		dialogMaster.getContentPane().add(btnEliminar);
		dialogMaster.setBounds(100, 100, 453, 203);
		dialogMaster.setLocationRelativeTo(null);
		dialogMaster.setResizable(false);
		dialogMaster.setVisible(true);
	}

	public void administrarCursos() {
		dialogMaster = new JDialog();
		dialogMaster.getContentPane().setLayout(null);

		JLabel lblAdministrarEstudiantes = new JLabel("Administrar Cursos");
		lblAdministrarEstudiantes.setForeground(SystemColor.activeCaptionBorder);
		lblAdministrarEstudiantes.setBackground(SystemColor.activeCaptionBorder);
		lblAdministrarEstudiantes.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		lblAdministrarEstudiantes.setBounds(132, 11, 180, 14);
		dialogMaster.getContentPane().add(lblAdministrarEstudiantes);

		JButton btnAgregarUsuario = new JButton("Agregar");
		btnAgregarUsuario.setBounds(65, 46, 111, 23);
		btnAgregarUsuario.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
			FormularioCurso form = new FormularioCurso();
			form.setVisible(true);
			form.setResizable(false);
			form.setLocationRelativeTo(null);
			}
			
		});
		dialogMaster.getContentPane().add(btnAgregarUsuario);

		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(65, 97, 111, 23);
		dialogMaster.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Visualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaCursos lista = new ListaCursos();
				lista.setVisible(true);
				lista.setResizable(false);
				lista.setLocationRelativeTo(null);
			}
		});
		btnNewButton_1.setBounds(256, 46, 111, 23);
		dialogMaster.getContentPane().add(btnNewButton_1);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(256, 97, 111, 23);
		btnEliminar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				EliminarCurso listas = new EliminarCurso();
				listas.setVisible(true);
				listas.setResizable(false);
				listas.setLocationRelativeTo(null);
			}
		});
		dialogMaster.getContentPane().add(btnEliminar);
		dialogMaster.setBounds(100, 100, 453, 203);
		dialogMaster.setLocationRelativeTo(null);
		dialogMaster.setResizable(false);
		dialogMaster.setVisible(true);
	}

	public void administrarSemestres() {
		dialogMaster = new JDialog();
		dialogMaster.getContentPane().setLayout(null);

		JLabel lblAdministrarEstudiantes = new JLabel("Administrar Semestres");
		lblAdministrarEstudiantes.setForeground(SystemColor.activeCaptionBorder);
		lblAdministrarEstudiantes.setBackground(SystemColor.activeCaptionBorder);
		lblAdministrarEstudiantes.setFont(new Font("Calibri Light", Font.PLAIN, 16));
		lblAdministrarEstudiantes.setBounds(132, 11, 180, 14);
		dialogMaster.getContentPane().add(lblAdministrarEstudiantes);

		JButton btnAgregarUsuario = new JButton("Agregar");
		btnAgregarUsuario.setBounds(65, 46, 111, 23);
		btnAgregarUsuario.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				FormularioCrear form = new FormularioCrear();
				form.setVisible(true);
				form.setLocationRelativeTo(null);
				form.setResizable(false);
			}

		});
		dialogMaster.getContentPane().add(btnAgregarUsuario);

		JButton btnNewButton = new JButton("Modificar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(65, 97, 111, 23);
		dialogMaster.getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Visualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaSsemestres lista = new ListaSsemestres();
				lista.setVisible(true);
				lista.setResizable(false);
				lista.setLocationRelativeTo(null);
			}
		});
		btnNewButton_1.setBounds(256, 46, 111, 23);
		dialogMaster.getContentPane().add(btnNewButton_1);

		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(256, 97, 111, 23);
		btnEliminar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}

		});
		dialogMaster.getContentPane().add(btnEliminar);
		dialogMaster.setBounds(100, 100, 453, 203);
		dialogMaster.setLocationRelativeTo(null);
		dialogMaster.setResizable(false);
		dialogMaster.setVisible(true);
	}
	static void leerLineas(String superTexto) {
		ListaEstudiante lista = new ListaEstudiante();
		ListaCatedratico lista2 = new ListaCatedratico();
		ListaSemestre lista3 = new ListaSemestre();
		ListaCurso lista4 = new ListaCurso();
		String nombre = null, identificador = null, carne = null, creditos = null, correo = null,anio=null;
		String  seccion=null,pre=null,post=null;
		int credito=0,codigo=0;
		String lineas[] = superTexto.split("\n");
		for (String linea : lineas) {
			if (linea != "") {
				String[] Clave_Valor = linea.split("#");
				if (Clave_Valor.length == 5) {
					carne = Clave_Valor[0];
					identificador = Clave_Valor[1];
					nombre = Clave_Valor[2];
					correo = Clave_Valor[3];
					creditos = Clave_Valor[4];
					Estudiante estudiante = new Estudiante(Integer.parseInt(carne),identificador,nombre,correo,Integer.parseInt(creditos),Integer.parseInt(contrasenia(carne,identificador)));
					ListaEstudiante.insertarEstudiante(estudiante);
				}else if(Clave_Valor.length == 3){
					identificador = Clave_Valor[0];
					nombre = Clave_Valor[1];
					correo = Clave_Valor[2];
					Catedratico catedratico = new Catedratico(identificador,nombre,correo,contraseniaCate(identificador,nombre));
					ListaCatedratico.ingresarCatedratico(catedratico);
				}else if(Clave_Valor.length == 2){
					nombre = Clave_Valor[0];
					anio = Clave_Valor[1];
					Semestre semestre = new Semestre(nombre,Integer.parseInt(anio));
					ListaSemestre.insertarSemestre(semestre);
				}else if(Clave_Valor.length==7){
					codigo = Integer.parseInt(Clave_Valor[0]);
					nombre = Clave_Valor[1];
					identificador = Clave_Valor[2];
					credito = Integer.parseInt(Clave_Valor[3]);
					seccion = Clave_Valor[4];
					pre = Clave_Valor[5];
					post = Clave_Valor[6];
					Curso curso = new Curso(codigo,nombre,identificador,credito,seccion,pre,post);
					ListaCurso.insertarCurso(curso);
				}
			}
		}
	}
	private static String contraseniaCate(String cui, String nombre){
		String contra = null;
		try{
			String uno = String.valueOf(cui.charAt(0))+String.valueOf(cui.charAt(1))+
					String.valueOf(cui.charAt(2))+String.valueOf(cui.charAt(3));
					String dos = String.valueOf(nombre.charAt(0))+String.valueOf(nombre.charAt(1)
							+String.valueOf(nombre.charAt(2)));
					contra=uno+dos;
		}catch(java.lang.StringIndexOutOfBoundsException e){
			JOptionPane.showMessageDialog(null, "LLene correctamente los campos");
		}
		return contra;
	}
	private static String contrasenia(String carneess, String cui){
		String uno = String.valueOf(carneess.charAt(5))+String.valueOf(carneess.charAt(6))+
		String.valueOf(carneess.charAt(7))+String.valueOf(carneess.charAt(8));
		String dos = String.valueOf(cui.charAt(0))+String.valueOf(cui.charAt(1));
		String contra=uno+dos;
		return contra;
	}
}
