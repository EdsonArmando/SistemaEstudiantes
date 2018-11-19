package Views.Reporte;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Lists.ListaAsignacionCurso;
import Lists.ListaEstudiante;
import Nodes.NodoAsignacion;

public class ReporteCatedratico extends JDialog {
	private NodoAsignacion primero = ListaAsignacionCurso.getPrimero();
	JTable tabla;
	JTextField idCui;
	public ReporteCatedratico() {
		DefaultTableModel modelo = new DefaultTableModel();
		 modelo.addColumn("Curso");
		 modelo.addColumn("Semestre");
		 modelo.addColumn("Estudiantes que Ganaron");
		 modelo.addColumn("Estudiantes que % Ganaron");
		 modelo.addColumn("Estudiantes que Perdieron");
		 modelo.addColumn("Estudiantes que % Perdieron");
		 modelo.addColumn("No llegaron a zona minima");
		 modelo.addColumn("Nota máxima");
		 modelo.addColumn("Nota mínima");
		 modelo.addColumn("Promedio de Notas");
		 modelo.addColumn("Total Asignados");
					 Object[] fila=new Object[11];
					
			 tabla = new JTable(modelo);
			 tabla.setPreferredScrollableViewportSize(new Dimension(200,200));
			 JScrollPane scroll = new JScrollPane(tabla);
			 scroll.setSize(1264, 100);
			 scroll.setLocation(10, 96);
			 
		setBounds(100, 100, 1300, 300);
		getContentPane().setLayout(null);
		
		
		tabla.setBounds(10, 125, 414, 100);
		getContentPane().add(scroll);

		JLabel lblListadoDeUsuaros = new JLabel("Reporte de Catedráticos");
		lblListadoDeUsuaros.setForeground(SystemColor.activeCaptionBorder);
		lblListadoDeUsuaros.setFont(new Font("Calibri Light", Font.PLAIN, 18));
		lblListadoDeUsuaros.setBounds(10, 21, 191, 23);
		getContentPane().add(lblListadoDeUsuaros);
		
		JLabel lblCurso = new JLabel("CUI:");
		lblCurso.setBounds(10, 71, 46, 14);
		getContentPane().add(lblCurso);
		JButton btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NodoAsignacion puntero=primero;
				String nombre=null;
				while(puntero != null){
					if(puntero.getAsignacion().getCuiCatedratico().equals(idCui.getText())){
						if(puntero.getAsignacion().getCurso().equals(nombre)){
							
						}else{
							 fila[0] = puntero.getAsignacion().getCurso();
							 fila[1] = semestre(idCui.getText());
							 fila[2] = ganaron(idCui.getText(),puntero.getAsignacion().getCurso(),puntero.getAsignacion().getSeccion());
							 fila[3] = (ganaron(idCui.getText(),puntero.getAsignacion().getCurso(),puntero.getAsignacion().getSeccion())/totalAsignados(idCui.getText(),puntero.getAsignacion().getCurso(),puntero.getAsignacion().getSeccion())*100);
							 fila[4] = perdieron(idCui.getText(),puntero.getAsignacion().getCurso(),puntero.getAsignacion().getSeccion());
							 fila[5] = (perdieron(idCui.getText(),puntero.getAsignacion().getCurso(),puntero.getAsignacion().getSeccion())/totalAsignados(idCui.getText(),puntero.getAsignacion().getCurso(),puntero.getAsignacion().getSeccion())*100);
							 fila[6] = zonaMinima(idCui.getText(),puntero.getAsignacion().getCurso(),puntero.getAsignacion().getSeccion());
							 fila[7] = notaMaxima(idCui.getText(),puntero.getAsignacion().getCurso(),puntero.getAsignacion().getSeccion());
							 fila[8] = notaMinima(idCui.getText(),puntero.getAsignacion().getCurso(),puntero.getAsignacion().getSeccion());
							 fila[9] = (totalNotas(idCui.getText(),puntero.getAsignacion().getCurso(),puntero.getAsignacion().getSeccion()))/totalAsignados(idCui.getText(),puntero.getAsignacion().getCurso(),puntero.getAsignacion().getSeccion());
							 fila[10] = totalAsignados(idCui.getText(),puntero.getAsignacion().getCurso(),puntero.getAsignacion().getSeccion());
							 nombre = puntero.getAsignacion().getCurso();
							 modelo.addRow(fila);
						}
					}
					puntero = puntero.siguiente;
				}		
			}
		});
		btnMostrar.setBounds(1185, 207, 89, 23);
		getContentPane().add(btnMostrar);
		
		idCui = new JTextField();
		idCui.setText("");
		idCui.setBounds(66, 65, 86, 20);
		getContentPane().add(idCui);
		idCui.setColumns(10);
	}
	public String curso(String cui){
		String nombreCurso=null;
		NodoAsignacion puntero=primero;
		while(puntero != null){
			if(puntero.getAsignacion().getCuiCatedratico().equals(cui)){
				nombreCurso=puntero.getAsignacion().getCurso();
			}
			puntero = puntero.siguiente;
		}		
		return nombreCurso;
	}
	public String semestre(String cui){
		String nombreSemestre=null;
		NodoAsignacion puntero=primero;
		while(puntero != null){
			if(puntero.getAsignacion().getCuiCatedratico().equals(cui)){
				nombreSemestre=puntero.getAsignacion().getSemestre()+" "+puntero.getAsignacion().getAnio();
			}
			puntero = puntero.siguiente;
		}
		return nombreSemestre;
	}
	public int ganaron(String cui,String curso, String seccion){
		int ganaron=0;
		NodoAsignacion puntero=primero;
		while(puntero != null){
			if(puntero.getAsignacion().getCuiCatedratico().equals(cui)&& puntero.getAsignacion().getCurso().equals(curso)
					&& puntero.getAsignacion().getSeccion().equals(seccion)&& puntero.getAsignacion().isAprobado()==true){
				ganaron++;
			}
			puntero = puntero.siguiente;
		}
		return ganaron;
	}
	public int perdieron(String cui, String curso, String seccion){
		int ganaron=0;
		NodoAsignacion puntero=primero;
		while(puntero != null){
			if(puntero.getAsignacion().getCuiCatedratico().equals(cui)&& puntero.getAsignacion().getCurso().equals(curso)
					&& puntero.getAsignacion().getSeccion().equals(seccion)&& puntero.getAsignacion().isAprobado()==false){
				ganaron++;
			}
			puntero = puntero.siguiente;
		}
		return ganaron;
	}
	public int zonaMinima(String cui, String curso, String seccion){
		int ganaron=0;
		NodoAsignacion puntero=primero;
		while(puntero != null){
			if(puntero.getAsignacion().getCuiCatedratico().equals(cui)&& puntero.getAsignacion().getCurso().equals(curso)
					&& puntero.getAsignacion().getSeccion().equals(seccion)&& puntero.getAsignacion().isAprobado()==false
					&& puntero.getAsignacion().getZona()<36){
				ganaron++;
			}
			puntero = puntero.siguiente;
		}
		return ganaron;
	}
	public int totalAsignados(String cui,String curso, String seccion){
		int ganaron=0;
		NodoAsignacion puntero=primero;
		while(puntero != null){
			if(puntero.getAsignacion().getCuiCatedratico().equals(cui)&& puntero.getAsignacion().getCurso().equals(curso)
					&& puntero.getAsignacion().getSeccion().equals(seccion)){
				ganaron++;
			}
			puntero = puntero.siguiente;
		}
		return ganaron;
	}
	public int notaMaxima(String cui,String curso, String seccion){
		int maxima=0;
		NodoAsignacion puntero=primero;
		while(puntero != null){
			if(puntero.getAsignacion().getCuiCatedratico().equals(cui)&& puntero.getAsignacion().getCurso().equals(curso)
					&& puntero.getAsignacion().getSeccion().equals(seccion)){
				if(maxima==0){
					maxima=puntero.getAsignacion().getNotaTotal();
				}else if(puntero.getAsignacion().getNotaTotal() >maxima){
					maxima=puntero.getAsignacion().getNotaTotal();
				}else{
					
				}
			}
			puntero = puntero.siguiente;
		}
		return maxima;
	}
	public int notaMinima(String cui,String curso, String seccion){
		int maxima=0;
		NodoAsignacion puntero=primero;
		while(puntero != null){
			if(puntero.getAsignacion().getCuiCatedratico().equals(cui)&& puntero.getAsignacion().getCurso().equals(curso)
					&& puntero.getAsignacion().getSeccion().equals(seccion)){
				if(maxima==0){
					maxima=puntero.getAsignacion().getNotaTotal();
				}else if(puntero.getAsignacion().getNotaTotal() <maxima){
					maxima=puntero.getAsignacion().getNotaTotal();
				}else{
					
				}
			}
			puntero = puntero.siguiente;
		}
		return maxima;
	}
	public double totalNotas(String cui,String curso, String seccion){
		double maxima=0;
		NodoAsignacion puntero=primero;
		while(puntero != null){
			if(puntero.getAsignacion().getCuiCatedratico().equals(cui)&& puntero.getAsignacion().getCurso().equals(curso)
					&& puntero.getAsignacion().getSeccion().equals(seccion)){
				maxima +=puntero.getAsignacion().getNotaTotal();
			}
			puntero = puntero.siguiente;
		}
		return maxima;
	}
}
