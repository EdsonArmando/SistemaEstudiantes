package Main;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Lists.Lista;
import Models.Administrador;
import Nodes.Nodo;
import Views.Login;

public class Main {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		Login login = new Login();
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		login.inicio();
	}

}
