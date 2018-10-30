package Lists;

import javax.swing.JOptionPane;

import Models.Administrador;
import Nodes.Nodo;

public class Lista {
	private Nodo inicio;
	private int tamanio;
	public void Lista(){
		this.inicio=null;
		this.tamanio=0;
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
		boolean ususuarioExistente=false;
		Nodo aux = inicio;
		while(aux!= null && ususuarioExistente != true){
			if(usernaeme.equals(aux.getAdministrador().getUserName())){
				if(password.equals(aux.getAdministrador().getPassword())){
					ususuarioExistente=true;
					JOptionPane.showMessageDialog(null, "Bienvenido al sistema");
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
}
