package Lists;

import javax.swing.JOptionPane;

import Models.Administrador;
import Models.Estudiante;
import Nodes.Nodo;
import Views.MenuAdministrador;

public class Lista {
	private Nodo inicio;
	private Nodo raiz;
	private int tamanio;
	public void Lista(){
		this.inicio=null;
		this.tamanio=0;
		this.raiz=null;
	}
	public boolean estaVacia(){
		return inicio ==null;
	}
	public void agregarNodo(Administrador admin){
		Nodo nuevo = new Nodo(admin);
		if(estaVacia()){
			inicio =nuevo;
		}else{
			nuevo.setSiguiente(inicio);
			inicio = nuevo;
		}
		tamanio++;
	}
	public boolean login(String usernaeme, String password){
		MenuAdministrador munuAdmin = new MenuAdministrador();
		boolean ususuarioExistente=false;
		Nodo aux = inicio;
		while(aux!= null && ususuarioExistente != true){
			if(usernaeme.equals(aux.getAdministrador().getUserName())){
				if(password.equals(aux.getAdministrador().getPassword())){
					ususuarioExistente=true;
					JOptionPane.showMessageDialog(null, "Bienvenido al sistema");
					munuAdmin.setVisible(true);
					munuAdmin.setLocationRelativeTo(null);
				}else{
					JOptionPane.showMessageDialog(null, "Contraseña Incorrecta");
				}
			}else{
				JOptionPane.showMessageDialog(null, "Username Incorrecto");
			}
			aux = aux.getSiguiente();
		}
		return ususuarioExistente;
	}
	public void insertarEstudiante(Estudiante estudiante){
		Nodo nuevo = new Nodo(estudiante);
		if(raiz==null){
			nuevo.setSiguiente(nuevo);
			nuevo.setAnterior(nuevo);
			raiz=nuevo;
		}else{
			Nodo ultimo = raiz.getAnterior();
			nuevo.setSiguiente(raiz);
			nuevo.setAnterior(ultimo);
			raiz.setAnterior(nuevo);
			ultimo.setSiguiente(nuevo);
			raiz=nuevo;
		}
	}
	 public boolean vacia (){
	    if(raiz == null)
	        return true;
	    else
	        return false;
	}
	 public void imprimir(){
		 if(!vacia()){
			 Nodo reco=raiz;
			  do {
	                System.out.print (reco.getEstudiante().getNombre()+ "-");
	                reco.setSiguiente(reco);             
	            } while (reco!=raiz);
	            System.out.println();
		 }
	 }
}
